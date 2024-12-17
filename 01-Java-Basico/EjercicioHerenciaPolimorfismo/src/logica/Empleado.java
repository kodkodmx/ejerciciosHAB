
package logica;

public class Empleado {
    
    protected String nombre;
    protected double salarioBase;

    public Empleado() {
    }

    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
    
    public double calcularSalario(){
        System.out.println("Debe elegir el tipo de empleado para calcular salario");
        return 0.0;
    }
    
    public String getDescripcion() {
         return "Descripción del puesto del empleado y responsabilidades.";
           }
}
