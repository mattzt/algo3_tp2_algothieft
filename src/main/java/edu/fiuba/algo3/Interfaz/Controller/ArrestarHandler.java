package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;

public class ArrestarHandler implements EventHandler<ActionEvent> {

    Partida partida;
    Policia policia;
    Stage stage;

    public ArrestarHandler(Stage stage) throws NoExisteError, IOException {
        partida = Partida.getInstance();
        policia = partida.getPolicia();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}
