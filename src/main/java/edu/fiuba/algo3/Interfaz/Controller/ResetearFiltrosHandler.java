package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaComputadora;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ResetearFiltrosHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Policia policia;

    public ResetearFiltrosHandler(Stage stage, Policia policia){
        this.stage = stage;
        this.policia = policia;
    }

    @Override
    public void handle(ActionEvent event) {
        policia.resetearSospechosos();

        Scene nuevaEscena = null;
        try {
            nuevaEscena = new Scene(new EscenaComputadora(stage));
        } catch (NoExisteError | IOException e) {
            e.printStackTrace();
        }
        stage.setScene(nuevaEscena);
    }
}
