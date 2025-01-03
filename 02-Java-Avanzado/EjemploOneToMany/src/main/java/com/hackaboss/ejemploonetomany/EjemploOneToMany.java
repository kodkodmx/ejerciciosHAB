package com.hackaboss.ejemploonetomany;

import java.util.ArrayList;
import java.util.List;
import logica.Carrito;
import logica.Item;
import persistencia.ControladoraPersistencia;

public class EjemploOneToMany {

    public static void main(String[] args) {
        
        //crear productos/items
        //crear carrito
        //agregar los productos a ese carrito
        
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        List<Item> listaItems = new ArrayList<Item>();
        //listaItems = null;
        listaItems.add(new Item (12L, "Arroz",null));
        listaItems.add(new Item (13L, "Fideo",null));
        
        Carrito carrito = new Carrito(1L, "Mi carrito de compras", listaItems);

        
        //no debería hacerse
        for (Item i : listaItems) {
            i.setCarrito(carrito);
        }
        
        controlPersis.crearCarrito(carrito);
        
    }
}
