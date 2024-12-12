package model;

public class Electrodomestico {
    
    //cod, marca, modelo, consumo y color.
    
    String cod;
    String marca;
    String modelo;
    String consumo;
    String color;

    public Electrodomestico() {
    }

    public Electrodomestico(String cod, String marca, String modelo, String consumo, String color) {
        this.cod = cod;
        this.marca = marca;
        this.modelo = modelo;
        this.consumo = consumo;
        this.color = color;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Electrodomestico{");
        sb.append("cod=").append(cod);
        sb.append(", marca=").append(marca);
        sb.append(", modelo=").append(modelo);
        sb.append(", consumo=").append(consumo);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }

    
    
    
    
}
