package ejercicioclasesanonimashotel;

import java.util.Scanner;
import logica.PrecioReserva;
import logica.Reserva;


public class EjercicioClasesAnonimasHotel {


    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al Hotel Luisina");
        System.out.println("Cual es el Precio Base?");        
        double base = teclado.nextInt();
        teclado.nextLine();
        System.out.println("Tipo de reserva? membresia, temporadaBaja o ultimaHora");
        String resp = teclado.nextLine();
        
        
        Reserva res = new Reserva();
        
        PrecioReserva membresia = new PrecioReserva(){
            @Override
            public double calcularPrecio(double precioBase) {
                return precioBase - (precioBase*0.10);
            }
            
        };
        
        PrecioReserva temporadaBaja = new PrecioReserva(){
            @Override
            public double calcularPrecio(double precioBase) {
                return precioBase - (precioBase*0.20);
            }
            
        };
        
        PrecioReserva ultimaHora = new PrecioReserva(){
            @Override
            public double calcularPrecio(double precioBase) {
                System.out.println("Reserva de ultima hora, el descuento no aplica.");
                return precioBase;
            }
            
        };
        
        switch(resp){
            case "membresia":
                res.realizarReserva(base, membresia);
                break;
            case "temporadaBaja":
                res.realizarReserva(base, temporadaBaja);
                break;
            case "ultimaHora":
                res.realizarReserva(base, ultimaHora);
                break;
            default:
                System.out.println("Tipo de reserva Invalido");
        }
    
    }
}
