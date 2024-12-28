package ejerciciocadenadeproduccion;

import logica.Trabajador;
import logica.Fabrica;

public class EjercicioCadenaDeProduccion {

    public static void main(String[] args) {
        
        
        Fabrica fabrica = new Fabrica();
        
        
        Trabajador tr1 = new Trabajador("Hugo", fabrica);
        Trabajador tr2 = new Trabajador("Paco", fabrica);
        Trabajador tr3 = new Trabajador("Luis", fabrica);
        
        
        tr1.start();
        tr2.start();
        tr3.start();
        
        
        while (true) {
            fabrica.recibirTarea();
            try {
                
                Thread.sleep(1000);
            }
            catch(InterruptedException e) {
                e.printStackTrace();
            }
    }
        
        //una vez que termina podemos cerrar la fabrica para que deje de esperar
      //  fabrica.shutdown();
        }
   
    }