public class Main {
    public static void main(String[] args) {
        IConjunto<Integer> conjunto1 = new Conjunto<>();
        IConjunto<Integer> conjunto2 = new Conjunto<>();

        conjunto1.insertar(1, 1);
        conjunto1.insertar(2, 2);
        conjunto1.insertar(3, 3);

        conjunto2.insertar(3, 3);
        conjunto2.insertar(4, 4);
        conjunto2.insertar(5, 5);

        IConjunto<Integer> unionConjuntos = conjunto1.union(conjunto2);
        System.out.println("Union del Conjunto 1 y Conjunto 2:");
        System.out.println(unionConjuntos.imprimir());

        IConjunto<Integer> interseccionConjuntos = conjunto1.interseccion(conjunto2);
        System.out.println("Interseccion del Conjunto 1 y Conjunto 2:");
        System.out.println(interseccionConjuntos.imprimir());
    }
}