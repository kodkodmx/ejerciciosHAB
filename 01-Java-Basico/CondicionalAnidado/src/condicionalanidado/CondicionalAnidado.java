/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package condicionalanidado;
import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class CondicionalAnidado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el precio:");
        int precio = teclado.nextInt();
        if (precio < 50) {
            System.out.println("Economico");
        } else if (precio <= 100) {
            System.out.println("Accesible");           
        } else if (precio <= 200) {
            System.out.println("Estandar");           
        } else {
            System.out.println("Premium");           
        }
    }
    
}
