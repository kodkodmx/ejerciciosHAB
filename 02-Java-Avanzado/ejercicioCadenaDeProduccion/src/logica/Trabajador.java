package logica;

public class Trabajador extends Thread {
    private String nombre;
    private Fabrica fabrica;

    public Trabajador(String nombre, Fabrica fabrica) {
        this.nombre = nombre;
        this.fabrica = fabrica;
    }
    
    @Override
    public void run() {
        while (fabrica.isActive()) {
        String tarea = fabrica.asignarTarea();
            
            System.out.println("\n" + nombre + " está controlando calidad " + tarea);
            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n" + nombre + " esta embalando " + tarea);
        }
    }
    
    
    
}
