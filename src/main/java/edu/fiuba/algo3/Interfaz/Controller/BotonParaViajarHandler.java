package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaViajar;
import edu.fiuba.algo3.Interfaz.Views.PantallaFinal;
import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Randomizador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BotonParaViajarHandler implements EventHandler<ActionEvent> {

    private final Button boton;
    private final Policia policia;
    private final Stage stage;
    private final Partida partida;

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
            SonidosHandler.sonidoBoton();
        } catch (NoExisteError | UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }

        if(partida.estaEnUltimoPais()) {
            Arma armaRandom = Randomizador.armaRandom();
            policia.recibirDanio(armaRandom);
        }

        partida.evaluarEstado(null);
        if(partida.terminoJuego()) {
            try {
                nuevaEscena = new Scene(new PantallaFinal(stage));
            } catch (NoExisteError | IOException e) {
                e.printStackTrace();
            }
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
}
