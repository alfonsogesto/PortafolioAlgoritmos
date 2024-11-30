public interface IArbolGenerico<T> {
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    public TNodoGenerico<T> buscar(Comparable unaEtiqueta);

    public void eliminar(Comparable unaEtiqueta);
    public T getDatos();
    public void listarIdentado( );

}