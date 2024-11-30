public class Main {
    public static void main(String[] args) {
        IAlmacen almacen = new Almacen();
        Compras(almacen);
        Ventas(almacen);   
    }
    public static void Compras(IAlmacen almacen) {
        Integer cantStock = 0;
        Integer dineroGastado = 0;
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("altas.txt");

        String codigoProducto;
        String descripcionProducto;
        Integer precioProducto;
        Integer cantidadProducto;
        IProducto producto = new Producto();

        for(String linea : lineas) {
            String[] info = linea.split(",");
            try {
                codigoProducto = info[0];
                descripcionProducto = info[1];
                precioProducto = Integer.parseInt(info[2]);
                cantidadProducto = Integer.parseInt(info[3]);            
            } catch(NumberFormatException e) {
                codigoProducto = info[0];
                descripcionProducto = info[1];
                precioProducto = 0;
                cantidadProducto = 0;
            }
            
            producto.setPrecio(precioProducto);
            producto.setStock(cantidadProducto);
            producto.setNombre(descripcionProducto);
            producto.setCodigo(codigoProducto);
            
            almacen.insertarProducto((Producto)producto);
            
            cantStock += cantidadProducto;
            dineroGastado += precioProducto;
        }
        
        System.out.println("El dinero gastado en las compras fue: $" + dineroGastado);
        System.out.println("La cantidad de stock comprado fue: " + cantStock); 
    }

    public static void Ventas(IAlmacen almacen) {
        Integer cantStockVendido = 0;
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("ventas.txt");

        String codigoProducto;
        Integer cantidadVender;
        IProducto producto = new Producto();

        for(String linea : lineas) {
            String[] info = linea.split(",");
            codigoProducto = info[0];
            cantidadVender = Integer.parseInt(info[1]);
                
            IProducto productoAvender = almacen.buscarPorCodigo(codigoProducto);
            if(productoAvender != null) {
                if(productoAvender.getStock() < cantidadVender) {
                    cantidadVender = productoAvender.getStock();
                }                
                almacen.restarStock(codigoProducto, cantidadVender);
                cantStockVendido += cantidadVender;
            }
            
        }
        
        System.out.println("Stock vendido: " + cantStockVendido);
    }
}
