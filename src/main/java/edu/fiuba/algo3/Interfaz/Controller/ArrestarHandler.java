package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.PantallaFinal;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
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
        Criminal atrapado = policia.arrestar();
        partida.evaluarEstado(atrapado);

        if(partida.terminoJuego()) {
            Label resultado = null;
            try {
                resultado = evaluarResultado();
            } catch (NoExisteError | IOException e) {
                e.printStackTrace();
            }
            Scene nuevaEscena = new Scene(new PantallaFinal(stage, resultado));
            stage.setScene(nuevaEscena);
        }
    }

    private Label evaluarResultado() throws NoExisteError, IOException {
        Label resultado = new Label();
        String mensaje = partida.mensajeFinal();


        resultado.setText(mensaje);
        resultado.setFont(Font.font(25));
        resultado.setWrapText(true);
        return resultado;
    }
}