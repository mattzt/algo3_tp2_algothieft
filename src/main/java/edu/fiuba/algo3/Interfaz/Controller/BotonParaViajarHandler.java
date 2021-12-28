package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaViajar;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BotonParaViajarHandler implements EventHandler<ActionEvent> {

    Button boton;
    Policia policia;
    Stage stage;

    public BotonParaViajarHandler(Button boton, Policia policia, Stage stage){
        this.boton = boton;
        this.policia = policia;
        this.stage = stage;
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

        try {
            nuevaEscena = new Scene(new EscenaViajar(stage));
        } catch (NoExisteError | IOException e) {
            e.printStackTrace();
        }
        stage.setScene(nuevaEscena);
    }
}
