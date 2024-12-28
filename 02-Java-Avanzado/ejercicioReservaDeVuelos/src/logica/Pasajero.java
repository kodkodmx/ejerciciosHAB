package logica;

//nombre, destino, fecha de viaje y número de asientos deseado
public class Pasajero {
    private String nombre;
    private String destino;
    private String fecha;
    private int Asientos;

    public Pasajero() {
    }

    public Pasajero(String nombre, String destino, String fechaViaje, int Asientos) {
        this.nombre = nombre;
        this.destino = destino;
        this.fecha = fechaViaje;
        this.Asientos = Asientos;
    }

    public int getAsientos() {
        return Asientos;
    }

    public void setAsientos(int Asientos) {
        this.Asientos = Asientos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pasajero{");
        sb.append("nombre=").append(nombre);
        sb.append(", destino=").append(destino);
        sb.append(", fechaViaje=").append(fecha);
        sb.append(", Asientos=").append(Asientos);
        sb.append('}');
        return sb.toString();
    }
    
    
    
}
