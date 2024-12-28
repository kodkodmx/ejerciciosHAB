
package ejercicioreservadevuelos;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import logica.Pasajero;
import logica.ReservaInvalidaException;
import logica.Vuelo;


public class EjercicioReservaDeVuelos {


    public static void main(String[] args) throws ReservaInvalidaException {
        Scanner teclado = new Scanner(System.in);
        char vor = 0;
        int pasajeros;
        String nPasajero = null;
        String destino = null;
        String fecha = null;
        List<Vuelo> listaVuelos = new ArrayList<>();
        
        while(true){
            System.out.println("¿Deseas crear un (V)uelo o una (R)eservacion?");

            vor = teclado.next().charAt(0);
            teclado.nextLine();

            if (vor == 'V') {
                System.out.println("Ingrese los datos del Vuelo"); 
                System.out.print("Numero de pasajeros disponibles: ");
                pasajeros = teclado.nextInt();
                teclado.nextLine();
                System.out.print("Destino: ");
                destino = teclado.nextLine();
                System.out.print("Fecha (dd-mm-yy): ");
                fecha = teclado.nextLine();

                Vuelo vuelo = new Vuelo(pasajeros, destino, fecha);
                listaVuelos.add(vuelo);

            }else if (vor == 'R') {
                System.out.println("Ingrese los datos de la Reserva");
                System.out.print("Nombre del Pasajero principal: ");
                nPasajero = teclado.nextLine();
                System.out.print("Destino: ");
                destino = teclado.nextLine();
                System.out.print("Fecha (dd-mm-yy): ");
                fecha = teclado.nextLine();
                System.out.print("Numero de pasajeros total en reserva: ");
                pasajeros = teclado.nextInt();
                teclado.nextLine();
                Pasajero pasajero = new Pasajero(nPasajero, destino, fecha, pasajeros);
                System.out.println(pasajero);
                System.out.println(listaVuelos);
                for(Vuelo vue : listaVuelos){
                    if(vue.getDestino().equals(pasajero.getDestino()) && vue.getFecha().equals(pasajero.getFecha())){
                        vue.setListaPasajeros(pasajero);                       
                    }else{
                        throw new ReservaInvalidaException("La reserva no puede ser agregada a ningun vuelo existente");
                    } 
                }
                System.out.println(listaVuelos);
            }else{
                throw new InvalidParameterException("Solo introducir una 'V' o una 'R' segun sea el caso2");
            }



        }
    }
}
