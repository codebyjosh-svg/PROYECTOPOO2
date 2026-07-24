
package org.joshuasuy.controller;

import java.util.ArrayList;
import org.joshuasuy.model.Empleado;
import org.joshuasuy.model.EmpleadoAsalariado;
import org.joshuasuy.model.EmpleadoComisionado;
import org.joshuasuy.model.EmpleadoPorHoras;
import org.joshuasuy.view.EmpleadoView;

public class EmpleadoController {

    private EmpleadoView vista;
    private ArrayList<Empleado> listaEmpleados;

    public EmpleadoController(EmpleadoView vista) {
        this.vista = vista;
        this.listaEmpleados = new ArrayList<>(); 
        inicializarEventos();
    }

    private void inicializarEventos() {
        //combobox
        vista.getCbTipo().setOnAction(e -> manejarTipoEmpleado());
        //boton guardar
        vista.getBtnGuardar().setOnAction(e -> guardarEmpleado());
        //boton actualizar
        vista.getBtnCalcular().setOnAction(e -> calcularNomina());
    }
    
    private void manejarTipoEmpleado() {
        //Accedemos al valor seleccionado de ComboBox
        String opcion = vista.getCbTipo().getValue();
        if (opcion == null) {
            return;
        }

        // El controlador le ordena a la vista cómo reconfigurar sus campos físicos
        switch (opcion) {
            case "Asalariado":
                System.out.println("Se selecciono asalariado");
                vista.mostrarAsalariado();
                break;
            case "Comisionado":
                System.out.println("Se selecciono Comision");
                break;
            case "Por Horas":
                System.out.println("Se selecciono Por horas");
                break;
            
        }
    }

    /**
     * Extrae los datos de la vista, los valida y genera un objeto polimórfico en el modelo.
     */
    private void guardarEmpleado() {
        System.out.println("Se ha guardado en empledo");
        String id = vista.getTxtId().getText();
        String nombre = vista.getTxtNombre().getText();
        String tipo = vista.getCbTipo().getValue();

            Empleado nuevoEmpleado = null;

            switch (tipo) {
                case "Asalariado":
                    double salario = Double.parseDouble(vista.getTxtSalario().getText());
                    nuevoEmpleado = new EmpleadoAsalariado(id, nombre, salario);
                    break;

                case "Por Horas":
                    int horas = Integer.parseInt(vista.getTxtHoras().getText());
                    double tarifa = Double.parseDouble(vista.getTxtTarifa().getText());
                    nuevoEmpleado = new EmpleadoPorHoras(id, nombre, horas, tarifa);
                    break;

                case "Comisionado":
                    double ventas = Double.parseDouble(vista.getTxtVentas().getText());
                    double porcentaje = Double.parseDouble(vista.getTxtPorcentaje().getText());
                    nuevoEmpleado = new EmpleadoComisionado(id, nombre, ventas, porcentaje);
                    break;
            }

 
                listaEmpleados.add(nuevoEmpleado);
                
            }

    private void calcularNomina() {
        System.out.println("Lista actualizada.");
        //vista.listaNomina <-- listaEmpleados
        //mostrar actualización de nomina
        vista.getListaNomina().getItems();
        
        //recorrer la lista listaEmpleados agregado uno a uno a listaNomina de la vista
        for (Empleado empleado : listaEmpleados) {
            String fila = String.format("ID: %s | %s (%s) Pago Total: $%.2f \n",
                    empleado.getId(),
                    empleado.getNombre(),
                    empleado.getClass().getSimpleName(),
                    empleado.calcularTotal());
            vista.getListaNomina().getItems().add(fila);
        }
        
        
    }
}
