package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.PantallaFinal;
import edu.fiuba.algo3.Interfaz.Views.resources.SeteadorNuevaEscena;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ArrestarHandler implements EventHandler<ActionEvent> {

    private final Partida partida;
    private final Policia policia;
    private final Stage stage;

    public ArrestarHandler(Stage stage) throws NoExisteError, IOException {
        partida = Partida.getInstance();
        policia = partida.getPolicia();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        Criminal atrapado = policia.arrestar();
        partida.evaluarEstado(atrapado);

        if(partida.terminoJuego()) {
            Scene nuevaEscena = null;
            try {
                nuevaEscena = new Scene(new PantallaFinal(stage));
            } catch (NoExisteError | IOException e) {
                e.printStackTrace();
            }
            stage.setScene(nuevaEscena);
        }
    }
}
