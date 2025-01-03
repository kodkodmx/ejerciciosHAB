package com.mycompany.ejercicioonetoone;

import logica.Director;
import logica.Oficina;
import persistencia.ControladoraPersistencia;

public class EjercicioOneToOne {

    public static void main(String[] args) {
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        Director dir = new Director (11111L, "Alberto", "Haboba", "123","Soltero", null);
        Oficina ofi = new Oficina (22222L, "CDMX", "Mexico", dir );
        dir.setOfi(ofi);
        
       controlPersis.crearOficina(ofi);
        
        
        
    }
}
