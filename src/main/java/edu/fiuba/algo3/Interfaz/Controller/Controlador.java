package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.IOException;

public abstract class Controlador {
    protected Partida partida;


    Label configurarHora() throws NoExisteError, IOException {
        partida = Partida.getInstance();
        Label hora = new Label();
        hora.setText("Hora inicial:\n" + partida.obtenerMomento().obtenerFecha());
        hora.setLayoutX(23);
        hora.setLayoutY(28);
        hora.setPrefHeight(140);
        hora.setPrefWidth(230);
        hora.setAlignment(Pos.CENTER);
        hora.setFont(Font.font(25));
        hora.setId("hora");

        return hora;
    }
}
