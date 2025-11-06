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

class ColaClientes {
    private int[] clientes;
    private int frente;
    private int fin;
    private int tamaño;

    public ColaClientes(int capacidad) {
        clientes = new int[capacidad];
        frente = 0;
        fin = -1;
        tamaño = 0;
    }

    public void encolar(int cliente) {
        if (estaLlena()) return;
        fin = (fin + 1) % clientes.length;
        clientes[fin] = cliente;
        tamaño++;
    }

    public int desencolar() {
        if (estaVacia()) return -1;
        int valor = clientes[frente];
        frente = (frente + 1) % clientes.length;
        tamaño--;
        return valor;
    }

    public boolean estaVacia() { return tamaño == 0; }
    public boolean estaLlena() { return tamaño == clientes.length; }
    public int getTamaño() { return tamaño; }
}

// ---------------------- Simulación de atencion de clientes ----------------------

public class ejer3_AtencionClientes {
    public static void main(String[] args) {
        ColaClientes fila = new ColaClientes(1000);
        Random rand = new Random();

        int tiempoTotal = 7 * 60; // 7 horas * 60 minutos
        int clientesAtendidos = 0;
        int maxFila = 0;
        int sumaTamañoFila = 0;
        int tiempoAperturaCuartaCaja = -1;
        boolean cuartaCajaAbierta = false;

        int[] tiempoCajas = {0, 0, 0, 0};

        for (int minuto = 1; minuto <= tiempoTotal; minuto++) {
            // Cada minuto llega un cliente
            fila.encolar(minuto);

            if (fila.getTamaño() > maxFila) maxFila = fila.getTamaño();

            // Abrir cuarta caja si hay mas de 20 clientes
            if (fila.getTamaño() > 20 && !cuartaCajaAbierta) {
                cuartaCajaAbierta = true;
                tiempoAperturaCuartaCaja = minuto;
                System.out.println("⚡ Se abre la cuarta caja en el minuto " + minuto);
            }

            // Atender en las cajas (simulacion aleatoria)
            for (int i = 0; i < (cuartaCajaAbierta ? 4 : 3); i++) {
                if (tiempoCajas[i] == 0 && !fila.estaVacia()) {
                    fila.desencolar();
                    clientesAtendidos++;
                    tiempoCajas[i] = 2 + rand.nextInt(3); // entre 2 y 4 minutos por cliente
                } else if (tiempoCajas[i] > 0) {
                    tiempoCajas[i]--;
                }
            }

            sumaTamañoFila += fila.getTamaño();
        }

        double promedioFila = (double) sumaTamañoFila / tiempoTotal;

        // Resultados finales
        System.out.println("\nRESULTADOS DE LA SIMULACIoN");
        System.out.println("Clientes atendidos: " + clientesAtendidos);
        System.out.println("Tamano medio de fila: " + String.format("%.2f", promedioFila));
        System.out.println("Tamano maximo de fila: " + maxFila);
        if (cuartaCajaAbierta)
            System.out.println("Cuarta caja abierta en el minuto: " + tiempoAperturaCuartaCaja);
        else
            System.out.println("La cuarta caja nunca se abrio bro");
    }
}

