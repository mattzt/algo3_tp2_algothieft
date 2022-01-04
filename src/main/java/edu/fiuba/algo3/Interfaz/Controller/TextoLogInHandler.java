package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaMenuPrincipal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class TextoLogInHandler implements EventHandler<KeyEvent> {

    Stage stage;
    TextField textField;

    public TextoLogInHandler(Stage stage, TextField textField) {
        this.stage = stage;
        this.textField = textField;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(!nombreIncorrecto() && keyEvent.getCode() == KeyCode.ENTER){
            try {
                Policia policia = Partida.getInstance().getPolicia();
                policia.setNombre(textField.getText());
                logIn();
            } catch (NoExisteError | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean nombreIncorrecto(){
        return textField.getText().isBlank();
    }

    private void logIn() throws NoExisteError, IOException {
        Scene nuevaEscena = new Scene(new EscenaMenuPrincipal(stage));
        stage.setScene(nuevaEscena);

        stage.centerOnScreen();
        stage.setResizable(false);
    }
}
