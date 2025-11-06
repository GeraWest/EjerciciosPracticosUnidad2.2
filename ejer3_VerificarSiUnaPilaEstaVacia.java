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
System.out.println("¿Está vacía la pila? " + pila.isEmpty());
pila.push(1);
System.out.println("¿Está vacía la pila? " + pila.isEmpty());
 }
    
}

