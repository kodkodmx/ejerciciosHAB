package logica;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Universidad {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EstudianteDAO estudianteDAO = null;

        try {
            estudianteDAO = new EstudianteDAO();

            while (true) {
                System.out.println("1. Agregar estudiante");
                System.out.println("2. Ver estudiantes");
                System.out.println("3. Salir");
                System.out.print("Selecciona una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.print("Ingrese el nombre del estudiante: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingrese la edad del estudiante: ");
                        int edad = scanner.nextInt();
                        System.out.print("Ingrese la calificación del estudiante: ");
                        double calificacion = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar buffer

                        Estudiante estudiante = new Estudiante(nombre, edad, calificacion);
                        estudianteDAO.agregarEstudiante(estudiante);
                        System.out.println("Estudiante agregado con éxito.");
                        break;

                    case 2:
                        List<Estudiante> estudiantes = estudianteDAO.obtenerEstudiantes();
                        System.out.println("Lista de estudiantes:");
                        for (Estudiante e : estudiantes) {
                            System.out.println(e);
                        }
                        break;

                    case 3:
                        System.out.println("Saliendo...");
                        return;

                    default:
                        System.out.println("Opción inválida.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
    
}
