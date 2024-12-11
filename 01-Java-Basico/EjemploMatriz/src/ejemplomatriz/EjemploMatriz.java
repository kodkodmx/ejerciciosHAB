package ejemplomatriz;

import java.util.Scanner;

public class EjemploMatriz {
    public static void main(String[] args) {
        // TODO code application logic here
        int edades [][] = new int[3][2];
        
        // manual   
        edades [0][0]=32;
        edades [0][1]=77;
        edades [1][0]=88;
        edades [1][1]=99;
        edades [2][0]=100;
        edades [2][1]=100;
        
        Scanner teclado = new Scanner (System.in);
        
        //por teclado
        for(int f=0; f<edades.length;f++){
            for(int c=0; c<edades[0].length;c++){
                System.out.println("Ingrese el valor para la fila:"+f+" columna:"+c);
                edades[f][c]=teclado.nextInt();
            }
        }
        System.out.println("\n\nAsi queda la matriz:");
        for(int f=0; f<edades.length;f++){
            for(int c=0; c<edades[0].length;c++){
                System.out.print(edades[f][c] + "\t");
            }
            System.out.println();
        }
        
    }
    
}
