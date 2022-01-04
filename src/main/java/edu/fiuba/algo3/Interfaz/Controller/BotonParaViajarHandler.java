package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaViajar;
import edu.fiuba.algo3.Interfaz.Views.PantallaFinal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BotonParaViajarHandler implements EventHandler<ActionEvent> {

    Button boton;
    Policia policia;
    Stage stage;
    Partida partida;

    public BotonParaViajarHandler(Button boton, Policia policia, Stage stage) throws NoExisteError, IOException {
        this.boton = boton;
        this.policia = policia;
        this.stage = stage;
        partida = Partida.getInstance();
    }

    @Override
    public void handle(ActionEvent event) {
        Pais destino;
        Paises paises = policia.getPaisActual().getPaisesConexos();
        String nombrePais = boton.getText();
        Scene nuevaEscena = null;

        try {
            destino = paises.buscar(nombrePais);
            policia.viajarApais(destino);
        } catch (NoExisteError | FileNotFoundException e) {
            e.printStackTrace();
        }

        partida.evaluarEstado(null);
        if(partida.terminoJuego()) {
            Label resultado = null;
            try {
                resultado = evaluarResultado();
            } catch (NoExisteError | IOException e) {
                e.printStackTrace();
            }
            nuevaEscena = new Scene(new PantallaFinal(stage, resultado));
            stage.setScene(nuevaEscena);
        }
        else {
            try {
                nuevaEscena = new Scene(new EscenaViajar(stage));
            } catch (NoExisteError | IOException e) {
                e.printStackTrace();
            }
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
