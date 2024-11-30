import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Expresion {

    public boolean controlCorchetes(List<Character> listaDeEntrada) {
        Stack<Character> pila = new Stack<>();

        for (char c : listaDeEntrada) {
            if (c == '{') {
                pila.push(c);
            } else if (c == '}') {
                if (pila.isEmpty()) {
                    return false;
                }
                pila.pop();
            }
        }

        return pila.isEmpty();
    }

    public static void main(String[] args) {
        Expresion exp = new Expresion();
        String[] lineas = ManejadorArchivosGenerico.leerArchivo("entradas.txt");

        for (String linea : lineas) {
            List<Character> secuencia = new ArrayList<>();
            for (char c : linea.toCharArray()) {
                secuencia.add(c);
            }
            boolean esCorrecta = exp.controlCorchetes(secuencia);
            System.out.println("La secuencia: " + linea + " -> " + (esCorrecta ? "True / Correcta" : "False / Incorrecta"));  
        }
    }
}
