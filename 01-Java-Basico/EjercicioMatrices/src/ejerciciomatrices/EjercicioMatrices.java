package ejerciciomatrices;

import java.util.Scanner;
import logica.Producto;
import static logica.Producto.buscarProducto;

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
    
    
}