package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonCiudadHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonComputadoraHandler;
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

public class EscenaMenuPrincipal extends AnchorPane {

    Stage stage;
    Policia policia;

    public EscenaMenuPrincipal(Stage stage) throws NoExisteError, IOException {
        policia = Partida.getInstance().getPolicia();
        this.stage = stage;
        this.setPrefHeight(700);
        this.setPrefWidth(900);

        setBotones();
        setHora();
        setPais();
    }

    private void setBotones(){
        HBox contenedorBotones = new HBox();
        contenedorBotones.setPrefHeight(100);
        contenedorBotones.setPrefWidth(550);
        contenedorBotones.setLayoutX(336);
        contenedorBotones.setLayoutY(586);

        Button botonCiudad = new Button("Explorar Ciudad");
        Button botonViajar = new Button("Viajar");
        Button botonComputadora = new Button("ComputadoraInterpol");

        botonCiudad.setOnAction(new BotonCiudadHandler(stage));
        botonComputadora.setOnAction(new BotonComputadoraHandler(stage));

        botonCiudad.setPrefHeight(100);
        botonCiudad.setPrefWidth(200);
        botonViajar.setPrefHeight(100);
        botonViajar.setPrefWidth(200);
        botonComputadora.setPrefHeight(100);
        botonComputadora.setPrefWidth(200);

        contenedorBotones.getChildren().addAll(botonCiudad, botonComputadora, botonViajar);

        this.getChildren().add(contenedorBotones);
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
