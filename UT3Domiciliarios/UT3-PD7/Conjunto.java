public class Conjunto<T> implements ILista<T>, IConjunto<T> {

    private Nodo<T> primero;

    public Conjunto() {
        primero = null;
    }

    @Override
    public Nodo<T> GetPrimero() {
        return this.primero;
    }

    @Override
    public void insertar(T dato, Comparable clave) {
        Nodo<T> nuevoNodo = new Nodo<T>(clave, dato);
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
        Nodo<T> actual = primero;
        StringBuilder resultado = new StringBuilder();
        while (actual != null) {
            resultado.append(actual.getEtiqueta().toString()).append("\n");
            actual = actual.getSiguiente();
        }
        System.out.println(resultado.toString());
        return resultado.toString();
    }

    @Override
    public String imprimirConSeparador(String separador) {
        Nodo<T> actual = primero;
        StringBuilder resultado = new StringBuilder();
        while (actual != null) {
            resultado.append(actual.getEtiqueta().toString()).append(separador);
            actual = actual.getSiguiente();
        }
        System.out.println(resultado.toString());
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

    @Override
    public IConjunto<T> union(IConjunto<T> otroConjunto) {
        IConjunto<T> conjuntoFinal = new Conjunto<>();
        Nodo<T> actual = primero;

        while (actual != null) {
            conjuntoFinal.insertar(actual.getDato(), actual.getEtiqueta());  
            actual = actual.getSiguiente();
        }

        Nodo<T> otroActual = otroConjunto.GetPrimero();
        while (otroActual != null) {
            if (conjuntoFinal.buscar(otroActual.getEtiqueta()) == null) {  
                conjuntoFinal.insertar(otroActual.getDato(), otroActual.getEtiqueta());
            }
            otroActual = otroActual.getSiguiente();
        }

        return conjuntoFinal;
    }

    @Override
    public IConjunto<T> interseccion(IConjunto<T> otroConjunto) {
        IConjunto<T> conjuntoFinal = new Conjunto<>();
        Nodo<T> actual = primero;

        while (actual != null) {
            if (otroConjunto.buscar(actual.getEtiqueta()) != null) {  
                conjuntoFinal.insertar(actual.getDato(), actual.getEtiqueta());
            }
            actual = actual.getSiguiente();
        }

        return conjuntoFinal;
    }
}
