package ejercicioexpresioneslambdabiblioteca;

import logica.NotificadorLibro;


public class EjercicioExpresionesLambdaBiblioteca {


    public static void main(String[] args) {
        new NotificadorLibro(){
            @Override
            public void enviarNotificacion(String mensaje) {
                System.out.println("Notificación clásica: " + mensaje);
            }
            
        }.enviarNotificacion("Libro disponible.");
        
        NotificadorLibro notif = mensaje -> System.out.println("Notificación moderna: " + mensaje);
        notif.enviarNotificacion("Fecha de Vencimiento proxima.");
    }
    
}
