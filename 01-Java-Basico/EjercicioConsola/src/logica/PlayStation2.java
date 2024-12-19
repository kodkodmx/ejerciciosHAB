package logica;

//PlayStation2: La cual tiene los atributos propios norma, chipeadaONo y
//tamañoMemoryCard. Al mismo tiempo, implementa un método propio “leerDvd”
//el cual recibirá el nombre de un juego como parámetro e indicará un mensaje
//por pantalla indicando esta situación. Por ejemplo: “Leyendo DVD Fifa 2009”.
//Por otro lado, también implementa un método propio llamado “grabarEnMemory”
//el cual debe informar al usuario que se ha guardado correctamente un juego en
//la memory card.


public class PlayStation2 extends Consola{
    
    private String norma;
    private boolean chipeadaONO;
    private int tamanioMemoryCard;

    public PlayStation2(String norma, boolean chipeadaONO, int tamanioMemoryCard, int codigo_consola, String nombre, String empresaDesarrollo, int anioLanzamiento) {
        super(codigo_consola, nombre, empresaDesarrollo, anioLanzamiento);
        this.norma = norma;
        this.chipeadaONO = chipeadaONO;
        this.tamanioMemoryCard = tamanioMemoryCard;
    }    
    

    @Override
    public String cargarJuego() {
        
        return "Cargando juego. Por favor espere... Desde PS";
        
    }

    public String getNorma() {
        return norma;
    }

    public void setNorma(String norma) {
        this.norma = norma;
    }

    public boolean isChipeadaONO() {
        return chipeadaONO;
    }

    public void setChipeadaONO(boolean chipeadaONO) {
        this.chipeadaONO = chipeadaONO;
    }

    public int getTamanioMemoryCard() {
        return tamanioMemoryCard;
    }

    public void setTamanioMemoryCard(int tamanioMemoryCard) {
        this.tamanioMemoryCard = tamanioMemoryCard;
    }
    
    public String leerDvd(String juego){
        return "Leyendo DVD" + juego;
    }
    
    public String grabarEnMemory(){
        return "Se ha guardado correctamente un juego en la memory card.";
    }
    
}
