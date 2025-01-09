package veterinariaapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Animal;


public class VeterinariaApp {
    
    

    public static void main(String[] args) {
        String nombre;
        String peso;
        Double doublePeso = null;
        List<Animal> Pacientes = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < 3; i++){
            System.out.print("Nombre de la mascota: ");
            nombre = teclado.nextLine();
            System.out.print("Peso de la mascota: ");
            peso = teclado.nextLine();
            try {
                    doublePeso = Double.parseDouble(peso);
                    Animal paciente = new Animal(nombre, doublePeso);
                    Pacientes.add(paciente);
       
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingresa un valor numérico válido para el peso.");
            }
         }    
            
        System.out.println("\nInformación de los pacientes:");
        Pacientes.forEach(Animal::mostrarInfo);   
        
        
    }
    
}
