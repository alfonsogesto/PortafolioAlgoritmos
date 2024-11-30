
import java.lang.reflect.Array;
import java.util.*;

public class TGrafoNoDirigido extends TGrafoDirigido implements IGrafoNoDirigido {

    protected TAristas lasAristas = new TAristas();

    /**
     *
     * @param vertices
     * @param aristas
     */
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
        TGrafoNoDirigido grafoMenorCosto = new TGrafoNoDirigido(v,conjuntoAristas);
        return grafoMenorCosto;
    }
    public LinkedList<TArista> PrimAuxiliar() {
        Set<TVertice> V = new HashSet<>(this.getVertices().values());
        LinkedList<TArista> T = new LinkedList<>();
        Set<TVertice> U = new HashSet<>();
        for(TVertice v : getVertices().values()) {
            U.add(v);
            break;
        }
        while(U.size() != V.size()) {
            double menorCosto = Double.MAX_VALUE;
            TArista aristaDeMenorCosto = null;
            LinkedList<TArista> todasLasaristasDelGrafo = this.getLasAristas();
            for(TArista a : todasLasaristasDelGrafo) {
                Set<TVertice> diferencia = new HashSet<>(V);
                diferencia.removeAll(U);
                TVertice origen = buscarVertice(a.etiquetaOrigen);
                TVertice destino = buscarVertice(a.etiquetaDestino);
                if(U.contains(origen) && diferencia.contains(destino) && a.getCosto() < menorCosto && !T.contains(a)) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public Collection<TVertice> bea() {
        return List.of();
    }

    @Override
    public Collection<TVertice> bea(Comparable etiquetaOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	 
	@Override
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
	@Override
    public boolean esConexo(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
