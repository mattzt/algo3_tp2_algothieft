package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.PantallaFinal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.stage.Stage;

import java.io.IOException;

public class EmitirOrdenHandler implements EventHandler<ActionEvent> {

    private final Policia policia;
    private final Label hora;
    private final Stage stage;
    private final Partida partida;
    private final Label orden;

    public EmitirOrdenHandler(Stage stage, Policia policia, Label hora, Label ordenArresto) throws NoExisteError, IOException {
        this.stage = stage;
        this.policia = policia;
        this.hora = hora;
        this.partida = Partida.getInstance();
        this.orden = ordenArresto;
    }

    @Override
    public void handle(ActionEvent event) {
        try {SonidosHandler.sonidoBoton();} catch (Exception e1) {e1.printStackTrace();}
        policia.emitirOrdenArresto();
        policia.dormir();
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

            String ordenArresto = policia.nombreOrden();
            orden.setText("Orden de arresto: " + ordenArresto);
        }
    }
}
