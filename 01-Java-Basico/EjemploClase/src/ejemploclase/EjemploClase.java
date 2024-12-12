
package ejemploclase;

import java.time.LocalDate;
import logica.Persona;
import logica.Animal;

public class EjemploClase {


    public static void main(String[] args) {
        Persona perso = new Persona();
        Persona perso2 = new Persona(1, "Alberto", "Haboba", LocalDate.of(1972,07,15), "Mi Calle 123");
        
        
        Animal perro = new Animal();
        Animal gato = new Animal("michi", "siames", "rojo");
    }
}
