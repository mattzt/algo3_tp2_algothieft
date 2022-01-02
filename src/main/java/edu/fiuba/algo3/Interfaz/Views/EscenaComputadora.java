package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.*;
import edu.fiuba.algo3.Interfaz.Views.resources.SeteadorNuevaEscena;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

public class EscenaComputadora extends AnchorPane {

    private final Stage stage;
    private final Policia policia;
    private ComboBox<String> sexo, accesorio, hobbie, pelo, vehiculo;
    private Label cantidadSospechosos;
    private final Label hora;
    private final URL css;

    public EscenaComputadora(Stage stage) throws NoExisteError, IOException {
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

        configurarMenu();
        setearContenedorPrincipal();
    }

    private void configurarMenu() throws MalformedURLException {
        HBox contenedorBotones = new HBox();
        contenedorBotones.setPrefHeight(100);
        contenedorBotones.setPrefWidth(550);
        contenedorBotones.setLayoutX(335);
        contenedorBotones.setLayoutY(586);

        Button botonMenu = new Button("Menu Principal");
        Button botonViajar = new Button("Viajar");
        Button botonCiudad = new Button("Explorar Ciudad");

        botonMenu.setOnAction(new BotonMenuHandler(stage));
        botonCiudad.setOnAction(new BotonCiudadHandler(stage));

        botonMenu.setPrefHeight(100);
        botonMenu.setPrefWidth(200);
        botonMenu.setFont(Font.font(14));

        botonViajar.setPrefHeight(100);
        botonViajar.setPrefWidth(200);
        botonViajar.setFont(Font.font(14));

        botonCiudad.setPrefHeight(100);
        botonCiudad.setPrefWidth(200);
        botonCiudad.setFont(Font.font(14));

        botonMenu.getStylesheets().add(String.valueOf(css));
        botonCiudad.getStylesheets().add(String.valueOf(css));
        botonViajar.getStylesheets().add(String.valueOf(css));

        estiloBotones(botonMenu, botonCiudad, botonViajar);

        contenedorBotones.getChildren().addAll(botonMenu, botonCiudad, botonViajar);

        botonCiudad.setOnAction(new BotonCiudadHandler(stage));
        botonMenu.setOnAction(new BotonMenuHandler(stage));
        botonViajar.setOnAction(new BotonEscenaViajarHandler(stage));

        this.getChildren().add(contenedorBotones);
    }

    private void estiloBotones(Button botonMenu, Button botonCiudad, Button botonViajar) throws MalformedURLException {
        URL ciudad = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/explore.png").toURI().toURL();
        URL viajar = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/viajar.png").toURI().toURL();

        ImageView imagenCiudad = new ImageView(String.valueOf(ciudad));
        ImageView imagenViajar = new ImageView(String.valueOf(viajar));

        imagenCiudad.setFitWidth(100);
        imagenCiudad.setFitHeight(100);
        imagenCiudad.setPickOnBounds(true);
        imagenCiudad.setBlendMode(BlendMode.HARD_LIGHT);
        imagenCiudad.setPreserveRatio(true);

        imagenViajar.setFitWidth(100);
        imagenViajar.setFitHeight(100);
        imagenViajar.setPickOnBounds(true);
        imagenViajar.setBlendMode(BlendMode.HARD_LIGHT);
        imagenViajar.setPreserveRatio(true);

        botonCiudad.setContentDisplay(ContentDisplay.TOP);
        botonViajar.setContentDisplay(ContentDisplay.TOP);

        botonCiudad.setGraphic(imagenCiudad);
        botonViajar.setGraphic(imagenViajar);
    }

    private void agregarSexo(VBox contenedorPrincipal){
        HBox opcionSexo = new HBox();
        opcionSexo.setAlignment(Pos.CENTER);
        opcionSexo.setPrefHeight(110);
        opcionSexo.setPrefWidth(550);
        opcionSexo.setSpacing(20);

        sexo = new ComboBox<>();
        sexo.setPrefWidth(200);
        sexo.setPrefHeight(30);
        sexo.setPromptText("Sexo");

        sexo.getItems().addAll(null, "Masculino", "Femenino");
        sexo.getStylesheets().add(String.valueOf(css));

        opcionSexo.getChildren().add(sexo);
        contenedorPrincipal.getChildren().add(opcionSexo);
    }

    private void agregarAccesorios(VBox contenedorPrincipal){
        HBox opcionAccesorios = new HBox();
        opcionAccesorios.setAlignment(Pos.CENTER);
        opcionAccesorios.setPrefHeight(110);
        opcionAccesorios.setPrefWidth(550);
        opcionAccesorios.setSpacing(20);

        accesorio = new ComboBox<>();
        accesorio.setPrefWidth(200);
        accesorio.setPrefHeight(30);
        accesorio.setPromptText("Accesorio");

        accesorio.getItems().addAll(null, "Anillo", "Tatuaje", "Joyas", "Cicatriz");
        accesorio.getStylesheets().add(String.valueOf(css));

        opcionAccesorios.getChildren().add(accesorio);
        contenedorPrincipal.getChildren().add(opcionAccesorios);
    }

