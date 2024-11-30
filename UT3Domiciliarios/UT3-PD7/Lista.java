public class Lista<T> implements ILista<T> {

    private Nodo<T> primero;

    public Lista() {
        this.primero = null;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> nuevoNodo = new Nodo<>(clave, dato);
        if (primero == null) {
            primero = nuevoNodo;
        } else {
            Nodo<T> actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
        }
    }

    @Override
    public T buscar(Comparable clave) {
        Nodo<T> actual = primero;
        while (actual != null) {
            if (actual.getEtiqueta().compareTo(clave) == 0) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }

        if (primero.getEtiqueta().compareTo(clave) == 0) {
            primero = primero.getSiguiente();
            return true;
        }

        Nodo<T> actual = primero;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getEtiqueta().compareTo(clave) == 0) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return true;
            }
            actual = actual.getSiguiente();
        }

        return false;
    }

    @Override
    public String imprimir() {
        StringBuilder resultado = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado.append(actual.getEtiqueta().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    @Override
    public String imprimirConSeparador(String separador) {
        StringBuilder resultado = new StringBuilder();
        Nodo<T> actual = primero;
        while (actual != null) {
            resultado.append(actual.getEtiqueta().toString()).append(separador);
            actual = actual.getSiguiente();
        }
        return resultado.toString();
    }

    @Override
    public int cantElementos() {
        int contador = 0;
        Nodo<T> actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }
}
