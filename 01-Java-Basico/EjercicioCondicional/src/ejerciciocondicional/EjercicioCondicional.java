/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciocondicional;
import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class EjercicioCondicional {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su peso en Kg:");
        int peso = teclado.nextInt();
        if (peso <= 100) {
            System.out.println("Bienvenido");
        } else {
            int diferencia = peso - 100;
            System.out.println("Lo siento te pasas por " + diferencia + " Kg.");            
        }
    }
    
}
