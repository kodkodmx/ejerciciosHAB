/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciowhilebandera;
import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class EjercicioWhileBandera {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        
        int edad = 0;
        
        while (edad <= 70){
            System.out.println("Ingrese su edad");
            edad = teclado.nextInt();
            
        }
        System.out.println("Persona Encontrada ");
    }
    
}

