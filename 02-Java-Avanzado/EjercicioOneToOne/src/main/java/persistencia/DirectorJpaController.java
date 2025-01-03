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
import logica.Director;
import logica.Oficina;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author betoh
 */
public class DirectorJpaController implements Serializable {
    
    public DirectorJpaController() {
        emf = Persistence.createEntityManagerFactory("oficinaPU");
    }

    public DirectorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Director director) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Oficina ofi = director.getOfi();
            if (ofi != null) {
                ofi = em.getReference(ofi.getClass(), ofi.getNum_oficina());
                director.setOfi(ofi);
            }
            em.persist(director);
            if (ofi != null) {
                Director oldUnDirectorOfOfi = ofi.getUnDirector();
                if (oldUnDirectorOfOfi != null) {
                    oldUnDirectorOfOfi.setOfi(null);
                    oldUnDirectorOfOfi = em.merge(oldUnDirectorOfOfi);
                }
                ofi.setUnDirector(director);
                ofi = em.merge(ofi);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Director director) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Director persistentDirector = em.find(Director.class, director.getId());
            Oficina ofiOld = persistentDirector.getOfi();
            Oficina ofiNew = director.getOfi();
            if (ofiNew != null) {
                ofiNew = em.getReference(ofiNew.getClass(), ofiNew.getNum_oficina());
                director.setOfi(ofiNew);
            }
            director = em.merge(director);
            if (ofiOld != null && !ofiOld.equals(ofiNew)) {
                ofiOld.setUnDirector(null);
                ofiOld = em.merge(ofiOld);
            }
            if (ofiNew != null && !ofiNew.equals(ofiOld)) {
                Director oldUnDirectorOfOfi = ofiNew.getUnDirector();
                if (oldUnDirectorOfOfi != null) {
                    oldUnDirectorOfOfi.setOfi(null);
                    oldUnDirectorOfOfi = em.merge(oldUnDirectorOfOfi);
                }
                ofiNew.setUnDirector(director);
                ofiNew = em.merge(ofiNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = director.getId();
                if (findDirector(id) == null) {
                    throw new NonexistentEntityException("The director with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Director director;
            try {
                director = em.getReference(Director.class, id);
                director.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The director with id " + id + " no longer exists.", enfe);
            }
            Oficina ofi = director.getOfi();
            if (ofi != null) {
                ofi.setUnDirector(null);
                ofi = em.merge(ofi);
            }
            em.remove(director);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Director> findDirectorEntities() {
        return findDirectorEntities(true, -1, -1);
    }

    public List<Director> findDirectorEntities(int maxResults, int firstResult) {
        return findDirectorEntities(false, maxResults, firstResult);
    }

    private List<Director> findDirectorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Director.class));
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

    public Director findDirector(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Director.class, id);
        } finally {
            em.close();
        }
    }

    public int getDirectorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Director> rt = cq.from(Director.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
