
package ejerciciofrutas;

import java.util.Scanner;
import logica.Fruta;

public class EjercicioFrutas {

    public static void main(String[] args) {
        
        Fruta frut = new Fruta();
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("Bienvenido al sistema de fruteria");
        System.out.println("Ingrese los datos de la fruta que quiere cargar");
        
        System.out.println("Ingrese Nombre de la fruta");
        frut.setNombre(teclado.nextLine());
        
        System.out.println("Ingrese Color de la fruta");
        frut.setColor(teclado.nextLine());
        
        System.out.println("Ingrese Tipo de Cascara de la fruta");
        frut.setTipoCascara(teclado.nextLine());               
        
        System.out.println("Ingrese Calorias de la fruta");
        teclado = new Scanner(System.in);
        frut.setCalorias(teclado.nextDouble());
        
        System.out.println("Ingrese si es Comestiblr de la fruta (Si o No)");
        teclado = new Scanner(System.in);
        String opcion= teclado.next();
        if (opcion.equals("Si")){
            frut.setEsComestible(true);
        }else{
            frut.setEsComestible(false);
        }
        
        if(frut.isEsComestible()==true){
            opcion = "Si";
        }else {
            opcion = "No";
        }
        
        System.out.println("La fruta cargada es: " + "Nombre: " + frut.getNombre() +" Color: " + frut.getColor()
        + " Tipo Cascara: " + frut.getTipoCascara()+ " Calorias: " + frut.getCalorias() + " Comestible?: " + opcion);
        
        frut.setCalorias(999);
        
        System.out.println(frut.toString());
    }
    
}
