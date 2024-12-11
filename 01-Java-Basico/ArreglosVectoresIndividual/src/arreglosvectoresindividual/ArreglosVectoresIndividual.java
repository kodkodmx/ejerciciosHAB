/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package arreglosvectoresindividual;

import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class ArreglosVectoresIndividual {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        double temperaturas[] = new double[7];
        int i = 0;
        double total =0;
        System.out.println("Dame 7 temperaturas:");
        while (i < temperaturas.length){
        System.out.println("Dame la temperatura " + (i+1));
        double temp = teclado.nextDouble();
        temperaturas[i]= temp;
        i++;
        }
        System.out.println("\nAsi se ve el vector: ");
        for (i = 0; i<temperaturas.length;i++){
            System.out.print(temperaturas[i]+ "\t" );
            total += temperaturas[i];
        }
        System.out.println("\n");
        System.out.println("La temperatura promedio fue de " + total/7);        
    }
    
}
