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

import java.util.Random;

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

    public void encolar(T dato) {
        if (estaLlena()) return;
        fin = (fin + 1) % elementos.length;
        elementos[fin] = dato;
        tamaño++;
    }

    public T desencolar() {
        if (estaVacia()) return null;
        T dato = elementos[frente];
        frente = (frente + 1) % elementos.length;
        tamaño--;
        return dato;
    }

    public boolean estaVacia() { return tamaño == 0; }
    public boolean estaLlena() { return tamaño == elementos.length; }
    public int getTamaño() { return tamaño; }

    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            System.out.print(elementos[(frente + i) % elementos.length] + " ");
        }
        System.out.println();
    }
}

// ---------------------- Clases del supermercado ----------------------

class Carrito {
    private int id;
    public Carrito(int id) { this.id = id; }
    public int getId() { return id; }
    @Override
    public String toString() { return "Carrito#" + id; }
}

class Cliente {
    private int id;
    private Carrito carrito;

    public Cliente(int id) { this.id = id; }

    public void tomarCarrito(Carrito c) { this.carrito = c; }
    public Carrito getCarrito() { return carrito; }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "Cliente#" + id + (carrito != null ? " con " + carrito : "");
    }
}

class Caja {
    private int id;
    private Cola<Cliente> colaClientes;

    public Caja(int id) {
        this.id = id;
        colaClientes = new Cola<>(50);
    }

    public void agregarCliente(Cliente c) { colaClientes.encolar(c); }
    public Cliente atenderCliente() { return colaClientes.desencolar(); }
    public int getTamañoCola() { return colaClientes.getTamaño(); }
    public int getId() { return id; }

    @Override
    public String toString() {
        return "Caja#" + id + " (" + colaClientes.getTamaño() + " clientes)";
    }
}

class Supermercado {
    private Cola<Carrito> carritosDisponibles;
    private Caja[] cajas;
    private int totalClientesAtendidos;

    public Supermercado(int totalCarritos, int numCajas) {
        carritosDisponibles = new Cola<>(totalCarritos);
        for (int i = 1; i <= totalCarritos; i++) carritosDisponibles.encolar(new Carrito(i));

        cajas = new Caja[numCajas];
        for (int i = 0; i < numCajas; i++) cajas[i] = new Caja(i + 1);
    }

    public void simular(int clientesTotales) {
        Random rand = new Random();

        for (int i = 1; i <= clientesTotales; i++) {
            Cliente cliente = new Cliente(i);
            System.out.println("\n Llega " + cliente);

            if (carritosDisponibles.estaVacia()) {
                System.out.println(" No hay carritos disponibles. Cliente espera...");
                continue;
            }

            Carrito carrito = carritosDisponibles.desencolar();
            cliente.tomarCarrito(carrito);
            System.out.println(" " + cliente + " toma un carrito.");

            // Buscar la caja con menos clientes
            Caja cajaElegida = cajas[0];
            for (Caja c : cajas) {
                if (c.getTamañoCola() < cajaElegida.getTamañoCola()) cajaElegida = c;
            }

            cajaElegida.agregarCliente(cliente);
            System.out.println(" " + cliente + " se forma en " + cajaElegida);
        }

        // Simular atencion 
        System.out.println("\n Atendiendo clientes...");
        for (Caja c : cajas) {
            Cliente atendido;
            while ((atendido = c.atenderCliente()) != null) {
                carritosDisponibles.encolar(atendido.getCarrito());
                totalClientesAtendidos++;
            }
        }

        System.out.println("\n Simulacion completada. Total clientes atendidos: " + totalClientesAtendidos);
        System.out.println("Carritos disponibles al final: " + carritosDisponibles.getTamaño());
    }
}

public class ejer2_SimulacionSupermercado {
    public static void main(String[] args) {
        Supermercado sm = new Supermercado(25, 3);
        sm.simular(10);
    }
}

