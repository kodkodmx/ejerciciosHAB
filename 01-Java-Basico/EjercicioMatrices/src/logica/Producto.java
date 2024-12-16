
package logica;

import java.util.Scanner;


public class Producto {
    
    public String nombre;
    public int precio;
    public String categoria;

    public Producto() {
    }

    public Producto(String nombre, int precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", precio=" + precio + ", categoria=" + categoria + '}';
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
