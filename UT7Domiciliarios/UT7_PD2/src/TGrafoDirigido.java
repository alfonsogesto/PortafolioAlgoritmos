
import java.util.*;

public class TGrafoDirigido implements IGrafoDirigido {

    private Map<Comparable, TVertice> vertices; // vertices del grafo.-

    private static final double INFINITO = Double.POSITIVE_INFINITY;
    public TGrafoDirigido(Collection<TVertice> vertices, Collection<TArista> aristas) {
        this.vertices = new HashMap<>();
        for (TVertice vertice : vertices) {
            insertarVertice(vertice.getEtiqueta());
        }
        for (TArista arista : aristas) {
            insertarArista(arista);
        }
    }

    /**
     * Metodo encargado de eliminar una arista dada por un origen y destino. En
     * caso de no existir la adyacencia, retorna falso. En caso de que las
     * etiquetas sean invalidas, retorna falso.
     *
     */
    public boolean eliminarArista(Comparable nomVerticeOrigen, Comparable nomVerticeDestino) {
        if ((nomVerticeOrigen != null) && (nomVerticeDestino != null)) {
            TVertice vertOrigen = buscarVertice(nomVerticeOrigen);
            if (vertOrigen != null) {
                return vertOrigen.eliminarAdyacencia(nomVerticeDestino);
            }
        }
        return false;
    }

    
    /**
     * Metodo encargado de verificar la existencia de una arista. Las etiquetas
     * pasadas por par�metro deben ser v�lidas.
     *
     * @return True si existe la adyacencia, false en caso contrario
     */
    public boolean existeArista(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TVertice vertOrigen = buscarVertice(etiquetaOrigen);
        TVertice vertDestino = buscarVertice(etiquetaDestino);
        if ((vertOrigen != null) && (vertDestino != null)) {
            return vertOrigen.buscarAdyacencia(vertDestino) != null;
        }
        return false;
    }

