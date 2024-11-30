package UT9TA7.src.main.java.uy.edu.ucu.aed;

import java.util.Arrays;

public class TClasificador {

    public static final int METODO_CLASIFICACION_INSERCION = 1;
    public static final int METODO_CLASIFICACION_SHELL = 2;
    public static final int METODO_CLASIFICACION_BURBUJA = 3;
    public static final int METODO_CLASIFICACION_QUICKSORT = 4;
    public static final int METODO_CLASIFICACION_HEAPSORT = 5;
    public static final int METODO_CLASIFICACION_CUENTA = 6;


    /**
     * Punto de entrada al clasificador
     *
     * @param metodoClasificacion
     * @param orden
     * @param tamanioVector
     * @return Un vector del tam. solicitado, ordenado por el algoritmo
     * solicitado
     */
    public int[] clasificar(int[] datosParaClasificar, int metodoClasificacion) {
        switch (metodoClasificacion) {
            case METODO_CLASIFICACION_INSERCION:
                return ordenarPorInsercion(datosParaClasificar);
            case METODO_CLASIFICACION_SHELL:
                return ordenarPorShell(datosParaClasificar);
            case METODO_CLASIFICACION_BURBUJA:
                return ordenarPorBurbuja(datosParaClasificar);
            case METODO_CLASIFICACION_QUICKSORT:
                return ordenarPorQuickSort(datosParaClasificar);
            case METODO_CLASIFICACION_HEAPSORT:
				return ordenarPorHeapSort(datosParaClasificar);
            case METODO_CLASIFICACION_CUENTA:
                return ordenarPorCuentaDistribucion(datosParaClasificar);
            default:
                System.err.println("Este codigo no deberia haberse ejecutado");
                break;
            }
            return datosParaClasificar;

        }
    

    private void intercambiar(int[] vector, int pos1, int pos2) {
        int temp = vector[pos2];
        vector[pos2] = vector[pos1];
        vector[pos1] = temp;
    }

    
    
