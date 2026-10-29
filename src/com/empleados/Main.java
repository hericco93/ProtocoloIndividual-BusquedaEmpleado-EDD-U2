package com.empleados;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("====================================================");
        System.out.println("   DEMOSTRACIÓN DE BÚSQUEDAS Y ORDENAMIENTO (EJ. 21)");
        System.out.println("====================================================\n");

        // Datos de prueba iniciales para el Arreglo desordenado
        Empleado[] listaInicial = {
                new Empleado(105, "Laura Gomez", "Desarrollador", 4500000),
                new Empleado(101, "Carlos Perez", "Analista", 3200000),
                new Empleado(104, "Ana Martinez", "Desarrollador", 4800000),
                new Empleado(102, "Beatriz Lopez", "Gerente", 8500000),
                new Empleado(103, "David Ruiz", "Analista", 3400000)
        };

        GestorEmpleados gestor = new GestorEmpleados(listaInicial);

        //Búsqueda por identificación
        System.out.println("--- 1. BÚSQUEDA LINEAL (POR IDENTIFICACIÓN) ---");
        int idBuscar = 104;
        GestorEmpleados.ResultadoBusqueda resLineal = gestor.busquedaLineal(idBuscar);
        if (resLineal.getPosicion() != -1) {
            System.out.println("Encontrado en posición [" + resLineal.getPosicion() + "]: " + resLineal.getEmpleado());
        } else {
            System.out.println("Empleado con ID " + idBuscar + " no encontrado.");
        }
        System.out.println("Comparaciones realizadas (Lineal): " + resLineal.getComparaciones() + "\n");

        //Búsqueda de empleados por cargo
        System.out.println("--- 2. BÚSQUEDA POR CARGO ('Desarrollador') ---");
        List<Empleado> devs = gestor.buscarPorCargo("Desarrollador");
        for (Empleado emp : devs) {
            System.out.println(emp);
        }
        System.out.println();

        //Ordenamiento por identificación
        System.out.println("--- 3. ORDENAMIENTO POR IDENTIFICACIÓN ---");
        gestor.ordenarPorIdentificacion();
        for (Empleado emp : gestor.getEmpleados()) {
            System.out.println(emp);
        }
        System.out.println();

        //Búsqueda binaria
        System.out.println("--- 4. BÚSQUEDA BINARIA (POR IDENTIFICACIÓN) ---");
        GestorEmpleados.ResultadoBusqueda resBinaria = gestor.busquedaBinaria(idBuscar);
        if (resBinaria.getPosicion() != -1) {
            System.out.println("Encontrado en posición [" + resBinaria.getPosicion() + "]: " + resBinaria.getEmpleado());
        } else {
            System.out.println("Empleado con ID " + idBuscar + " no encontrado.");
        }
        System.out.println("Comparaciones realizadas (Binaria): " + resBinaria.getComparaciones() + "\n");

        //Comparación de rendimiento con diferentes tamaños de arreglos
        System.out.println("====================================================");
        System.out.println("--- 5. PRUEBA EXPERIMENTAL DE RENDIMIENTO ---");
        System.out.println("====================================================");
        probarRendimiento(1000);
        probarRendimiento(50000);
        probarRendimiento(200000);
    }

    private static void probarRendimiento(int tamano) {
        Empleado[] grande = generarEmpleadosAleatorios(tamano);
        GestorEmpleados gestorGrande = new GestorEmpleados(grande);

        // ID inexistente para evaluar el peor caso de ambos algoritmos
        int idInexistente = -999;

        // Medir Búsqueda Lineal O(n)
        long inicioLineal = System.nanoTime();
        GestorEmpleados.ResultadoBusqueda resLineal = gestorGrande.busquedaLineal(idInexistente);
        long finLineal = System.nanoTime();
        double tiempoLinealMs = (finLineal - inicioLineal) / 1e6;

        // Precondición para binaria: Ordenar el arreglo
        gestorGrande.ordenarPorIdentificacion();

        //Medir Búsqueda Binaria O(log n)
        long inicioBinaria = System.nanoTime();
        GestorEmpleados.ResultadoBusqueda resBinaria = gestorGrande.busquedaBinaria(idInexistente);
        long finBinaria = System.nanoTime();
        double tiempoBinariaMs = (finBinaria - inicioBinaria) / 1e6;

        System.out.printf("\nTamaño del Arreglo: %,d elementos\n", tamano);
        System.out.printf("  [Lineal]  Comparaciones: %,d | Tiempo: %.4f ms\n",
                resLineal.getComparaciones(), tiempoLinealMs);
        System.out.printf("  [Binaria] Comparaciones: %,d | Tiempo: %.4f ms\n",
                resBinaria.getComparaciones(), tiempoBinariaMs);
    }

    private static Empleado[] generarEmpleadosAleatorios(int cantidad) {
        Empleado[] empleados = new Empleado[cantidad];
        Random rand = new Random(42);
        for (int i = 0; i < cantidad; i++) {
            int id = rand.nextInt(1_000_000);
            empleados[i] = new Empleado(id, "Empleado " + i, "Cargo " + (i % 5), 2000000 + i);
        }
        return empleados;
    }
}