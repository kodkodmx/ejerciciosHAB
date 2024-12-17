package logica;

/*"Ave" con atributos adicionales: envergadura de alas, tipo de vuelo, color de plumaje, tipo de pico.
"Ave": sobrescribir el método saludar de la clase madre y colocar el mensaje "Hola, soy un ave".
*/

public class Ave extends Animal{
    
    int envergaduraAlas;
    String tipoVuelo;
    String colorPlumaje;
    String tipoPico;
    
    @Override
    public void saludar(){
        System.out.println("Hola, soy un ave");
    }
}
