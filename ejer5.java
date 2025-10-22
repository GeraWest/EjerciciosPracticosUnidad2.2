package ejerciciospracticosunidad2;

import java.util.Scanner;

/**
 *
 * @author Rey Gerardo Avalos Mellado
 * 1224100509
 * GTID0141
 * 1. Lectura de cadena desde teclado
Solicitar al usuario una cadena de texto.
Extraer cada carácter individualmente.
2. Construcción de lista doblemente enlazada
Crear un nodo por cada carácter.
Cada nodo debe tener:
▪ Un campo para el carácter.
▪ Un puntero al nodo anterior (predecesor).
▪ Un puntero al nodo siguiente (sucesor).
3. Ordenamiento alfabético
Implementar un algoritmo de ordenamiento (por ejemplo, burbuja o
inserción) sobre la lista.
Reorganizar los nodos sin perder la doble referencia.
4. Mostrar lista ordenada
Recorrer la lista desde el primer nodo y mostrar los caracteres ordenados
en pantalla.
 */
class Nodo5 {
    char dato;
    Nodo5 ant;
    Nodo5 sig;
}

public class ejer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Nodo5 cabeza = null, ultimo = null;

        System.out.print("Ingresa una cadena: ");
        String cadena = sc.nextLine();

        // Crear lista doblemente enlazada
        for (char c : cadena.toCharArray()) {
            Nodo5 n = new Nodo5();
            n.dato = c;
            if (cabeza == null) {
                cabeza = n;
            } else {
                ultimo.sig = n;
                n.ant = ultimo;
            }
            ultimo = n;
        }

        if (cabeza == null) {
            System.out.println("No se ingresó texto.");
            return;
        }

        // Ordenar la lista 
        boolean cambio;
        do {
            cambio = false;
            Nodo5 actual = cabeza;
            while (actual.sig != null) {
                if (actual.dato > actual.sig.dato) {
                    // intercambio de valores
                    char temp = actual.dato;
                    actual.dato = actual.sig.dato;
                    actual.sig.dato = temp;
                    cambio = true;
                }
                actual = actual.sig;
            }
        } while (cambio);

        // Mostrar lista ordenada
        System.out.println("\nCaracteres ordenados alfabeticamente:");
        Nodo5 aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.sig;
        }
        System.out.println();
    }
}
