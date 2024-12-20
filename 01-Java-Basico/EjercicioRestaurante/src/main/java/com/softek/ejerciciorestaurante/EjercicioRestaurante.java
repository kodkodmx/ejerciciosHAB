package com.softek.ejerciciorestaurante;

import java.util.List;
import logica.Platillo;
import peristencia.ControladoraPersistencia;


public class EjercicioRestaurante {

    public static void main(String[] args) {
        
        ControladoraPersistencia controlPersi = new ControladoraPersistencia();
        
        
        //creamos
        controlPersi.crearPlatillo(new Platillo(1,"Milanesa", "Receta Milanesa", 7));
        controlPersi.crearPlatillo(new Platillo(2,"Tacos", "Receta Tacos", 2));
        controlPersi.crearPlatillo(new Platillo(3,"Pizza", "Receta Pizza", 9));
        
        //traemos todo antes de modificar
        List<Platillo>listaPlatillos = controlPersi.traerPlatillos();
        
        //mostramos todo antes de modificar
        for (Platillo item:listaPlatillos){
            System.out.println(item.toString());
        }
        //borramos    
        controlPersi.borrarPlatillo(2);
        
        //modificamos
        controlPersi.modificarPlatillo(new Platillo(3,"Pizza", "Receta Pizza", 11));
        
        System.out.println("");
        System.out.println("");
        
        
        //traemos todo despues  de modificar
        listaPlatillos = controlPersi.traerPlatillos();
        
        //mostramos todo despues de modificar
        for (Platillo item:listaPlatillos){
            System.out.println(item.toString());
        }
    }
}