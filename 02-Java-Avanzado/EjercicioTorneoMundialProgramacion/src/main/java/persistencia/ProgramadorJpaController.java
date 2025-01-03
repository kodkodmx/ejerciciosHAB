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
import logica.Programador;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author betoh
 */
public class ProgramadorJpaController implements Serializable {
    
    public ProgramadorJpaController() {
        emf = Persistence.createEntityManagerFactory("TorneoPU");
    }

    public ProgramadorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Programador programador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(programador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Programador programador) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            programador = em.merge(programador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = programador.getNumProgramador();
                if (findProgramador(id) == null) {
                    throw new NonexistentEntityException("The programador with id " + id + " no longer exists.");
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
            Programador programador;
            try {
                programador = em.getReference(Programador.class, id);
                programador.getNumProgramador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The programador with id " + id + " no longer exists.", enfe);
            }
            em.remove(programador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Programador> findProgramadorEntities() {
        return findProgramadorEntities(true, -1, -1);
    }

    public List<Programador> findProgramadorEntities(int maxResults, int firstResult) {
        return findProgramadorEntities(false, maxResults, firstResult);
    }

    private List<Programador> findProgramadorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Programador.class));
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

    public Programador findProgramador(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Programador.class, id);
        } finally {
            em.close();
        }
    }

    public int getProgramadorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Programador> rt = cq.from(Programador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
