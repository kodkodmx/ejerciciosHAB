package logica;

/*
Pantalon: estilo, tipoTejido
 */
public class Pantalon extends Vestimenta{
    
    private String estilo, tipoTejido;

    public Pantalon(String estilo, String tipoTejido, int código, int precio, int talla, String nombre, String marca, String color) {
        super(código, precio, talla, nombre, marca, color);
        this.estilo = estilo;
        this.tipoTejido = tipoTejido;
    }
    
    @Override
    public String mostrarMarca() {
        return ("Estos pantalones son de marca: " + super.mostrarMarca());
    }
    
    
}
