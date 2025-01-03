
package persistencia;

import java.time.LocalDate;
import javax.persistence.TypedQuery;
import logica.Categoria;
import logica.Inscripcion;
import logica.Programador;
import logica.Torneo;
import persistencia.exceptions.IllegalOrphanException;


public class ControladoraPersistencia {
    
    TorneoJpaController torneoJpa = new TorneoJpaController();
    CategoriaJpaController categoriaJpa = new CategoriaJpaController();
    InscripcionJpaController inscripcionJpa = new InscripcionJpaController();
    ProgramadorJpaController programadorJpa = new ProgramadorJpaController();
    
    //create
    public void crearTorneo (Torneo torneo) {
        torneoJpa.create(torneo);
    }
    public void crearCategoria (Categoria categoria) {
        categoriaJpa.create(categoria);
    }
    public void crearInscripcion (Inscripcion inscripcion){
        inscripcionJpa.create(inscripcion);
    }
    public void crearProgramador (Programador programador) {
        programadorJpa.create(programador);
    }
    
}
