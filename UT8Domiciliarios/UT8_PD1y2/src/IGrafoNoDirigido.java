
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public interface IGrafoNoDirigido {

    public Collection <TVertice> bea();
    
	public Collection <TVertice> beaDesdeVerticeInicial(Comparable etiquetaOrigen);
    
	public TGrafoNoDirigido Prim();

    public TGrafoNoDirigido Kruskal();
	
	public LinkedList<TVertice> puntosArticulacion(Comparable etOrigen);
    
	public boolean esConexo();
}
