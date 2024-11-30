package uy.edu.ucu.aed.tdas;

public class Lista<T> implements ILista<T> {

    protected class Nodo<T> {
        protected final Comparable etiqueta;
        protected T dato;
        protected Nodo<T> siguiente = null;

        public Nodo(Comparable etiqueta, T dato ) {
            this.etiqueta = etiqueta;
            this.dato = dato;
        }
    }

    protected Nodo<T> primero;
    protected Nodo<T> ultimo;

    public Lista() {
        primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> nuevoNodo = new Nodo<>(clave, dato);
        if (primero == null) {
            primero = nuevoNodo;
            ultimo = primero;
        } else {
            ultimo.siguiente = nuevoNodo;
            ultimo = ultimo.siguiente;


        }
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.etiqueta.equals(clave)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }
        if (primero.etiqueta.equals(clave)) {
            primero = primero.siguiente;
            return true;
        }

        Nodo<T> actual = primero;
        while (actual.siguiente != null) {
            if (actual.siguiente.etiqueta.equals(clave)) {
                actual.siguiente = actual.siguiente.siguiente;
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }

    @Override
    public String imprimir() {
        return imprimir(" ");
    }

    @Override
    public String imprimir(String separador) {
        StringBuilder sb = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            sb.append(actual.etiqueta.toString());
            if (actual.siguiente != null) {
                sb.append(separador);
            }
            actual = actual.siguiente;
        }
        return sb.toString();
    }

    @Override
    public int cantElementos() {
        int count = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            count++;
            actual = actual.siguiente;
        }
        return count;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
}
