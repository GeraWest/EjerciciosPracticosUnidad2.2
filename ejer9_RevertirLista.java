package pilas;

import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer9_RevertirLista {
    public static void main(String[] args) {
int[] lista = {1, 2, 3, 4};
Stack<Integer> pila = new Stack<>();
for (int n : lista) pila.push(n);
System.out.print("Lista invertida: ");
while (!pila.isEmpty()) System.out.print(pila.pop() + " ");
System.out.println();
}
    
}
