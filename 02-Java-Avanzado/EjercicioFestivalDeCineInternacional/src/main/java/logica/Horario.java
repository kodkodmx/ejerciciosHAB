package logica;

import java.io.Serializable;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Horario implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
        
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pelicula", referencedColumnName = "numPelicula")  
    private Pelicula unaPelicula;
    
    private LocalTime horaInicio;
    private LocalTime horaFin;
    
    
    public Horario() {
    }

    public Horario(int id, Pelicula unaPelicula, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.unaPelicula = unaPelicula;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pelicula getUnaPelicula() {
        return unaPelicula;
    }

    public void setUnaPelicula(Pelicula unaPelicula) {
        this.unaPelicula = unaPelicula;
    }

    
}
