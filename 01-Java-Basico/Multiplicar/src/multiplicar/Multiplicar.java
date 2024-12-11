package multiplicar;

import java.util.Scanner;

public class Multiplicar {

    public static void main(String[] args) {
        int numero; 
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Ingresa un número para mostrar su tabla de multiplicar:");
        numero = teclado.nextInt(); 
        
        if (numero >= 0) { 
            for (int cont = 1; cont <= 10; cont++) {
                System.out.println(numero + " x " + cont + " = " + (numero * cont));
            }
        } else {
            System.out.println("El número debe ser positivo para generar la tabla de multiplicar.");
        }

    }
}
