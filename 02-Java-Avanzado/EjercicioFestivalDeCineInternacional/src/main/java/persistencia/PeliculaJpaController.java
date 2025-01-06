/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.Sala;
import logica.Pelicula;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author betoh
 */
public class PeliculaJpaController implements Serializable {
    
    public PeliculaJpaController() {
        emf = Persistence.createEntityManagerFactory("FestivalPU");
    }

    public PeliculaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pelicula inscripcion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sala categoria = inscripcion.getSala();
            if (categoria != null) {
                categoria = em.getReference(categoria.getClass(), categoria.getId());
                inscripcion.setSala(categoria);
            }
            em.persist(inscripcion);
            if (categoria != null) {
                categoria.getListaPeliculas().add(inscripcion);
                categoria = em.merge(categoria);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pelicula inscripcion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pelicula persistentInscripcion = em.find(Pelicula.class, inscripcion.getNumPelicula());
            Sala categoriaOld = persistentInscripcion.getSala();
            Sala categoriaNew = inscripcion.getSala();
            if (categoriaNew != null) {
                categoriaNew = em.getReference(categoriaNew.getClass(), categoriaNew.getId());
                inscripcion.setSala(categoriaNew);
            }
            inscripcion = em.merge(inscripcion);
            if (categoriaOld != null && !categoriaOld.equals(categoriaNew)) {
                categoriaOld.getListaPeliculas().remove(inscripcion);
                categoriaOld = em.merge(categoriaOld);
            }
            if (categoriaNew != null && !categoriaNew.equals(categoriaOld)) {
                categoriaNew.getListaPeliculas().add(inscripcion);
                categoriaNew = em.merge(categoriaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = inscripcion.getNumPelicula();
                if (findInscripcion(id) == null) {
                    throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.");
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
            Pelicula inscripcion;
            try {
                inscripcion = em.getReference(Pelicula.class, id);
                inscripcion.getNumPelicula();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The inscripcion with id " + id + " no longer exists.", enfe);
            }
            Sala categoria = inscripcion.getSala();
            if (categoria != null) {
                categoria.getListaPeliculas().remove(inscripcion);
                categoria = em.merge(categoria);
            }
            em.remove(inscripcion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pelicula> findInscripcionEntities() {
        return findInscripcionEntities(true, -1, -1);
    }

    public List<Pelicula> findInscripcionEntities(int maxResults, int firstResult) {
        return findInscripcionEntities(false, maxResults, firstResult);
    }

    private List<Pelicula> findInscripcionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pelicula.class));
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

    public Pelicula findInscripcion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pelicula.class, id);
        } finally {
            em.close();
        }
    }

    public int getInscripcionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pelicula> rt = cq.from(Pelicula.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
