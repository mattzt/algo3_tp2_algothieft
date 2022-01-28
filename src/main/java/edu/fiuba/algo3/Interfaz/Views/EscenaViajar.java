package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonCiudadHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonComputadoraHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonMenuHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonParaViajarHandler;
import edu.fiuba.algo3.Interfaz.Views.resources.SeteadorNuevaEscena;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class EscenaViajar extends AnchorPane {

    private final Stage stage;
    private final Policia policia;
    private final URL css;
    private final Partida partida;

    public EscenaViajar(Stage stage) throws NoExisteError, IOException {
        this.stage = stage;
        this.setPrefHeight(700);
        this.setPrefWidth(900);
        partida = Partida.getInstance();
        policia = partida.getPolicia();

        css = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/darkTheme.css").toURI().toURL();

        SeteadorNuevaEscena seteadorNuevaEscena = new SeteadorNuevaEscena(this);
        seteadorNuevaEscena.setearFondo();

        Label hora = new Label();
        Label pais = new Label();
        seteadorNuevaEscena.setInfo(policia, hora, pais);

        configurarMenu();
        setBotonesPaises();
    }

    private void configurarMenu() throws MalformedURLException {
        HBox contenedorBotones = new HBox();
        contenedorBotones.setPrefHeight(100);
        contenedorBotones.setPrefWidth(550);
        contenedorBotones.setLayoutX(335);
        contenedorBotones.setLayoutY(586);

        Button botonMenu = new Button("Menu Principal");
        Button botonCiudad = new Button("Explorar Ciudad");
        Button botonComputadora = new Button("Interpol");

        botonComputadora.setOnAction(new BotonComputadoraHandler(stage));
        botonMenu.setOnAction(new BotonMenuHandler(stage));
        botonCiudad.setOnAction(new BotonCiudadHandler(stage));

        botonMenu.setPrefHeight(100);
        botonMenu.setPrefWidth(200);
        botonMenu.setFont(Font.font(14));

        botonCiudad.setPrefHeight(100);
        botonCiudad.setPrefWidth(200);
        botonCiudad.setFont(Font.font(14));

        botonComputadora.setPrefHeight(100);
        botonComputadora.setPrefWidth(200);
        botonComputadora.setFont(Font.font(14));

        botonCiudad.getStylesheets().add(String.valueOf(css));
        botonMenu.getStylesheets().add(String.valueOf(css));
        botonComputadora.getStylesheets().add(String.valueOf(css));

        estiloBotones(botonCiudad, botonMenu, botonComputadora);

        contenedorBotones.getChildren().addAll(botonMenu, botonComputadora, botonCiudad);

        this.getChildren().add(contenedorBotones);
    }

    private void estiloBotones(Button botonCiudad, Button botonMenu, Button botonComputadora) throws MalformedURLException {
        URL ciudad = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/explore.png").toURI().toURL();
        URL computadora = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/interpol.png").toURI().toURL();

        ImageView imagenCiudad = new ImageView(String.valueOf(ciudad));
        ImageView imagenComputadora = new ImageView(String.valueOf(computadora));

        imagenCiudad.setFitWidth(100);
        imagenCiudad.setFitHeight(100);
        imagenCiudad.setPickOnBounds(true);
        imagenCiudad.setBlendMode(BlendMode.HARD_LIGHT);
        imagenCiudad.setPreserveRatio(true);

        imagenComputadora.setFitWidth(100);
        imagenComputadora.setFitHeight(100);
        imagenComputadora.setPickOnBounds(true);
        imagenComputadora.setBlendMode(BlendMode.HARD_LIGHT);
        imagenComputadora.setPreserveRatio(true);

        botonCiudad.setContentDisplay(ContentDisplay.TOP);
        botonComputadora.setContentDisplay(ContentDisplay.TOP);

        botonCiudad.setGraphic(imagenCiudad);
        botonComputadora.setGraphic(imagenComputadora);
    }

    private void setBotonesPaises() throws NoExisteError, IOException {
        Paises paisesParaViajar = policia.getPaisActual().getPaisesConexos();
        ArrayList<String> paises = paisesParaViajar.obtenerNombres();

        VBox contenedor = new VBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setPrefHeight(570);
        contenedor.setPrefWidth(550);
        contenedor.setLayoutX(336);
        contenedor.setLayoutY(6);
        contenedor.setSpacing(30);


        for(String pais : paises){
            Button boton = new Button(pais);
            BotonParaViajarHandler viajarHandler = new BotonParaViajarHandler(boton, policia, stage);

            boton.setPrefHeight(80);
            boton.setPrefWidth(200);
            boton.setFont(Font.font(16));
            boton.setOnAction(viajarHandler);
            boton.getStylesheets().add(String.valueOf(css));
            contenedor.getChildren().add(boton);

        }

        if(partida.estaEnUltimoPais()){
            Label avisoDanio = new Label("Un criminal te ha atacado!!! Tuviste que recuperarte por un par de horas");
            avisoDanio.setWrapText(true);
            avisoDanio.setFont(Font.font(22));
            avisoDanio.setTextFill(Paint.valueOf("WHITE"));

            avisoDanio.setLayoutX(30);
            avisoDanio.setLayoutY(200);
            avisoDanio.setMaxWidth(400);

            this.getChildren().add(avisoDanio);
        }

        this.getChildren().add(contenedor);
    }
}
