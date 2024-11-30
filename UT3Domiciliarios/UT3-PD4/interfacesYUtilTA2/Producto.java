public class Producto implements IProducto {
    
    private String nombre;
    private String codigo;
    private Integer precio;
    private Integer stock;

    @Override
    public Comparable getEtiqueta() {
        return codigo;
    }

    @Override
    public Integer getPrecio() {
        return precio;
    }

    @Override
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public Integer getStock() {
        return stock;
    }

    @Override
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
