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
import logica.Torneo;
import logica.Inscripcion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Categoria;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author betoh
 */
public class CategoriaJpaController implements Serializable {
    
    public CategoriaJpaController() {
        emf = Persistence.createEntityManagerFactory("TorneoPU");
    }

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Categoria categoria) {
        if (categoria.getListaInscripciones() == null) {
            categoria.setListaInscripciones(new ArrayList<Inscripcion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Torneo torneo = categoria.getTorneo();
            if (torneo != null) {
                torneo = em.getReference(torneo.getClass(), torneo.getId());
                categoria.setTorneo(torneo);
            }
            List<Inscripcion> attachedListaInscripciones = new ArrayList<Inscripcion>();
            for (Inscripcion listaInscripcionesInscripcionToAttach : categoria.getListaInscripciones()) {
                listaInscripcionesInscripcionToAttach = em.getReference(listaInscripcionesInscripcionToAttach.getClass(), listaInscripcionesInscripcionToAttach.getNumInscripcion());
                attachedListaInscripciones.add(listaInscripcionesInscripcionToAttach);
            }
            categoria.setListaInscripciones(attachedListaInscripciones);
            em.persist(categoria);
            if (torneo != null) {
                torneo.getListaCategorias().add(categoria);
                torneo = em.merge(torneo);
            }
            for (Inscripcion listaInscripcionesInscripcion : categoria.getListaInscripciones()) {
                Categoria oldCategoriaOfListaInscripcionesInscripcion = listaInscripcionesInscripcion.getCategoria();
                listaInscripcionesInscripcion.setCategoria(categoria);
                listaInscripcionesInscripcion = em.merge(listaInscripcionesInscripcion);
                if (oldCategoriaOfListaInscripcionesInscripcion != null) {
                    oldCategoriaOfListaInscripcionesInscripcion.getListaInscripciones().remove(listaInscripcionesInscripcion);
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

    public void edit(Categoria categoria) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getId());
            Torneo torneoOld = persistentCategoria.getTorneo();
            Torneo torneoNew = categoria.getTorneo();
            List<Inscripcion> listaInscripcionesOld = persistentCategoria.getListaInscripciones();
            List<Inscripcion> listaInscripcionesNew = categoria.getListaInscripciones();
            List<String> illegalOrphanMessages = null;
            for (Inscripcion listaInscripcionesOldInscripcion : listaInscripcionesOld) {
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
                categoria.setTorneo(torneoNew);
            }
            List<Inscripcion> attachedListaInscripcionesNew = new ArrayList<Inscripcion>();
            for (Inscripcion listaInscripcionesNewInscripcionToAttach : listaInscripcionesNew) {
                listaInscripcionesNewInscripcionToAttach = em.getReference(listaInscripcionesNewInscripcionToAttach.getClass(), listaInscripcionesNewInscripcionToAttach.getNumInscripcion());
                attachedListaInscripcionesNew.add(listaInscripcionesNewInscripcionToAttach);
            }
            listaInscripcionesNew = attachedListaInscripcionesNew;
            categoria.setListaInscripciones(listaInscripcionesNew);
            categoria = em.merge(categoria);
            if (torneoOld != null && !torneoOld.equals(torneoNew)) {
                torneoOld.getListaCategorias().remove(categoria);
                torneoOld = em.merge(torneoOld);
            }
            if (torneoNew != null && !torneoNew.equals(torneoOld)) {
                torneoNew.getListaCategorias().add(categoria);
                torneoNew = em.merge(torneoNew);
            }
            for (Inscripcion listaInscripcionesNewInscripcion : listaInscripcionesNew) {
                if (!listaInscripcionesOld.contains(listaInscripcionesNewInscripcion)) {
                    Categoria oldCategoriaOfListaInscripcionesNewInscripcion = listaInscripcionesNewInscripcion.getCategoria();
                    listaInscripcionesNewInscripcion.setCategoria(categoria);
                    listaInscripcionesNewInscripcion = em.merge(listaInscripcionesNewInscripcion);
                    if (oldCategoriaOfListaInscripcionesNewInscripcion != null && !oldCategoriaOfListaInscripcionesNewInscripcion.equals(categoria)) {
                        oldCategoriaOfListaInscripcionesNewInscripcion.getListaInscripciones().remove(listaInscripcionesNewInscripcion);
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
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The categoria with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Inscripcion> listaInscripcionesOrphanCheck = categoria.getListaInscripciones();
            for (Inscripcion listaInscripcionesOrphanCheckInscripcion : listaInscripcionesOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Categoria (" + categoria + ") cannot be destroyed since the Inscripcion " + listaInscripcionesOrphanCheckInscripcion + " in its listaInscripciones field has a non-nullable categoria field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Torneo torneo = categoria.getTorneo();
            if (torneo != null) {
                torneo.getListaCategorias().remove(categoria);
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

    public List<Categoria> findCategoriaEntities() {
        return findCategoriaEntities(true, -1, -1);
    }

    public List<Categoria> findCategoriaEntities(int maxResults, int firstResult) {
        return findCategoriaEntities(false, maxResults, firstResult);
    }

    private List<Categoria> findCategoriaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Categoria.class));
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

    public Categoria findCategoria(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }

    public int getCategoriaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Categoria> rt = cq.from(Categoria.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
