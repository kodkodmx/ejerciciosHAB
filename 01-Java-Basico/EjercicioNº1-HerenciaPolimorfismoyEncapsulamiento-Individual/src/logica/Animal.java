package logica;

/*Crear una clase "Animal" con los atributos: id, nombre, edad, tipo de piel y tipo de alimentación 
(con sus métodos y constructores correspondientes). 
Agregar también un método llamado saludar que emita un mensaje por pantalla que diga “Hola, soy un animal”.*/

public class Animal {
    
    private int id;
    private String nombre;
    private int edad;
    private String tipoPiel;
    private String tipoAlimentación;

    public Animal() {
    }

    public Animal(int id, String nombre, int edad, String tipoPiel, String tipoAlimentación) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.tipoPiel = tipoPiel;
        this.tipoAlimentación = tipoAlimentación;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoPiel() {
        return tipoPiel;
    }

    public void setTipoPiel(String tipoPiel) {
        this.tipoPiel = tipoPiel;
    }

    public String getTipoAlimentación() {
        return tipoAlimentación;
    }

    public void setTipoAlimentación(String tipoAlimentación) {
        this.tipoAlimentación = tipoAlimentación;
    }
    
    private void saludar(){
        System.out.println("Hola, soy un animal");
    }
    
}
