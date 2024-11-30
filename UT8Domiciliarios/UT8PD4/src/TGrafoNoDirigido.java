import java.lang.reflect.Array;
import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido, IGrafoKevinBacon {

    protected TAristas lasAristas = new TAristas();

    public TGrafoNoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        super(vertices, aristas);
        lasAristas.insertarAmbosSentidos(aristas);
    }

    @Override
    public boolean insertarArista(TArista arista) {
        boolean tempbool = false;
        TArista arInv = new TArista(arista.getEtiquetaDestino(), arista.getEtiquetaOrigen(), arista.getCosto());
        tempbool = (super.insertarArista(arista) && super.insertarArista(arInv));
        return tempbool;
    }

    public TAristas getLasAristas() {
        return lasAristas;
    }

    @Override
    public TGrafoNoDirigido Prim() {
        LinkedList<TArista> conjuntoAristas = PrimAuxiliar();
        Collection<TVertice> v = getVertices().values();
        TGrafoNoDirigido grafoMenorCosto = new TGrafoNoDirigido(v, conjuntoAristas);
        return grafoMenorCosto;
    }

    public LinkedList<TArista> PrimAuxiliar() {
        Set<TVertice> V = new HashSet<>(this.getVertices().values());
        LinkedList<TArista> T = new LinkedList<>();
        Set<TVertice> U = new HashSet<>();
        for (TVertice v : getVertices().values()) {
            U.add(v);
            break;
        }
        while (U.size() != V.size()) {
            double menorCosto = Double.MAX_VALUE;
            TArista aristaDeMenorCosto = null;
            LinkedList<TArista> todasLasaristasDelGrafo = this.getLasAristas();
            for (TArista a : todasLasaristasDelGrafo) {
                Set<TVertice> diferencia = new HashSet<>(V);
                diferencia.removeAll(U);
                TVertice origen = buscarVertice(a.etiquetaOrigen);
                TVertice destino = buscarVertice(a.etiquetaDestino);
                if (U.contains(origen) && diferencia.contains(destino) && a.getCosto() < menorCosto && !T.contains(a)) {
                    menorCosto = a.getCosto();
                    aristaDeMenorCosto = a;
                }
            }
            T.add(aristaDeMenorCosto);
            TVertice ver = buscarVertice(aristaDeMenorCosto.etiquetaDestino);
            U.add(ver);
        }
        return T;
    }

    @Override
    public TGrafoNoDirigido Kruskal() {
        return kruskalAuxiliar();
    }

    public TGrafoNoDirigido kruskalAuxiliar() {
        TGrafoNoDirigido AAM = new TGrafoNoDirigido(getVertices().values(), new TAristas());
        TAristas aristasSinOrdenar = lasAristas;
        aristasSinOrdenar.sort(Comparator.comparingDouble((TArista arista) -> arista.costo));
        TAristas aristasOrdenadas = new TAristas();
        aristasOrdenadas.addAll(aristasSinOrdenar);
        int aristasAgregadasAlAMM = 0;
        while (aristasAgregadasAlAMM != getVertices().size() - 1) {
            TArista aristaMinima = aristasOrdenadas.removeFirst();
            TVertice verticeOrigen = AAM.getVertices().get(aristaMinima.getEtiquetaOrigen());
            TVertice verticeDestino = AAM.getVertices().get(aristaMinima.getEtiquetaDestino());
            if (!AAM.estanConectadosKruskal(verticeOrigen.getEtiqueta(), verticeDestino.getEtiqueta())) {
                AAM.insertarArista(aristaMinima);
                AAM.getLasAristas().add(aristaMinima.aristaInversa());
                aristasAgregadasAlAMM++;
            }
        }
        return AAM;
    }

    private boolean estanConectados(Comparable etiquetaVertice1, Comparable etiquetaVertice2) {
        TVertice v = buscarVertice(etiquetaVertice1);
        if (v.buscarAdyacencia(etiquetaVertice2) != null) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("")
    private boolean estanConectadosKruskal(Comparable etiquetaVertice1, Comparable etiquetaVertice2) {
        TVertice v1 = buscarVertice(etiquetaVertice1);
        TVertice v2 = buscarVertice(etiquetaVertice2);
        if (v1 == null || v2 == null) {
            return false;
        }
        Set<Comparable> visitados = new HashSet<>();
        return bpfKruskal(v1, etiquetaVertice2, visitados);
    }

    @Override
    public Collection<TVertice> bea() {
        desvisitarVertices();
        Collection<TVertice> verticesVisitados = new LinkedList<>();
        for (TVertice vertice : getVertices().values()) {
            if (!vertice.getVisitado()) {
                verticesVisitados.addAll(vertice.bea());
            }
        }
        return verticesVisitados;
    }

    @Override
    public Collection<TVertice> beaDesdeVerticeInicial(Comparable etiquetaOrigen) {
        Collection<TVertice> verticesVisitados = new LinkedList<>();
        desvisitarVertices();
        TVertice verticeOrigen = getVertices().get(etiquetaOrigen);
        if (verticeOrigen != null) {
            verticesVisitados.addAll(verticeOrigen.bea());
        }
        return verticesVisitados;
    }

    @Override
    public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        desvisitarVertices();
        LinkedList<TVertice> puntosDeArticulacion = new LinkedList<>();
        int[] cont = new int[1];
        TVertice verticeOrigen = getVertices().get(etOrigen);
        if (verticeOrigen != null && !verticeOrigen.getVisitado()) {
            verticeOrigen.puntoDeArticulacion(puntosDeArticulacion, cont);
        }
        LinkedList<TVertice> puntosDeArticulacionSinRepetir = new LinkedList<>();
        for (TVertice vertice : puntosDeArticulacion) {
            if (!puntosDeArticulacionSinRepetir.contains(vertice)) {
                puntosDeArticulacionSinRepetir.add(vertice);
            }
        }
        return puntosDeArticulacionSinRepetir;
    }

    public LinkedList<TVertice> puntosArticulacion() {
        desvisitarVertices();
        LinkedList<TVertice> puntosDeArticulacion = new LinkedList<>();
        int[] cont = new int[1];
        for (TVertice vertice : getVertices().values()) {
            if (!vertice.getVisitado()) {
                vertice.puntoDeArticulacion(puntosDeArticulacion, cont);
            }
        }
        LinkedList<TVertice> puntosDeArticulacionSinRepetir = new LinkedList<>();
        for (TVertice vertice : puntosDeArticulacion) {
            if (!puntosDeArticulacionSinRepetir.contains(vertice)) {
                puntosDeArticulacionSinRepetir.add(vertice);
            }
        }
        return puntosDeArticulacionSinRepetir;
    }

    @Override
    public boolean esConexo() {
        if (getVertices().isEmpty()) {
            return true;
        }
        desvisitarVertices();
        TVertice verticeInicial = getVertices().values().iterator().next();
        Collection<TVertice> verticesVisitadosEnBea = verticeInicial.bea();
        for (TVertice vertice : getVertices().values()) {
            if (!vertice.getVisitado()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int numBacon(Comparable actor) {
        desvisitarVertices();
        TVertice kevinBacon = getVertices().get("Kevin_Bacon");
        if (kevinBacon != null) {
            return kevinBacon.numBacon(actor.toString());
        } else {
            return -1;
        }
    }
}
