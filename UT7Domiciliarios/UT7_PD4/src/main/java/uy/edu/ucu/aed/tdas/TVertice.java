package uy.edu.ucu.aed.tdas;

import java.util.*;

class TVertice {
    private Comparable etiqueta;
    private boolean visitado;
    private List<TAdyacencia> adyacentes = new LinkedList<>();

    public TVertice(Comparable etiqueta) {
        this.etiqueta = etiqueta;
        this.visitado = false;
    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    public boolean getVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public List<TAdyacencia> getAdyacentes() {
        return adyacentes;
    }

    public void agregarAdyacencia(TAdyacencia adyacencia) {
        adyacentes.add(adyacencia);
    }

    public void todosLosCaminos(Comparable etVertDest, TCamino caminoPrevio, TCaminos todosLosCaminos) {
        this.setVisitado(true);
        for (TAdyacencia adyacencia : this.getAdyacentes()) {
            TVertice destino = adyacencia.getDestino();
            if (!destino.getVisitado()) {
                TCamino copia = caminoPrevio.copiar();
                copia.agregarAdyacencia(adyacencia);
                if (destino.getEtiqueta().compareTo(etVertDest) == 0) {
                    todosLosCaminos.getCaminos().add(copia);
                } else {
                    destino.todosLosCaminos(etVertDest, copia, todosLosCaminos);
                }
            }
        }
        this.setVisitado(false);
    }
}

class TAdyacencia {
    private TVertice destino;
    private double costo;

    public TAdyacencia(TVertice destino, double costo) {
        this.destino = destino;
        this.costo = costo;
    }

    public TVertice getDestino() {
        return destino;
    }

    public double getCosto() {
        return costo;
    }
}

class TCamino {
    private List<TAdyacencia> adyacencias = new LinkedList<>();
    private double costoTotal;

    public TCamino(TVertice origen) {
        costoTotal = 0;
    }

    public void agregarAdyacencia(TAdyacencia adyacencia) {
        adyacencias.add(adyacencia);
        costoTotal += adyacencia.getCosto();
    }

    public TCamino copiar() {
        TCamino copia = new TCamino(null);
        copia.adyacencias.addAll(this.adyacencias);
        copia.costoTotal = this.costoTotal;
        return copia;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TAdyacencia adyacencia : adyacencias) {
            sb.append(adyacencia.getDestino().getEtiqueta()).append(" -> ");
        }
        sb.append("Costo: ").append(costoTotal);
        return sb.toString();
    }
}

class TCaminos {
    private List<TCamino> caminos = new LinkedList<>();

    public List<TCamino> getCaminos() {
        return caminos;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (TCamino camino : caminos) {
            sb.append(camino).append("\n");
        }
        return sb.toString();
    }
}

class TGrafoDirigido {
    private Map<Comparable, TVertice> vertices = new HashMap<>();

    public void agregarVertice(TVertice vertice) {
        vertices.put(vertice.getEtiqueta(), vertice);
    }

    public void agregarAdyacencia(Comparable origen, Comparable destino, double costo) {
        TVertice vOrigen = vertices.get(origen);
        TVertice vDestino = vertices.get(destino);
        if (vOrigen != null && vDestino != null) {
            vOrigen.agregarAdyacencia(new TAdyacencia(vDestino, costo));
        }
    }

    public TVertice buscarVertice(Comparable etiqueta) {
        return vertices.get(etiqueta);
    }

    public TCaminos todosLosCaminos(Comparable etiquetaOrigen, Comparable etiquetaDestino) {
        TCaminos todosLosCaminos = new TCaminos();
        TVertice origen = buscarVertice(etiquetaOrigen);
        if (origen != null) {
            TCamino caminoPrevio = new TCamino(origen);
            origen.todosLosCaminos(etiquetaDestino, caminoPrevio, todosLosCaminos);
        }
        return todosLosCaminos;
    }
}