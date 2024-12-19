package ejercicionº1collectionsclasesabstractaseinterfacesgrupal;

import java.util.ArrayList;
import logica.Auto;
import logica.Camioneta;
import logica.Moto;
import logica.Vehiculo;

public class EjercicioNº1CollectionsClasesAbstractaseInterfacesGrupal {

    public static void main(String[] args) {
        
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();

        Auto a1 = new Auto(10, 5, 222845, "ASD123", "Compacto", 2024, 150000);
        vehiculos.add(a1);
        System.out.println("Edad Vehiculo: "+a1.edadVehiculo());
        System.out.println(a1.cargarEnergia());
        Auto a2 = new Auto(15, 7, 30985, "QWE456", "Sedán", 2023, 180000);
        vehiculos.add(a2);
        System.out.println("Edad Vehiculo: "+a2.edadVehiculo());
        System.out.println(a2.cargarEnergia());
        Auto a3 = new Auto(12, 6, 25478, "ZXC789", "Convertible", 2022, 200000);
        vehiculos.add(a3);
        System.out.println("Edad Vehiculo: "+a3.edadVehiculo());
        System.out.println(a3.cargarEnergia());
        Moto m1 = new Moto(12, "2 Tiempos", 252489, "ZXC789", "SUV", 2022, 200000);
        vehiculos.add(m1);
        System.out.println("Edad Vehiculo: "+m1.edadVehiculo());
        System.out.println(m1.recargarCombustible());
        Moto m2 = new Moto(8, "4 Tiempos", 306589, "RTY456", "Chopper", 2021, 120000);
        vehiculos.add(m2);
        System.out.println("Edad Vehiculo: "+m2.edadVehiculo());
        System.out.println(m2.recargarCombustible());
        Moto m3 = new Moto(10, "2 Tiempos", 350025, "FGH123", "Sport", 2023, 140000);
        vehiculos.add(m3);
        System.out.println("Edad Vehiculo: "+m3.edadVehiculo());
        System.out.println(m3.recargarCombustible());
        Camioneta c1 = new Camioneta(10, 9, 350025, "FGl563", "Doble Cabina", 2022, 185000);
        vehiculos.add(c1);
        System.out.println("Edad Vehiculo: "+c1.edadVehiculo());
        System.out.println(c1.recargarCombustible());
        Camioneta c2 = new Camioneta(15, 8, 450030, "JKL456", "SUV", 2022, 180000);
        vehiculos.add(c2);
        System.out.println("Edad Vehiculo: "+c2.edadVehiculo());
        System.out.println(c2.recargarCombustible());
        Camioneta c3 = new Camioneta(12, 7, 400050, "MNO789", "Pickup", 2021, 160000);
        vehiculos.add(c3);
        System.out.println("Edad Vehiculo: "+c3.edadVehiculo());
        System.out.println(c3.recargarCombustible());
        for (Vehiculo vehiculo : vehiculos) {
        System.out.println(vehiculo);
}

        
        



    }
    
}
