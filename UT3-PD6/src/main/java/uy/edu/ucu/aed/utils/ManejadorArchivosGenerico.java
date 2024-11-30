package uy.edu.ucu.aed.utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ManejadorArchivosGenerico {
	public static String[] leerArchivo(String nombreCompletoArchivo) {
		FileReader fr;
		ArrayList<String> listaLineasArchivo = new ArrayList<String>();
		try {
			fr = new FileReader(nombreCompletoArchivo);
			BufferedReader br = new BufferedReader(fr);
			String lineaActual = br.readLine();
			while (lineaActual != null) {
				listaLineasArchivo.add(lineaActual);
				lineaActual = br.readLine();
			}
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error al leer el archivo "
					+ nombreCompletoArchivo);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo "
					+ nombreCompletoArchivo);
			e.printStackTrace();
		}
		System.out.println("Archivo leido satisfactoriamente");

		return listaLineasArchivo.toArray(new String[0]);
	}
}