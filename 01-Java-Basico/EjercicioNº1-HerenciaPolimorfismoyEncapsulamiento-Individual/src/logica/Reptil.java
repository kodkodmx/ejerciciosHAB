package logica;

/*"Reptil" con atributos adicionales: longitud, tipo de escamas, tipo de veneno, hábitat.
"Reptil": sobrescribir el método saludar de la clase madre y colocar el mensaje "Hola, soy un reptil"
*/

public class Reptil extends Animal{
    
    int longitud;
    String tipoEscamas;
    String tipoVeneno;
    String habitat;
    
    
    @Override
    public void saludar(){
        System.out.println("Hola, soy un reptil");
    } 
}
