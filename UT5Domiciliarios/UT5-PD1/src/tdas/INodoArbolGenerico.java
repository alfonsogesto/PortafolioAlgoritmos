public interface INodoArbolGenerico<T> {
    public Comparable getEtiqueta();
    public TNodoGenerico<T> getPrimerHijo();
    public TNodoGenerico<T> getHermanoDer();
    public void setPrimerHijo(TNodoGenerico<T> elemento);
    public void setHermanoDer(TNodoGenerico<T> elemento);
    public TNodoGenerico<T> buscar(Comparable unaEtiqueta);
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre);
    public TNodoGenerico<T> eliminar(Comparable unaEtiqueta);
    public void listarIdentado();
    public T getDatos();
}