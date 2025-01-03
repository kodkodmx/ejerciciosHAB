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
public class OficinaJpaController implements Serializable {
    
    public OficinaJpaController() {
        emf = Persistence.createEntityManagerFactory("oficinaPU");
    }

    public OficinaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

        public void create(Oficina oficina) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(oficina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Oficina oficina) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Oficina persistentOficina = em.find(Oficina.class, oficina.getNum_oficina());
            Director unDirectorOld = persistentOficina.getUnDirector();
            Director unDirectorNew = oficina.getUnDirector();
            if (unDirectorNew != null) {
                unDirectorNew = em.getReference(unDirectorNew.getClass(), unDirectorNew.getId());
                oficina.setUnDirector(unDirectorNew);
            }
            oficina = em.merge(oficina);
            if (unDirectorOld != null && !unDirectorOld.equals(unDirectorNew)) {
                unDirectorOld.setOfi(null);
                unDirectorOld = em.merge(unDirectorOld);
            }
            if (unDirectorNew != null && !unDirectorNew.equals(unDirectorOld)) {
                Oficina oldOfiOfUnDirector = unDirectorNew.getOfi();
                if (oldOfiOfUnDirector != null) {
                    oldOfiOfUnDirector.setUnDirector(null);
                    oldOfiOfUnDirector = em.merge(oldOfiOfUnDirector);
                }
                unDirectorNew.setOfi(oficina);
                unDirectorNew = em.merge(unDirectorNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = oficina.getNum_oficina();
                if (findOficina(id) == null) {
                    throw new NonexistentEntityException("The oficina with id " + id + " no longer exists.");
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
            Oficina oficina;
            try {
                oficina = em.getReference(Oficina.class, id);
                oficina.getNum_oficina();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The oficina with id " + id + " no longer exists.", enfe);
            }
            Director unDirector = oficina.getUnDirector();
            if (unDirector != null) {
                unDirector.setOfi(null);
                unDirector = em.merge(unDirector);
            }
            em.remove(oficina);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Oficina> findOficinaEntities() {
        return findOficinaEntities(true, -1, -1);
    }

    public List<Oficina> findOficinaEntities(int maxResults, int firstResult) {
        return findOficinaEntities(false, maxResults, firstResult);
    }

    private List<Oficina> findOficinaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Oficina.class));
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

    public Oficina findOficina(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Oficina.class, id);
        } finally {
            em.close();
        }
    }

    public int getOficinaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Oficina> rt = cq.from(Oficina.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
