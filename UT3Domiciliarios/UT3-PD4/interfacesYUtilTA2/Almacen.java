public class Almacen implements IAlmacen {
    
    private String direccion;
    private String telefono;
    private String nombre;
    private ILista<IProducto> productos = new Lista<IProducto>();

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String getTelefono() {
        return telefono;
    }

    @Override
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public Lista getListaProductos() {
        return (Lista) productos;
    }

    @Override
    public void insertarProducto(Producto unProducto) {
        productos.insertar(new Nodo(unProducto.getEtiqueta(), unProducto));
    }

    @Override
    public boolean eliminar(Comparable clave) {
        return productos.eliminar(clave);
    }

    @Override
    public String imprimirProductos() {
        return productos.imprimir();
    }

    @Override
    public String imprimirSeparador(String separador) {
        return productos.imprimir(separador);
    }

    @Override
    public Boolean agregarStock(Comparable clave, Integer cantidad) {
        IProducto producto = buscarPorCodigo(clave);
        producto.setStock(producto.getStock() + cantidad);
        return true;
    }

    @Override
    public Integer restarStock(Comparable clave, Integer cantidad) {
        IProducto producto = buscarPorCodigo(clave);
        
        Integer stock = producto.getStock();
        if (stock <= cantidad) {
            producto.setStock(0);
        } else {
            producto.setStock(stock - cantidad);
        }
        return producto.getStock();
    }

    @Override
    public Producto buscarPorCodigo(Comparable clave) {
        INodo<IProducto> nodoProducto = productos.buscar(clave);
        if(nodoProducto == null) {
            return null;
        }
        return (Producto) nodoProducto.getDato();
    }

    @Override
    public void listarOrdenadoPorNombre() {
        ListaOrdenada<IProducto> listaOrdenada = new ListaOrdenada<>();
        INodo nodo = productos.darPrimero();
        IProducto producto = (IProducto)nodo.getDato();
        
        while(nodo != null) {
            listaOrdenada.insertarOrdenado(new Nodo(producto.getNombre(), producto));
            nodo = nodo.getSiguiente();
            producto = (IProducto)nodo.getDato();
        }

        INodo nodoImprimir = (INodo)listaOrdenada.primero;
        
        while(nodoImprimir != null) {
            System.out.println(nodoImprimir.getEtiqueta());
            nodoImprimir = nodoImprimir.getSiguiente();
        }
    }

    @Override
    public Producto buscarPorDescripcion(String descripcion) {
        INodo nodo = productos.darPrimero();
        Producto producto = (Producto)nodo.getDato();
        String etiquetaDescripcion = producto.getNombre();
        
        while(nodo != null) {
            producto = (Producto)nodo.getDato();
            etiquetaDescripcion = producto.getNombre();
            
            if(descripcion.equalsIgnoreCase(etiquetaDescripcion)) {
                return producto;
            }
            nodo = nodo.getSiguiente();
        }
        return null;
    }

    @Override
    public int cantidadProductos() {
        return productos.cantElementos();
    }
    
}
