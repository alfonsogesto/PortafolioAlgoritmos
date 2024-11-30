public class Potencia {
    public static int potencia(int x , int n) {
        if(n == 0) {
            return 1;
        } else {
            return x * potencia(x, n - 1);
        }
    }
}
