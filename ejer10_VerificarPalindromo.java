package pilas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer10_VerificarPalindromo {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Ingrese palabra: ");
String palabra = sc.nextLine();
Stack<Character> pila = new Stack<>();
for (char c : palabra.toCharArray()) pila.push(c);
StringBuilder invertida = new StringBuilder();
while (!pila.isEmpty()) invertida.append(pila.pop());
if (palabra.equalsIgnoreCase(invertida.toString()))
System.out.println("Es palíndromo");
else
System.out.println("No es palíndromo");
sc.close();
}
}
