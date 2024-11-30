/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 
package uy.edu.ucu.aed;

import static uy.edu.ucu.aed.TClasificador.METODO_CLASIFICACION_BURBUJA;
import static uy.edu.ucu.aed.TClasificador.METODO_CLASIFICACION_INSERCION;
import static uy.edu.ucu.aed.TClasificador.METODO_CLASIFICACION_SHELL;

import org.junit.jupiter.api.Test;


import uy.edu.ucu.aed.TClasificador;

import static org.junit.jupiter.api.Assertions.*;

public class TClasificadorTest {

    public TClasificadorTest() {
        
        
    }

    @Test
    public void testClasificar() {
        int[] vector = {5, 4, 2, 3, 9};

        TClasificador clasif = new TClasificador();

        System.out.println(clasif.estaOrdenado(vector));

        int[] clasificacion = clasif.clasificar(vector, METODO_CLASIFICACION_INSERCION);

        
        assertArrayEquals(clasificacion, new int[] {2, 3, 4, 5, 9});
    }

    @Test
    public void testShellSort() {
        TClasificador clasif = new TClasificador();

        vector = new int[]{5, 4, 2, 3, 9};

        int[] shell = clasif.clasificar(vector, METODO_CLASIFICACION_SHELL);

        assertArrayEquals(shell, new int[] {2, 3, 4, 5, 9});
    }

    @Test
    public void testBurbuja() {
        TClasificador clasif = new TClasificador();

        vector = new int[]{5, 4, 2, 3, 9};

        int[] burbuja = clasif.clasificar(vector, METODO_CLASIFICACION_BURBUJA);
        assertArrayEquals(burbuja, new int[] {2, 3, 4, 5, 9});

    }

}
*/