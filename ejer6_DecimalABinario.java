package pilas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer6_DecimalABinario {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.print("Ingrese número: ");
int num = 0;
if (sc.hasNextInt()) {
num = sc.nextInt();
} else {
System.out.println("Entrada no válida");
sc.close();
return;
}


if (num == 0) {
System.out.println("Binario: 0");
sc.close();
return;
}


Stack<Integer> pila = new Stack<>();
int n = Math.abs(num);
while (n > 0) {
pila.push(n % 2);
n /= 2;
}


StringBuilder sb = new StringBuilder();
if (num < 0) sb.append('-');
while (!pila.isEmpty()) sb.append(pila.pop());


System.out.println("Binario: " + sb.toString());
sc.close();
}
    
}
