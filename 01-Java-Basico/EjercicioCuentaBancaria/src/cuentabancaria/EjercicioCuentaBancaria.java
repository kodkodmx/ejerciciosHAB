
package cuentabancaria;

import model.CuentaBancaria;


public class EjercicioCuentaBancaria {

    public static void main(String[] args) {
        
        CuentaBancaria cuenta = new CuentaBancaria("Alberto", 78.5,12345);
        
        
        System.out.println("Titular: " + cuenta.getTitular());
        System.out.println("Saldo: " + cuenta.getCuenta());
        System.out.println("Cuenta: " + cuenta.getSaldo());
    }
}
