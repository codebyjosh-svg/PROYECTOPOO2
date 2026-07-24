
package org.joshuasuy.model;

public abstract class Empleado {

    //Atributos privados [se cumple la encapsulación junto con Getters y Setters]
    private String id;
    private String nombre;

    // Constructor
    public Empleado(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // 2. Encapsulamiento: Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // 1. Método abstracto principal
    public abstract double calcularTotal();
}