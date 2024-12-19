package logica;

//código, nombre, marca, tipo, precio costo, precio venta, cantidad en stock.

public class Producto {
    
    private String codigo;
    private String nombre;
    private String marca;
    private String tipo;
    private int precioCosto;
    private int precioVenta;
    private int Stock;

    public Producto() {
    }

    public Producto(String codigo, String nombre, String marca, String tipo, int precioCosto, int precioVenta, int Stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.marca = marca;
        this.tipo = tipo;
        this.precioCosto = precioCosto;
        this.precioVenta = precioVenta;
        this.Stock = Stock;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("codigo=").append(codigo);
        sb.append(", nombre=").append(nombre);
        sb.append(", marca=").append(marca);
        sb.append(", tipo=").append(tipo);
        sb.append(", precioCosto=").append(precioCosto);
        sb.append(", precioVenta=").append(precioVenta);
        sb.append(", Stock=").append(Stock);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
