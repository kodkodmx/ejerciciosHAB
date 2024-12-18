package ejerciciolistas;

import java.util.ArrayList;
import java.util.Scanner;
import logica.Producto;

public class EjercicioListas {

    public static void main(String[] args) {
        
        ArrayList<Producto> lista = new ArrayList<Producto>();
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        
        while (salir == false){
            
            System.out.println("---------------------------------------------" );
            System.out.println("| Opciones: 1:Agregar  2:Buscar  3:Terminar |" );
            System.out.println("---------------------------------------------" );

            int select = teclado.nextInt();

            if (select == 1){
                teclado.nextLine();
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();
                System.out.print("Marca: ");
                String marca = teclado.nextLine();
                System.out.print("Precio: ");
                int precio = teclado.nextInt();
                System.out.println("Producto Capturado"); 
                lista.add(new Producto(nombre,marca,precio));
            }else if (select == 2){

                teclado.nextLine();
                System.out.print("Nombre: ");
                String nombre = teclado.nextLine();
                boolean na = true;
                for(Producto producto : lista){
                    if (producto.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                        System.out.println(producto);
                        na = false;                
                    }
                }
                if (na){
                    System.out.println("Producto no encontrado");
                }
            }else{
                System.out.println("Adieu...");
                salir = true;
            }
            
        }

        
        

    }
    
}
