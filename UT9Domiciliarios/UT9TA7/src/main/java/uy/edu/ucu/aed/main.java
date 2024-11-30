package UT9TA7.src.main.java.uy.edu.ucu.aed;
import java.util.Arrays;

import static UT9TA7.src.main.java.uy.edu.ucu.aed.TClasificador.METODO_CLASIFICACION_BURBUJA;
import static UT9TA7.src.main.java.uy.edu.ucu.aed.TClasificador.METODO_CLASIFICACION_HEAPSORT;
import static UT9TA7.src.main.java.uy.edu.ucu.aed.TClasificador.METODO_CLASIFICACION_INSERCION;
import static UT9TA7.src.main.java.uy.edu.ucu.aed.TClasificador.METODO_CLASIFICACION_QUICKSORT;
import static UT9TA7.src.main.java.uy.edu.ucu.aed.TClasificador.METODO_CLASIFICACION_SHELL;

public class main {
    public static int[] vector = { 256, 458, 655, 298, 43, 648, 778, 621, 655, 19, 124, 847};
 
    public static void main(String args[]) {
      TClasificador clasif = new TClasificador();
      GeneradorDatosGenericos gdg = new GeneradorDatosGenericos();
      int[] vectorAleatorio = gdg.generarDatosAleatorios();
      int[] vectorAscendente = gdg.generarDatosAscendentes();
      int[] vectorDescendente = gdg.generarDatosDescendentes();
  
  //		int[] resAleatorio = clasif.clasificar(vectorAleatorio,
  //				METODO_CLASIFICACION_INSERCION);
  //		for (int i = 0; i < resAleatorio.length; i++) {
  //			System.out.print(resAleatorio[i] + " ");
  //		}
  //		int[] resAscendente = clasif.clasificar(vectorAscendente,
  //				METODO_CLASIFICACION_INSERCION);
  //		for (int i = 0; i < resAscendente.length; i++) {
  //			System.out.print(resAscendente[i] + " ");
  //		}
  //		int[] resDescendente = clasif.clasificar(vectorDescendente,
  //				METODO_CLASIFICACION_INSERCION);
  //		for (int i = 0; i < resDescendente.length; i++) {
  //			System.out.print(resDescendente[i] + " ");
  //		}
  
        System.out.println("Clasificación");

        System.out.println(clasif.estaOrdenado(vector));
        
        int[] clasificacion = clasif.clasificar(vector, METODO_CLASIFICACION_INSERCION);
        
        System.out.println(Arrays.toString(clasificacion));
        System.out.println(clasif.estaOrdenado(clasificacion));
        
        System.out.println("Shellsort");
        vector = new int[] { 256, 458, 655, 298, 43, 648, 778, 621, 655, 19, 124, 847};
        
        int[] shell = clasif.clasificar(vector, METODO_CLASIFICACION_SHELL);
        System.out.println(Arrays.toString(shell));
        System.out.println(clasif.estaOrdenado(shell));
        
        System.out.println("Burbuja");
        vector = new int[] { 256, 458, 655, 298, 43, 648, 778, 621, 655, 19, 124, 847};
        
        int[] burbuja = clasif.clasificar(vector, METODO_CLASIFICACION_BURBUJA);
        System.out.println(Arrays.toString(burbuja));
        System.out.println(clasif.estaOrdenado(burbuja));

        System.out.println("Quicksort");
        vector = new int[] { 256, 458, 655, 298, 43, 648, 778, 621, 655, 19, 124, 847};

        int[] quicksort = clasif.clasificar(vector, METODO_CLASIFICACION_QUICKSORT);
        System.out.println(Arrays.toString(quicksort));
        System.out.println(clasif.estaOrdenado(quicksort));


        System.out.println("HeapSort");


        int[] heapsort = clasif.clasificar(vector, METODO_CLASIFICACION_HEAPSORT);
        System.out.println(Arrays.toString(heapsort));
        System.out.println(clasif.estaOrdenado(heapsort));



        
      }
}








