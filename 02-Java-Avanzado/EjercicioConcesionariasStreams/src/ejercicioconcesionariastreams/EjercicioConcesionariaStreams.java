package ejercicioconcesionariastreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import logica.Vehiculo;

public class EjercicioConcesionariaStreams {

        
    public static void main(String[] args) {
        
        List<Vehiculo> carros = new ArrayList<>();
        carros.add(new Vehiculo("Ford", "Fiesta", 1000));
        carros.add(new Vehiculo("Ford", "Focus", 1200));
        carros.add(new Vehiculo("Ford", "Explorer", 2500));
        carros.add(new Vehiculo("Fiat", "Uno", 500));
        carros.add(new Vehiculo("Fiat", "Cronos", 1000));
        carros.add(new Vehiculo("Fiat", "Turin", 1250));
        carros.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        carros.add(new Vehiculo("Chevrolet", "Spin", 2500));
        carros.add(new Vehiculo("Toyota", "Corolla", 1200));
        carros.add(new Vehiculo("Toyota", "Fortuner", 3000));
        carros.add(new Vehiculo("Renault", "Logan", 950));
        

        carros.sort((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()));         
        System.out.println("Vehiculos ordenados por costo de menor a mayor:");
        carros.forEach(System.out::println);
        
        System.out.println("\n_________________________________________________________________________________\n");
        
        carros.sort((v1, v2) -> Double.compare(v2.getCosto(), v1.getCosto()));         
        System.out.println("Vehiculos ordenados por costo de mayor a menor:");
        carros.forEach(System.out::println);
        
        System.out.println("\n_________________________________________________________________________________\n");
        
        carros.sort((v1, v2) -> {
            int marcaComparacion = v1.getMarca().compareTo(v2.getMarca());
            if (marcaComparacion == 0) {
                return Double.compare(v1.getCosto(), v2.getCosto());
            }
            return marcaComparacion;
        });
        
        System.out.println("Vehículos ordenados por marca y luego por precio:");
        carros.forEach(System.out::println);
        
        System.out.println("\n_________________________________________________________________________________\n");

        List<Vehiculo> ordenadosPorMarcaYCosto = carros.stream()
                .sorted(Comparator.comparing(Vehiculo::getCosto))
                .collect(Collectors.toList());
        System.out.println("Vehiculos ordenados por marca y costo:");
        ordenadosPorMarcaYCosto.forEach(System.out::println);
        
        System.out.println("\n_________________________________________________________________________________\n");
        
        List<Vehiculo> vehiculosMenores1000 = carros.stream()
                .filter(serv->serv.getCosto()<1000)
                .collect(Collectors.toList());
        System.out.println("Vehiculos con costo menor a 1000:");
        vehiculosMenores1000.forEach(System.out::println);
        
        System.out.println("\n_________________________________________________________________________________\n");
        
        List<Vehiculo> vehiculosMayores1000 = carros.stream()
                .filter(serv->serv.getCosto()>=1000)
                .collect(Collectors.toList());

        System.out.println("Vehiculos con costo mayor o igual a 1000:");
        vehiculosMayores1000.forEach(System.out::println);

        System.out.println("\n_________________________________________________________________________________\n");
        double promedio = carros.stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);

        System.out.println("Promedio costo de los vehiculos: $" + promedio);

        System.out.println("\n_________________________________________________________________________________\n");
        
        List<Vehiculo> ordenadosPorMarcas = carros.stream()
               .filter(serv -> serv.getMarca().equalsIgnoreCase("Chevrolet") || serv.getMarca().equalsIgnoreCase("Fiat"))
                .collect(Collectors.toList());
         
        System.out.println("Vehiculos Chevrolet o Fiat:");
        ordenadosPorMarcas.forEach(System.out::println);
        
        System.out.println("\n_________________________________________________________________________________\n");
        
        List<Vehiculo> modelosConLetraC = carros.stream()
            .filter(vehiculo -> vehiculo.getModelo().toLowerCase().contains("c"))
            .collect(Collectors.toList());

        System.out.println("Vehículos cuyo modelo contiene al menos una letra 'c':");
        modelosConLetraC.forEach(System.out::println);

        
    }
    
}