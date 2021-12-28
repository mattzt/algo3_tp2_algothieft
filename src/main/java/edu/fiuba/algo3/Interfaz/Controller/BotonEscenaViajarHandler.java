package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaMenuPrincipal;
import edu.fiuba.algo3.Interfaz.Views.EscenaViajar;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class BotonEscenaViajarHandler implements EventHandler<ActionEvent> {
    
    Stage stage;
    
    public BotonEscenaViajarHandler(Stage stage){
        this.stage = stage;
    }
    
    @Override
    public void handle(ActionEvent event) {
        Scene nuevaEscena = null;
        try {
            nuevaEscena = new Scene(new EscenaViajar(stage));
        } catch (NoExisteError | IOException e) {
            e.printStackTrace();
        }
        stage.setScene(nuevaEscena);
    }
}
