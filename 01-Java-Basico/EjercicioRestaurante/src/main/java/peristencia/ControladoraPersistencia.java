
package peristencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Platillo;
import peristencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    PlatilloJpaController platilloJpa = new PlatilloJpaController();
    
    public void crearPlatillo(Platillo platillo){
        platilloJpa.create(platillo);
    }
    
    public void borrarPlatillo(int id){
        try {
            platilloJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Platillo traerPlatillo(int id){
        return platilloJpa.findPlatillo(id);
    }
    
    public List<Platillo> traerPlatillos(){
        return platilloJpa.findPlatilloEntities();
    }
    
    public void modificarPlatillo(Platillo platillo){
        try {
            platilloJpa.edit(platillo);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
