package logica;


public class Camioneta extends Vehiculo implements Combustion {
    
    private int capacidadTanque;
    private int consumoCombustible;

    public Camioneta(int capacidadTanque, int consumoCombustible, int id, String placa, String modelo, int anio, int costo) {
        super(id, placa, modelo, anio, costo);
        this.capacidadTanque = capacidadTanque;
        this.consumoCombustible = consumoCombustible;
    }
    
    @Override
    public int edadVehiculo() {
        return 2024 - super.getAnio();
    }
    
    @Override
    public String recargarCombustible() {
        return "Cargando Combustible";
    }

    public int getCapacidadTanque() {
        return capacidadTanque;
    }

    public void setCapacidadTanque(int capacidadTanque) {
        this.capacidadTanque = capacidadTanque;
    }

    public int getConsumoCombustible() {
        return consumoCombustible;
    }

    public void setConsumoCombustible(int consumoCombustible) {
        this.consumoCombustible = consumoCombustible;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Camioneta{");
        sb.append("capacidadTanque=").append(capacidadTanque);
        sb.append(", consumoCombustible=").append(consumoCombustible);
        sb.append('}');
        return sb.toString();
    }

}
