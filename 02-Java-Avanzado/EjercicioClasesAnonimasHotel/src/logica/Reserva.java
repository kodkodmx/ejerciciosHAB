package logica;


public class Reserva {
    
    public void realizarReserva (double precioBase, PrecioReserva precio) {
        double precioFinal = precio.calcularPrecio(precioBase);
        System.out.println("El precio final es de: " + precioFinal);
    }
    
}
