public class Main {
    public static void main(String[] args) {
        TArbolGenerico<String> arbol = new TArbolGenerico<>();
        TNodoGenerico<String> nodo1 = new TNodoGenerico<>("Rectoría", null);
        TNodoGenerico<String> nodo2 = new TNodoGenerico<>("Vicerrectoría del medio universitario",null);
        TNodoGenerico<String> nodo3 = new TNodoGenerico<>("Vicerrectoría académica", null);
        TNodoGenerico<String> nodo4 = new TNodoGenerico<>("Vicerrectoría administrativa", null);
        TNodoGenerico<String> nodo5 = new TNodoGenerico<>("Facultad de ciencias empresariales", null);
        TNodoGenerico<String> nodo6 = new TNodoGenerico<>("Facultad de ciencias humanas", null);
        TNodoGenerico<String> nodo7 = new TNodoGenerico<>("Facultad de ingeniería y tecnologías", null);
        TNodoGenerico<String> nodo8 = new TNodoGenerico<>("Facultad de psicología", null);
        TNodoGenerico<String> nodo9 = new TNodoGenerico<>("Departamento de informática y ciencias de la computación", null);
        TNodoGenerico<String> nodo10 = new TNodoGenerico<>("Departamento de ingeniería eléctrica", null);
        TNodoGenerico<String> nodo11 = new TNodoGenerico<>("Departamento de matemáticas", null);
        arbol.insertar(nodo1.getEtiqueta(), "");
        arbol.insertar(nodo2.getEtiqueta(),nodo1.getEtiqueta());
        arbol.insertar(nodo3.getEtiqueta(),nodo1.getEtiqueta());
        arbol.insertar(nodo4.getEtiqueta(),nodo1.getEtiqueta());
        arbol.insertar(nodo5.getEtiqueta(),nodo3.getEtiqueta());
        arbol.insertar(nodo6.getEtiqueta(),nodo3.getEtiqueta());
        arbol.insertar(nodo7.getEtiqueta(),nodo3.getEtiqueta());
        arbol.insertar(nodo8.getEtiqueta(),nodo3.getEtiqueta());
        arbol.insertar(nodo9.getEtiqueta(),nodo7.getEtiqueta());
        arbol.insertar(nodo10.getEtiqueta(),nodo7.getEtiqueta());
        arbol.insertar(nodo11.getEtiqueta(),nodo7.getEtiqueta());

        TNodoGenerico<String> elementoBuscado0 = arbol.buscar("pepito");
        TNodoGenerico<String> elementoBuscado1 = arbol.buscar("Rectoría");
        TNodoGenerico<String> elementoBuscado2 = arbol.buscar("Facultad de cohetes espaciales");
        TNodoGenerico<String> elementoBuscado3 = arbol.buscar("Facultad de ingeniería y tecnologías");

        if(elementoBuscado0 != null) {
            System.out.println("El elemento " +  elementoBuscado0.getEtiqueta() + " " + "Existe en el árbol");
        } else {
            System.out.println("No existe en el árbol");
        }
        if(elementoBuscado1 != null) {
            System.out.println("El elemento " +  elementoBuscado1.getEtiqueta() + " " + "Existe en el árbol");
        } else {
            System.out.println("No existe en el árbol");
        }
        if(elementoBuscado2 != null) {
            System.out.println("El elemento " +  elementoBuscado2.getEtiqueta() +  " " + "Existe en el árbol");
        } else {
            System.out.println("No existe en el árbol");
        }
        if(elementoBuscado3 != null) {
            System.out.println("El elemento " +  elementoBuscado3.getEtiqueta() +   " " + "Existe en el árbol");
        } else {
            System.out.println("No existe en el árbol");
        }
    }
}