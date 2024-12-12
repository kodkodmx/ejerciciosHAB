package ejercicioelectrodomestico;

import model.Electrodomestico;

public class EjercicioElectrodomestico {

    public static void main(String[] args) {
        
        //cod, marca, modelo, consumo y color.
        
        Electrodomestico e1 = new Electrodomestico();
        Electrodomestico e2 = new Electrodomestico("A123456","Sony","M016-V","100 Watts","Verde");
        Electrodomestico e3 = new Electrodomestico("A123457","Sony","M017-R","100 Watts","Rojo");
        Electrodomestico e4 = new Electrodomestico("A123458","Sony","M018-A","100 Watts","Azul");
        
        
        System.out.println("Marca: "+e2.getMarca() + " Modelo: "+e2.getModelo()+" Consumo: "+e2.getConsumo());
        System.out.println("Marca: "+e3.getMarca() + " Modelo: "+e3.getModelo()+" Consumo: "+e3.getConsumo());
        System.out.println("Marca: "+e4.getMarca() + " Modelo: "+e4.getModelo()+" Consumo: "+e4.getConsumo());
        System.out.println("Electrodomestico sin parametros: "+" Marca: "+e1.getMarca());
    }
    
}
