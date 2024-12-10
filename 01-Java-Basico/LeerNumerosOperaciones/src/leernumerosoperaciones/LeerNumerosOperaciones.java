/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package leernumerosoperaciones;
import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class LeerNumerosOperaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese primer numero:");
        int primero = teclado.nextInt();
        System.out.println("Ingrese primer numero:");
        int segundo = teclado.nextInt();
        int suma = primero + segundo;
        int resta = primero - segundo;
        int multi = primero * segundo;
        int div = primero / segundo;
        
        
        System.out.println("La suma de " + primero  + " + " + segundo + " es " + suma);
        System.out.println("La resta de " + primero  + " - " + segundo + " es " + resta);
        System.out.println("La multiplicacion de " + primero  + " x " + segundo + " es " + multi);
        System.out.println("La divicion de " + primero  + " x " + segundo + " es " + div);
    }
    
}
