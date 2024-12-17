
package model;

public class CuentaBancaria {
    
        
    private String titular;
    private double saldo;
    private int cuenta;

    //public CuentaBancaria() {
    //}

    public CuentaBancaria(String titular, double saldo, int cuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    private double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }
    
    
        
        

}