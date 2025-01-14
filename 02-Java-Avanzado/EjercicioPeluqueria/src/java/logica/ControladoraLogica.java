package logica;

import persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public void crearInsumo (String codigo, String nombre, String cantidad, String fecha) {
    
        Insumo insum = new Insumo (codigo, nombre, cantidad, fecha); 
        this.mostrarInsumo(insum);
        System.out.println(insum.toString());
    }
    
    public void mostrarInsumo(Insumo insum) {
        System.out.println(insum.toString());
    }
    
}
