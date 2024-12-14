package ejerciciomatrices;

import java.util.Scanner;
import logica.Producto;


public class EjercicioMatrices {


    public static void main(String[] args) {
        
        Producto productos [][] = new Producto[3][3];
        
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < productos.length; i++){
            for (int j = 0; j < productos[0].length; j++){
                teclado = new Scanner(System.in);
                System.out.println("Por favor registra tus 9 productos");
                System.out.print("Nombre del producto " + (i+1)*(j+1) + ": ");
                productos[i][j] = new Producto();
                productos[i][j].setNombre(teclado.nextLine());
                System.out.print("Categoria del producto " + (i+1)*(j+1) + ": ");
                productos[i][j].setCategoria(teclado.nextLine());
                System.out.print("Precio del producto " + (i+1)*(j+1) + ": ");
                teclado = new Scanner(System.in);
                productos[i][j].setPrecio(teclado.nextInt());
            }
            
        }
        
    }
    
}
