import java.util.Scanner;

public class PrincipalArea {

    public static void leerEntradaStdin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el radio de la circunferencia: ");
        double radio = scanner.nextDouble();

        // Calculamos área y perímetro
        double area = Math.PI * Math.pow(radio, 2);
        double perimetro = 2 * Math.PI * radio;

        // Mostramos los resultados
        System.out.println("El área de la circunferencia es: " + area);
        System.out.println("El perímetro de la circunferencia es: " + perimetro);
        
        scanner.close();
    }

    public static void main(String[] args) {
        leerEntradaStdin();
    }
}
