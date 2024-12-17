package logica;

/*
Zapato: material, tipoCierre
*/

public class Zapato extends Vestimenta{
    
    private String material, tipoCierre;

    public Zapato(String material, String tipoCierre, int código, int precio, int talla, String nombre, String marca, String color) {
        super(código, precio, talla, nombre, marca, color);
        this.material = material;
        this.tipoCierre = tipoCierre;
        
    }
    
    @Override
    public String mostrarMarca() {
        return ("Estos zapatos son de marca: " + super.mostrarMarca());
    }


    
    
    
}
