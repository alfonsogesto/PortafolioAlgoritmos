import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void leerNumeros(String rutaArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));
            String lineaActual = br.readLine();
            int N = Integer.parseInt(lineaActual);
            int[] archivoArray = new int[N];
            
            for (int i = 0; i < N; i++) {
                archivoArray[i] = Integer.parseInt(br.readLine());
            }
            
            int contadorSi = 0;
            
            for (int i = 1; i < N; i++) {
                for (int j = N - 1; j >= i; j--) {
                    if (archivoArray[j] < archivoArray[j - 1]) {
                        contadorSi++;
                        int temp = archivoArray[j];
                        archivoArray[j] = archivoArray[j - 1];
                        archivoArray[j - 1] = temp;
                    }
                }
            }
            
            System.out.println("Longitud de N: " + N);
            System.out.println("Se invocó a la sentencia 'si' " + contadorSi + " veces");
            System.out.println("Primer elemento del arreglo ordenado: " + archivoArray[0]);
            System.out.println("Último elemento del arreglo ordenado: " + archivoArray[N - 1]);
            
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        leerNumeros("numeros.txt");
    }
}
