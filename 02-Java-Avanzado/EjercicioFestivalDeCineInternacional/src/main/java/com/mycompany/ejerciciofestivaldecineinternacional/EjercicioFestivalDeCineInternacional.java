package com.mycompany.ejerciciofestivaldecineinternacional;

import java.time.LocalTime;
import logica.Sala;
import logica.Pelicula;
import logica.Horario;
import logica.Festival;
import persistencia.ControladoraPersistencia;

public class EjercicioFestivalDeCineInternacional {

    public static void main(String[] args) {
        
        ControladoraPersistencia controlPersis = new ControladoraPersistencia();
        
        Festival festival = new Festival();
        festival.setNombre("Festival Internacional de Cine \"Stanley Kubrick\"");
        controlPersis.crearFestival(festival);

        Sala sala1 = new Sala();
        sala1.setNombreSala("Sala 1");
        sala1.setFestival(festival);
        Sala sala2 = new Sala();
        sala2.setNombreSala("Sala 2");
        sala2.setFestival(festival);

        controlPersis.crearSala(sala1);
        controlPersis.crearSala(sala2);

        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("El Resplandor");
        pelicula1.setDirector("Stanley Kubrick");        
        pelicula1.setSala(sala1);

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Ojos Bien Cerrados");
        pelicula2.setDirector("Stanley Kubrick");      
        pelicula2.setSala(sala2);

        Pelicula pelicula3 = new Pelicula();
        pelicula3.setTitulo("Naranja Mecanica");
        pelicula3.setDirector("Stanley Kubrick"); 
        pelicula3.setSala(sala1);
        
        Horario horario1 = new Horario();
        horario1.setHoraInicio(LocalTime.of(12, 0));
        horario1.setHoraFin(LocalTime.of(14, 30));
        horario1.setUnaPelicula(pelicula1);
        controlPersis.crearHorario(horario1);

        Horario horario2 = new Horario();
        horario2.setHoraInicio(LocalTime.of(14, 0));
        horario2.setHoraFin(LocalTime.of(16, 30));
        horario2.setUnaPelicula(pelicula2);
        controlPersis.crearHorario(horario2);

        Horario horario3 = new Horario();
        horario3.setHoraInicio(LocalTime.of(16, 0));
        horario3.setHoraFin(LocalTime.of(18, 30));
        horario3.setUnaPelicula(pelicula3);
        controlPersis.crearHorario(horario3);
        

        Horario horario4 = new Horario();
        horario4.setHoraInicio(LocalTime.of(18, 0));
        horario4.setHoraFin(LocalTime.of(20, 30));
        horario4.setUnaPelicula(pelicula1);
        controlPersis.crearHorario(horario4);

        Horario horario5 = new Horario();
        horario5.setHoraInicio(LocalTime.of(20, 0));
        horario5.setHoraFin(LocalTime.of(22, 30));
        horario5.setUnaPelicula(pelicula2);
        controlPersis.crearHorario(horario5);
        
        
        

        System.out.println("Datos cargados exitosamente.");
    }
}
