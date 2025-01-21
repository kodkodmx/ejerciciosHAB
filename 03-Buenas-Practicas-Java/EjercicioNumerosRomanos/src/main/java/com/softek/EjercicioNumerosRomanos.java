package com.softek;

import java.util.Scanner;

public class EjercicioNumerosRomanos {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Romanos romanos = new Romanos();

        System.out.print("Ingresa un número entre 1 y 10: ");
        int numero = teclado.nextInt();

        String resultado = romanos.convertir(numero);
        System.out.println("El número en romano es: " + resultado);
    }
}
