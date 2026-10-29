package com.empleados;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    private Empleado[] empleados;

    public GestorEmpleados(Empleado[] empleados) {
        this.empleados = empleados;
    }

    //Búsqueda por identificación
    public ResultadoBusqueda busquedaLineal(int idBuscada) {
        int comparaciones = 0;
        for (int i = 0; i < empleados.length; i++) {
            comparaciones++;
            if (empleados[i].getIdentificacion() == idBuscada) {
                return new ResultadoBusqueda(i, comparaciones, empleados[i]);
            }
        }
        return new ResultadoBusqueda(-1, comparaciones, null);
    }

    //Búsqueda de empleados por cargo
    public List<Empleado> buscarPorCargo(String cargoBuscado) {
        List<Empleado> coincidencia = new ArrayList<>();
        for (Empleado emp : empleados) {
            if (emp.getCargo().equalsIgnoreCase(cargoBuscado)) {
                coincidencia.add(emp);
            }
        }
        return coincidencia;
    }

    //Ordenamiento por identificación
    public void ordenarPorIdentificacion() {
        for (int i = 1; i < empleados.length; i++) {
            Empleado clave = empleados[i];
            int j = i - 1;
            while (j >= 0 && empleados[j].getIdentificacion() > clave.getIdentificacion()) {
                empleados[j + 1] = empleados[j];
                j--;
            }
            empleados[j + 1] = clave;
        }
    }

    //Búsqueda binaria
    public ResultadoBusqueda busquedaBinaria(int idBuscada) {
        int lo = 0;
        int hi = empleados.length - 1;
        int comparaciones = 0;

        while (lo <= hi) {
            comparaciones++;
            int mid = lo + ((hi - lo) >>> 1); // Evita desbordamiento
            int idActual = empleados[mid].getIdentificacion();

            if (idActual == idBuscada) {
                return new ResultadoBusqueda(mid, comparaciones, empleados[mid]);
            }
            if (idActual < idBuscada) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return new ResultadoBusqueda(-1, comparaciones, null);
    }

    public Empleado[] getEmpleados() {
        return empleados;
    }

    // Clase auxiliar para retornar índice, comparaciones y el objeto
    public static class ResultadoBusqueda {
        private final int posicion;
        private final int comparaciones;
        private final Empleado empleado;

        public ResultadoBusqueda(int posicion, int comparaciones, Empleado empleado) {
            this.posicion = posicion;
            this.comparaciones = comparaciones;
            this.empleado = empleado;
        }

        public int getPosicion() { return posicion; }
        public int getComparaciones() { return comparaciones; }
        public Empleado getEmpleado() { return empleado; }
    }
}