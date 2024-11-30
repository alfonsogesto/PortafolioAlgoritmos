import java.util.*;

public class TNodoTrieHashMap {
    private HashMap<Character, TNodoTrieHashMap> hijos;
    private boolean esPalabra;

    public TNodoTrieHashMap() {
        hijos = new HashMap<>();
        esPalabra = false;
    }

    public void insertar(String unaPalabra) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            char character = unaPalabra.charAt(c);
            nodo.hijos.putIfAbsent(character, new TNodoTrieHashMap());
            nodo = nodo.hijos.get(character);
        }
        nodo.esPalabra = true;
    }

    private void imprimir(String s, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (Map.Entry<Character, TNodoTrieHashMap> entry : nodo.hijos.entrySet()) {
                imprimir(s + entry.getKey(), entry.getValue());
            }
        }
    }

    public void imprimir() {
        imprimir("", this);
    }

    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < s.length(); c++) {
            char character = s.charAt(c);
            if (nodo == null) {
                return null;
            }
            nodo = nodo.hijos.get(character);
        }
        return nodo;
    }

    public int buscar(String s) {
        TNodoTrieHashMap nodo = this;
        int comparaciones = 0;
        for (int c = 0; c < s.length(); c++) {
            char character = s.charAt(c);
            nodo = nodo.hijos.get(character);
            comparaciones++;
            if (nodo == null) {
                return comparaciones;
            }
        }
        return nodo.esPalabra ? comparaciones : -1;
    }

    private void predecir(String s, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (Map.Entry<Character, TNodoTrieHashMap> entry : nodo.hijos.entrySet()) {
                if (entry.getKey() != null) {
                    predecir(s + entry.getKey(), palabras, entry.getValue());
                }
            }
        }
    }

    public void predecir(String prefijo, List<String> palabras) {
        TNodoTrieHashMap nodo = buscarNodoTrie(prefijo);
        if (nodo != null) {
            predecir(prefijo, (LinkedList<String>) palabras, nodo);
        }
    }
}
