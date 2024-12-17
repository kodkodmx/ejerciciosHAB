package logica;

/*"Mamífero" con atributos adicionales: número de patas, tipo de reproducción, color de pelaje, hábitat.
"Mamífero": sobrescribir el método saludar de la clase madre y colocar el mensaje "Hola, soy un mamífero".
*/

public class Mamifero extends Animal{
    
    int numeroPatas;
    String tipoReproduccion;
    String colorPelaje;
    String habitat;
    
    @Override
    public void saludar(){
        System.out.println("Hola, soy un mamífero");
    }
    
    
}
