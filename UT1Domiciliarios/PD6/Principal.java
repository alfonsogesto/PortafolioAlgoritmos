import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Principal {
    public static void main(String[] args) {
        leerEntradaArchivo("entrada.txt");
        leerEntradaStdin();
    }

    public static void leerEntradaArchivo(String rutaArchivo) {
        try {
            File archivo = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivo);

            int entero = scanner.nextInt();
            double flotante = scanner.nextDouble();
            String cadena = scanner.next();

            System.out.println("El entero leído es: " + entero);
            System.out.println("El número de punto flotante es: " + flotante);
            System.out.println("La cadena leída es \"" + cadena + "\"");
            System.out.println("¡Hola " + cadena + "! La suma de " + entero + " y " + flotante + " es " + (entero + flotante) + ".");
            System.out.println("La división entera de " + flotante + " y " + entero + " es " + (int)(flotante / entero) + " y su resto es " + (flotante % entero) + ".");

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no fue encontrado: " + rutaArchivo);
            e.printStackTrace();
        }
        
    }
    public static void leerEntradaStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el radio de la circunferencia: ");
        double radio = scanner.nextDouble();

        double area = Math.PI * Math.pow(radio, 2);
        double perimetro = 2 * Math.PI * radio;

        System.out.println("El área de la circunferencia es: " + area);
        System.out.println("El perímetro de la circunferencia es: " + perimetro);
        
        scanner.close();
    }

}
