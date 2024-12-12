/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciomatricesteatro;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author betoh
 */
public class EjercicioMatricesTeatro {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        char teatro[][]= new char[5][5];
        int fila;
        int asiento;
        boolean continuar = true;
        
        for (int i = 0; i < teatro.length; i++) {
            for (int j = 0; j < teatro[i].length; j++) {
                teatro[i][j] = 'O';
            }
        }

        
        while (continuar){
            System.out.println("¿Que Asiento quieres reservar?\n\n");
            System.out.println("Vacios: O | Ocupados: X \n");
            System.out.println(" | 0 1 2 3 4  F");
            System.out.println("-+----------");
            for (int i = 0; i < teatro.length; i++) {
                System.out.print(i + "| ");
                for (int j = 0; j < teatro[i].length; j++) {
                    System.out.print(teatro[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("\nC");
            System.out.println("\n\nEn que fila quieres tus asiento?");
            fila = teclado.nextInt();
            
            System.out.println("Que Asiento?");
            asiento = teclado.nextInt();
            
            if (teatro[fila][asiento] == 'X'){
                System.out.println("***El Asiento ya esta ocupado***\n"); 
            }else{
                teatro[fila][asiento] = 'X';
            }
            System.out.println("¿Quieres reservar otro? (N para no)");
            teclado = new Scanner(System.in);
            String res = teclado.nextLine();
            if (res.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }
    }
    
}
