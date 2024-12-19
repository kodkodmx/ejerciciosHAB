package logica;


public class Moto extends Vehiculo implements Combustion {
    
    private int cilidrada;
    private String tipoMotor;

    public Moto(int cilidrada, String tipoMotor, int id, String placa, String modelo, int anio, int costo) {
        super(id, placa, modelo, anio, costo);
        this.cilidrada = cilidrada;
        this.tipoMotor = tipoMotor;
    } 

    @Override
    public int edadVehiculo() {
        return 2024 - super.getAnio();
    }

    @Override
    public String recargarCombustible() {
        return "Cargando Combustible";
    }
    
    public int getCilidrada() {
        return cilidrada;
    }

    public void setCilidrada(int cilidrada) {
        this.cilidrada = cilidrada;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Moto{");
        sb.append("cilidrada=").append(cilidrada);
        sb.append(", tipoMotor=").append(tipoMotor);
        sb.append('}');
        return sb.toString();
    }

    
}
