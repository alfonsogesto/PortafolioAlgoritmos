package uy.edu.ucu.aed.tdas;
public interface IStack<T> {
    public void Push(T dato, Comparable clave);
    public T Pop();
    public boolean isEmpty();
}
