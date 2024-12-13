/*
Crear una clase llamada VideoJuego, que tenga los siguientes atributos: codigo, titulo, consola, cantidadJugadores, categoría (tener en cuenta todos sus atributos, constructores, métodos getters y setters).
- Crear un vector de tipo VideoJuego que pueda almacenar 5 videojuegos. Crear 5 videojuegos y guardarlos en el vector.
- Recorrer el vector creado y mostrar por pantalla el titulo, consola y cantidad de jugadores de los videojuegos almacenados.
- Cambiar el nombre y la cantidad de jugadores de dos videojuegos. Mostrar por pantalla los datos de todos los videojuegos luego del cambio.
- Recorrer el vector y mostrar por pantalla únicamente a los videojuegos que sean de la consola “Nintendo 64”. En caso que no encuentre ninguno, informarlo también por pantalla. (editado) 
 */
package ejerciciovideojuego;

import logica.VideoJuego;


public class EjercicioVideojuego {


    public static void main(String[] args) {        
        //codigo, titulo, consola, cantidadJugadores, categoría
        
        VideoJuego v1 = new VideoJuego("App", "Age of Empires", "Xbox", "RTS", 8);
        VideoJuego v2 = new VideoJuego("App", "The Legend of Zelda: Breath of the Wild", "Nintendo 64", "Adventure", 10);
        VideoJuego v3 = new VideoJuego("App", "Minecraft", "PC", "Sandbox", 9);
        VideoJuego v4 = new VideoJuego("App", "FIFA 23", "PlayStation", "Sports", 7);
        VideoJuego v5 = new VideoJuego("App", "Call of Duty: Modern Warfare II", "PC", "Shooter", 8);
        
        VideoJuego Videojuegos[]= {v1, v2, v3, v4, v5};
        
        System.out.println("Todas las Videojuegos en el array: \n");
        for (int i = 0; i < Videojuegos.length; i++) {
            String titulo = Videojuegos[i].getTitulo();
            String consola = Videojuegos[i].getConsola();
            int jugadores = Videojuegos[i].getCantidadJugadores();
            System.out.println(titulo + " Se juega en " + consola + " y pueden jugar hasta "+ jugadores);
            }
        
        v2.setTitulo("NBA");
        v2.setCantidadJugadores(2);
        v4.setTitulo("FIFA");
        v4.setCantidadJugadores(4);

        System.out.println("\n\nDespues del cambio:\n");
        
        System.out.println(v2.toString());
        System.out.println(v4.toString());
        
        
         System.out.println("\n\nPara Nintedo 64: \n");
        
        for (int i = 0; i < Videojuegos.length; i++) {
            String consola  = Videojuegos[i].getConsola(); 
            if (consola.equals("Nintendo 64")){
                System.out.println(Videojuegos[i].toString());
            }
        }
        
    }
    
}
