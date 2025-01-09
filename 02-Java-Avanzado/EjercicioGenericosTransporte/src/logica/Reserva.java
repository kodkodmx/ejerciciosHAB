package logica;

public class Reserva <T,U extends MetodoReserva> {
    
    T vehiculo;
    U metodoReserva;

    public Reserva(T vehiculo, U metodoReserva) {
        this.vehiculo = vehiculo;
        this.metodoReserva = metodoReserva;
    }
    
    public void mostrarInfo() {
        System.out.println("Tipo de vehiculo: " + vehiculo + " Reservado via: " + metodoReserva);
    }

    @Override
    public String toString() {
        return "Tipo de vehiculo: " + vehiculo + " Reservado via: " + metodoReserva;
    }
    
    
    
    
}
