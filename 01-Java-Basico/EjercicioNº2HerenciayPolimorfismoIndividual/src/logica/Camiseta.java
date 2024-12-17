package logica;

/*
Camiseta: manga, cuello
 */
public class Camiseta extends Vestimenta{
    
    private String manga, cuello;

    public Camiseta(String manga, String cuello, int código, int precio, int talla, String nombre, String marca, String color) {
        super(código, precio, talla, nombre, marca, color);
        this.manga = manga;
        this.cuello = cuello;
    }
    
    @Override
    public String mostrarMarca() {
        return ("Esta Camiseta es de marca: " + super.mostrarMarca());
    }
    
}
