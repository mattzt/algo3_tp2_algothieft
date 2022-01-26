package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.PantallaFinal;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class VisitarEdificioHandler implements EventHandler<ActionEvent> {

    private final Policia policia;
    private final Button boton;
    private final Label pantallaPista;
    private final Label hora;
    private final Partida partida;
    private final Stage stage;

    public VisitarEdificioHandler(Label hora, Button boton, Label pantallaPista, Stage stage) throws NoExisteError, IOException {
        this.boton = boton;
        this.pantallaPista = pantallaPista;
        this.hora = hora;
        partida = Partida.getInstance();
        this.policia = partida.getPolicia();
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        String nombreEdificio = boton.getText();
        Pista obtenida;
        Edificio edificio = null;

        switch (nombreEdificio) {
            case "Aeropuerto":
                edificio = new Aeropuerto();
                break;
            case "Banco":
                edificio = new Banco();
                break;
            case "Biblioteca":
                edificio = new Biblioteca();
                break;
            case "Bolsa":
                edificio = new Bolsa();
                break;
            case "Puerto":
                edificio = new Puerto();
                break;
        }
        try {SonidosHandler.sonidoBoton();} catch (Exception e1) {e1.printStackTrace();}
        obtenida = policia.visitarEdificio(edificio, partida.obtenerPistas());
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
            pantallaPista.setText(obtenida.darPista());
            pantallaPista.setTextFill(Paint.valueOf("WHITE"));

            String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";
            hora.setText(fecha);
        }
    }
}
