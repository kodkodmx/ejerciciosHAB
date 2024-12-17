package logica;

/*Crea la clase EmpleadoDependencia que herede de Empleado y agrega:
	- Un atributo propio privado llamado bono (double).
	- Constructores que inicialicen los atributos heredados y propio/s.
	- Sobreescribe el método calcularSalario() para que devuelva el salario base más el bono.
	- Sobrecarga/sobrescribe (decidir qué creen mejor) el método getDescripcion() para que,
además de explica el rol del empleado, muestre el bono que cobra por ser empleado en relac de dependencia*/


public class EmpleadoDependencia extends Empleado{
    
    private double bono;

    public EmpleadoDependencia() {
    }

    public EmpleadoDependencia(double bono, String nombre, double salarioBase) {
        super(nombre, salarioBase);
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    /*public String getNombre() {
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
    }*/
    
    @Override
    public double calcularSalario() {
        return salarioBase + bono;
    }
    
    
    @Override
    public String getDescripcion(){        
        return "Descripción del puesto del empleado y responsabilidades. Por se empleado por dependencia con un bono de " + bono;
    }
    
    
    
}
