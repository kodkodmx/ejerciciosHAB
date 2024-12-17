package logica;

/*
Sombrero: tipo, tamaño
 */
public class Sombrero extends Vestimenta{
    
    private String tipo, tamanio;

    public Sombrero(String tipo, String tamanio, int código, int precio, int talla, String nombre, String marca, String color) {
        super(código, precio, talla, nombre, marca, color);
        this.tipo = tipo;
        this.tamanio = tamanio;
    }
    
   
    @Override
    public String mostrarMarca() {
        return ("Este sombrero es de marca: " + super.mostrarMarca());
    }
}
