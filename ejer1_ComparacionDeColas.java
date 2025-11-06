/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colas;

/**
 *
 * @author Avalos Mellado Rey Gerardo
 * 1224100509
 * GTID0141
 */

class Cola<T> {
    private T[] elementos;
    private int frente;
    private int fin;
    private int tamaño;

    @SuppressWarnings("unchecked")
    public Cola(int capacidad) {
        elementos = (T[]) new Object[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }
    
      // Encolar (insertar al final)
    public void encolar(T dato) {
        if (estaLlena()) {
            System.out.println("Cola llena, no se puede encolar: " + dato);
            return;
        }
        fin = (fin + 1) % elementos.length;
        elementos[fin] = dato;
        tamaño++;
    }
    
    // Desencolar (retirar al frente)
    public T desencolar() {
        if (estaVacia()) {
            System.out.println("Cola vacía, no se puede desencolar.");
            return null;
        }
        T dato = elementos[frente];
        frente = (frente + 1) % elementos.length;
        tamaño--;
        return dato;
    }
    // Ver si la cola esta vacia
    public boolean estaVacia() {
        return tamaño == 0;
    }
    
    // Ver si la cola esta llena

    public boolean estaLlena() {
        return tamaño == elementos.length;
    }
    // Obtener el tamaño actual
    public int getTamaño() {
        return tamaño;
    }
    // Obtener un elemento sin modificar la cola
    public T obtenerElemento(int index) {
        if (index < 0 || index >= tamaño) return null;
        return elementos[(frente + index) % elementos.length];
    }
    // comparar dos colas
    public boolean esIgual(Cola<T> otra) {
        if (this.tamaño != otra.getTamaño()) return false;
        for (int i = 0; i < tamaño; i++) {
            if (!this.obtenerElemento(i).equals(otra.obtenerElemento(i))) return false;
        }
        return true;
    }
    //mostrar

    public void mostrar() {
        System.out.print("Cola: [");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(obtenerElemento(i));
            if (i < tamaño - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}


public class ejer1_ComparacionDeColas {
    public static void main(String[] args) {
        Cola<Integer> cola1 = new Cola<>(5);
        Cola<Integer> cola2 = new Cola<>(5);

        cola1.encolar(10);
        cola1.encolar(20);
        cola1.encolar(30);

        cola2.encolar(10);
        cola2.encolar(20);
        cola2.encolar(30);

        cola1.mostrar();
        cola2.mostrar();

        if (cola1.esIgual(cola2))
            System.out.println("Las colas son idénticas.");
        else
            System.out.println("Las colas son diferentes.");

        cola2.desencolar();
        cola2.encolar(99);

        cola1.mostrar();
        cola2.mostrar();

        if (cola1.esIgual(cola2))
            System.out.println("Las colas son idénticas.");
        else
            System.out.println("Las colas son diferentes.");
    }
}