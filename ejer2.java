/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciospracticosunidad2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 *@author Rey Gerardo Avalos Mellado
 * 1224100509
 * GTID0141
 * 1. Lectura del archivo
Leer un archivo de texto que contiene palabras separadas por espacios o
saltos de línea.
Extraer cada palabra y almacenarla como un nodo en una lista enlazada.
2. Formación de la lista
Crear una lista enlazada simple donde cada nodo contiene una palabra.
La inserción se realiza en orden de aparición (al final de la lista).
3. Manipulación dinámica
Permitir al usuario añadir nuevas palabras a la lista.
Permitir eliminar palabras específicas de la lista.
4. Escritura en archivo
Al finalizar, escribir todas las palabras contenidas en la lista nuevamente en
el archivo.
Las palabras deben estar separadas por espacios o saltos de línea, según el
formato original.
 */

class Nodo2 {
    String palabra;
    Nodo2 sig;
}
public class ejer2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre del archivo: ");
        String nombre = sc.nextLine();

        Nodo2 cabeza = null, aux = null;

        try (Scanner f = new Scanner(new File(nombre))) {
            while (f.hasNext()) {
                Nodo2 nuevo = new Nodo2();
                nuevo.palabra = f.next();
                if (cabeza == null) cabeza = nuevo;
                else aux.sig = nuevo;
                aux = nuevo;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
            return;
        }

        int op;
        do {
            System.out.println("\n1. Mostrar\n2. Agregar palabra\n3. Eliminar palabra\n4. Guardar y salir");
            op = sc.nextInt(); sc.nextLine();
            if (op == 1) {
                aux = cabeza;
                while (aux != null) {
                    System.out.print(aux.palabra + " ");
                    aux = aux.sig;
                }
                System.out.println();
            } else if (op == 2) {
                System.out.print("Palabra nueva: ");
                Nodo2 nuevo = new Nodo2();
                nuevo.palabra = sc.nextLine();
                if (cabeza == null) cabeza = nuevo;
                else {
                    aux = cabeza;
                    while (aux.sig != null) aux = aux.sig;
                    aux.sig = nuevo;
                }
            } else if (op == 3) {
                System.out.print("Palabra a eliminar: ");
                String elim = sc.nextLine();
                while (cabeza != null && cabeza.palabra.equalsIgnoreCase(elim)) cabeza = cabeza.sig;
                aux = cabeza;
                while (aux != null && aux.sig != null) {
                    if (aux.sig.palabra.equalsIgnoreCase(elim)) aux.sig = aux.sig.sig;
                    else aux = aux.sig;
                }
            } else if (op == 4) {
                try (PrintWriter pw = new PrintWriter(new FileWriter(nombre))) {
                    aux = cabeza;
                    while (aux != null) {
                        pw.print(aux.palabra + " ");
                        aux = aux.sig;
                    }
                }
                System.out.println("Archivo guardado.");
            }
        } while (op != 4);
    }

}
