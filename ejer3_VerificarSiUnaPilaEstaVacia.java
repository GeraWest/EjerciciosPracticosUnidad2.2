package pilas;

import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer3_VerificarSiUnaPilaEstaVacia {
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack<>();
        System.out.println("¿La pila está vacía? " + pila.isEmpty());
        pila.push(10); // Inserta un elemento
        System.out.println("Se ha insertado un elemento (10).");
        System.out.println("¿La pila está vacía ahora? " + pila.isEmpty());
    }
    
}


