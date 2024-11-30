package uy.edu.ucu.aed.tdas;

public class Stack<T> extends Lista<T> implements IStack<T> {

    @Override
    public void Push(T dato, Comparable clave) {
        insertar(dato, clave);
    }

    @Override
    public T Pop() {
        if (isEmpty()) {
            return null;
        }

        Nodo<T> actual = primero;
        Nodo<T> anterior = null;

        while (actual.siguiente != null) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (anterior != null) {
            anterior.siguiente = null;
        } else {
            primero = null; // Si solo hay un elemento
        }

        return actual.dato;
    }

    @Override
    public boolean isEmpty() {
        return esVacia();
    }
}