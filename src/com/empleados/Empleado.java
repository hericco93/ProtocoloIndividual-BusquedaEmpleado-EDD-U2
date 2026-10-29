package com.empleados;

public class Empleado {
    private int identificacion;
    private String nombre;
    private String cargo;
    private double salario;

    public Empleado(int identificacion, String nombre, String cargo, double salario) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Nombre: %-15s | Cargo: %-15s | Salario: $%.2f",
                identificacion, nombre, cargo, salario);
    }
}