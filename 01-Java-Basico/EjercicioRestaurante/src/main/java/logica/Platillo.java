package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Platillo implements Serializable {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String receta;
    private double precio;

    public Platillo() {
    }

    public Platillo(int id, String nombre, String receta, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.receta = receta;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReceta() {
        return receta;
    }

    public void setReceta(String receta) {
        this.receta = receta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Platillo{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", receta=").append(receta);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
