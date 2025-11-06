package pilas;

import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer1_simulacionSimpleDePilas {

 public static void main(String[] args) {
 Stack<Integer> pila = new Stack<>();
 pila.push(5);
 pila.push(10);
 pila.push(15);
 pila.push(20);
 pila.pop();
 pila.pop();
 System.out.println("Contenido actual: " + pila);
 }
}