    /**
     * Metodo encargado de verificar la existencia de un vertice dentro del
     * grafo.-
     *
     * La etiqueta especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return True si existe el vertice con la etiqueta indicada, false en caso
     * contrario
     */
    public boolean existeVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta) != null;
    }

    /**
     * Metodo encargado de verificar buscar un vertice dentro del grafo.-
     *
     * La etiqueta especificada como parametro debe ser valida.
     *
     * @param unaEtiqueta Etiqueta del vertice a buscar.-
     * @return El vertice encontrado. En caso de no existir, retorna nulo.
     */
    private TVertice buscarVertice(Comparable unaEtiqueta) {
        return getVertices().get(unaEtiqueta);
    }

    /**
     * Metodo encargado de insertar una arista en el grafo (con un cierto
     * costo), dado su vertice origen y destino.- Para que la arista sea valida,
     * se deben cumplir los siguientes casos: 1) Las etiquetas pasadas por
     * parametros son v�lidas.- 2) Los vertices (origen y destino) existen
     * dentro del grafo.- 3) No es posible ingresar una arista ya existente
     * (miso origen y mismo destino, aunque el costo sea diferente).- 4) El
     * costo debe ser mayor que 0.
     *
     * @return True si se pudo insertar la adyacencia, false en caso contrario
     */
    public boolean insertarArista(TArista arista) {
        if ((arista.getEtiquetaOrigen() != null) && (arista.getEtiquetaDestino() != null)) {
            TVertice vertOrigen = buscarVertice(arista.getEtiquetaOrigen());
            TVertice vertDestino = buscarVertice(arista.getEtiquetaDestino());
            if ((vertOrigen != null) && (vertDestino != null)) {
                return vertOrigen.insertarAdyacencia(arista.getCosto(), vertDestino);
            }
        }
        return false;
    }

    /**
     * Metodo encargado de insertar un vertice en el grafo.
     *
     * No pueden ingresarse vertices con la misma etiqueta. La etiqueta
     * especificada como par�metro debe ser v�lida.
     *
     * @param unaEtiqueta Etiqueta del vertice a ingresar.
     * @return True si se pudo insertar el vertice, false en caso contrario
     */
    public boolean insertarVertice(Comparable unaEtiqueta) {
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            TVertice vert = new TVertice(unaEtiqueta);
            getVertices().put(unaEtiqueta, vert);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    @Override

    public boolean insertarVertice(TVertice vertice) {
        Comparable unaEtiqueta = vertice.getEtiqueta();
        if ((unaEtiqueta != null) && (!existeVertice(unaEtiqueta))) {
            getVertices().put(unaEtiqueta, vertice);
            return getVertices().containsKey(unaEtiqueta);
        }
        return false;
    }

    public Object[] getEtiquetasOrdenado() {
        TreeMap<Comparable, TVertice> mapOrdenado = new TreeMap<>(this.getVertices());
        return mapOrdenado.keySet().toArray();
    }

    /**
     * @return the vertices
     */
    public Map<Comparable, TVertice> getVertices() {
        return vertices;
    }

    @Override
    public Comparable centroDelGrafo() {
        /*
        Para obtener el centro de un grafo hacer:
        – aplicar Floyd para obtener el largo de los caminos,
        – encontrar el máximo valor en cada columna i, y con ello se obtiene la excentricidad de i,
        – encontrar el vértice con excentricidad mínima: el
        centro de G
         */
        //Inicializamos a la excentricidad minima con el valor máximo que puede tener un double, para asegurarnos que en la primera iteracción
        //la excentricidad calculada sea menor a ese valor.

        Comparable etiquetaVerticeCentro = null;
        double excentricidadMinima = Double.MAX_VALUE;

        for(Map.Entry<Comparable,Double> entry : obtenerExentricidadesGrafo().entrySet()) {
            if(excentricidadMinima > entry.getValue()) {
                excentricidadMinima = entry.getValue();
                etiquetaVerticeCentro = entry.getKey();
            }
        }
        return etiquetaVerticeCentro;
    }

    private Map<Comparable, Double> obtenerExentricidadesGrafo() {
        Map<Comparable,Double> resultado = new HashMap<>();
        Double[][] matrizFloyd = floyd();
        Comparable[] etiquetas = new Comparable[vertices.size()];
        int i = 0;
        for(Comparable clave : vertices.keySet()) {
            etiquetas[i] = clave;
            i++;
        }

        for(int col = 0; col < vertices.size(); col++) {
            Double maximoValorEnI = 0.0;
            for(int fil = 0; fil < vertices.size(); fil++) {
                if(maximoValorEnI < matrizFloyd[fil][col]) {
                    maximoValorEnI = matrizFloyd[fil][col];
                }
            }
            resultado.put(etiquetas[col], maximoValorEnI);
        }
        return resultado;
    }

    @Override
    public Double[][] floyd() {
        /*
         int n = vertices.size();
        Double[][] matrizCaminosMasCortos = new Double[n][n];

        //Almacenamos las claves de los vértices para así acceder a la clave i y j
        List<Comparable> etiquetasVertices = new ArrayList<>(vertices.keySet());

        //FORMAMOS LA MATRIZ
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) { //El vértice de origen y el vértice de destino son los mismos, por ende el camino tiene costo 0.
                   matrizCaminosMasCortos[i][j] = 0.0;
                } else{
                    //Obtenemos los costos de las aristas
                    TVertice verticeOrigen = vertices.get(etiquetasVertices.get(i));
                    TVertice verticeDestino = vertices.get(etiquetasVertices.get(j));
                    Double costoArista = verticeOrigen.obtenerCostoAdyacencia(verticeDestino);

                    //Existe una arista directa
                    if(costoArista != Double.MAX_VALUE) {
                        matrizCaminosMasCortos[i][j] = costoArista;
                    } else {
                        matrizCaminosMasCortos[i][j] = INFINITO;
                    }
                }
            }
        }
         */
        Double[][] matriz = UtilGrafos.obtenerMatrizCostos(vertices);

        //ALGORITMO DE FLOYD-WARSHALL

        for(int k = 0; k < vertices.size(); k++) {
            for(int i = 0; i < vertices.size(); i++) {
                for(int j = 0; j < vertices.size(); j++) {
                    if((matriz[i][k] + matriz[k][j]) < matriz[i][j]) {
                        matriz[i][j] = matriz[i][k] + matriz[k][j];
                    }
                }
            }
        }

        return matriz;
    }

    @Override
    public Comparable obtenerExcentricidad(Comparable etiquetaVertice) {
        return obtenerExentricidadesGrafo().get(etiquetaVertice);
    }

    @Override
    public boolean[][] warshall() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminarVertice(Comparable nombreVertice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
