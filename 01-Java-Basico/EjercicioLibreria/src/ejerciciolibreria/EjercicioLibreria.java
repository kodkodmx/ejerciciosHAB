
package ejerciciolibreria;

import java.util.Arrays;
import java.util.Scanner;
import logica.Libro;

public class EjercicioLibreria {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        Libro libros[] = new Libro[2];
        
        System.out.println("Bienvenido al sistema de libreria");
        System.out.println("Ingrese los datos del libro que quiere cargar");
        
        //codigo ISBN, título, autor, género, número de páginas.
        Libro book = new Libro();
        
        for (int i=0; i<libros.length; i++){
            
            
            System.out.println("Ingrese ISBN");
            book.setIsbn(teclado.nextLine());

            System.out.println("Ingrese Titulo");
            book.setTitulo(teclado.nextLine());

            System.out.println("Ingrese Autor");
            book.setAutor(teclado.nextLine());

            System.out.println("Ingrese Genero");
            book.setGenero(teclado.nextLine());

            teclado = new Scanner(System.in);

            System.out.println("Ingrese Numero de Paginas");
            book.setPaginas(teclado.nextInt());
            
            System.out.println("Antes del cambio");
            System.out.println(book.toString());

            book.setPaginas(i);
            
            System.out.println("Despues del cambio");
            System.out.println(book.toString());
            
            libros[i] = book;
            teclado = new Scanner(System.in);
            book = new Libro();
            
        }
        
        System.out.println("Arreglo completo:");
        System.out.println(Arrays.toString(libros));
        for(int j=0;j<libros.length;j++){
            System.out.println(libros[j].toString());
        }
                  
    }

}
    
