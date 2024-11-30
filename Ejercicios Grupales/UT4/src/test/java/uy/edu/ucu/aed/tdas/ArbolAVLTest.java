package uy.edu.ucu.aed.tdas;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.ucu.aed.tdas.ArbolAVL;
import uy.edu.ucu.aed.tdas.ElementoAVL;

public class ArbolAVLTest {

    private ArbolAVL<Integer> arbolAVL;

    @BeforeEach
    public void setUp() {
        // Inicializa un nuevo árbol AVL antes de cada prueba
        arbolAVL = new ArbolAVL<>();
    }

    @Test
    public void testInsertarNodo() {
        // Inserta un nodo y verifica si fue agregado correctamente
        assertTrue(arbolAVL.insertar(10, 10));
        assertEquals(Integer.valueOf(10), arbolAVL.getRaiz().getDatos());
    }

    @Test
    public void testInsercionBalanceoDerecha() {
        // Inserta varios nodos que provoquen una rotación a la derecha
        arbolAVL.insertar(30, 30);
        arbolAVL.insertar(20, 20);
        arbolAVL.insertar(10, 10); // Esto debería desencadenar una rotación a la derecha

        // Verifica que el nodo 20 ahora es la raíz del árbol balanceado
        assertEquals(Integer.valueOf(20), arbolAVL.getRaiz().getDatos());
    }

    @Test
    public void testInsercionBalanceoIzquierda() {
        // Inserta varios nodos que provoquen una rotación a la izquierda
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(20, 20);
        arbolAVL.insertar(30, 30); // Esto debería desencadenar una rotación a la izquierda

        // Verifica que el nodo 20 ahora es la raíz del árbol balanceado
        assertEquals(Integer.valueOf(20), arbolAVL.getRaiz().getDatos());
    }

    @Test
    public void testInsercionBalanceoIzquierdaDerecha() {
        // Inserta varios nodos que provoquen una rotación izquierda-derecha
        arbolAVL.insertar(30, 30);
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(20, 20); // Esto debería desencadenar una rotación izquierda-derecha

        // Verifica que el nodo 20 ahora es la raíz del árbol balanceado
        assertEquals(Integer.valueOf(20), arbolAVL.getRaiz().getDatos());
    }

    @Test
    public void testInsercionBalanceoDerechaIzquierda() {
        // Inserta varios nodos que provoquen una rotación derecha-izquierda
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(30, 30);
        arbolAVL.insertar(20, 20); // Esto debería desencadenar una rotación derecha-izquierda

        // Verifica que el nodo 20 ahora es la raíz del árbol balanceado
        assertEquals(Integer.valueOf(20), arbolAVL.getRaiz().getDatos());
    }

    @Test
    public void testNoPermitirDuplicados() {
        // Inserta un nodo y luego intenta insertar un duplicado
        assertTrue(arbolAVL.insertar(10, 10));
        assertFalse(arbolAVL.insertar(10, 10)); // No se debe permitir duplicados
    }

    @Test
    public void testRecorridoEnNivel() {
        // Verifica que el recorrido por niveles funcione correctamente
        arbolAVL.insertar(20, 20);
        arbolAVL.insertar(10, 10);
        arbolAVL.insertar(30, 30);

        // El recorrido en nivel debería dar: 20, 10, 30
        // Este método imprime el recorrido, así que la verificación podría ser visual.
        arbolAVL.levelOrder(arbolAVL.getRaiz());
    }

    @Test
    public void testBuscarNodo() {
        // Inserta un nodo y busca un nodo existente
        arbolAVL.insertar(10, 10);
        assertNotNull(arbolAVL.getRaiz());
        assertEquals(Integer.valueOf(10), arbolAVL.getRaiz().getDatos());
    }

    @Test
    public void testArbolVacio() {
        // Verifica que un árbol recién creado esté vacío
        assertNull(arbolAVL.getRaiz());
    }
}
