package UT9PD1.src;


import java.util.Random;

public class GeneradorDatosGenericos {
	private static int TAMANIO_MAX = 32000;

	public int[] generarDatosAleatorios(int tamanio) {
		Random rnd = new Random();
		int[] datosGenerados = new int[tamanio];
		boolean[] datosUtilizados = new boolean[tamanio];
		for (int i = 0; i < datosGenerados.length; i++) { 
			int j = rnd.nextInt(tamanio);
			
			while (datosUtilizados[j]) { 
				j = (j + 1) % tamanio;
			}
			datosGenerados[j] = i;
			datosUtilizados[j] = true;
		}
		return datosGenerados;
	}

	public int[] generarDatosAleatorios(){
		return generarDatosAleatorios(TAMANIO_MAX);
	}

	public int[] generarDatosAscendentes(int tamanio) {
		int[] copiaAscendente = new int[tamanio];
		for (int i = 0; i < tamanio; i++) {
			copiaAscendente[i] = i;
		}
		return copiaAscendente;
	}

	public int[] generarDatosAscendentes() {
		return generarDatosAscendentes(TAMANIO_MAX);
	}

	public int[] generarDatosDescendentes(int tamanio) {
		int[] copiaDescendente = new int[tamanio];
		for (int i = 0; i < tamanio; i++) {
			copiaDescendente[i] = tamanio - i;
		}
		return copiaDescendente;
	}

	public int[] generarDatosDescendentes() {
		return generarDatosDescendentes(TAMANIO_MAX);
	}
}