package ejerciciocrudproductos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Producto;
import persistencia.ControladoraPersistencia;

public class EjercicioCRUDProductos {

    public static void main(String[] args) throws ProductoNoEncontradoException {
        int opcion, stock, id = 0;
        boolean menu = true, idValido = false;
        String nombre, entrada;
        double precio;

        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        List<Producto> productos = new ArrayList<Producto>();
        Scanner teclado = new Scanner(System.in);

        while (menu) {
            System.out.println("\n");
            System.out.println("+---------------------------------------------+");
            System.out.println("|      1. Alta Producto                       |");
            System.out.println("|      2. Consultar Todos los Productos       |");
            System.out.println("|      3. Modificar Producto                  |");
            System.out.println("|      4. Baja Producto por ID                |");
            System.out.println("|      5. Salir                               |");
            System.out.println("+---------------------------------------------+");
            System.out.print("Selecciona una opcion: ");

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\nCaptura los datos del producto a dar de alta");
                    teclado.nextLine();
                    System.out.print("Nombre: ");
                    nombre = teclado.nextLine();
                    try {
                        validarNombre(nombre);

                    } catch (NombreInvalidoException e) {
                        System.out.println(e.getCause() + ": " + e.getMessage());
                        break;
                    }

                    System.out.print("Precio: ");
                    precio = teclado.nextDouble();
                    try {
                        validarPrecio(precio);

                    } catch (PrecioInvalidoException e) {
                        System.out.println(e.getCause() + ": " + e.getMessage());
                        break;
                    }

                    System.out.print("Cantidad: ");
                    stock = teclado.nextInt();
                    try {
                        validarStock(stock);

                    } catch (StockInvalidoException e) {
                        System.out.println(e.getCause() + ": " + e.getMessage());
                        break;
                    }

                    Producto prod = new Producto(0, nombre, precio, stock);
                    controlPersis.crearProducto(prod);

                    System.out.println("\nProducto Dado de Alta Correctamente en Base de Datos");
                    break;

                case 2:
                    productos = controlPersis.traerTodos();
                    for (Producto producto : productos) {
                        System.out.println(producto);
                    }
                    break;

                case 3:
                    teclado.nextLine();
                    productos = controlPersis.traerTodos();
                    idValido = false;

                    while (!idValido) {
                        System.out.print("\nID del producto a modificar: ");
                        entrada = teclado.nextLine();

                        try {
                            id = Integer.parseInt(entrada);
                            idValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("\nEl ID debe ser un número válido.\n");
                        }
                    }

                    Producto productoAModificar = null;


                    for (Producto producto : productos) {
                        if (id == producto.getId()) {
                            productoAModificar = producto;
                            break; 
                        }
                    }

                    try {
                        if (productoAModificar == null) {
                            throw new ProductoNoEncontradoException("\nNo existe ningún producto con ese ID.");
                        }
                    } catch (ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    
                    System.out.println("\nCaptura los nuevos datos.");


                    System.out.print("Nuevo nombre: ");
                    nombre = teclado.nextLine();
                    try {
                        validarNombre(nombre);
                    } catch (NombreInvalidoException e) {
                        System.out.println(e.getMessage());
                        return; 
                    }


                    System.out.print("Nuevo precio: ");
                    precio = teclado.nextDouble();
                    try {
                        validarPrecio(precio);
                    } catch (PrecioInvalidoException e) {
                        System.out.println(e.getMessage());
                        return; 
                    }


                    System.out.print("Nueva cantidad: ");
                    stock = teclado.nextInt();
                    try {
                        validarStock(stock);
                    } catch (StockInvalidoException e) {
                        System.out.println(e.getMessage());
                        return; 
                    }


                    productoAModificar.setNombre(nombre);
                    productoAModificar.setPrecio(precio);
                    productoAModificar.setStock(stock);


                    controlPersis.modificarProducto(productoAModificar);

                    System.out.println("\nProducto modificado correctamente.");
                    break;
                    
                case 4:
                    
                    teclado.nextLine();
                    productos = controlPersis.traerTodos();
                    idValido = false;

                    while (!idValido) {
                        System.out.print("\nID del producto a eliminar: ");
                        entrada = teclado.nextLine();

                        try {
                            id = Integer.parseInt(entrada);
                            idValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("\nEl ID debe ser un número válido.\n");
                        }
                    }
                    
                    Producto productoAEliminar = null;


                    for (Producto producto : productos) {
                        if (id == producto.getId()) {
                            productoAEliminar = producto;
                            break; 
                        }
                    }

                    try {
                        if (productoAEliminar == null) {
                            throw new ProductoNoEncontradoException("\nNo existe ningún producto con ese ID.");
                        }
                    } catch (ProductoNoEncontradoException e) {
                        System.out.println(e.getMessage());
                        break;
                    }
                    
                    controlPersis.borrarProducto(id);
                    break;
                    
                    
                case 5:
                    menu = false;
                    break;

            }

        }
    }

    public static void validarNombre(String nombre) throws NombreInvalidoException {
        if (nombre.isEmpty()) {
            throw new NombreInvalidoException("Nombre no puede estar vacio");

        }
    }

    private static void validarPrecio(double precio) throws PrecioInvalidoException {
        if (precio <= 0.0) {
            throw new PrecioInvalidoException("Precio debe ser mayor a 0");
        }

    }

    private static void validarStock(int stock) throws StockInvalidoException {
        if (stock <= 0) {
            throw new StockInvalidoException("Cantidad debe ser mayor a 0");
        }

    }

}
