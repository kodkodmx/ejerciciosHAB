package logica;

//Xbox One: La cual tiene una serie de atributos propios para manejar: Si está
//conectada a internet o no, si la calidad 4K está activada y si se permite la
//descarga automática de actualizaciones. Al mismo tiempo implementa un
//método propio “leerJuegoDigital” el cual recibirá el nombre de un juego como
//parámetro e indicará un mensaje por pantalla indicando esta situación. Por
//ejemplo: “Leyendo GTA V desde tienda”.


public class XboxOne extends Consola{
    
    private boolean estaConectada;
    private boolean es4K;
    private boolean autoUpdate;

    @Override
    public String cargarJuego() {        
        return "Cargando juego. Por favor espere... Desde XboxOne";
    }
    
    public String leerJuegoDigital(String juego){
        return "Leyendo "+juego+" desde tienda";
    }

    public XboxOne(boolean estaConectada, boolean es4K, boolean autoUpdate, int codigo_consola, String nombre, String empresaDesarrollo, int anioLanzamiento) {
        super(codigo_consola, nombre, empresaDesarrollo, anioLanzamiento);
        this.estaConectada = estaConectada;
        this.es4K = es4K;
        this.autoUpdate = autoUpdate;
    }

    public boolean isAutoUpdate() {
        return autoUpdate;
    }

    public void setAutoUpdate(boolean autoUpdate) {
        this.autoUpdate = autoUpdate;
    }

    public boolean isEstaConectada() {
        return estaConectada;
    }

    public void setEstaConectada(boolean estaConectada) {
        this.estaConectada = estaConectada;
    }

    public boolean isEs4K() {
        return es4K;
    }

    public void setEs4K(boolean es4K) {
        this.es4K = es4K;
    }
    
    
    
    
    
    
    
}
