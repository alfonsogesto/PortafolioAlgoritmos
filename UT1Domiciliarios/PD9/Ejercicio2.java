public class Ejercicio2 {
    public static void main(String[] args) {
        int n = 10;
        int base = 2;
        int par = 2;
        int imp = 1;
        int sum = 0;
        double raiz = Math.sqrt(n);
        boolean isPrime = true;

        while(base <= raiz) {
            while(n % base == 0) {
                isPrime = false;
                break;
            }
            base += 1;
        }

        System.out.println("es primo? " + isPrime);
        while(isPrime && par <= n) {
            sum += par;
            par += 2;
        }
        while(!isPrime && imp <= n) {
            sum += imp;
            imp += 2;
        }

        System.out.println("La suma es " + sum);
    }
}
