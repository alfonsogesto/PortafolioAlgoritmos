public class Nodo<T> implements INodo<T> {
    private T dato;
    private Nodo<T> siguiente;
    private Comparable etiqueta;

    public Nodo(Comparable etiqueta, T dato) {
        this.etiqueta = etiqueta;
        this.dato = dato;
        this.siguiente = null;
    }

    @Override
    public T getDato() {
        return this.dato;
    }

    @Override
    public Nodo<T> getSiguiente() {
        return this.siguiente;
    }

    @Override
    public void setSiguiente(Nodo<T> nodo) {
        this.siguiente = nodo;
    }

    @Override
    public void imprimir() {
        System.out.println(this.dato.toString());
    }

    @Override
    public void imprimirEtiqueta() {
        System.out.println(this.etiqueta);
    }

    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public int compareTo(Comparable etiqueta) {
        return this.etiqueta.compareTo(etiqueta);
    }
}
