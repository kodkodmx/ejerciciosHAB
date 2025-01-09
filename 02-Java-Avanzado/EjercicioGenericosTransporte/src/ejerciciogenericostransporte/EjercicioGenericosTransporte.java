package ejerciciogenericostransporte;

import java.util.ArrayList;
import java.util.List;
import logica.Auto;
import logica.Bici;
import logica.EnLinea;
import logica.MetodoReserva;
import logica.Moto;
import logica.Presencial;
import logica.Reserva;


public class EjercicioGenericosTransporte {
    


    public static void main(String[] args) {
               
        Reserva <Auto, MetodoReserva> auto = new Reserva (new Auto(),new EnLinea());
        Reserva <Moto, MetodoReserva> moto = new Reserva (new Moto(),new Presencial());
        Reserva <Bici, MetodoReserva> bici = new Reserva (new Bici(),new EnLinea());
        
        auto.mostrarInfo();
        moto.mostrarInfo();
        bici.mostrarInfo();
        
        //_________________________________________________________________
        System.out.println("\n_________________________________________________________________\n");
        
        List<Reserva> Reservas = new ArrayList<>();
        
        Reservas.add(auto);
        Reservas.add(moto);
        Reservas.add(bici);
        
        Reservas.stream().forEach(System.out::println); 

    }
    
}
