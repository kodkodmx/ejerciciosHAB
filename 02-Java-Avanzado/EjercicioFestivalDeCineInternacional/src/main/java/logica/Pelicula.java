package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Pelicula implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numPelicula;
    
    private String titulo;
    
    private String director;
    
    @ManyToOne
    @JoinColumn(name = "sala_id", nullable = false) 
    private Sala sala;

    @OneToOne (mappedBy = "unaPelicula")
    private Horario horario ;

    public Pelicula() {
    }

    public Pelicula(int numPelicula, String titulo, String director, Sala sala, Horario horario) {
        this.numPelicula = numPelicula;
        this.titulo = titulo;
        this.director = director;
        this.sala = sala;
        this.horario = horario;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getNumPelicula() {
        return numPelicula;
    }

    public void setNumPelicula(int numPelicula) {
        this.numPelicula = numPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    
    
}
