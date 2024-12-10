/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicioswitch;
import java.util.Scanner;
/**
 *
 * @author betoh
 */
public class EjercicioSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dia:");
        int dia = teclado.nextInt();
        
        switch(dia){
            case 1 : System.out.println("Lunes");
            break;
            case 2 : System.out.println("Martes");
            break;
            case 3 : System.out.println("Miercoles");
            break;
            case 4 : System.out.println("Jueves");
            break;
            case 5 : System.out.println("Viernes");
            break;
            case 6 : System.out.println("Sabado");
            break;
            case 7 : System.out.println("Domingo");
            break;
            default : System.out.println("Ingresa un dia valido");
            break;            
        }
    }
    
}
