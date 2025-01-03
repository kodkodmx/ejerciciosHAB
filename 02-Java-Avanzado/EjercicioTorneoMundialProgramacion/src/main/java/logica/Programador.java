package logica;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Programador implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numProgramador;
    
    private String nombre;
    private String apellido;
    private String nivelAcademico;
    
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id_inscripcion", referencedColumnName = "numInscripcion")  
    private Inscripcion unaInscripcion;
    
    
    public Programador() {
    }

    public int getNumProgramador() {
        return numProgramador;
    }

    public Programador(String nombre, String apellido, String nivelAcademico, Inscripcion inscripcion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nivelAcademico = nivelAcademico;
        this.unaInscripcion = inscripcion;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public Inscripcion getUnaInscripcion() {
        return unaInscripcion;
    }

    public void setUnaInscripcion(Inscripcion unaInscripcion) {
        this.unaInscripcion = unaInscripcion;
    }

    
}
