package persistencia;

import logica.Persona;
import persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    PersonaJpaController persoJPA = new PersonaJpaController();
    
    public void crearPersona(Persona pers) {
        persoJPA.create(pers);
    }
    
    public void borrarPersona(Long id) {
        try {
            persoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Persona> traerPersonas () {
        return persoJPA.findPersonaEntities();
    }
    
    public void modificarPersona (Persona pers) {
    
        try {
            persoJPA.edit(pers);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
