package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonComputadoraHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonEscenaViajarHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonMenuHandler;
import edu.fiuba.algo3.Interfaz.Controller.VisitarEdificioHandler;
import edu.fiuba.algo3.Interfaz.Views.resources.SeteadorNuevaEscena;
import edu.fiuba.algo3.modelo.Edificios.Edificios;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
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

public class EscenaCiudad extends AnchorPane {

    private final Stage stage;
    private final Policia policia;
    private Label pantallaPista;
    private final Label hora;
    private final URL css;

    public EscenaCiudad(Stage stage) throws NoExisteError, IOException {
        policia = Partida.getInstance().getPolicia();
        this.setPrefHeight(700);
        this.setPrefWidth(900);
        this.stage = stage;

        css = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/darkTheme.css").toURI().toURL();

        SeteadorNuevaEscena seteadorNuevaEscena = new SeteadorNuevaEscena(this);
        seteadorNuevaEscena.setearFondo();

        hora = new Label();
        Label pais = new Label();

        seteadorNuevaEscena.setInfo(policia, hora, pais);

        setPantallaPista();
        configurarEdificios();
        configurarMenu();
    }

    private void configurarMenu() throws MalformedURLException {
        HBox contenedorBotones = new HBox();
        contenedorBotones.setPrefHeight(100);
        contenedorBotones.setPrefWidth(550);
        contenedorBotones.setLayoutX(335);
        contenedorBotones.setLayoutY(586);

        Button botonMenu = new Button("Menu Principal");
        Button botonViajar = new Button("Viajar");
        Button botonComputadora = new Button("Interpol");

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

        botonMenu.getStylesheets().add(String.valueOf(css));
        botonViajar.getStylesheets().add(String.valueOf(css));
        botonComputadora.getStylesheets().add(String.valueOf(css));

        estiloBotones(botonMenu, botonViajar, botonComputadora);

        contenedorBotones.getChildren().addAll(botonMenu, botonComputadora, botonViajar);

        this.getChildren().add(contenedorBotones);
    }

    private void estiloBotones(Button botonMenu, Button botonViajar, Button botonComputadora) throws MalformedURLException {
        URL viajar = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/viajar.png").toURI().toURL();
        URL computadora = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/interpol.png").toURI().toURL();

        ImageView imagenViajar = new ImageView(String.valueOf(viajar));
        ImageView imagenComputadora = new ImageView(String.valueOf(computadora));

        imagenViajar.setFitWidth(100);
        imagenViajar.setFitHeight(100);
        imagenViajar.setPickOnBounds(true);
        imagenViajar.setBlendMode(BlendMode.HARD_LIGHT);
        imagenViajar.setPreserveRatio(true);

        imagenComputadora.setFitWidth(100);
        imagenComputadora.setFitHeight(100);
        imagenComputadora.setPickOnBounds(true);
        imagenComputadora.setBlendMode(BlendMode.HARD_LIGHT);
        imagenComputadora.setPreserveRatio(true);

        botonViajar.setContentDisplay(ContentDisplay.TOP);
        botonComputadora.setContentDisplay(ContentDisplay.TOP);

        botonViajar.setGraphic(imagenViajar);
        botonComputadora.setGraphic(imagenComputadora);
    }

    private void configurarEdificios() throws NoExisteError, IOException {
        VBox contenedorCiudades = new VBox();

        contenedorCiudades.setAlignment(Pos.CENTER);
        contenedorCiudades.prefHeight(570);
        contenedorCiudades.prefWidth(550);
        contenedorCiudades.setLayoutX(510);
        contenedorCiudades.setLayoutY(70);
        contenedorCiudades.setSpacing(20);

        ArrayList<String> nombres = new ArrayList<>();
        nombres.add("Aeropuerto");
        nombres.add("Banco");
        nombres.add("Biblioteca");
        nombres.add("Bolsa");
        nombres.add("Puerto");

        String leido;

        for(String nombre : nombres){
            leido = nombre;
            Button boton = new Button(leido);

            boton.setPrefHeight(70);
            boton.setPrefWidth(200);
            boton.setFont(Font.font(16));

            VisitarEdificioHandler visitarHandler = new VisitarEdificioHandler(hora, boton, pantallaPista, stage);
            boton.setOnAction(visitarHandler);
            boton.getStylesheets().add(String.valueOf(css));

            contenedorCiudades.getChildren().add(boton);
        }

        this.getChildren().add(contenedorCiudades);
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
