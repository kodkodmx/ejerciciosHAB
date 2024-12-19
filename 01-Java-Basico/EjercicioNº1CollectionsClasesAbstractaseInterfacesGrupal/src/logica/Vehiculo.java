
package logica;

public abstract class Vehiculo {
//    id, placa, marca, modelo, año, costo
    
    private int id;
    private String placa;
    private String modelo;
    private int anio;
    private int costo;

    public Vehiculo() {
    }

    public Vehiculo(int id, String placa, String modelo, int anio, int costo) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.anio = anio;
        this.costo = costo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo{");
        sb.append("id=").append(id);
        sb.append(", placa=").append(placa);
        sb.append(", modelo=").append(modelo);
        sb.append(", anio=").append(anio);
        sb.append(", costo=").append(costo);
        sb.append('}');
        return sb.toString();
    }
    
    public abstract int edadVehiculo();
    
}
