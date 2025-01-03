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
import logica.Categoria;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Torneo;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author betoh
 */
public class TorneoJpaController implements Serializable {
    
    public TorneoJpaController() {
        emf = Persistence.createEntityManagerFactory("TorneoPU");
    }

    public TorneoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Torneo torneo) {
        if (torneo.getListaCategorias() == null) {
            torneo.setListaCategorias(new ArrayList<Categoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Categoria> attachedListaCategorias = new ArrayList<Categoria>();
            for (Categoria listaCategoriasCategoriaToAttach : torneo.getListaCategorias()) {
                listaCategoriasCategoriaToAttach = em.getReference(listaCategoriasCategoriaToAttach.getClass(), listaCategoriasCategoriaToAttach.getId());
                attachedListaCategorias.add(listaCategoriasCategoriaToAttach);
            }
            torneo.setListaCategorias(attachedListaCategorias);
            em.persist(torneo);
            for (Categoria listaCategoriasCategoria : torneo.getListaCategorias()) {
                Torneo oldTorneoOfListaCategoriasCategoria = listaCategoriasCategoria.getTorneo();
                listaCategoriasCategoria.setTorneo(torneo);
                listaCategoriasCategoria = em.merge(listaCategoriasCategoria);
                if (oldTorneoOfListaCategoriasCategoria != null) {
                    oldTorneoOfListaCategoriasCategoria.getListaCategorias().remove(listaCategoriasCategoria);
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

    public void edit(Torneo torneo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo persistentTorneo = em.find(Torneo.class, torneo.getId());
            List<Categoria> listaCategoriasOld = persistentTorneo.getListaCategorias();
            List<Categoria> listaCategoriasNew = torneo.getListaCategorias();
            List<Categoria> attachedListaCategoriasNew = new ArrayList<Categoria>();
            for (Categoria listaCategoriasNewCategoriaToAttach : listaCategoriasNew) {
                listaCategoriasNewCategoriaToAttach = em.getReference(listaCategoriasNewCategoriaToAttach.getClass(), listaCategoriasNewCategoriaToAttach.getId());
                attachedListaCategoriasNew.add(listaCategoriasNewCategoriaToAttach);
            }
            listaCategoriasNew = attachedListaCategoriasNew;
            torneo.setListaCategorias(listaCategoriasNew);
            torneo = em.merge(torneo);
            for (Categoria listaCategoriasOldCategoria : listaCategoriasOld) {
                if (!listaCategoriasNew.contains(listaCategoriasOldCategoria)) {
                    listaCategoriasOldCategoria.setTorneo(null);
                    listaCategoriasOldCategoria = em.merge(listaCategoriasOldCategoria);
                }
            }
            for (Categoria listaCategoriasNewCategoria : listaCategoriasNew) {
                if (!listaCategoriasOld.contains(listaCategoriasNewCategoria)) {
                    Torneo oldTorneoOfListaCategoriasNewCategoria = listaCategoriasNewCategoria.getTorneo();
                    listaCategoriasNewCategoria.setTorneo(torneo);
                    listaCategoriasNewCategoria = em.merge(listaCategoriasNewCategoria);
                    if (oldTorneoOfListaCategoriasNewCategoria != null && !oldTorneoOfListaCategoriasNewCategoria.equals(torneo)) {
                        oldTorneoOfListaCategoriasNewCategoria.getListaCategorias().remove(listaCategoriasNewCategoria);
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
            Torneo torneo;
            try {
                torneo = em.getReference(Torneo.class, id);
                torneo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The torneo with id " + id + " no longer exists.", enfe);
            }
            List<Categoria> listaCategorias = torneo.getListaCategorias();
            for (Categoria listaCategoriasCategoria : listaCategorias) {
                listaCategoriasCategoria.setTorneo(null);
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

    public List<Torneo> findTorneoEntities() {
        return findTorneoEntities(true, -1, -1);
    }

    public List<Torneo> findTorneoEntities(int maxResults, int firstResult) {
        return findTorneoEntities(false, maxResults, firstResult);
    }

    private List<Torneo> findTorneoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Torneo.class));
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

    public Torneo findTorneo(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Torneo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTorneoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Torneo> rt = cq.from(Torneo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
