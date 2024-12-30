package logica;


public class CuentaBancaria {
    
    private double saldo;

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }
    
    public void depositar (double deposito){
        this.saldo = saldo + deposito;
    }
    
    public void retirar (double retiro) throws SaldoInsuficienteException{
        if(saldo < retiro){
            throw new SaldoInsuficienteException("El saldo es insuficiente.\n");      
        }else{
            saldo -= retiro;
        }
        
    }           
            
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nTu Cuenta Bancaria Tiene un ");
        sb.append("saldo de $").append(saldo);
        
        return sb.toString();
    }
    
    
    
}
