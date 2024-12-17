
package ejercicioherencia;

import model.Auto;
import model.Moto;


public class EjercicioHerencia {


    public static void main(String[] args) {
        
        Auto a = new Auto(2,"Ford","Fiesta",2024);
        Moto m = new Moto(1000,"Yamaha","R1",2016);
        
        System.out.println("El auto: " + "Puertas: "+a.getCantidadPuertas() +" Anio: "+ a.getAnio() + " Marca: " + a.getMarca() + " Modelo: "+ a.getModelo());
        a.acelerar();
        System.out.println("La moto: " + "Cilindrada: " +m.getCilindrada() + " Anio: " +  m.getAnio() + " Marca: " + m.getMarca() + " Modelo: "+ m.getModelo());
        m.acelerar();
        
    }
    
}
