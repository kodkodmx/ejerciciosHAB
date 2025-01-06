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
import logica.Festival;
import logica.Pelicula;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Sala;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author betoh
 */
public class SalaJpaController implements Serializable {
    
    public SalaJpaController() {
        emf = Persistence.createEntityManagerFactory("FestivalPU");
    }

    public SalaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sala categoria) {
        if (categoria.getListaPeliculas() == null) {
            categoria.setListaPeliculas(new ArrayList<Pelicula>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Festival torneo = categoria.getFestival();
            if (torneo != null) {
                torneo = em.getReference(torneo.getClass(), torneo.getId());
                categoria.setFestival(torneo);
            }
            List<Pelicula> attachedListaInscripciones = new ArrayList<Pelicula>();
            for (Pelicula listaInscripcionesInscripcionToAttach : categoria.getListaPeliculas()) {
                listaInscripcionesInscripcionToAttach = em.getReference(listaInscripcionesInscripcionToAttach.getClass(), listaInscripcionesInscripcionToAttach.getNumPelicula());
                attachedListaInscripciones.add(listaInscripcionesInscripcionToAttach);
            }
            categoria.setListaPeliculas(attachedListaInscripciones);
            em.persist(categoria);
            if (torneo != null) {
                torneo.getListaSalas().add(categoria);
                torneo = em.merge(torneo);
            }
            for (Pelicula listaInscripcionesInscripcion : categoria.getListaPeliculas()) {
                Sala oldCategoriaOfListaInscripcionesInscripcion = listaInscripcionesInscripcion.getSala();
                listaInscripcionesInscripcion.setSala(categoria);
                listaInscripcionesInscripcion = em.merge(listaInscripcionesInscripcion);
                if (oldCategoriaOfListaInscripcionesInscripcion != null) {
                    oldCategoriaOfListaInscripcionesInscripcion.getListaPeliculas().remove(listaInscripcionesInscripcion);
                    oldCategoriaOfListaInscripcionesInscripcion = em.merge(oldCategoriaOfListaInscripcionesInscripcion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sala categoria) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sala persistentCategoria = em.find(Sala.class, categoria.getId());
            Festival torneoOld = persistentCategoria.getFestival();
            Festival torneoNew = categoria.getFestival();
            List<Pelicula> listaInscripcionesOld = persistentCategoria.getListaPeliculas();
            List<Pelicula> listaInscripcionesNew = categoria.getListaPeliculas();
            List<String> illegalOrphanMessages = null;
            for (Pelicula listaInscripcionesOldInscripcion : listaInscripcionesOld) {
                if (!listaInscripcionesNew.contains(listaInscripcionesOldInscripcion)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Inscripcion " + listaInscripcionesOldInscripcion + " since its categoria field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (torneoNew != null) {
                torneoNew = em.getReference(torneoNew.getClass(), torneoNew.getId());
                categoria.setFestival(torneoNew);
            }
            List<Pelicula> attachedListaInscripcionesNew = new ArrayList<Pelicula>();
            for (Pelicula listaInscripcionesNewInscripcionToAttach : listaInscripcionesNew) {
                listaInscripcionesNewInscripcionToAttach = em.getReference(listaInscripcionesNewInscripcionToAttach.getClass(), listaInscripcionesNewInscripcionToAttach.getNumPelicula());
                attachedListaInscripcionesNew.add(listaInscripcionesNewInscripcionToAttach);
            }
            listaInscripcionesNew = attachedListaInscripcionesNew;
            categoria.setListaPeliculas(listaInscripcionesNew);
            categoria = em.merge(categoria);
            if (torneoOld != null && !torneoOld.equals(torneoNew)) {
                torneoOld.getListaSalas().remove(categoria);
                torneoOld = em.merge(torneoOld);
            }
            if (torneoNew != null && !torneoNew.equals(torneoOld)) {
                torneoNew.getListaSalas().add(categoria);
                torneoNew = em.merge(torneoNew);
            }
            for (Pelicula listaInscripcionesNewInscripcion : listaInscripcionesNew) {
                if (!listaInscripcionesOld.contains(listaInscripcionesNewInscripcion)) {
                    Sala oldCategoriaOfListaInscripcionesNewInscripcion = listaInscripcionesNewInscripcion.getSala();
                    listaInscripcionesNewInscripcion.setSala(categoria);
                    listaInscripcionesNewInscripcion = em.merge(listaInscripcionesNewInscripcion);
                    if (oldCategoriaOfListaInscripcionesNewInscripcion != null && !oldCategoriaOfListaInscripcionesNewInscripcion.equals(categoria)) {
                        oldCategoriaOfListaInscripcionesNewInscripcion.getListaPeliculas().remove(listaInscripcionesNewInscripcion);
                        oldCategoriaOfListaInscripcionesNewInscripcion = em.merge(oldCategoriaOfListaInscripcionesNewInscripcion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = categoria.getId();
                if (findCategoria(id) == null) {
                    throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sala categoria;
            try {
                categoria = em.getReference(Sala.class, id);
                categoria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Pelicula> listaInscripcionesOrphanCheck = categoria.getListaPeliculas();
            for (Pelicula listaInscripcionesOrphanCheckInscripcion : listaInscripcionesOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Categoria (" + categoria + ") cannot be destroyed since the Inscripcion " + listaInscripcionesOrphanCheckInscripcion + " in its listaInscripciones field has a non-nullable categoria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Festival torneo = categoria.getFestival();
            if (torneo != null) {
                torneo.getListaSalas().remove(categoria);
                torneo = em.merge(torneo);
            }
            em.remove(categoria);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sala> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Sala> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Sala> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sala.class));
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

    public Sala findCategoria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sala.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sala> rt = cq.from(Sala.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
