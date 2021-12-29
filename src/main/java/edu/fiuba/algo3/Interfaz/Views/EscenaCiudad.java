package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonComputadoraHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonEscenaViajarHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonMenuHandler;
import edu.fiuba.algo3.Interfaz.Controller.VisitarEdificioHandler;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class EscenaCiudad extends AnchorPane {

    Stage stage;
    Policia policia;
    Label pantallaPista;
    Label hora;

    public EscenaCiudad(Stage stage) throws NoExisteError, IOException {
        policia = Partida.getInstance().getPolicia();
        this.setPrefHeight(700);
        this.setPrefWidth(900);
        this.stage = stage;

        setPantallaPista();
        setInfo();
        configurarMenu();
        configurarEdificios();
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
        botonViajar.setOnAction(new BotonEscenaViajarHandler(stage));

        botonMenu.setPrefHeight(100);
        botonMenu.setPrefWidth(200);
        botonMenu.setFont(Font.font(14));

        botonViajar.setPrefHeight(100);
        botonViajar.setPrefWidth(200);
        botonViajar.setFont(Font.font(14));

        botonComputadora.setPrefHeight(100);
        botonComputadora.setPrefWidth(200);
        botonComputadora.setFont(Font.font(14));

        contenedorBotones.getChildren().addAll(botonMenu, botonComputadora, botonViajar);

        this.getChildren().add(contenedorBotones);
    }

    private void configurarEdificios() throws NoExisteError, IOException {
        VBox contenedorCiudades = new VBox();

        contenedorCiudades.setAlignment(Pos.CENTER);
        contenedorCiudades.prefHeight(570);
        contenedorCiudades.prefWidth(550);
        contenedorCiudades.setLayoutX(510);
        contenedorCiudades.setLayoutY(70);
        contenedorCiudades.setSpacing(20);

        Edificios edificios = policia.getPaisActual().getEdificios();
        ArrayList<String> nombres = edificios.nombres();
        String leido;

        for(String nombre : nombres){
            leido = nombre;
            Button boton = new Button(leido);

            boton.setPrefHeight(70);
            boton.setPrefWidth(200);
            boton.setFont(Font.font(16));

            VisitarEdificioHandler visitarHandler = new VisitarEdificioHandler(hora, boton, pantallaPista);
            boton.setOnAction(visitarHandler);

            contenedorCiudades.getChildren().add(boton);
        }

        this.getChildren().add(contenedorCiudades);
    }

    private void setInfo(){
        VBox contenedor = new VBox();
        contenedor.setPrefWidth(300);
        contenedor.setPrefHeight(250);
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setSpacing(10);

        hora = new Label();
        String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";

        hora.setText(fecha);
        hora.setAlignment(Pos.CENTER);
        hora.setFont(Font.font(25));
        hora.setPrefWidth(300);

        contenedor.getChildren().add(hora);


        Label pais = new Label();

        pais.setText("Pais actual: " + policia.getPaisActual().getNombre());
        pais.setFont(Font.font(25));
        pais.setAlignment(Pos.CENTER);
        pais.setPrefWidth(300);

        contenedor.getChildren().add(pais);

        this.getChildren().add(contenedor);
    }

    private void setPantallaPista(){
        pantallaPista = new Label();
        pantallaPista.setFont(Font.font(22));
        pantallaPista.setWrapText(true);

        pantallaPista.setMaxWidth(400);
        pantallaPista.setLayoutX(30);
        pantallaPista.setLayoutY(200);
        this.getChildren().add(pantallaPista);
    }
}