    private void agregarHobbie(VBox contenedorPrincipal){
        HBox opcionHobbie = new HBox();
        opcionHobbie.setAlignment(Pos.CENTER);
        opcionHobbie.setPrefHeight(110);
        opcionHobbie.setPrefWidth(550);
        opcionHobbie.setSpacing(20);

        hobbie = new ComboBox<>();
        hobbie.setPrefWidth(200);
        hobbie.setPrefHeight(30);
        hobbie.setPromptText("Hobbie");

        hobbie.getItems().addAll(null, "Alpinismo", "Croquet", "Musica", "Natacion", "Paracaidismo", "Tenis");
        hobbie.getStylesheets().add(String.valueOf(css));

        opcionHobbie.getChildren().add(hobbie);
        contenedorPrincipal.getChildren().add(opcionHobbie);
    }

    private void agregarPelo(VBox contenedorPrincipal){
        HBox opcionPelo = new HBox();
        opcionPelo.setAlignment(Pos.CENTER);
        opcionPelo.setPrefHeight(110);
        opcionPelo.setPrefWidth(550);
        opcionPelo.setSpacing(20);

        pelo = new ComboBox<>();
        pelo.setPrefWidth(200);
        pelo.setPrefHeight(30);
        pelo.setPromptText("Pelo");

        pelo.getItems().addAll(null, "Castanio", "Negro", "Rubio", "Rojo");
        pelo.getStylesheets().add(String.valueOf(css));

        opcionPelo.getChildren().add(pelo);
        contenedorPrincipal.getChildren().add(opcionPelo);
    }

    private void agregarVehiculo(VBox contenedorPrincipal){
        HBox opcionVehiculo = new HBox();
        opcionVehiculo.setAlignment(Pos.CENTER);
        opcionVehiculo.setPrefHeight(110);
        opcionVehiculo.setPrefWidth(550);
        opcionVehiculo.setSpacing(20);

        vehiculo = new ComboBox<>();
        vehiculo.setPrefWidth(200);
        vehiculo.setPrefHeight(30);
        vehiculo.setPromptText("Vehiculo");

        vehiculo.getItems().addAll(null, "Deportivo", "Descapotable", "Moto", "Limusina");
        vehiculo.getStylesheets().add(String.valueOf(css));

        opcionVehiculo.getChildren().add(vehiculo);
        contenedorPrincipal.getChildren().add(opcionVehiculo);

    }

    private void setearContenedorPrincipal() throws NoExisteError, IOException {
        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setLayoutX(336);
        contenedorPrincipal.setLayoutY(6);
        contenedorPrincipal.setPrefHeight(570);
        contenedorPrincipal.setPrefWidth(550);

        Label filtrarSospechosos = new Label("Filtrar sospechosos");
        filtrarSospechosos.setFont(Font.font(24));
        filtrarSospechosos.setTextFill(Paint.valueOf("WHITE"));
        contenedorPrincipal.getChildren().add(filtrarSospechosos);

        agregarSexo(contenedorPrincipal);
        agregarAccesorios(contenedorPrincipal);
        agregarHobbie(contenedorPrincipal);
        agregarPelo(contenedorPrincipal);
        agregarVehiculo(contenedorPrincipal);

        cantidadSospechosos = new Label("Cantidad de sospechosos: " + policia.cantidadSospechosos());
        cantidadSospechosos.setFont(Font.font(16));
        cantidadSospechosos.setTextFill(Paint.valueOf("WHITE"));
        contenedorPrincipal.getChildren().add(cantidadSospechosos);

        setearBotonesPolicia(contenedorPrincipal);


        this.getChildren().add(contenedorPrincipal);
    }

    private void setearBotonesPolicia(VBox contenedor) throws NoExisteError, IOException {
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(20);
        opciones.setPrefHeight(100);
        opciones.setPrefWidth(200);

        Button resetFiltros = new Button("Resetear filtros");
        Button emitirOrden = new Button("Emitir orden");
        Button arrestar = new Button("Arrestar");
        Button filtrar = new Button("Filtrar");

        resetFiltros.setFont(Font.font(14));
        emitirOrden.setFont(Font.font(14));
        arrestar.setFont(Font.font(14));
        filtrar.setFont(Font.font(14));

        resetFiltros.getStylesheets().add(String.valueOf(css));
        emitirOrden.getStylesheets().add(String.valueOf(css));
        arrestar.getStylesheets().add(String.valueOf(css));
        filtrar.getStylesheets().add(String.valueOf(css));

        ArrayList<ComboBox<String>> listaOpciones = new ArrayList<>();
        listaOpciones.add(sexo);
        listaOpciones.add(accesorio);
        listaOpciones.add(hobbie);
        listaOpciones.add(pelo);
        listaOpciones.add(vehiculo);

        ResetearFiltrosHandler resetHandler = new ResetearFiltrosHandler(cantidadSospechosos, policia);
        FiltrarHandler filtrarHandler = new FiltrarHandler(listaOpciones, cantidadSospechosos, policia);
        EmitirOrdenHandler ordenHandler = new EmitirOrdenHandler(stage, policia, hora);
        ArrestarHandler arrestarHandler = new ArrestarHandler(stage);


        resetFiltros.setOnAction(resetHandler);
        filtrar.setOnAction(filtrarHandler);
        emitirOrden.setOnAction(ordenHandler);
        arrestar.setOnAction(arrestarHandler);

        opciones.getChildren().addAll(resetFiltros, emitirOrden, arrestar, filtrar);

        contenedor.getChildren().add(opciones);
    }

}
