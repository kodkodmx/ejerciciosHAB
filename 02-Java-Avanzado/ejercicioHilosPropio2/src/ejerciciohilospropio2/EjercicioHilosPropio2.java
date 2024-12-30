package ejerciciohilospropio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjercicioHilosPropio2 {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        // Preguntar cuántos hilos crear
        System.out.print("¿Cuántos hilos deseas crear? ");
        int numHilos = scanner.nextInt();
        
        // Preguntar cuántas vueltas imprimir por hilo
        System.out.print("¿Cuántas vueltas (repeticiones) debe dar cada hilo? ");
        int vueltas = scanner.nextInt();

        // Lista para almacenar los hilos
        List<Thread> hilos = new ArrayList<>();

        // Crear y ejecutar los hilos por cada vuelta
        for (int v = 0; v < vueltas; v++) {
            for (int i = 0; i < numHilos; i++) {
                final int hiloNum = i; // El número del hilo
                Thread hilo = new Thread(new ImprimirNumero(hiloNum));
                hilos.add(hilo);
                hilo.start();
            }
            
            // Esperar a que todos los hilos terminen con join()
            for (Thread hilo : hilos) {
                hilo.join();
            }
            
            // Limpiar la lista de hilos después de cada vuelta
            hilos.clear();
            
            // Saltar a la siguiente línea después de cada vuelta
            System.out.println();
        }
    }
}

class ImprimirNumero implements Runnable {
    private final int numero;

    public ImprimirNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void run() {
        // Imprimir el número del hilo
        System.out.print(numero);
    }
}
