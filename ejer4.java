package ejerciciospracticosunidad2;

import java.util.Scanner;

/**
 *
 * @author Rey Gerardo Avalos Mellado
 * 1224100509
 * GTID0141
 * 1. Partir del modelo del Problema 4
Cada nodo representa un término del polinomio.
Contiene dos campos: coeficiente y exponente.
2. Convertir la lista en circular
El último nodo debe apuntar al primer nodo, formando un ciclo.
La referencia de acceso será el último nodo, no el primero.
3. Entrada del polinomio
Solicitar al usuario los pares coeficiente-exponente.
Ejemplo: el polinomio ( 3x^4 - 4x^2 + 11 ) se representa como:
3 4, -4 2, 11 0
4. Recorrido circular
Implementar un recorrido que parta del nodo siguiente al último (es decir, el
primero).
Detener el recorrido al volver al nodo inicial.
 */
class Nodo4 {
    double coef;
    int exp;
    Nodo4 sig;
}

public class ejer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nodo4 ultimo = null; // referencia al último nodo

        System.out.println("Ingresa coeficiente y exponente (escribe 'fin' para terminar bro):");

        while (true) {
            System.out.print("Coef: ");
            String c = sc.next();
            if (c.equalsIgnoreCase("fin")) break;

            Nodo4 n = new Nodo4();
            n.coef = Double.parseDouble(c);

            System.out.print("Exp: ");
            n.exp = sc.nextInt();

            if (ultimo == null) {
                ultimo = n;
                n.sig = n; // apunta a sí mismo (primer nodo)
            } else {
                n.sig = ultimo.sig;
                ultimo.sig = n;
                ultimo = n;
            }
        }

        if (ultimo == null) {
            System.out.println("\nNo se ingresaron terminos.");
            return;
        }

        System.out.println("\nTerminos del polinomio:");
        Nodo4 aux = ultimo.sig; // primer nodo
        do {
            System.out.printf("%.2fx^%d  ", aux.coef, aux.exp);
            aux = aux.sig;
        } while (aux != ultimo.sig);

        // Evaluacion del polinomio
        System.out.println("\n\nx\tP(x)");
        System.out.println("----------------");
        for (double x = 0; x <= 5; x += 0.5) {
            double res = 0;
            aux = ultimo.sig;
            do {
                res += aux.coef * Math.pow(x, aux.exp);
                aux = aux.sig;
            } while (aux != ultimo.sig);
            System.out.printf("%.1f\t%.2f\n", x, res);
        }
    }
}
