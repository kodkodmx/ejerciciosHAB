/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Sala;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Festival;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author betoh
 */
public class FestivalJpaController implements Serializable {
    
    public FestivalJpaController() {
        emf = Persistence.createEntityManagerFactory("FestivalPU");
    }

    public FestivalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Festival torneo) {
        if (torneo.getListaSalas() == null) {
            torneo.setListaSalas(new ArrayList<Sala>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Sala> attachedListaCategorias = new ArrayList<Sala>();
            for (Sala listaCategoriasCategoriaToAttach : torneo.getListaSalas()) {
                listaCategoriasCategoriaToAttach = em.getReference(listaCategoriasCategoriaToAttach.getClass(), listaCategoriasCategoriaToAttach.getId());
                attachedListaCategorias.add(listaCategoriasCategoriaToAttach);
            }
            torneo.setListaSalas(attachedListaCategorias);
            em.persist(torneo);
            for (Sala listaCategoriasCategoria : torneo.getListaSalas()) {
                Festival oldTorneoOfListaCategoriasCategoria = listaCategoriasCategoria.getFestival();
                listaCategoriasCategoria.setFestival(torneo);
                listaCategoriasCategoria = em.merge(listaCategoriasCategoria);
                if (oldTorneoOfListaCategoriasCategoria != null) {
                    oldTorneoOfListaCategoriasCategoria.getListaSalas().remove(listaCategoriasCategoria);
                    oldTorneoOfListaCategoriasCategoria = em.merge(oldTorneoOfListaCategoriasCategoria);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Festival torneo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Festival persistentTorneo = em.find(Festival.class, torneo.getId());
            List<Sala> listaCategoriasOld = persistentTorneo.getListaSalas();
            List<Sala> listaCategoriasNew = torneo.getListaSalas();
            List<Sala> attachedListaCategoriasNew = new ArrayList<Sala>();
            for (Sala listaCategoriasNewCategoriaToAttach : listaCategoriasNew) {
                listaCategoriasNewCategoriaToAttach = em.getReference(listaCategoriasNewCategoriaToAttach.getClass(), listaCategoriasNewCategoriaToAttach.getId());
                attachedListaCategoriasNew.add(listaCategoriasNewCategoriaToAttach);
            }
            listaCategoriasNew = attachedListaCategoriasNew;
            torneo.setListaSalas(listaCategoriasNew);
            torneo = em.merge(torneo);
            for (Sala listaCategoriasOldCategoria : listaCategoriasOld) {
                if (!listaCategoriasNew.contains(listaCategoriasOldCategoria)) {
                    listaCategoriasOldCategoria.setFestival(null);
                    listaCategoriasOldCategoria = em.merge(listaCategoriasOldCategoria);
                }
            }
            for (Sala listaCategoriasNewCategoria : listaCategoriasNew) {
                if (!listaCategoriasOld.contains(listaCategoriasNewCategoria)) {
                    Festival oldTorneoOfListaCategoriasNewCategoria = listaCategoriasNewCategoria.getFestival();
                    listaCategoriasNewCategoria.setFestival(torneo);
                    listaCategoriasNewCategoria = em.merge(listaCategoriasNewCategoria);
                    if (oldTorneoOfListaCategoriasNewCategoria != null && !oldTorneoOfListaCategoriasNewCategoria.equals(torneo)) {
                        oldTorneoOfListaCategoriasNewCategoria.getListaSalas().remove(listaCategoriasNewCategoria);
                        oldTorneoOfListaCategoriasNewCategoria = em.merge(oldTorneoOfListaCategoriasNewCategoria);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = torneo.getId();
                if (findTorneo(id) == null) {
                    throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Festival torneo;
            try {
                torneo = em.getReference(Festival.class, id);
                torneo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.", enfe);
            }
            List<Sala> listaCategorias = torneo.getListaSalas();
            for (Sala listaCategoriasCategoria : listaCategorias) {
                listaCategoriasCategoria.setFestival(null);
                listaCategoriasCategoria = em.merge(listaCategoriasCategoria);
            }
            em.remove(torneo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Festival> findTorneoEntities() {
        return findTorneoEntities(true, -1, -1);
    }

    public List<Festival> findTorneoEntities(int maxResults, int firstResult) {
        return findTorneoEntities(false, maxResults, firstResult);
    }

    private List<Festival> findTorneoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Festival.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Festival findTorneo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Festival.class, id);
        } finally {
            em.close();
        }
    }

    public int getTorneoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Festival> rt = cq.from(Festival.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
