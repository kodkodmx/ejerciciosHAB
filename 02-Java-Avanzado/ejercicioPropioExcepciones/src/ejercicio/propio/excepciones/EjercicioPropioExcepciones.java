package ejercicio.propio.excepciones;

import java.util.Scanner;

// Excepción personalizada (Chequeada)
class UsuarioNoEncontradoException extends Exception {
    public UsuarioNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}

// Excepción personalizada (No chequeada)
class ContraseñaIncorrectaException extends RuntimeException {
    public ContraseñaIncorrectaException(String mensaje) {
        super(mensaje);
    }
}

public class EjercicioPropioExcepciones {

    // Usuario administrador único
    private static final String USUARIO_ADMIN = "admin";
    private static final String CONTRASEÑA_ADMIN = "root";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== Sistema de Inicio de Sesión ===");

            // Solicitar credenciales al usuario
            System.out.print("Ingrese el usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese la contraseña: ");
            String contraseña = scanner.nextLine();

            // Intentar iniciar sesión
            iniciarSesion(usuario, contraseña);

        } catch (UsuarioNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ContraseñaIncorrectaException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Fin del proceso de inicio de sesión.");
            scanner.close();
        }
    }

    // Método para iniciar sesión
    public static void iniciarSesion(String usuario, String contraseña) throws UsuarioNoEncontradoException {
        if (!USUARIO_ADMIN.equals(usuario)) {
            // Lanza una excepción chequeada si el usuario no es correcto
            throw new UsuarioNoEncontradoException("El usuario ingresado no existe.");
        }

        if (!CONTRASEÑA_ADMIN.equals(contraseña)) {
            // Lanza una excepción no chequeada si la contraseña no es correcta
            throw new ContraseñaIncorrectaException("La contraseña ingresada es incorrecta.");
        }

        System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario + "!");
    }
}
