package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Font;

import java.io.IOException;

public abstract class Controlador{
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

    Label configurarMensajeFinal() throws NoExisteError, IOException {
        partida = Partida.getInstance();
        Label mensajeFinal = new Label();
        Criminal buscado = partida.getCriminalActual();
        Criminal atrapado = partida.arrestar();

        if(atrapado == null)
            mensajeFinal.setText("Perdiste, intentaste arrestar sin orden de arresto!");
        else if(atrapado.equals(buscado))
            mensajeFinal.setText("Felicidades, arrestaste a " + partida.getCriminalActual().getNombre());

        else if(partida.arrestar() != null && !atrapado.equals(buscado))
            mensajeFinal.setText("Perdiste, arrestaste a " + atrapado.getNombre() + "\nPero el criminal era " + buscado.getNombre());

        mensajeFinal.setFont(Font.font(25));
        mensajeFinal.setAlignment(Pos.CENTER);
        mensajeFinal.setLayoutX(50);
        mensajeFinal.setLayoutY(180);

        return mensajeFinal;
    }

    Label configurarSospechosos() throws NoExisteError, IOException {
        partida = Partida.getInstance();
        Label sospechosos = new Label();

        sospechosos.setText("Cantidad de sospechosos: " + partida.cantidadSospechosos());
        sospechosos.setFont(Font.font(14));
        sospechosos.setAlignment(Pos.CENTER);
        sospechosos.setLayoutX(520);
        sospechosos.setLayoutY(520);

        return sospechosos;
    }

    Label configurarPais() throws NoExisteError, IOException {
        partida = Partida.getInstance();
        Label pais = new Label();

        pais.setText("Pais actual: " + partida.paisActual());
        pais.setFont(Font.font(25));
        pais.setAlignment(Pos.CENTER);
        pais.setLayoutX(20);
        pais.setLayoutY(600);

        return pais;
    }
}
