package com.mycompany.ejerciciocrudproductos;

import java.util.Scanner;
import logica.Producto;
import persistencia.ControladoraPersistencia;


public class EjercicioCRUDProductos {

    public static void main(String[] args) {
        int opcion = 0;
        boolean opcionValida = true;
        Scanner teclado = new Scanner(System.in);

        while (opcionValida) {
            System.out.println("\n");
            System.out.println("+---------------------------------------------+");
            System.out.println("|      1. Alta Producto                       |");
            System.out.println("|      2. Consultar Todos los Productos       |");
            System.out.println("|      4. Modificar Producto                  |");
            System.out.println("|      5. Baja Producto por ID                |");
            System.out.println("|      6. Salir                               |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Selecciona una opcion: ");

            opcion = teclado.nextInt();
            ControladoraPersistencia controlPersis = new ControladoraPersistencia();

            switch(opcion){
                
            
            case 1:
                
                
                Producto prod  = new Producto (0, "Prueba", 5.5, 10);
                controlPersis.crearProducto(prod);
                break;
            }
        
        }
    }
}
