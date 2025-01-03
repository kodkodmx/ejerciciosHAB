package com.mycompany.ejerciciotorneomundialprogramacion;

import java.time.LocalDate;
import logica.Categoria;
import logica.Inscripcion;
import logica.Programador;
import logica.Torneo;
import persistencia.ControladoraPersistencia;

public class EjercicioTorneoMundialProgramacion {

    public static void main(String[] args) {
        
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        Torneo torneo = new Torneo();
        torneo.setNombre("Torneo Mundial de Programación");
        controlPersis.crearTorneo(torneo);

        Categoria categoria1 = new Categoria();
        categoria1.setNombre("Hackathons Relámpago");
        categoria1.setTorneo(torneo);
        Categoria categoria2 = new Categoria();
        categoria2.setNombre("Algoritmos en Tiempo Real");
        categoria2.setTorneo(torneo);

        controlPersis.crearCategoria(categoria1);
        controlPersis.crearCategoria(categoria2);

        Inscripcion inscripcion1 = new Inscripcion();
        inscripcion1.setFecha(LocalDate.now());
        inscripcion1.setCategoria(categoria1);

        Inscripcion inscripcion2 = new Inscripcion();
        inscripcion2.setFecha(LocalDate.now());
        inscripcion2.setCategoria(categoria2);

        Inscripcion inscripcion3 = new Inscripcion();
        inscripcion3.setFecha(LocalDate.now());
        inscripcion3.setCategoria(categoria1);
        
        Programador programador1 = new Programador();
        programador1.setNombre("Juan");
        programador1.setApellido("Pérez");
        programador1.setNivelAcademico("Intermedio");
        programador1.setUnaInscripcion(inscripcion1);
        controlPersis.crearProgramador(programador1);

        Programador programador2 = new Programador();
        programador2.setNombre("Ana");
        programador2.setApellido("Gómez");
        programador2.setNivelAcademico("Avanzado");
        programador2.setUnaInscripcion(inscripcion2);
        controlPersis.crearProgramador(programador2);

        Programador programador3 = new Programador();
        programador3.setNombre("Carlos");
        programador3.setApellido("Martínez");
        programador3.setNivelAcademico("Principiante");
        programador3.setUnaInscripcion(inscripcion3);
        controlPersis.crearProgramador(programador3);

        System.out.println("Datos cargados exitosamente.");
    }
}
