package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class EmitirOrdenHandler implements EventHandler<ActionEvent> {

    Policia policia;
    Label hora;
    Stage stage;

    public EmitirOrdenHandler(Stage stage, Policia policia, Label hora){
        this.stage = stage;
        this.policia = policia;
        this.hora = hora;
    }

    @Override
    public void handle(ActionEvent event) {
        policia.emitirOrdenArresto();

        String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";
        hora.setText(fecha);
    }
}
