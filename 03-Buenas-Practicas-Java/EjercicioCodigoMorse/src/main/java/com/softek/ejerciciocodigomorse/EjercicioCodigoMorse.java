package com.softek.ejerciciocodigomorse;

import com.softek.ejerciciocodigomorse.logica.TraductorMorse;
import java.util.Scanner;

public class EjercicioCodigoMorse {

    public static void main(String[] args) {
        TraductorMorse traductor = new TraductorMorse();
        Scanner teclado = new Scanner(System.in);
        int opcion;
        String captura;

        System.out.println("1)Traductor de Morse a Español\n2)Traductor de Español a Morse");
        opcion = teclado.nextInt();
        teclado.nextLine();

        System.out.print("Dame la frase ( .- .-.. -... . .-. - ---   .... .- -... --- -... .- ): ");
        captura = teclado.nextLine();
        if (opcion == 1) {
            String[] palabras = captura.split("   ");
            StringBuilder textoFrase = new StringBuilder();

            for (String palabra : palabras) {
                String[] letras = palabra.split(" ");
                for (String letra : letras) {
                    char caracter = traductor.aEspañol(letra);
                    textoFrase.append(caracter);
                }
                textoFrase.append(" ");
            }
            System.out.println("Traducción a Español: " + textoFrase);

        } else if (opcion == 2) {
            StringBuilder textoFrase = new StringBuilder();
            for (int i = 0; i < captura.length(); i++) {
                char caracter = captura.charAt(i);
                if (caracter != ' ') {
                    textoFrase.append(traductor.aMorse(caracter)+ " ");
                } else {
                    textoFrase.append("   ");
                }
                
            }
            System.out.println(textoFrase);
        }
    }
}
