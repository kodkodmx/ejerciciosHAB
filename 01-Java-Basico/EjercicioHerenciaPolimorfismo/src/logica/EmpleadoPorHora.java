package logica;

/*Crea la clase EmpleadoPorHora que herede de Empleado y agrega:
	- Atributos privados propios llamados horasTrabajadas (int) y tarifaPorHora (double).
	- Constructores que inicialicen los atributos heredados, las horas trabajadas y la tarifa por hora.
	- Sobreescribe el método calcularSalario() para que devuelva el total calculado como horasTrabajadas * tarifaPorHora.*/


public class EmpleadoPorHora extends Empleado{
    
    private int horasTrabajadas;
    private double tarifaPorHora;

    public EmpleadoPorHora() {
    }

    public EmpleadoPorHora(int horasTrabajadas, double tarifaPorHora, String nombre) {
        super(nombre);
        this.horasTrabajadas = horasTrabajadas;
        this.tarifaPorHora = tarifaPorHora;
    }

    
    
    @Override
    public double calcularSalario() {
        return horasTrabajadas * tarifaPorHora;
    }
    
}
