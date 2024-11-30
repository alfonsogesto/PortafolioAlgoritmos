
import javax.print.DocFlavor;
import java.util.*;

public class TNodoTrie implements INodoTrie {
    private boolean esPalabra;
    private HashMap<Character, TNodoTrie> hijos;

    public TNodoTrie(){
        hijos = new HashMap<>();
        esPalabra = false;
    }

    @Override
    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            char indice = unaPalabra.charAt(c);
            if(nodo.hijos.get(indice) == null) {
                nodo.hijos.put(indice, new TNodoTrie());
            }
            nodo = nodo.hijos.get(indice);
        }
        nodo.esPalabra = true;
    }


    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);

            }
            for (char c : nodo.hijos.keySet()) {
                if (nodo.hijos.get(c) != null) {
                    imprimir(s + c ,nodo.hijos.get(c));
                }
            }
        }
    }

    @Override
    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrie buscarNodoTrie(String s) {
        TNodoTrie nodo = this;
        for (int c = 0; c < s.length(); c++) {
            char indice = s.charAt(c);
            if (nodo.hijos.get(indice) == null) {
                return null;
            }
            nodo = nodo.hijos.get(indice);
        }
        return nodo;
    }

    /**
     * Busca una palabra en el trie y devuelve la cantidad de comparaciones realizadas durante la búsqueda.
     *
     * @param s La palabra a buscar dentro del trie.
     * @return El número de comparaciones realizadas para determinar si la palabra está o no en el trie.
     */
    @Override
    public int buscar(String s) {
        TNodoTrie nodo = this;
        int comparaciones = 0;
        for (int c = 0; c < s.length(); c++) {
            char indice = s.charAt(c);
            nodo = nodo.hijos.get(indice);
            comparaciones++;
            if (nodo == null) {
                return comparaciones;
            }
        }
        return nodo.esPalabra ? comparaciones : -1;
    }
    /**
     * Toma una lista de palabras como parámetro y las busca en el trie
     *
     * se utiliza metodo nanoTime de la clase System para medir el tiempo antes y después de la busqueda
     * se utiliza el metodo runtime para medir el consumo de memoria.
     */
    public void busquedaMasiva(List<String> palabras) { //Método para buscar de forma masiva y comparar memoria y tiempo de ejecución
        //Forzamos a que el garbage collector se ejecute antes de medir la memoria final y esperamos un poco
        System.gc();
        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

        long tiempoInicio = System.nanoTime();
        long memoriaInicial = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        int comparaciones = 0;


        for(String palabra : palabras) {
            comparaciones += buscar(palabra);
        }
        long tiempoFinal = System.nanoTime();

        System.gc();
        try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }

        long memoriaFinal = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long tiempoDeEjecucion = tiempoFinal - tiempoInicio;
        long memoriaUtilizada = memoriaFinal - memoriaInicial;

        System.out.println("Tiempo de ejecución utilizado" + tiempoDeEjecucion);
        System.out.println("Memoria Utilizada" + "bytes" + memoriaUtilizada);
        System.out.println("Total de comparaciones realizadas" + comparaciones);

    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (char c : nodo.hijos.keySet()) {
                if (nodo.hijos.get(c) != null) {
                    predecir(s + c, palabras, nodo.hijos.get(c));
                }
            }
        }
    }

    /**
     * Genera una lista de todas las palabras que contienen el prefijo dado.
     * Las palabras encontradas se agregan a la lista 'palabras'.
     *
     * @param prefijo El prefijo que se utilizará para buscar palabras en el trie.
     * @param palabras Lista de strings donde se almacenarán las palabras encontradas que coinciden con el prefijo dado.
     */
    @Override
    public void predecir(String prefijo, List<String> palabras) {
        TNodoTrie nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir(prefijo, (LinkedList<String>) palabras, nodo);
        }
    }
}