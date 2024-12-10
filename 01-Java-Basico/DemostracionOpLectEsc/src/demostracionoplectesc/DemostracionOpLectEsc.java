/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demostracionoplectesc;
import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class DemostracionOpLectEsc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese su nombre:");
        String nombre = teclado.nextLine();
        //String nombre = teclado.nextLine();
        
        System.out.println("Su nombre es: " + nombre);
        System.out.println("Ingrese su nombre:");
        int edad = teclado.nextInt();
        System.out.println("Su edad es: " + edad);
    }
    
}
