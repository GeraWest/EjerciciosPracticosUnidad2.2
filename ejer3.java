/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospracticosunidad2;

import java.util.Scanner;

/**
 *
 * @author Rey Gerardo Avalos Mellado
 * 1224100509
 * GTID0141
 * 1. Entrada del polinomio
Solicitar al usuario los términos del polinomio en forma de pares:
coeficiente y exponente.
Ejemplo: el polinomio ( 3x^4 - 4x^2 + 11 ) se representa como:
3 4, -4 2, 11 0
2. Representación con lista enlazada
Cada nodo de la lista contiene dos campos:
▪ coeficiente
▪ exponente
Los nodos se enlazan en el orden en que aparecen los términos del
polinomio.
3. Evaluación del polinomio
Calcular el valor del polinomio para valores de ( x ) desde 0.0 hasta 5.0, en
incrementos de 0.5.
Mostrar los resultados en forma de tabla de valores: 
 */
class Nodo3 {
    double coef;
    int exp;
    Nodo3 sig;
}
public class ejer3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nodo3 cabeza = null, aux = null;

        System.out.println("Ingresa coeficiente y exponente (fin para terminar):");
        while (true) {
            System.out.print("Coef: ");
            String c = sc.next();
            if (c.equalsIgnoreCase("fin")) break;
            Nodo3 n = new Nodo3();
            n.coef = Double.parseDouble(c);
            System.out.print("Exp: ");
            n.exp = sc.nextInt();
            if (cabeza == null) cabeza = n;
            else aux.sig = n;
            aux = n;
        }

        System.out.println("\nx\tP(x)");
        for (double x = 0; x <= 5; x += 0.5) {
            double res = 0;
            aux = cabeza;
            while (aux != null) {
                res += aux.coef * Math.pow(x, aux.exp);
                aux = aux.sig;
            }
            System.out.printf("%.1f\t%.2f\n", x, res);
        }
    }
    
}
