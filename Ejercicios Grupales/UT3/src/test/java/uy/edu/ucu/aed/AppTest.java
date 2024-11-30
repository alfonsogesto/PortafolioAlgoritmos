package uy.edu.ucu.aed;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uy.edu.ucu.aed.tdas.Lista;
import uy.edu.ucu.aed.tdas.Queue;
import uy.edu.ucu.aed.tdas.Stack;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    Stack<Integer> Pila = new Stack<Integer>();
    Queue<Integer> Cola = new Queue<Integer>();
    int dato = 1;
    int dato2 = 2;
    int dato3 = 3;


    @Test
    void testPop() {
        Pila.insertar(dato, dato);
        Pila.insertar(dato2, dato2);
        Pila.insertar(dato3, dato3);

        int resultado = Pila.Pop();

        assertEquals(dato3, resultado);
    }


    @Test
    void testIsEmpty() {
        assertTrue(Pila.isEmpty());
        Pila.Push(1, 1);
        assertFalse(Pila.isEmpty());

        Pila.Pop();
        assertTrue(Pila.isEmpty());
    }

    @Test
    void testPush() {
        Pila.insertar(dato2, dato2);
        Pila.insertar(dato, dato);


        assertEquals(dato, Pila.Pop());
    }

    @Test
    void testPopQueue() {
        Cola.insertar(dato,dato);
        Cola.insertar(dato2,dato2);
        Cola.insertar(dato3,dato3);

        assertEquals(dato,Cola.Pop());
    }


}
