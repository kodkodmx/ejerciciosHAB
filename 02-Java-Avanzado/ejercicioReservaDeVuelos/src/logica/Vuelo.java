
package logica;

import java.util.ArrayList;
import java.util.List;


public class Vuelo {
    
    private int numeroPasajeros;
    private String destino;
    private String fecha;
    private List<Pasajero> listaPasajeros = new ArrayList<>();

    public Vuelo() {
    }

    public Vuelo(int numeroPasajeros, String destino, String fecha) {
        this.numeroPasajeros = numeroPasajeros;
        this.destino = destino;
        this.fecha = fecha;
    }
    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
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

    public List<Pasajero> getListaPasajeros() {
        return listaPasajeros;
    }

    public void setListaPasajeros(Pasajero pasajero){
        this.listaPasajeros.add(pasajero);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vuelo{");
        sb.append("numeroPasajeros=").append(numeroPasajeros);
        sb.append(", destino=").append(destino);
        sb.append(", fecha=").append(fecha);
        sb.append(", listaPasajeros=").append(listaPasajeros);
        sb.append('}');
        return sb.toString();
    }

}   
