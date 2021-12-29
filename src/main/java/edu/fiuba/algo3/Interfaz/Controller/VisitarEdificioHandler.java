package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;


public class VisitarEdificioHandler implements EventHandler<ActionEvent> {

    Policia policia;
    Button boton;
    RepositorioPistas pistas;
    Label pantallaPista, hora;

    public VisitarEdificioHandler(Label hora, Button boton, Label pantallaPista) throws NoExisteError, IOException {
        this.policia = Partida.getInstance().getPolicia();
        this.boton = boton;
        this.pistas = Partida.getInstance().obtenerPistas();
        this.pantallaPista = pantallaPista;
        this.hora = hora;
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

        obtenida = policia.visitarEdificio(edificio, pistas);
        pantallaPista.setText(obtenida.darPista());

        String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";
        hora.setText(fecha);

    }
}
