package ejerciciomanejodeinventariosenuncomercio;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import logica.Producto;
import logica.opcionInvalidaException;

public class EjercicioManejoDeInventariosEnUnComercio {

    public static void main(String[] args) throws opcionInvalidaException {
        
        List<Producto> listaProductos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String nombre;
        double precio = 0;
        int stock = 0;
        char opcion;
        boolean salir = false, precioValido, stockValido;
        
        while (!salir) {
            System.out.print("(A)gregar, (V)er Inventario o (S)alir: ");
            opcion = teclado.next().charAt(0);
            
            if (opcion == 'A' || opcion == 'a') {
                precioValido = false;
                stockValido = false;
                teclado.nextLine(); 
                System.out.print("Producto: ");
                nombre = teclado.nextLine();
                if (nombre.isEmpty() || nombre.isBlank()){
                    throw new opcionInvalidaException("El nombre no puede estar vacio");
                }
                while (!precioValido) {
                    System.out.print("Precio: ");
                    try {
                        precio = teclado.nextDouble();
                        if (precio <= 0) { 
                            throw new InputMismatchException("El precio debe ser mayor que 0.");
                        }
                        teclado.nextLine(); 
                        precioValido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                        teclado.nextLine();
                    }
                }

                while (!stockValido) {
                    System.out.print("Stock: ");
                    try {
                        stock = teclado.nextInt();
                        teclado.nextLine(); 
                        stockValido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, introduce un número válido.");
                        teclado.nextLine();
                    }
                }   
                              
                Producto nuevoProducto = new Producto(nombre, precio, stock);
                boolean productoExistente = false;
                
                for (Producto produ : listaProductos) {
                    if (produ.getNombre().equalsIgnoreCase(nuevoProducto.getNombre())) {
                        produ.setStock(produ.getStock() + nuevoProducto.getStock());
                        produ.setPrecio(nuevoProducto.getPrecio());
                        productoExistente = true;
                        break;
                    }
                }
                
                if (!productoExistente) {
                    listaProductos.add(nuevoProducto);
                    System.out.println("Nuevo producto agregado correctamente.");
                } else {
                    System.out.println("Producto existente. Stock y precio actualizados.");
                }
                
            } else if (opcion == 'V' || opcion == 'v') {
                if (listaProductos.isEmpty()) {
                    System.out.println("No hay productos en el inventario.");
                } else {
                    System.out.println("Lista de productos:");
                    for (Producto producto : listaProductos) {
                        System.out.println(producto);
                    }
                }
                
            } else if (opcion == 'S' || opcion == 's') {
                salir = true;
            } else {
                throw new opcionInvalidaException("La opción '" + opcion + "' no es válida.");
            }
        }
        
        teclado.close();
    }
}
