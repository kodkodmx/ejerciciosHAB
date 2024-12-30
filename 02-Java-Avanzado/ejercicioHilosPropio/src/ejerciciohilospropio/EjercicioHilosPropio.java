package ejerciciohilospropio;


class Cuenta {
    private double saldo;

    public Cuenta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void transferir(Cuenta destino, double monto) {
        if (saldo >= monto) {
            saldo -= monto;
            destino.saldo += monto;
        }
    }
}

class TransferenciaThread extends Thread {
    private Cuenta origen;
    private Cuenta destino;
    private double monto;

    public TransferenciaThread(Cuenta origen, Cuenta destino, double monto) {
        this.origen = origen;
        this.destino = destino;
        this.monto = monto;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            origen.transferir(destino, monto);
        }
    }
}

public class EjercicioHilosPropio {
    public static void main(String[] args) throws InterruptedException {
        Cuenta cuenta1 = new Cuenta(1000);
        Cuenta cuenta2 = new Cuenta(1000);

        TransferenciaThread hilo1 = new TransferenciaThread(cuenta1, cuenta2, 1);
        TransferenciaThread hilo2 = new TransferenciaThread(cuenta2, cuenta1, 1);

        hilo1.start();
        hilo2.start();

        hilo1.join();
        hilo2.join();

        System.out.println("Saldo final cuenta 1: " + cuenta1.getSaldo());
        System.out.println("Saldo final cuenta 2: " + cuenta2.getSaldo());
    }
}
