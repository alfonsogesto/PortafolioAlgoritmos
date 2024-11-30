import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TArbolTrie trie = new TArbolTrie();
        String[] palabrasDesdeArchivo = ManejadorArchivosGenerico.leerArchivo("src/palabras.txt");
        for (String palabra : palabrasDesdeArchivo) {
            trie.insertar(palabra);
        }

        String[] palabrasClave = {
                "apple", "app", "apricot", "banana", "band", "bandit", "bandage",
                "berry", "blueberry", "blackberry", "cherry", "cranberry", "date"
        };
        for (String palabra : palabrasClave) {
            trie.insertar(palabra);
        }

        trie.imprimir();

        LinkedList<String> listaPredicciones = trie.predecir("programa");
        for (String palabra : listaPredicciones) {
            System.out.println(palabra);
        }

        List<String> palabrasBuscar = Arrays.asList(
                "apple", "apricot", "banana", "bandage", "blueberry", "cranberry",
                "date", "notaword", "bandit", "cherry", "blackberry", "berry"
        );
        trie.busquedaMasiva(palabrasBuscar);
    }
}
