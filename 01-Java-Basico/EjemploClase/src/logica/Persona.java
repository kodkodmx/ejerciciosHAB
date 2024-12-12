package logica;

import java.time.LocalDate;


public class Persona {
    
    //atributos
    int id_personal;
    String nombre;
    String apellido;
    LocalDate fecha_nac;
    String direccion;
    
    //metodos
    //constructores

    public Persona() {
    }
    
    public Persona(int id_personal, String nombre, String apellido, LocalDate fecha_nac, String direccion) {
        this.id_personal = id_personal;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
    }

 
    
    
    
    
    //getters y setters

    public int getId_personal() {
        return id_personal;
    }

    public void setId_personal(int id_personal) {
        this.id_personal = id_personal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(LocalDate fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    

    
    
    
}
