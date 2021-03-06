package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.Interfaz.Views.EscenaMenuPrincipal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NuevoCasoHandler implements EventHandler<ActionEvent> {

    private final Stage stage;

    public NuevoCasoHandler(Stage stage){
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent event) {
        try {SonidosHandler.sonidoBoton();} catch (Exception e1) {e1.printStackTrace();}
        Partida partida = null;
        try {
            partida = Partida.getInstance();
        } catch (NoExisteError | IOException e) {
            e.printStackTrace();
        }
        try {
            partida.nuevoCaso();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Scene nuevaEscena = null;
        try {
            nuevaEscena =  new Scene(new EscenaMenuPrincipal(stage));
        } catch (NoExisteError | IOException e) {
            e.printStackTrace();
        }
        stage.setScene(nuevaEscena);


    }
}
