/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package estructurascondicionalesindividual;

import java.util.Scanner;

/**
 *
 * @author betoh
 */
public class EstructurasCondicionalesIndividual {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("Edad?");
        int edad = teclado.nextInt();
        if(edad >= 18){
            System.out.println("Bienvenido");
        }else{
            System.out.println("Caminale");
        }
    }
    
}
