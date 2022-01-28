package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaComputadora;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class BotonComputadoraHandler implements EventHandler<ActionEvent> {

    private final Stage stage;

    public BotonComputadoraHandler(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        Scene nuevaEscena = null;
        try {
            nuevaEscena = new Scene(new EscenaComputadora(stage));
            SonidosHandler.sonidoBoton();
        } catch (NoExisteError | IOException | UnsupportedAudioFileException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
        stage.setScene(nuevaEscena);
    }
}
