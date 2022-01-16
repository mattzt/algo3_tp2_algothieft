package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.PantallaFinal;
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

public class EmitirOrdenHandler implements EventHandler<ActionEvent> {

    Policia policia;
    Label hora;
    Stage stage;
    Partida partida;

    public EmitirOrdenHandler(Stage stage, Policia policia, Label hora) throws NoExisteError, IOException {
        this.stage = stage;
        this.policia = policia;
        this.hora = hora;
        this.partida = Partida.getInstance();
    }

    @Override
    public void handle(ActionEvent event) {
        policia.emitirOrdenArresto();
        partida.evaluarEstado(null);

        if(partida.terminoJuego()) {
            Scene nuevaEscena = null;
            try {
                nuevaEscena = new Scene(new PantallaFinal(stage));
            } catch (NoExisteError | IOException e) {
                e.printStackTrace();
            }
            stage.setScene(nuevaEscena);
        }
        else {
            String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";
            hora.setText(fecha);
        }
    }
}
