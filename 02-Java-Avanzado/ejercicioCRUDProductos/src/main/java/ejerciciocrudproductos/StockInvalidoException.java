package ejerciciocrudproductos;

class StockInvalidoException extends Exception{
    public StockInvalidoException(String mensaje) {
        super(mensaje);
    }
}