package logica;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre_item", nullable = false)
    private String nombreItem;

    @ManyToOne
    @JoinColumn(name = "id_carrito", nullable = false) 
    private Carrito carrito;


    public Item() {
    }


    public Item(Long id, String nombreItem, Carrito carrito) {
        this.id = id;
        this.nombreItem = nombreItem;
        this.carrito = carrito;
    }


    public Item(Long id, String nombreItem) {
        this.id = id;
        this.nombreItem = nombreItem;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public void setNombreItem(String nombreItem) {
        this.nombreItem = nombreItem;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
