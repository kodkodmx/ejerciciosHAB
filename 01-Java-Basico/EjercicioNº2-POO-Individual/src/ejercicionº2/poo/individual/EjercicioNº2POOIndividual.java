
package ejercicionº2.poo.individual;

import logica.Persona;

public class EjercicioNº2POOIndividual {

    public static void main(String[] args) {
        
        //Crear un vector de tipo Persona cinco posiciones. Crear cinco personas y guardarlas en él.
        //id, nombre, edad, dirección y número de teléfono
        
        Persona p1 = new Persona("HAOA720715", "Alberto Haboba Ocejo", 52, "Av Mexico 8b", "52 552511 7423");
        Persona p2 = new Persona("GARC840101", "María García López", 20, "Calle Reforma 12", "55 3456 7890");
        Persona p3 = new Persona("LARZ900215", "Ana Lara Zamora", 33, "Av Juárez 45", "55 2345 6789");
        Persona p4 = new Persona("ROSA750305", "Carmen Rosales Díaz", 48, "Calle Hidalgo 23", "55 1234 5678");
        Persona p5 = new Persona("LOPG860920", "Patricia López Gómez", 27, "Blvd Insurgentes 10", "55 9876 5432");

        Persona Personas[] = {p1, p2, p3, p4, p5};
        
        //Recorrer el vector creado y mostrar por pantalla el nombre y edad de cada persona almacenada.
        
        System.out.println("Todas las personas en el array: \n");
        for (int i = 0; i < Personas.length; i++) {
            String nombre = Personas[i].getNombre(); 
            int edad = Personas[i].getEdad();   
            System.out.println(nombre + " " + edad + " años.");
            }
        
        //Cambiar el nombre de dos personas. Mostrar por pantalla el antes, realizar el cambio y luego mostrar el después de los datos de las dos personas cuyos nombres fueron cambiados.
        
        System.out.println("\n\nAntes del cambio:\n");
        
        System.out.println(p2.toString());
        System.out.println(p4.toString());
        
        p2.setNombre("María Luisa García López");
        p4.setNombre("Carmela Rosales Díaz");
        
        System.out.println("\n\nDespues del cambio:\n");
        
        System.out.println(p2.toString());
        System.out.println(p4.toString());
        
        //Recorrer el vector y mostrar por pantalla únicamente a las personas cuya edad sea mayor de 30 años.
        System.out.println("\n\nMayores de 30 años: \n");
        
        for (int i = 0; i < Personas.length; i++) {
            int edad = Personas[i].getEdad(); 
            if (edad > 30){
                System.out.println(Personas[i].toString());
            }
        }

    }
    
}
