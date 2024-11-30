public class SumaLinea {
    public static int sumaLinea(int[] A , int n) {
        if(n == 1) {
            return A[0];
        } else {
            return sumaLinea(A, n - 1) + A[n - 1];
        }
    }
}
