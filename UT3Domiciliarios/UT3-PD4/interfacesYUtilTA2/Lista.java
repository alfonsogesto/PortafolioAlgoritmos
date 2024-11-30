
public class Lista<T> implements ILista<T> {
    
    protected INodo<T> primero;
    
    public Lista() {
        this.primero = null;
    }

    @Override
    public void insertar(Nodo nodo) {
        INodo nodoActual = this.primero;
        if(nodoActual == null) {
            this.primero = nodo;
            primero.setSiguiente(null);
        } else {
            while(nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nodo);
        }
    }

    
    @Override
    public Nodo buscar(Comparable clave) {
        if(primero.equals(null)) {
            return null;
        }
        
        INodo nodoActual = primero;
        while(nodoActual != null) {
            if(nodoActual.getEtiqueta().equals(clave)) {
                return (Nodo)nodoActual;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }

    @Override
    public boolean eliminar(Comparable clave) {
        if (primero == null) {
            return false;
        }       
        
        INodo<T> nodoActual = primero;
        INodo<T> nodoAnterior = null;
        
        while (nodoActual != null) {
            if (nodoActual.getEtiqueta().equals(clave)) {
                if (nodoAnterior == null) {
                    primero = nodoActual.getSiguiente();
                } else {
                    nodoAnterior.setSiguiente(nodoActual.getSiguiente());
                }
                nodoActual.setSiguiente(null);
                return true;
            }
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getSiguiente();
        }
        return false;
    }
    @Override
    public String imprimir() {
        if(primero.equals(null)) {
            return "Lista vacía.";
        }      
        
        StringBuilder cadena = new StringBuilder();
        
        INodo nodoActual = this.primero;
        while(nodoActual != null) {
            cadena.append(nodoActual.getEtiqueta().toString() + " ");
            nodoActual = nodoActual.getSiguiente();
        }
        return cadena.toString();
    }

    @Override
    public String imprimir(String separador) {
        if(primero.equals(null)) {
            return "Lista vacía.";
        }      
        
        StringBuilder cadena = new StringBuilder();
        
        INodo nodoActual = this.primero;
        while(nodoActual != null) {
            cadena.append(nodoActual.getEtiqueta().toString() + separador);
            nodoActual = nodoActual.getSiguiente();
        }
        return cadena.toString();
    }

    @Override
    public int cantElementos() {
        if(primero.equals(null)) {
            return 0;
        }      
        
        Integer cantidad = 0;
        INodo nodoActual = this.primero;
        
        while(nodoActual != null) {
            cantidad++;
            nodoActual = nodoActual.getSiguiente();
        }
        return cantidad;
    }

    @Override
    public boolean esVacia() {
        return (this.primero.equals(null)) ? true : false; 
    }

    @Override
    public void setPrimero(Nodo unNodo) {
        this.primero = unNodo;
    }

    @Override
    public Nodo darPrimero() {
        return (Nodo)this.primero;
    }

    @Override
    public void insertar(Comparable etiqueta, T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(etiqueta, dato);
        this.insertar(nuevoNodo);
    }
    
}