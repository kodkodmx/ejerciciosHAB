
package persistencia;

import java.time.LocalDate;
import javax.persistence.TypedQuery;
import logica.Sala;
import logica.Pelicula;
import logica.Horario;
import logica.Festival;
import persistencia.exceptions.IllegalOrphanException;


public class ControladoraPersistencia {
    
    FestivalJpaController festivalJpa = new FestivalJpaController();
    SalaJpaController salaJpa = new SalaJpaController();
    PeliculaJpaController peliculaJpa = new PeliculaJpaController();
    HorarioJpaController horarioJpa = new HorarioJpaController();
    
    //create
    public void crearFestival (Festival festival) {
        festivalJpa.create(festival);
    }
    public void crearSala (Sala sala) {
        salaJpa.create(sala);
    }
    public void crearPelicula (Pelicula pelicula){
        peliculaJpa.create(pelicula);
    }
    public void crearHorario (Horario horario) {
        horarioJpa.create(horario);
    }
    
}
