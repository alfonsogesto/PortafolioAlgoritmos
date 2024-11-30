package uy.edu.ucu.aed.tdas;

public interface IQueue<T> {
    public void Push(T dato, Comparable clave);
    public T Pop();
    public boolean isEmpty();
}
