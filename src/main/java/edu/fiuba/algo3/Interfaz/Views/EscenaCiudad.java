package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonComputadoraHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonMenuHandler;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class EscenaCiudad extends AnchorPane {

    Stage stage;
    Policia policia;

    public EscenaCiudad(Stage stage) throws NoExisteError, IOException {
        policia = Partida.getInstance().getPolicia();
        this.setPrefHeight(700);
        this.setPrefWidth(900);
        this.stage = stage;

        configurarMenu();
        configurarEdificios();
        setHora();
        setPais();
    }

    private void configurarMenu(){
        HBox contenedorBotones = new HBox();
        contenedorBotones.setPrefHeight(100);
        contenedorBotones.setPrefWidth(550);
        contenedorBotones.setLayoutX(335);
        contenedorBotones.setLayoutY(586);

        Button botonMenu = new Button("Menu Principal");
        Button botonViajar = new Button("Viajar");
        Button botonComputadora = new Button("Computadora Interpol");

        botonComputadora.setOnAction(new BotonComputadoraHandler(stage));
        botonMenu.setOnAction(new BotonMenuHandler(stage));

        botonMenu.setPrefHeight(100);
        botonMenu.setPrefWidth(200);
        botonViajar.setPrefHeight(100);
        botonViajar.setPrefWidth(200);
        botonComputadora.setPrefHeight(100);
        botonComputadora.setPrefWidth(200);

        contenedorBotones.getChildren().addAll(botonMenu, botonComputadora, botonViajar);

        this.getChildren().add(contenedorBotones);
    }

    private void configurarEdificios(){
        HBox contenedorCiudades = new HBox();
        contenedorCiudades.setAlignment(Pos.CENTER);
        contenedorCiudades.setLayoutX(335);
        contenedorCiudades.setLayoutY(429);
        contenedorCiudades.prefHeight(100);
        contenedorCiudades.prefWidth(550);
        contenedorCiudades.setSpacing(50);

        Button botonAeropuerto = new Button("Aeropuerto");
        Button botonBanco = new Button("Banco");
        Button botonBiblioteca = new Button("Biblioteca");
        Button botonBolsa = new Button("Bolsa");
        Button botonPuerto = new Button("Puerto");

        contenedorCiudades.getChildren().addAll(botonAeropuerto, botonBanco, botonBolsa, botonPuerto, botonBiblioteca);

        this.getChildren().add(contenedorCiudades);
    }

    private void setHora(){
        Label hora = new Label();
        String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";

        hora.setText(fecha);
        hora.setLayoutX(23);
        hora.setLayoutY(28);
        hora.setPrefHeight(140);
        hora.setPrefWidth(230);
        hora.setAlignment(Pos.CENTER);
        hora.setFont(Font.font(25));

        this.getChildren().add(hora);
    }

    private void setPais(){
        Label pais = new Label();

        pais.setText("Pais actual: " + policia.getPaisActual().getNombre());
        pais.setFont(Font.font(25));
        pais.setAlignment(Pos.CENTER);
        pais.setLayoutX(20);
        pais.setLayoutY(600);

        this.getChildren().add(pais);
    }
}
