package ejercicionº1herenciapolimorfismoyencapsulamientoindividual;

import logica.*;

/*
c) En el método "main", crear un objeto de cada clase hija. Llamar a los 3 métodos saludar desde cada objeto.

d) Crear un objeto de tipo animal e intentar asignarle al Mamífero creado… ¿Qué sucede? 
¿Es posible hacer esto? ¿Se aplica alguna propiedad para esto?

E) Cambiar el modificador de acceso de los métodos de "public" a "private". 
Intentar acceder desde el "main" a estos métodos. ¿Qué sucede? ¿Es posible hacer esto?
*/

public class EjercicioNº1HerenciaPolimorfismoyEncapsulamientoIndividual {


    public static void main(String[] args) {
        
        Animal mam = new Mamifero();
        Animal ave = new Ave();
        Animal rep = new Reptil();
                
        mam.saludar();
        ave.saludar();
        rep.saludar();
        
        Animal ani = new Animal();
        
        ani.saludar();
        
        ani = mam;
        
        ani.saludar();
        
        //Si cambiamos el metodo saludar a private en animal manda error en todas las instancias.
        

    }
    
}
