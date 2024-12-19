package ejercicioconsola;

import logica.Consola;
import logica.Nintendo64;
import logica.PlayStation2;
import logica.XboxOne;

public class EjercicioConsola {

    public static void main(String[] args) {
        
        Nintendo64 n = new Nintendo64("NTSC", true, 897, "Mario", "Sega"   , 1999);
        PlayStation2 p = new PlayStation2("pal", true, 0, 0, "Medal of honor", "AE", 2005);
        XboxOne x = new XboxOne(true, true, true, 0, "Fifa", "EAsports", 2004);
        
        
        System.out.println("Nintendo");
        System.out.println(n.cargarJuego());
        System.out.println(n.leerCartucho("Mario"));
        System.out.println("\nPlay Station");
        System.out.println(p.cargarJuego());
        System.out.println(p.leerDvd("juego"));
        System.out.println(p.grabarEnMemory());
        System.out.println("\nXboxOne");
        System.out.println(x.cargarJuego());
        System.out.println(x.leerJuegoDigital("juego"));
        
        
        
        
        
        System.out.println();
                

    }
    
}