    /**
     * @param datosParaClasificar
     * @return
     */
    private int[] ordenarPorShell(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};

        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    while (j >= 0) {
                        if (datosParaClasificar[j] > datosParaClasificar[j + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                        }
                        j -= inc;
                    }
                }
            }

            // No se por que no imprime como deberia
            // for (int i = 0; i < datosParaClasificar.length; i++) {
            //     if (i == 0) {
            //         System.out.print("[" + " " + datosParaClasificar[i] + "," + " ");
            //     }
            //     if (i == datosParaClasificar.length) {
            //         System.out.println(datosParaClasificar[i] + " " + "]");
            //         System.out.println("   ");
            //     }
            //     if ((i != 0) && (i != datosParaClasificar.length)){
            //         System.out.print(datosParaClasificar[i] + "," + " ");
            //     }
                
            // }
        }
        return datosParaClasificar;
    }

    // Hay que implementarlo en el metodo Clasificar
    private int[] ordenarPorShellDescendente(int[] datosParaClasificar) {
        int j, inc;
        int[] incrementos = new int[]{3223, 358, 51, 10, 3, 1};
    
        for (int posIncrementoActual = 0; posIncrementoActual < incrementos.length; posIncrementoActual++) {
            inc = incrementos[posIncrementoActual];
            if (inc < (datosParaClasificar.length / 2)) {
                for (int i = inc; i < datosParaClasificar.length; i++) {
                    j = i - inc;
                    while (j >= 0) {
                        if (datosParaClasificar[j] < datosParaClasificar[j + inc]) {
                            intercambiar(datosParaClasificar, j, j + inc);
                        }
                        j -= inc;
                    }
                }
            }
        }
        return datosParaClasificar;
    }
    
    /**
     * @param datosParaClasificar
     * @return
     */
    protected int[] ordenarPorInsercion(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j + 1] < datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j + 1, j);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }

    // Hay que implementarlo en el metodo Clasificar
    protected int[] ordenarPorInsercionDescendente(int[] datosParaClasificar) {
        if (datosParaClasificar != null) {
            for (int i = 1; i < datosParaClasificar.length; i++) {
                int j = i - 1;
                while ((j >= 0) && (datosParaClasificar[j + 1] > datosParaClasificar[j])) {
                    intercambiar(datosParaClasificar, j + 1, j);
                    j--;
                }
            }
            return datosParaClasificar;
        }
        return null;
    }
    

    private int[] ordenarPorBurbuja(int[] datosParaClasificar) {
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] < datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }

    // Hay que implementarlo en el metodo Clasificar
    private int[] ordenarPorBurbujaDescendente(int[] datosParaClasificar) {
        int n = datosParaClasificar.length - 1;
        for (int i = 0; i <= n; i++) {
            for (int j = n; j >= (i + 1); j--) {
                if (datosParaClasificar[j] > datosParaClasificar[j - 1]) {
                    intercambiar(datosParaClasificar, j - 1, j);
                }
            }
        }
        return datosParaClasificar;
    }
    

    public boolean estaOrdenado(int[] vector) {
        for (int i = 0; i < (vector.length - 1); i++) {
            if (vector[i] > vector[i + 1]) {
                return false;
            }
        }
        return true;
    }

    protected int[] ordenarPorQuickSort(int[] datosParaClasificar) {
		quicksort(datosParaClasificar, 0, datosParaClasificar.length - 1);
		return datosParaClasificar;
	}

	private void quicksort(int[] entrada, int i, int j) {
		int izquierda = i;
		int derecha = j;

		int posicionPivote = encuentraPivote(izquierda, derecha, entrada);
		if (posicionPivote >= 0) {
			int pivote = entrada[posicionPivote];
			while (izquierda <= derecha) {
				while ((entrada[izquierda] < pivote) && (izquierda < j)) {
					izquierda++;
				}

				while ((pivote <= entrada[derecha]) && (derecha > i)) {
					derecha--;
				}

				if (izquierda <= derecha) {
					intercambiar(entrada, izquierda, derecha);
					izquierda++;
					derecha--;
				}
			}
		}

		if (i < derecha)
			quicksort(entrada, i, derecha);
		if (izquierda < j)
			quicksort(entrada, izquierda, j);
	}

	private int encuentraPivote(int izquierda, int derecha, int[] entrada) {
		int pivote = -1;
		if (entrada[izquierda] > entrada[izquierda + 1]) {
			pivote = izquierda;
		} else {
			pivote = izquierda + 1;
		}
		return pivote;
	}

    // Hay que implementarlo en el metodo Clasificar
    protected int[] ordenarPorQuickSortDescendente(int[] datosParaClasificar) {
        quicksortDescendente(datosParaClasificar, 0, datosParaClasificar.length - 1);
        return datosParaClasificar;
    }
    
    private void quicksortDescendente(int[] entrada, int i, int j) {
        int izquierda = i;
        int derecha = j;
    
        int posicionPivote = encuentraPivoteDescendente(izquierda, derecha, entrada);
        if (posicionPivote >= 0) {
            int pivote = entrada[posicionPivote];
            while (izquierda <= derecha) {
                // Cambiar las condiciones para orden descendente
                while ((entrada[izquierda] > pivote) && (izquierda < j)) {
                    izquierda++;
                }
    
                while ((pivote >= entrada[derecha]) && (derecha > i)) {
                    derecha--;
                }
    
                if (izquierda <= derecha) {
                    intercambiar(entrada, izquierda, derecha);
                    izquierda++;
                    derecha--;
                }
            }
        }
    
        // Aplicar recursión a las sublistas
        if (i < derecha)
            quicksortDescendente(entrada, i, derecha);
        if (izquierda < j)
            quicksortDescendente(entrada, izquierda, j);
    }
    
    private int encuentraPivoteDescendente(int izquierda, int derecha, int[] entrada) {
        int pivote = -1;
        // Ajustar para encontrar un pivote en función del orden descendente
        if (entrada[izquierda] < entrada[izquierda + 1]) {
            pivote = izquierda;
        } else {
            pivote = izquierda + 1;
        }
        return pivote;
    }
    

    protected int[] ordenarPorHeapSort(int[] datosParaClasificar) {
		for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { 
			armaHeap(datosParaClasificar, i, datosParaClasificar.length - 1);
		}
		for (int i = datosParaClasificar.length - 1; i >= 1; i--) { 
			intercambiar(datosParaClasificar, 0, i);
			armaHeap(datosParaClasificar, 0, i - 1);
		}
		return datosParaClasificar;
	}

	private void armaHeap(int[] datosParaClasificar, int primero, int ultimo) {
		if (primero < ultimo) {
			int r = primero;
			while (r <= ultimo / 2) {
				if (ultimo == 2 * r) { 
					if (datosParaClasificar[r] < datosParaClasificar[r * 2]) {
						intercambiar(datosParaClasificar, r, 2 * r); 					}
					r = ultimo;
				} else { 
					int posicionIntercambio = 0;
					if (datosParaClasificar[2 * r] < datosParaClasificar[2 * r + 1]) {
						posicionIntercambio = 2 * r + 1;
					} else {
						posicionIntercambio = 2 * r;
					}
					if (datosParaClasificar[r] < datosParaClasificar[posicionIntercambio]) {
						intercambiar(datosParaClasificar, r, posicionIntercambio);
						r = posicionIntercambio;
					} else {
						r = ultimo;
					}
				}
			}
		}
    }

    // Hay que implementarlo en el metodo Clasificar
    protected int[] ordenarPorHeapSortDescendente(int[] datosParaClasificar) {
        // Construir el heap inicial (min-heap para orden descendente)
        for (int i = (datosParaClasificar.length - 1) / 2; i >= 0; i--) { 
            armaHeapDescendente(datosParaClasificar, i, datosParaClasificar.length - 1);
        }
        // Extraer elementos uno por uno y reajustar el heap
        for (int i = datosParaClasificar.length - 1; i >= 1; i--) { 
            intercambiar(datosParaClasificar, 0, i);
            armaHeapDescendente(datosParaClasificar, 0, i - 1);
        }
        return datosParaClasificar;
    }
    
    private void armaHeapDescendente(int[] datosParaClasificar, int primero, int ultimo) {
        if (primero < ultimo) {
            int r = primero;
            while (r <= ultimo / 2) {
                if (ultimo == 2 * r) { 
                    // Si solo hay un hijo, comparar con él
                    if (datosParaClasificar[r] > datosParaClasificar[r * 2]) {
                        intercambiar(datosParaClasificar, r, 2 * r);
                    }
                    r = ultimo;
                } else { 
                    // Si hay dos hijos, encontrar el menor
                    int posicionIntercambio = 0;
                    if (datosParaClasificar[2 * r] > datosParaClasificar[2 * r + 1]) {
                        posicionIntercambio = 2 * r + 1;
                    } else {
                        posicionIntercambio = 2 * r;
                    }
                    // Comparar con el menor hijo
                    if (datosParaClasificar[r] > datosParaClasificar[posicionIntercambio]) {
                        intercambiar(datosParaClasificar, r, posicionIntercambio);
                        r = posicionIntercambio;
                    } else {
                        r = ultimo;
                    }
                }
            }
        }
    }
    
    private int[] ordenarPorCuentaDistribucion(int[] datosParaClasificar) {
        int u = Arrays.stream(datosParaClasificar).min().orElse(0);
        int v = Arrays.stream(datosParaClasificar).max().orElse(0);
        int[] Cuenta = new int[v - u + 1];
        int[] S = new int[datosParaClasificar.length];

        // Inicializar arreglo Cuenta
        for (int i = u; i <= v; i++) {
            Cuenta[i - u] = 0;
        }

        // Contar ocurrencias de cada clave en datosParaClasificar
        for (int j = 0; j < datosParaClasificar.length; j++) {
            Cuenta[datosParaClasificar[j] - u]++;
        }

        // Modificar arreglo Cuenta para acumulación
        for (int i = 1; i < Cuenta.length; i++) {
            Cuenta[i] += Cuenta[i - 1];
        }

        // Construir arreglo de salida
        for (int j = datosParaClasificar.length - 1; j >= 0; j--) {
            int key = datosParaClasificar[j];
            int i = Cuenta[key - u] - 1;
            S[i] = key;
            Cuenta[key - u]--;
        }

        return S;
    }

    // Hay que implementarlo en el metodo Clasificar
    private int[] ordenarPorCuentaDistribucionDescendente(int[] datosParaClasificar) {
        int u = Arrays.stream(datosParaClasificar).min().orElse(0);
        int v = Arrays.stream(datosParaClasificar).max().orElse(0);
        int[] Cuenta = new int[v - u + 1];
        int[] S = new int[datosParaClasificar.length];
    
        // Inicializar arreglo Cuenta
        for (int i = u; i <= v; i++) {
            Cuenta[i - u] = 0;
        }
    
        // Contar ocurrencias de cada clave en datosParaClasificar
        for (int j = 0; j < datosParaClasificar.length; j++) {
            Cuenta[datosParaClasificar[j] - u]++;
        }
    
        // Modificar arreglo Cuenta para acumulación descendente
        for (int i = Cuenta.length - 2; i >= 0; i--) {
            Cuenta[i] += Cuenta[i + 1];
        }
    
        // Construir arreglo de salida en orden descendente
        for (int j = 0; j < datosParaClasificar.length; j++) {
            int key = datosParaClasificar[j];
            int i = Cuenta[key - u] - 1;
            S[i] = key;
            Cuenta[key - u]--;
        }
    
        return S;
    }


    /* LOS SIGUIENTES METODOS SON LOS DE RADIX Y BINSORT. AMOS ESTAN HECHOS CON "STATIC VOID" POR LO QUE PARA UTILIZARLOS EN EL MAIN
     * NO HAY QUE INSTANCIAR LA CLASE SINO QUE SIMPLEMENTE TENEMOS QUE HACER: TClasificador.<EL_METODO>
     * 
     * PARA LOS METODOS QUE ESTAN ARRIBA, SI HAY QUE CREAR UNA INSTANCIA: TClasificador clasi = new TClasificador() PARA DESPUES PODER 
     * UTILIZAR LOS METODOS
     */
    
        /**
     * Método para realizar la Ordenación Radix (Radix Sort) sobre un arreglo de enteros.
     * 
     * @param arr El arreglo de enteros a ordenar.
     */
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // No hay nada que ordenar
        }

        // Encontrar el valor máximo para determinar el número de dígitos
        int max = getMax(arr);

        // Ordenar por cada dígito, de menor a mayor posición
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(arr, exp);
        }
    }

    /**
     * Método auxiliar para realizar Counting Sort basado en un dígito específico.
     * 
     * @param arr El arreglo de enteros.
     * @param exp El valor de la posición del dígito a ordenar (1, 10, 100...).
     */
    private static void countingSortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Para dígitos de 0 a 9

        // Contar ocurrencias de cada dígito en la posición actual
        for (int num : arr) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        // Convertir las cuentas en posiciones acumulativas
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo ordenado
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[--count[digit]] = arr[i];
        }

        // Copiar los valores ordenados al arreglo original
        System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     * Encuentra el valor máximo en un arreglo.
     * 
     * @param arr El arreglo de enteros.
     * @return El valor máximo del arreglo.
     */
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Método para realizar la Ordenación BinSort (Bucket Sort) sobre un arreglo de enteros.
     * 
     * @param arr El arreglo de enteros a ordenar.
     * @param maxValue El valor máximo esperado en el arreglo.
     */
    public static void binSort(int[] arr, int maxValue) {
        if (arr == null || arr.length == 0 || maxValue <= 0) {
            return; // No hay nada que ordenar
        }

        // Crear contenedores (buckets) para contar las ocurrencias de cada valor
        int[] bins = new int[maxValue + 1];

        // Contar ocurrencias de cada valor en el arreglo
        for (int num : arr) {
            bins[num]++;
        }

        // Reconstruir el arreglo ordenado
        int index = 0;
        for (int i = 0; i <= maxValue; i++) {
            while (bins[i] > 0) {
                arr[index++] = i;
                bins[i]--;
            }
        }
    }



    

    /**
     * Método para realizar la Ordenación Radix (Radix Sort) en orden descendente.
     * 
     * @param arr El arreglo de enteros a ordenar.
     */
    public static void radixSortDescending(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // No hay nada que ordenar
        }

        // Encontrar el valor máximo para determinar el número de dígitos
        int max = getMax(arr);

        // Ordenar por cada dígito, de menor a mayor posición
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigitDescending(arr, exp);
        }
    }

    /**
     * Método auxiliar para realizar Counting Sort basado en un dígito específico en orden descendente.
     * 
     * @param arr El arreglo de enteros.
     * @param exp El valor de la posición del dígito a ordenar (1, 10, 100...).
     */
    private static void countingSortByDigitDescending(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // Para dígitos de 0 a 9

        // Contar ocurrencias de cada dígito en la posición actual
        for (int num : arr) {
            int digit = (num / exp) % 10;
            count[digit]++;
        }

        // Convertir las cuentas en posiciones acumulativas para orden descendente
        for (int i = 8; i >= 0; i--) {
            count[i] += count[i + 1];
        }

        // Construir el arreglo ordenado en orden descendente
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[--count[digit]] = arr[i];
        }

        // Copiar los valores ordenados al arreglo original
        System.arraycopy(output, 0, arr, 0, n);
    }

    /**
     * Método para realizar la Ordenación BinSort (Bucket Sort) en orden descendente.
     * 
     * @param arr El arreglo de enteros a ordenar.
     * @param maxValue El valor máximo esperado en el arreglo.
     */
    public static void binSortDescending(int[] arr, int maxValue) {
        if (arr == null || arr.length == 0 || maxValue <= 0) {
            return; // No hay nada que ordenar
        }

        // Crear contenedores (buckets) para contar las ocurrencias de cada valor
        int[] bins = new int[maxValue + 1];

        // Contar ocurrencias de cada valor en el arreglo
        for (int num : arr) {
            bins[num]++;
        }

        // Reconstruir el arreglo ordenado en orden descendente
        int index = 0;
        for (int i = maxValue; i >= 0; i--) {
            while (bins[i] > 0) {
                arr[index++] = i;
                bins[i]--;
            }
        }
    }


}
