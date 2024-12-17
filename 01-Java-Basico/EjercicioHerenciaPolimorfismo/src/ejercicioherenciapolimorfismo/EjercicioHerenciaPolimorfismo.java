package ejercicioherenciapolimorfismo;

import logica.Empleado;
import logica.EmpleadoDependencia;
import logica.EmpleadoPorHora;



/*En una clase principal, crea un vector de tipo Empleado[] con 5 posiciones y almacena objetos de tipo EmpleadoTiempoCompleto y EmpleadoPorHora.
Luego, recorre el vector y muestra el nombre de cada empleado, su salario y su descripción...
¿Es posible reutilizar los mismos métodos para cada objeto?*/

public class EjercicioHerenciaPolimorfismo {


    public static void main(String[] args) {
        
        /*
        public EmpleadoPorHora(int horasTrabajadas, double tarifaPorHora, String nombre)
        Public EmpleadoDependencia(double bono, String nombre, double salarioBase)
        */
        
        EmpleadoPorHora ephj = new EmpleadoPorHora(150, 10.0, "Juan");
        EmpleadoPorHora ephp = new EmpleadoPorHora(145, 10.0, "Pedro");
        EmpleadoDependencia edl = new EmpleadoDependencia (500, "Luis", 1300);
        EmpleadoDependencia eda = new EmpleadoDependencia (500, "Andrea", 1400);
        EmpleadoDependencia edk = new EmpleadoDependencia (500, "Karla", 1850);
        
        Empleado empleados[] = {ephj, ephp, edl, eda, edk};
        
        for(int i=0;i<empleados.length;i++){
            System.out.println("Indice " + i + " Nombre: " + empleados[i].getNombre() + " Salario: " + empleados[i].calcularSalario() + " Descripcion: " + empleados[i].getDescripcion());
        }
        
        // Es mejor override porque si se sobrecarga es complicado acceder al bono dentro del array de clase Empleado que no tiene bono para ponerlo como parametro.
    }
    
}
