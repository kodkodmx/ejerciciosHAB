package ejerciciovectoresyexcepciones;

import java.util.Scanner;

public class EjercicioVectoresYExcepciones {  
    
    public static int vector[] = new int[10];    
    
   

    public static void main(String[] args) {
        int index;
        
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 100);
        }
        
        Scanner teclado = new Scanner(System.in);
        System.out.print("Indice para vector de 10 posiciones: ");
        index = teclado.nextInt();
        
        try{
            System.out.println(acceder(index));
        }catch(IndexOutOfBoundsException e){
            System.out.println(e + ": El indice " + index + " no existe en 10 posiciones");
            
        }
        
        
    }
    
    public static int acceder (int index){        
        return vector[index];
    }
    
}
