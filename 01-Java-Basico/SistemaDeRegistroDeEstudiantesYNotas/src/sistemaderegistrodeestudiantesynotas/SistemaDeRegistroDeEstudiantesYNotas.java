package sistemaderegistrodeestudiantesynotas;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SistemaDeRegistroDeEstudiantesYNotas {
/*    
Eres parte de un equipo que está desarrollando un sistema para gestionar las notas de los estudiantes de una universidad.
El sistema debe permitir almacenar las notas de los estudiantes para diferentes materias utilizando un HashMap. 
Cada estudiante tiene un número de matrícula único, que será la clave del mapa y el valor será su promedio.
Crear un programa que permita hacer esto con un número indeterminado de alumnos ingresados por teclado.
Permitir que el programa pueda buscar un alumno por promedio o por matricula en base a lo que elija el usuario. (editado) 
*/

    public static void main(String[] args) {
        
        HashMap<Integer, Integer> calificaciones = new HashMap<>();
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir){
            System.out.println("Vamos a Capturar...");
            System.out.println("Dame la matricula:");
            Integer matr = teclado.nextInt();
            System.out.println("Dame el promedio:");
            int prom = teclado.nextInt();
            calificaciones.put(matr, prom);
            
            System.out.println("¿Quieres ir a buscar? (1) para SI (otro) para NO");
            int sal = teclado.nextInt();
            
            
            if (sal == 1){
                salir = true;
            }
        }
        boolean buscar = true;
        while (buscar){
            System.out.println("Vamos a Buscar...");    
            System.out.println("Buscar: (1) por matricula (2) por promedio (otro) Salir");
            int bus = teclado.nextInt();

            if (bus == 1){
                System.out.println("dame matricula:");
                int mat = teclado.nextInt();
                System.out.println("Promedio encontrado: " + calificaciones.get(mat));


            }else if (bus == 2) {
                System.out.println("Dame la calificación:");
                int calificacion = teclado.nextInt();

                boolean encontrado = false;

                for (Map.Entry<Integer, Integer> entrada : calificaciones.entrySet()) {
                    if (entrada.getValue().equals(calificacion)) {
                        System.out.println("Matrícula encontrada: " + entrada.getKey());
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.println("Calificación no encontrada.");
                }
            }else{
               buscar = false;
               System.out.println("Gracias por Usar el Sistema..."); 
            }
        }
        
    }
}
