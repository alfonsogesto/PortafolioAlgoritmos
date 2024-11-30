import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        String[] ar1 = {"Hola", "mundo", "de", "los", "algoritmos"};
        String[] ar2 = {"Hola", "mundo", "de", "la", "informática"};

        ContadorPalabras contadorPalabras = new ContadorPalabras();
        String[] palabrasComunes = contadorPalabras.palabrasComunes(ar1, ar2);
        
        System.out.println("Las palabras que se repiten en ambos son: ");
        System.out.println(Arrays.toString(palabrasComunes));
    }
}
