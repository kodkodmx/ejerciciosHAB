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
import logica.Item;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.Carrito;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Luisina
 */
public class CarritoJpaController implements Serializable {

       public CarritoJpaController() {
        emf = Persistence.createEntityManagerFactory("CarritoPU");
    }
    
    public CarritoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Carrito carrito) {
               EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(carrito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Carrito carrito) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Carrito persistentCarrito = em.find(Carrito.class, carrito.getId());
            List<Item> listaItemsOld = persistentCarrito.getListaItems();
            List<Item> listaItemsNew = carrito.getListaItems();
            ArrayList<Item> attachedListaItemsNew = new ArrayList<Item>();
            for (Item listaItemsNewItemToAttach : listaItemsNew) {
                listaItemsNewItemToAttach = em.getReference(listaItemsNewItemToAttach.getClass(), listaItemsNewItemToAttach.getId());
                attachedListaItemsNew.add(listaItemsNewItemToAttach);
            }
            listaItemsNew = attachedListaItemsNew;
            carrito.setListaItems(listaItemsNew);
            carrito = em.merge(carrito);
            for (Item listaItemsOldItem : listaItemsOld) {
                if (!listaItemsNew.contains(listaItemsOldItem)) {
                    listaItemsOldItem.setCarrito(null);
                    listaItemsOldItem = em.merge(listaItemsOldItem);
                }
            }
            for (Item listaItemsNewItem : listaItemsNew) {
                if (!listaItemsOld.contains(listaItemsNewItem)) {
                    Carrito oldCarritoOfListaItemsNewItem = listaItemsNewItem.getCarrito();
                    listaItemsNewItem.setCarrito(carrito);
                    listaItemsNewItem = em.merge(listaItemsNewItem);
                    if (oldCarritoOfListaItemsNewItem != null && !oldCarritoOfListaItemsNewItem.equals(carrito)) {
                        oldCarritoOfListaItemsNewItem.getListaItems().remove(listaItemsNewItem);
                        oldCarritoOfListaItemsNewItem = em.merge(oldCarritoOfListaItemsNewItem);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = carrito.getId();
                if (findCarrito(id) == null) {
                    throw new NonexistentEntityException("The carrito with id " + id + " no longer exists.");
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
            Carrito carrito;
            try {
                carrito = em.getReference(Carrito.class, id);
                carrito.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The carrito with id " + id + " no longer exists.", enfe);
            }
            List<Item> listaItems = carrito.getListaItems();
            for (Item listaItemsItem : listaItems) {
                listaItemsItem.setCarrito(null);
                listaItemsItem = em.merge(listaItemsItem);
            }
            em.remove(carrito);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Carrito> findCarritoEntities() {
        return findCarritoEntities(true, -1, -1);
    }

    public List<Carrito> findCarritoEntities(int maxResults, int firstResult) {
        return findCarritoEntities(false, maxResults, firstResult);
    }

    private List<Carrito> findCarritoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Carrito.class));
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

    public Carrito findCarrito(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrito.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarritoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carrito> rt = cq.from(Carrito.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
