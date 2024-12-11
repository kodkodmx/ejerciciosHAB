package ejercicio.matriz;

import java.util.Scanner;

public class EjercicioMatriz {

    public static void main(String[] args) {
        int calificaciones[][] = new int[4][4];
        int suma = 0;
        int promedio;
        Scanner teclado = new Scanner(System.in);

        for (int i = 0; i < calificaciones.length; i++) {
            promedio = 0;
            suma = 0;
            for (int j = 0; j < calificaciones[0].length-1; j++) {
                System.out.println("Dame la calificación para la posición [" + i + "][" + j + "]:");
                calificaciones[i][j] = teclado.nextInt();
                suma += calificaciones[i][j];
                promedio = suma / (calificaciones[i].length-1);
                calificaciones[i][calificaciones[i].length-1] = promedio;
            }
        }

        System.out.println("\nMatriz de calificaciones:");
        for (int i = 0; i < calificaciones.length; i++) {
            for (int j = 0; j < calificaciones[i].length; j++) {
                System.out.print(calificaciones[i][j] + "\t");
            }
            System.out.println();
        }

        //System.out.println("\nEl promedio de las calificaciones es: " + promedio);
    }
}
