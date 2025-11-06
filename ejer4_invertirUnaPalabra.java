package pilas;

import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer4_invertirUnaPalabra {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Ingrese una palabra: ");
String palabra = sc.nextLine();
Stack<Character> pila = new Stack<>();
for (char c : palabra.toCharArray()) pila.push(c);
System.out.print("Invertida: ");
while (!pila.isEmpty()) System.out.print(pila.pop());
System.out.println();
sc.close();
     }
}
