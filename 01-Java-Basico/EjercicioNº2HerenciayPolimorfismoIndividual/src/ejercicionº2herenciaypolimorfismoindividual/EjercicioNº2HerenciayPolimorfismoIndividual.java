package ejercicionº2herenciaypolimorfismoindividual;

import logica.*;

/*
b) Una vez creadas las clases, crear en el Main un vector de tipo Vestimenta y almacenar 3 zapatos, 3 pantalones, 2 camisetas y 1 sombrero (crear un objeto con parámetros para cada uno de ellos).
c) Crear los siguientes métodos (en cada subclase correspondiente):

Zapato: método para mostrar un mensaje en pantalla que diga "Estos zapatos son de marca: " (mostrar marca).

Pantalon: método para mostrar un mensaje en pantalla que diga "Estos pantalones son de marca: " (mostrar estilo).

Camiseta: método para mostrar un mensaje en pantalla que diga "Esta camiseta es de marca: " (mostrar manga).

Sombrero: método para mostrar un mensaje en pantalla que diga "Este sombrero es de marca: " (mostrar tipo).

d) Recorrer el vector y ejecutar el método que corresponde en cada posición del mismo.
PISTA: Todos tendrán el mismo método, con el mismo nombre, pero únicamente cambia el mensaje que muestran. 
Tener en cuenta para esto la implementación de herencia y sobreescritura de métodos.
*/


public class EjercicioNº2HerenciayPolimorfismoIndividual {


    public static void main(String[] args) {

        Vestimenta vestimentas[] = new Vestimenta[9];
        
        Sombrero som1 = new Sombrero("Ala","Chica",1234,280,3600,"Juvenil","Tardan","Negro");
        Camiseta cam1 = new Camiseta("Larga","V",1122,80,680,"T-shirt","Adidas","Blanco");
        Camiseta cam2 = new Camiseta("Corta","Redondo",8837,850,34,"Do it","Nike","Azul");
        Zapato zap1 = new Zapato("Cuero", "Cordones", 1001, 1200, 42, "Oxford", "Clarks", "Negro");
        Zapato zap2 = new Zapato("Sintético", "Velcro", 1002, 800, 40, "Casual", "Adidas", "Blanco");
        Zapato zap3 = new Zapato("Cuero", "Sin cierre", 1003, 1500, 44, "Botín", "Timberland", "Marrón");
        Pantalon pan1 = new Pantalon("Formal", "Algodón", 2001, 600, 32, "Traje", "Dockers", "Gris");
        Pantalon pan2 = new Pantalon("Casual", "Mezclilla", 2002, 500, 34, "Jeans", "Levi's", "Azul");
        Pantalon pan3 = new Pantalon("Deportivo", "Poliéster", 2003, 450, 36, "Joggers", "Puma", "Negro");
       
        vestimentas[0] = som1;
        vestimentas[1] = cam1;
        vestimentas[2] = cam2;
        vestimentas[3] = zap1;
        vestimentas[4] = zap2;
        vestimentas[5] = zap3;
        vestimentas[6] = pan1;
        vestimentas[7] = pan2;
        vestimentas[8] = pan3;
        
        
        for(int i=0;i<vestimentas.length;i++){
            System.out.println(vestimentas[i].mostrarMarca());
        }
        
    }
    
}
