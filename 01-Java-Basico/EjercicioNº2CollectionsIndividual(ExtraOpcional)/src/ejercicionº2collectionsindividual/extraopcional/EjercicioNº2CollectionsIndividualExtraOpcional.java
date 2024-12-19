package ejercicionº2collectionsindividual.extraopcional;

import logica.Producto;
import java.util.ArrayList;

/*A partir de esto, realizar las siguientes acciones en el programa desarrollado:
a) Crear 10 objetos de tipo Producto con sus correspondientes valores cargados (por ejemplo, teléfono, laptop, auriculares/cascos, cargador, tablet, etc).
b) Guardar estos objetos creados en un ArrayList.
c) Recorrer el ArrayList y determinar el producto con el mayor precio de venta.
d) Recorrer el ArrayList y determinar el producto con el menor precio de costo.
e) Borrar el producto que se encuentre en la posición 5 del ArrayList.
f) Determinar el producto que tenga la mayor cantidad en stock. A ese producto, descontarle 3 unidades del stock y actualizar el registro en la lista en base a eso.
g) Mostrar siempre por consola un mensaje informativo luego de resolver cada punto.*/

public class EjercicioNº2CollectionsIndividualExtraOpcional {

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();

        Producto p1 = new Producto("A2188Z", "Laptop", "Asus", "Gamer", 89990, 14599, 7);
        Producto p2 = new Producto("B3921X", "Teléfono", "Samsung", "Galaxy S23", 59999, 12000, 15);
        Producto p3 = new Producto("C7834Y", "Tablet", "Apple", "iPad Pro", 120000, 25000, 10);
        Producto p4 = new Producto("D5678W", "Auriculares", "Sony", "WH-1000XM5", 29990, 8000, 20);
        Producto p5 = new Producto("E1245V", "Cargador", "Belkin", "30W USB-C", 1999, 500, 50);
        Producto p6 = new Producto("F6789U", "Monitor", "LG", "UltraWide", 34999, 8000, 12);
        Producto p7 = new Producto("G8901T", "Teclado", "Logitech", "Mechanical", 4999, 1500, 25);
        Producto p8 = new Producto("H9012S", "Mouse", "Razer", "DeathAdder", 2999, 1200, 30);
        Producto p9 = new Producto("I3456R", "Smartwatch", "Garmin", "Forerunner", 44999, 12000, 5);
        Producto p10 = new Producto("J7890Q", "Cámara", "Canon", "EOS M50", 119999, 30000, 8);
        
        System.out.println("Creados 10 objetos de tipo Producto");
        
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);
        productos.add(p9);
        productos.add(p10);
        
        System.out.println("Guardados estos objetos creados en un ArrayList.");

        Producto pMaximo = productos.get(0);
        Producto pMinimo = productos.get(0);
        Producto sMaximo = productos.get(0);
        int index = 0;
        int stock = 0;

        for (int i = 0;i<productos.size();i++) {
            
            if (productos.get(i).getPrecioVenta() > pMaximo.getPrecioVenta()) {
                pMaximo = productos.get(i);
            }

            if (productos.get(i).getPrecioCosto() < pMinimo.getPrecioCosto()) {
                pMinimo = productos.get(i);
            }
            
            if (productos.get(i).getStock() > sMaximo.getStock()) {
                sMaximo = productos.get(i);
                index = i;
                
            }
        }

        System.out.println("El producto con el precio de venta mayor es: " + pMaximo.getNombre() + " ($" + pMaximo.getPrecioVenta() + ")");
        System.out.println("El producto con el precio de costo menor es: " + pMinimo.getNombre() + " ($" + pMinimo.getPrecioCosto() + ")");
    
        Producto eliminado = productos.remove(5);
        System.out.println("Se eliminó el producto en la posición 5: " + eliminado.getNombre());
        
        
        System.out.println("El producto con el mayor stock es: " + sMaximo.getNombre() + " con " + sMaximo.getStock());
        sMaximo.setStock((sMaximo.getStock() - 3));
        productos.set(index, sMaximo);
        System.out.println("Al descontarle 3 tiene " + productos.get(index).getStock());   
    }
}
