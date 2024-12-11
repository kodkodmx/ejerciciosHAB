/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploarrays;

import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class EjemploArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numeros [] = new int[5];
        numeros [0]=32;
        numeros [1]=77;
        numeros [2]=88;
        numeros [3]=99;
        numeros [4]=100;
        
        
        Scanner teclado = new Scanner (System.in);
        System.out.println("Numeros a guardar");
        for(int i=0; i<=4; i++ ){
            numeros[i]=teclado.nextInt();
        }
        
        for(int i=0; i<=4; i++ ){
            System.out.println("el numero es " + numeros[i]);
        }
    }
    
}
