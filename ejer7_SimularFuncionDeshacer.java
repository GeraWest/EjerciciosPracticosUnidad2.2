package pilas;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */
public class ejer7_SimularFuncionDeshacer {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Stack<String> acciones = new Stack<>();


while (true) {
System.out.print("Acción (UNDO/FIN): ");
String act = sc.nextLine();
if (act.equalsIgnoreCase("FIN")) break;
if (act.equalsIgnoreCase("UNDO")) {
if (!acciones.isEmpty()) acciones.pop();
else System.out.println("Nada que deshacer");
} else {
acciones.push(act);
}
System.out.println("Actual: " + acciones);
}


sc.close();
}
}
