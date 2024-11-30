public class CalculadoraFactorial {

    public static int factorial(int num) {
        if (num < 0) {
            System.out.println("Error: No se puede calcular el factorial de un negativo.");
            return -1;
        }
        if (num == 0) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 7;
        int factorialResult = factorial(number);
        if (factorialResult != -1) {
            System.out.println("El factorial de " + number + " es " + factorialResult);
        }
    }
}
