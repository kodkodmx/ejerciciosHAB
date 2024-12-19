package com.mycompany.jpa;

import logica.Persona;
import persistencia.ControladoraPersistencia;
import java.util.List;

public class Jpa {

    public static void main(String[] args) {
        
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        //recuerda que como es un Long se especifica con una L mayúscula a la derecha
        Persona pers  = new Persona (1L, "Luisina", 32);
        
        //creamos una persona en la BD
        controlPersis.crearPersona(pers);
        
        controlPersis.crearPersona(new Persona (2L, "Prueba borrar", 23));
        controlPersis.crearPersona(new Persona (3L, "Otro más", 35));
        
        //borramos el registro "Prueba Borrar" mediante su id (en este caso sería la 2)
        
        controlPersis.borrarPersona(2L);
        
        //editamos el primer registro cambiando la edad
        //antes era 32 ahora será 31
        pers.setEdad(31);
        controlPersis.modificarPersona(pers);
        
        //mostrar todas las personas de la tabla mediante find entities
        List<Persona> listaPersonas = controlPersis.traerPersonas();
        
        //usando for each para recorrer la collection
        System.out.println("----Lista de personas----");
        for (Persona per:listaPersonas) {
            System.out.println(per.toString());
        }
        
    }
}
