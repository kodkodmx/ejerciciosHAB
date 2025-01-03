package persistencia;

import logica.Carrito;
import logica.Item;

public class ControladoraPersistencia {
    
    CarritoJpaController carritoJpa = new CarritoJpaController();
    ItemJpaController itemJpa = new ItemJpaController();
    
    //create
    public void crearCarrito (Carrito carrito) {
        carritoJpa.create(carrito);
    }
    
    public void crearItem(Item item) {
        itemJpa.create(item);
    
    }
    
}
