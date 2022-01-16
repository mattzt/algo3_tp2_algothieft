package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonSalirHandler;
import edu.fiuba.algo3.Interfaz.Controller.NuevoCasoHandler;
import edu.fiuba.algo3.Interfaz.Views.resources.SeteadorNuevaEscena;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class PantallaFinal extends AnchorPane {

    Stage stage;
    VBox contenedor;
    Partida partida;
    private URL css;

    public PantallaFinal(Stage stage) throws IOException, NoExisteError {
        this.stage = stage;
        this.partida = Partida.getInstance();
        this.setPrefHeight(700);
        this.setPrefWidth(900);

        contenedor = new VBox();

        css = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/darkTheme.css").toURI().toURL();

        SeteadorNuevaEscena seteadorNuevaEscena = new SeteadorNuevaEscena(this);
        seteadorNuevaEscena.setearFondo();

        mostrarMensaje();
        configurarBotones();
    }

    private void configurarBotones(){
        contenedor.setPrefWidth(500);
        contenedor.setPrefHeight(650);
        contenedor.setSpacing(50);
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setLayoutX(200);
        contenedor.setLayoutY(25);

        Button nuevoCaso = new Button("Nuevo caso");
        Button salir = new Button("Salir");

        BotonSalirHandler botonSalirHandler = new BotonSalirHandler(stage);
        NuevoCasoHandler nuevoCasoHandler = new NuevoCasoHandler(stage);

        salir.setOnAction(botonSalirHandler);
        nuevoCaso.setOnAction(nuevoCasoHandler);

        nuevoCaso.setPrefWidth(150);
        nuevoCaso.setPrefHeight(50);

        salir.setPrefWidth(150);
        salir.setPrefHeight(50);

        nuevoCaso.getStylesheets().add(String.valueOf(css));
        salir.getStylesheets().add(String.valueOf(css));

        contenedor.getChildren().addAll(nuevoCaso, salir);

        this.getChildren().add(contenedor);
    }

    private void mostrarMensaje() throws NoExisteError, IOException {
        Label resultado = new Label();
        String mensaje = partida.mensajeFinal();

        URL css = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/darkTheme.css").toURI().toURL();
        resultado.getStylesheets().add(String.valueOf(css));
        resultado.setPrefHeight(200);
        resultado.setPrefWidth(500);
        resultado.setText(mensaje);
        resultado.setWrapText(true);

        contenedor.getChildren().add(resultado);
    }
}
