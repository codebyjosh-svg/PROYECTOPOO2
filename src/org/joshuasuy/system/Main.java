
package org.joshuasuy.system;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import org.joshuasuy.controller.EmpleadoController;
import org.joshuasuy.view.EmpleadoView;
 


/**
 * 
 * @author Joshua
 */

public class Main extends Application {
    
    public static void main(String[] args){
        launch(args);
    }

   @Override
    public void start(Stage stage) {
        stage.setTitle("Sistema de Gestión de Empleados");
        EmpleadoView vista = new EmpleadoView();
        new EmpleadoController(vista);
        TabPane raiz = vista.getTabPane();
        Scene escena = new Scene(raiz, 450, 600);
        
        stage.setScene(escena);
        stage.setResizable(false);
        stage.show();
    }
    }
    
