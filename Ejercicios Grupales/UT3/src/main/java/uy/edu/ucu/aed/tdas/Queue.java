package uy.edu.ucu.aed.tdas;

public class Queue<T> extends Lista<T> implements IQueue<T> {

    @Override
    public void Push(T dato, Comparable clave) {
        insertar(dato, clave);
    }

    @Override
    public T Pop() {
        if (isEmpty()) {
            return null;
        }
        Nodo<T> nodo = primero;
       nodo.siguiente=primero;

        return nodo.dato;



    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
