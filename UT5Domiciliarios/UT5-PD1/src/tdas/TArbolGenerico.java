package UT5_PD1.src.tdas;

public class TArbolGenerico<T> implements IArbolGenerico<T>{
    TNodoGenerico<T> raiz;
    public TArbolGenerico() {
        this.raiz = null;
    }
    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if(etiquetaPadre.equals("")) {
            if(raiz == null) {
                raiz = new TNodoGenerico<>(unaEtiqueta, null); 
                return true;
            } else {
                return false;
            }
        } else {
            if(raiz != null) {
                return raiz.insertar(unaEtiqueta, etiquetaPadre);
            } else {
                return false;
            }
        }
    }

    @Override
    public TNodoGenerico<T> buscar(Comparable unaEtiqueta) {
        if(raiz != null) {
            return raiz.buscar(unaEtiqueta);
        }
        return null;
    }

    @Override
    public void eliminar(Comparable unaEtiqueta) {

    }

    @Override
    public T getDatos() {
        return raiz.getDatos();
    }

    @Override
    public void listarIdentado() {
       if(raiz == null) {
           System.out.println("Arbol vacío");
       } else {
           raiz.listarIdentado();
       }
    }
}