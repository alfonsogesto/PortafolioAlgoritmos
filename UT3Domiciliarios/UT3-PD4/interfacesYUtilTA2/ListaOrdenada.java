public class ListaOrdenada<T> extends Lista<T> {

    public void insertarOrdenado(Nodo<T> nuevoNodo) {
        if (this.esVacia()) {
            this.setPrimero(nuevoNodo);
            return;
        }

        Nodo<T> actual = this.darPrimero();
        Nodo<T> anterior = null;

        while (actual != null) {
            int comparacion = actual.compareTo(nuevoNodo.getEtiqueta());

            if (comparacion >= 0) {
                break;
            }

            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (anterior == null) {
            nuevoNodo.setSiguiente(actual);
            this.setPrimero(nuevoNodo);
        } else {
            anterior.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(actual);
        }
    }
}
