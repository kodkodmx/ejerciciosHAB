package logica;

public class Animal {
    private String nombre;
    private double peso;

    public Animal(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public void mostrarInfo() {
        System.out.println("Nombre del Paciente: " + nombre + " Con un peso de: " + peso + " Kg.");
    }
}
