
package logica;

/*
Crear una clase llamada Vestimenta con los atributos: código, nombre, precio, marca, talla y color
(con sus métodos y constructores correspondientes).
 */
public class Vestimenta {
    
    private int código, precio, talla;
    private String nombre, marca, color;

    public Vestimenta(int código, int precio, int talla, String nombre, String marca, String color) {
        this.código = código;
        this.precio = precio;
        this.talla = talla;
        this.nombre = nombre;
        this.marca = marca;
        this.color = color;
    }
    
    public String mostrarMarca() {
        return marca;
    }
    
    
}
