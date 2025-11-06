package pilas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer2_PilaDeNombres {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Stack<String> pila = new Stack<>();
String nombre;


while (true) {
System.out.print("Ingrese un nombre (FIN para salir): ");
nombre = sc.nextLine();
if (nombre.equalsIgnoreCase("FIN")) break;
if (!nombre.trim().isEmpty()) pila.push(nombre);
     }


System.out.println("Nombres en orden inverso:");
while (!pila.isEmpty()) {
System.out.println(pila.pop());

     }


sc.close();
     }
}
  
