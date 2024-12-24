package ejerciciotiendaexcepciones;

import java.util.Scanner;

public class EjercicioTiendaExcepciones {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        boolean tv = false;

        while (!tv) {
            System.out.print("Tarjeta: ");
            String tarjeta = teclado.nextLine();

            try {
                validarTarjeta(tarjeta);
                System.out.println("Tarjeta válida.");
                tv = true;
            } catch (NumberFormatException e) {
                System.out.println(e + " La tarjeta debe contener solo números y tener exactamente 16 dígitos.");
            } 
        }

        boolean mv = false;

        while (!mv) {
            System.out.print("Monto: ");
            try {
                int monto = teclado.nextInt();
                validarMonto(monto);
                System.out.println("Monto válido.");
                mv = true;
            } catch (MontoInvalidoException e) {
                System.out.println(e + " " + e.getMessage());
            } catch (Exception e) {
                System.out.println(e + " El monto debe ser un número válido.");
                teclado.nextLine();
            }
        }

        teclado.nextLine();
        boolean nv = false;

        while (!nv) {
            System.out.print("Nombre: ");
            try {
                String nombre = teclado.nextLine();
                validarNombre(nombre);
                System.out.println("Nombre válido.");
                nv = true;
            } catch (NombreInvalidoException e) {
                System.out.println(e + " " + e.getMessage());
            }
        }
    }

    public static void validarTarjeta(String dato) {
        try {
            Long.valueOf(dato);
            if (dato.length() != 16);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("La tarjeta debe contener solo 16 digitos.");
        }

         /*{
            throw new IllegalArgumentException("La tarjeta debe tener exactamente 16 dígitos.");
        }*/
    }

    public static void validarMonto(int monto) throws MontoInvalidoException {
        if (monto <= 0) {
            throw new MontoInvalidoException("El monto debe ser mayor a cero.");
        }
    }

    public static void validarNombre(String nombre) throws NombreInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new NombreInvalidoException("El nombre no puede ser vacío.");
        }
    }
}

class MontoInvalidoException extends Exception {
    public MontoInvalidoException(String mensaje) {
        super(mensaje);
    }
}

class NombreInvalidoException extends Exception {
    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}
