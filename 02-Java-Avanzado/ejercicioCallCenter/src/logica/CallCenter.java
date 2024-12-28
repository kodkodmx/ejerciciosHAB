package logica;

import java.util.ArrayList;
import java.util.List;

public class CallCenter {
    private List<String> listaLlamadas; // Lista de llamadas
    private int numLlamada; // Identificador de llamada
    private boolean isActive = true; // Variable que controla si el centro está activo o no

    
    
   public CallCenter() {
        listaLlamadas = new ArrayList<>();
        numLlamada = 1; // Inicializa el ID de las llamadas
    }

    // Método sincronizado para recibir llamadas
    public synchronized void recibirLlamada() {
        String llamada = "Llamada " + numLlamada;
        listaLlamadas.add(llamada);
        System.out.println("\n" + llamada + " ha sido recibida.");
        numLlamada++;
        notifyAll(); // Notifica a los agentes de que hay una nueva llamada
    }
    
    // Método sincronizado para asignar una llamada a un agente
    public synchronized String asignarLlamada() {
        while (listaLlamadas.isEmpty()) {
            try {
                wait(); // Espera si no hay llamadas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return listaLlamadas.remove(0); // Elimina de la lista la primera llamada y la devuelve
        
    }
    
        // Método para verificar si el centro de atención está activo
    public synchronized boolean isActive() {
        return isActive;
    }

    // Método para cerrar el centro de atención
   /* public synchronized void shutdown() {
        isActive = false; // Cambiar el estado a inactivo
        notifyAll(); // Notifica a los hilos en espera para que terminen
    }*/
    

    public List<String> getListaLlamadas() {
        return listaLlamadas;
    }

    public void setListaLlamadas(List<String> listaLlamadas) {
        this.listaLlamadas = listaLlamadas;
    }

    public int getNumLlamada() {
        return numLlamada;
    }

    public void setNumLlamada(int numLlamada) {
        this.numLlamada = numLlamada;
    }
    
    
    
}