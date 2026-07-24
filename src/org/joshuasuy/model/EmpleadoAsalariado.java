
package org.joshuasuy.model;


public class EmpleadoAsalariado extends Empleado {

    private double salarioMensual; // Atributo único

    public EmpleadoAsalariado(String id, String nombre, double salarioMensual) {
        super(id, nombre);
        this.salarioMensual = salarioMensual;
    }
    
    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    
    // 4. Polimorfismo
    @Override
    public double calcularTotal() {
        return this.salarioMensual;
    }
}