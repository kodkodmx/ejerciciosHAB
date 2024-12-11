package sumanumeros;

import java.util.Scanner;

public class SumaNumeros {

    public static void main(String[] args) {
        int total = 0;
        int numero = 0; 
        Scanner teclado = new Scanner(System.in);

        System.out.println("Ingresa números para sumar (número negativo para salir)");

        while (numero >= 0) {
            System.out.println("Número a sumar:");
            numero = teclado.nextInt(); 

            if (numero >= 0) { 
                total += numero;
            }
        }

        System.out.println("La suma total es: " + total); 
    }
}
