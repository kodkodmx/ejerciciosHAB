
package model;


public class Auto extends Vehiculo {
    
    private int cantidadPuertas;

    public Auto() {
    }

    public Auto(int cantidadPuertas, String marca, String modelo, int anio) {
        super(marca, modelo, anio);
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public String getMarca() {
        return marca;
    }

    @Override
    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public int getAnio() {
        return anio;
    }

    @Override
    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    
    
    @Override
    public void acelerar(){
        System.out.println("El Auto esta acelerando");
    }
    
}
