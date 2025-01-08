package logica;

public class Vehiculo {
    
    private String modelo;
    private String Marca;
    private double costo;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, double costo) {
        this.modelo = modelo;
        this.Marca = marca;
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Vehiculo{");
        sb.append("modelo=").append(modelo);
        sb.append(", Marca=").append(Marca);
        sb.append(", costo=").append(costo);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
