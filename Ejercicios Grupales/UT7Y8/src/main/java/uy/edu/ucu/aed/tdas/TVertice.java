package uy.edu.ucu.aed.tdas;

import java.util.Collection;
import java.util.LinkedList;

public class TVertice<T> implements IVertice {

    private Comparable etiqueta;
    private LinkedList<IAdyacencia> adyacentes;
    private boolean visitado;
    private T datos;

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    @Override
    public LinkedList<IAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public T getDatos() {
        return datos;
    }

    public TVertice(Comparable unaEtiqueta) {
        this.etiqueta = unaEtiqueta;
        adyacentes = new LinkedList();
        visitado = false;
    }

    public void setVisitado(boolean valor) {
        this.visitado = valor;
    }

    public boolean getVisitado() {
        return this.visitado;
    }

    @Override
    public IAdyacencia buscarAdyacencia(IVertice verticeDestino) {
        if (verticeDestino != null) {
            return buscarAdyacencia(verticeDestino.getEtiqueta());
        }
        return null;
    }

    @Override
    public Double obtenerCostoAdyacencia(IVertice verticeDestino) {
        IAdyacencia ady = buscarAdyacencia(verticeDestino);
        if (ady != null) {
            return ady.getCosto();
        }
        return Double.MAX_VALUE;
    }

    @Override
    public boolean insertarAdyacencia(Double costo, IVertice verticeDestino) {
        if (buscarAdyacencia(verticeDestino) == null) {
            TAdyacencia ady = new TAdyacencia(costo, verticeDestino);
            return adyacentes.add(ady);
        }
        return false;
    }

    @Override
    public boolean eliminarAdyacencia(Comparable nomVerticeDestino) {
        IAdyacencia ady = buscarAdyacencia(nomVerticeDestino);
        if (ady != null) {
            adyacentes.remove(ady);
            return true;
        }
        return false;
    }

    @Override
    public IVertice primerAdyacente() {
        if (this.adyacentes.getFirst() != null) {
            return this.adyacentes.getFirst().getDestino();
        }
        return null;
    }

    @Override
    public IAdyacencia buscarAdyacencia(Comparable etiquetaDestino) {
        for (IAdyacencia adyacencia : adyacentes) {
            if (adyacencia.getDestino().getEtiqueta().compareTo(etiquetaDestino) == 0) {
                return adyacencia;
            }
        }
        return null;
    }

    @Override
    public void bpf(Collection<TVertice> visitados) {
        setVisitado(true);
        visitados.add(this);
        for (IAdyacencia adyacente : adyacentes) {
        IVertice vertAdy = adyacente.getDestino();
            if (!vertAdy.getVisitado()) {
                vertAdy.bpf(visitados);
            }
        }
    }

    @Override
    public TCaminos todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (IAdyacencia adyacencia : this.getAdyacentes()) {
            IVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    TCamino copia = caminoPrevio.copiar();
                    copia.agregarAdyacencia((TAdyacencia)adyacencia);
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    caminoPrevio.agregarAdyacencia((TAdyacencia)adyacencia);
                    destino.todosLosCaminos(etVertDest, caminoPrevio, todosLosCaminos);
                    caminoPrevio.eliminarAdyacencia((TAdyacencia)adyacencia);
                }
            }
        }
        this.setVisitado(false);
        return todosLosCaminos;
    }

    @Override
    public void bea(Collection<TVertice> visitados) {
        this.visitado = true;
        LinkedList<TVertice> lista = new LinkedList();
        lista.add(this);
        visitados.add(this);
        while(!lista.isEmpty()){
            TVertice primero = lista.remove(0);
            LinkedList<TAdyacencia> ady = primero.getAdyacentes();
            for(TAdyacencia t : ady){
                if(!t.getDestino().getVisitado()){
                    t.getDestino().setVisitado(true);
                    lista.add((TVertice)t.getDestino());
                    visitados.add((TVertice)t.getDestino());
                }
            }
        }
    }

    @Override
    public TVertice siguienteAdyacente(TVertice w) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

 
    @Override
    public boolean tieneCiclo(LinkedList<Comparable> camino) {
        setVisitado(true);
        camino.add(this.getEtiqueta());
        boolean ciclo = false;
        for (IAdyacencia adyacencia : this.getAdyacentes()) {
            IVertice w = adyacencia.getDestino();
            if (!w.getVisitado()) {
                ciclo = w.tieneCiclo(camino);
                if (ciclo) {
                    break;
                }
            } else {
                if (camino.contains(w.getEtiqueta())) {
                    ciclo = true;
                    break;
                }

            }

        }
        camino.remove(this.getEtiqueta());
        return ciclo;
    }


    @Override
    public boolean conectadoCon(TVertice etVertDest) {
        this.setVisitado(true);
        for (IAdyacencia adyacencia : this.getAdyacentes()) {
            IVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {                    
                    return true;
                } else {                    
                    boolean existe =  destino.conectadoCon(etVertDest);
                    if (existe){
                       return existe;
                    }
                }                
            }
        }
        this.setVisitado(false);
        return false;
    }

}
