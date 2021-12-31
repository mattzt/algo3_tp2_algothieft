package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaMenuPrincipal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;

public class BotonLogInHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final TextField nombre;

    public BotonLogInHandler(Stage stage, TextField nombre){
        this.stage = stage;
        this.nombre = nombre;
    }

    @Override
    public void handle(ActionEvent event) {
        if(!nombreIncorrecto(nombre)){
            try {
                logIn();
            } catch (NoExisteError | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean nombreIncorrecto(TextField texto){
        return texto.getText().isBlank();
    }

    private void logIn() throws NoExisteError, IOException {
        Scene nuevaEscena = new Scene(new EscenaMenuPrincipal(stage));
        stage.setScene(nuevaEscena);

        stage.centerOnScreen();
        stage.setResizable(false);
    }
}
