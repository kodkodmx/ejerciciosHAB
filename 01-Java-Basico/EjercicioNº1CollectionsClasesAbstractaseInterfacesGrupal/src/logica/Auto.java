package logica;


public class Auto extends Vehiculo implements Electrico {
    
    private int capacidadBateria;
    private int autonomia;

    public Auto(int capacidadBateria, int autonomia, int id, String placa, String modelo, int anio, int costo) {
        super(id, placa, modelo, anio, costo);
        this.capacidadBateria = capacidadBateria;
        this.autonomia = autonomia;
    }    

    @Override
    public int edadVehiculo() {
        return 2024 - super.getAnio();
    }

    @Override
    public String cargarEnergia() {
        return "Cargando Electricidad";
    }

    public int getCapacidadBateria() {
        return capacidadBateria;
    }

    public void setCapacidadBateria(int capacidadBateria) {
        this.capacidadBateria = capacidadBateria;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Auto{");
        sb.append("capacidadBateria=").append(capacidadBateria);
        sb.append(", autonomia=").append(autonomia);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
