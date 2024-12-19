package logica;


public abstract class Consola {  
    //codigo_consola, nombre, empresaDesarrollo y año de lanzamiento.
    
    private int codigo_consola;
    private String nombre;
    private String empresaDesarrollo;
    private int anioLanzamiento;


    public Consola(int codigo_consola, String nombre, String empresaDesarrollo, int anioLanzamiento) {
        this.codigo_consola = codigo_consola;
        this.nombre = nombre;
        this.empresaDesarrollo = empresaDesarrollo;
        this.anioLanzamiento = anioLanzamiento;
    }
    
    public abstract String cargarJuego();

    public int getCodigo_consola() {
        return codigo_consola;
    }

    public void setCodigo_consola(int codigo_consola) {
        this.codigo_consola = codigo_consola;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresaDesarrollo() {
        return empresaDesarrollo;
    }

    public void setEmpresaDesarrollo(String empresaDesarrollo) {
        this.empresaDesarrollo = empresaDesarrollo;
    }

    public int getAnioLanzamiento() {
        return anioLanzamiento;
    }

    public void setAnioLanzamiento(int anioLanzamiento) {
        this.anioLanzamiento = anioLanzamiento;
    }
   
    
    
}
