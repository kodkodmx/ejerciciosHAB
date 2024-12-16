package ejerciciomatrices;

import java.util.Scanner;
import logica.Producto;

public class EjercicioMatrices {

    public static void main(String[] args) {
        
        Producto productos[][] = new Producto[3][3];
        
        Scanner teclado = new Scanner(System.in);
        int count = 1; 
        for (int i = 0; i < productos.length; i++) {
            for (int j = 0; j < productos[0].length; j++) {
                System.out.println("\n¡¡ Por favor registra el producto numero " + count + " !!\n");
                System.out.print("Nombre del producto " + count + ": ");
                productos[i][j] = new Producto();
                productos[i][j].setNombre(teclado.nextLine());
                System.out.print("Categoria del producto " + count + ": ");
                productos[i][j].setCategoria(teclado.nextLine());
                System.out.print("Precio del producto " + count + ": ");
                productos[i][j].setPrecio(teclado.nextInt());
                teclado.nextLine(); 
                System.out.println("Producto registrado correctamente \n");
                count++;
            }
        }
        System.out.println("Todos los productos se han registrado correctamente \n");
        
        boolean salir = false;
        while (!salir) {
            salir = buscarProducto(productos);
        }
        
        teclado.close();
        System.out.println("\nGracias por usar nuestro sistema\n");
    }
    
    public static boolean buscarProducto(Producto[][] productos) {
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("\n¿Desea buscar algun producto? (S/N) ");
        String respuesta = teclado.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.print("\nNombre del producto a buscar: ");
            String nombre = teclado.nextLine();
            boolean encontrado = false;
            for (int i = 0; i < productos.length; i++) {
                for (int j = 0; j < productos[0].length; j++) {
                    if (productos[i][j].getNombre().equals(nombre)) {
                        System.out.println("\nProducto encontrado: ");
                        System.out.println("Nombre: " + productos[i][j].getNombre());
                        System.out.println("Categoria: " + productos[i][j].getCategoria());
                        System.out.println("Precio: " + productos[i][j].getPrecio());
                        System.out.println("El producto se encuentra en la posicion [" + i + "][" + j + "]");
                        encontrado = true;
                    }
                }
            }
            if (!encontrado) {
                System.out.println("\nProducto no encontrado");
            }
            return false;
        } else {
            return true;
        }
    }
}