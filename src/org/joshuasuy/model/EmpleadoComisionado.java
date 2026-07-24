/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.joshuasuy.model;

/**
 *
 * @author informatica
 */
public class EmpleadoComisionado extends Empleado {

    private double ventasTotales; // Atributos únicos
    private double porcentajeComision;

    public EmpleadoComisionado(String id, String nombre, double ventasTotales, double porcentajeComision) {
        super(id, nombre);
        this.ventasTotales = ventasTotales;
        this.porcentajeComision = porcentajeComision;
    }

    public double getVentasTotales() {
        return ventasTotales;
    }

    public void setVentasTotales(double ventasTotales) {
        this.ventasTotales = ventasTotales;
    }

    public double getPorcentajeComision() {
        return porcentajeComision;
    }

    public void setPorcentajeComision(double porcentajeComision) {
        this.porcentajeComision = porcentajeComision;
    }

    // 4. Polimorfismo
    @Override
    public double calcularTotal() {
        return this.ventasTotales * (this.porcentajeComision / 100);
    }
}
