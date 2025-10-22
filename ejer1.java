/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospracticosunidad2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Rey Gerardo Avalos Mellado
 * 1224100509
 * GTID0141
1. Crear la lista enlazada
-Generar números enteros positivos al azar.
-Insertar cada número al final de la lista (inserción por último nodo).
2. Recorrer la lista
-Mostrar en pantalla cada elemento de la lista.
-El recorrido debe visitar nodo por nodo hasta llegar a null.
3. Eliminar nodos mayores a un valor dado
-Solicitar al usuario un valor límite.
-Eliminar todos los nodos cuyo campo dato sea mayor al valor ingresado.
-Ajustar los enlaces para mantener la integridad de la lista.
 */

class Nodo{
     int dato;
     Nodo sig;
}
public class ejer1 {
        int dato;
        Nodo sig;
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        Nodo cabeza = null, aux = null;

        // Crear lista con 10 números aleatorios
        for (int i = 0; i < 10; i++) {
            Nodo nuevo = new Nodo();
            nuevo.dato = r.nextInt(100) + 1;
            if (cabeza == null) cabeza = nuevo;
            else aux.sig = nuevo;
            aux = nuevo;
        }

        // Mostrar lista
        System.out.print("Lista original: ");
        aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.sig;
        }

        // Eliminar mayores a un valor
        System.out.print("\nIngresa valor limite: ");
        int lim = sc.nextInt();

        while (cabeza != null && cabeza.dato > lim) cabeza = cabeza.sig;
        aux = cabeza;
        while (aux != null && aux.sig != null) {
            if (aux.sig.dato > lim) aux.sig = aux.sig.sig;
            else aux = aux.sig;
        }

        // Mostrar nueva lista
        System.out.print("Lista filtrada: ");
        aux = cabeza;
        while (aux != null) {
            System.out.print(aux.dato + " ");
            aux = aux.sig;
        }
    }
}
