/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructurasrepetitivasindividual;

import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class EstructurasRepetitivasIndividual {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        Integer precio = null;
        int total=0;
        System.out.println("Captura el precio de los productos, para terminar ingresa \"0\"");
        
        while (precio == null || precio != 0){
            System.out.println("Precio?");
            precio = teclado.nextInt();
            total += precio;
        }
        System.out.println("Total: $" + total);
    }
}
