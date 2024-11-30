public class InvertirArray {
    public static int[] invertirArray(int[] A, int i , int j) {
        if(i < 0 || j < 0) {
            return A;
        }
        if(i < j) {
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
        return invertirArray(A, i + 1, j - 1);
    }
}
