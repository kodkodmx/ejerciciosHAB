package ejerciciopropiocajeroautomatico;

import java.util.Scanner;
import logica.CuentaBancaria;
import logica.SaldoInsuficienteException;

public class EjercicioPropioCajeroAutomatico {
    

    public static void main(String[] args) {
        boolean salir = false;
        int opcion;
        double cantidad;
        Scanner teclado = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria(0.0);
        
        while(!salir){
            System.out.println("1. Depositar");
            System.out.println("2. Retirar");
            System.out.println("3. Ver Saldo");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = teclado.nextInt();

            switch(opcion){
            
            case 1:            
                System.out.print("\nCantidad a depositar: ");
                cantidad = teclado.nextDouble();
                cuenta.depositar(cantidad);
                System.out.println("");
                break;
                
            case 2:
                System.out.print("\nCantidad a retirar: ");
                cantidad = teclado.nextDouble();
                try{
                    cuenta.retirar(cantidad);
                    System.out.println("\nRetiro exitoso. Saldo restante: " + cuenta.getSaldo());
                }catch (SaldoInsuficienteException e){
                    System.out.println("\nError: " + e);  
                }
                break;
                
            case 3:
                System.out.println(cuenta);
                break;
                
            case 4:
                salir = true;
                teclado.close();
                break;
            
            }
            
        }
        
        
        
        
    }
    
}
