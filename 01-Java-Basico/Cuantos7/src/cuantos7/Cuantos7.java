/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuantos7;

import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class Cuantos7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numeros [] = new int[15];
        int sietes =0;
        Scanner teclado = new Scanner (System.in);
        System.out.println("Numeros a guardar");
          for(int i=0; i<numeros.length; i++ ){
            numeros[i]=teclado.nextInt();
            if (numeros[i] == 7){
            sietes ++;
            }
        }
          if (sietes >0){
              System.out.println("Hubo " + sietes + " Sietes");
          }
          else{
              System.out.println("No hay sietes");
          }
        
        
    }
    
}
