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
public class Oficina implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long num_oficina; 
    private String ciudad;
    private String pais;
    
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "id_director", referencedColumnName = "id")    
    private Director unDirector;

    public Oficina() {
    }

    public Oficina(Long num_oficina, String ciudad, String pais, Director unDirector) {
        this.num_oficina = num_oficina;
        this.ciudad = ciudad;
        this.pais = pais;
        this.unDirector = unDirector;
    }

    public Long getNum_oficina() {
        return num_oficina;
    }

    public void setNum_oficina(Long num_oficina) {
        this.num_oficina = num_oficina;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Director getUnDirector() {
        return unDirector;
    }

    public void setUnDirector(Director unDirector) {
        this.unDirector = unDirector;
    }
    
    
    
}
