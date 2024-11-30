public class Tablero {
    
    public static void main(String[] args) {
        imprimirTablero(7, 7);
    }

    public static void imprimirTablero(int largo, int ancho) {
        for (int i = 0; i < largo; i++) { 
            for (int j = 0; j < ancho; j++) { 
                if ((i + j) % 2 == 0) {
                    System.out.print("#");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
