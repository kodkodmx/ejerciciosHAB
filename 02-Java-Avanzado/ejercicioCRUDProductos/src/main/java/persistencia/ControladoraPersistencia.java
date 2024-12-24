package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Producto;
import persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {    
    

    ProductoJpaController proJPA = new ProductoJpaController();

    public void crearProducto(Producto pro) {
        proJPA.create(pro);
    }

    public List<Producto> traerTodos() {
        return proJPA.findProductoEntities();
    }

    public void modificarProducto(Producto pro) {
        try {
            proJPA.edit(pro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void borrarProducto(int id) {
        try {
            proJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}