package logica;

//    Nintendo64: La cual tiene un atributo propio norma y otro para determinar si lee
//cartuchos piratas. Al mismo tiempo, implementa un método propio
//“leerCartucho” el cual recibirá el nombre de un juego como parámetro e indicará
//un mensaje por pantalla indicando esta situación. Por ejemplo: “Leyendo
//cartucho Banjo Kazooie”.

public class Nintendo64 extends Consola {
    
    private String norma;
    private boolean leePirata;


    public Nintendo64(String norma, boolean leePirata, int codigo_consola, String nombre, String empresaDesarrollo, int anioLanzamiento) {
        super(codigo_consola, nombre, empresaDesarrollo, anioLanzamiento);
        this.norma = norma;
        this.leePirata = leePirata;
    }
    
    public String getNorma() {
        return norma;
    }

    public void setNorma(String norma) {
        this.norma = norma;
    }

    public boolean isLeePirata() {
        return leePirata;
    }

    public void setLeePirata(boolean leePirata) {
        this.leePirata = leePirata;
    }
    
    public String leerCartucho(String juego){
        
        return "Leyendo Cartucho" + juego;
    }
    
    @Override
    public String cargarJuego(){
        
        return "Cargando juego. Por favor espere... Desde N64";
        
    }
    
    
    
    
}
