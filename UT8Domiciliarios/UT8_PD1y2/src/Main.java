import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        TVertice verticeB = new TVertice("B");
        TVertice verticeD = new TVertice("D");
        TVertice verticeE = new TVertice("E");
        TVertice verticeA = new TVertice("A");
        TVertice verticeC  = new TVertice("C");
        TVertice verticeF  = new TVertice("F");
        TVertice verticeG  = new TVertice("G");

        TArista aristaBD = new TArista("B", "D", 0);
        TArista aristaBE = new TArista("B", "E", 0);
        TArista aristaBA = new TArista("B", "A", 0);
        TArista aristaEC = new TArista("E", "C", 0);
        TArista aristaCF = new TArista("C", "F", 0);
        TArista aristaCG = new TArista("C", "G", 0);

        Collection<TVertice> vertices = new ArrayList<>();
        vertices.add(verticeA);
        vertices.add(verticeB);
        vertices.add(verticeC);
        vertices.add(verticeD);
        vertices.add(verticeE);
        vertices.add(verticeF);
        vertices.add(verticeG);

        LinkedList<TArista> aristas = new LinkedList<>();
        aristas.add(aristaBD);
        aristas.add(aristaBE);
        aristas.add(aristaBA);
        aristas.add(aristaEC);
        aristas.add(aristaCF);
        aristas.add(aristaCG);

        TGrafoNoDirigido grafo = new TGrafoNoDirigido(vertices, aristas);

        Collection<TVertice> bosqueAbarcador = grafo.beaDesdeVerticeInicial("B");

        for (TVertice vertice : bosqueAbarcador) {
            System.out.println(vertice.getEtiqueta());
        }

    }
}
