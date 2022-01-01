package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonCiudadHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonComputadoraHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonEscenaViajarHandler;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class EscenaMenuPrincipal extends AnchorPane {

    private final Stage stage;
    private final Policia policia;
    private final Partida partida;

    public EscenaMenuPrincipal(Stage stage) throws NoExisteError, IOException {
        partida = Partida.getInstance();
        policia = partida.getPolicia();
        this.stage = stage;
        this.setPrefHeight(700);
        this.setPrefWidth(900);

        configurarEstilo();
        setBotones();
        setInfo();
        setObjetoRobado();
    }

    private void setBotones() throws MalformedURLException {
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
        botonViajar.setOnAction(new BotonEscenaViajarHandler(stage));

        botonCiudad.setPrefHeight(100);
        botonCiudad.setPrefWidth(183);
        botonCiudad.setFont(Font.font(14));

        botonViajar.setPrefHeight(100);
        botonViajar.setPrefWidth(183);
        botonViajar.setFont(Font.font(14));

        botonComputadora.setPrefHeight(100);
        botonComputadora.setPrefWidth(183);
        botonComputadora.setFont(Font.font(14));

        URL css = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/darkTheme.css").toURI().toURL();

        botonCiudad.getStylesheets().add(String.valueOf(css));
        botonViajar.getStylesheets().add(String.valueOf(css));
        botonComputadora.getStylesheets().add(String.valueOf(css));

        URL ciudad = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/explore.png").toURI().toURL();
        URL viajar = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/viajar.png").toURI().toURL();
        URL computadora = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/buttons/interpol.png").toURI().toURL();

        ImageView imagenCiudad = new ImageView(String.valueOf(ciudad));
        ImageView imagenViajar = new ImageView(String.valueOf(viajar));
        ImageView imagenComputadora = new ImageView(String.valueOf(computadora));

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

        imagenComputadora.setFitWidth(100);
        imagenComputadora.setFitHeight(100);
        imagenComputadora.setPickOnBounds(true);
        imagenComputadora.setBlendMode(BlendMode.HARD_LIGHT);
        imagenComputadora.setPreserveRatio(true);

        botonCiudad.setGraphic(imagenCiudad);
        botonViajar.setGraphic(imagenViajar);
        botonComputadora.setGraphic(imagenComputadora);

        contenedorBotones.getChildren().addAll(botonCiudad, botonComputadora, botonViajar);

        this.getChildren().add(contenedorBotones);
    }

    private void setInfo(){
        VBox contenedor = new VBox();
        contenedor.setPrefWidth(300);
        contenedor.setPrefHeight(250);
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setSpacing(10);

        Label hora = new Label();
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

    private void setObjetoRobado(){
        VBox contenedor = new VBox();
        contenedor.setPrefWidth(400);
        contenedor.setPrefHeight(400);
        contenedor.setLayoutX(350);
        contenedor.setLayoutY(150);
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setSpacing(50);


        Label objetoRobado = new Label();

        objetoRobado.setText("Objeto robado: " + partida.nombreObjetoRobado());
        objetoRobado.setWrapText(true);
        objetoRobado.setFont(Font.font(25));
        objetoRobado.setAlignment(Pos.TOP_CENTER);
        objetoRobado.setPrefWidth(400);

        contenedor.getChildren().add(objetoRobado);

        Label mensaje = new Label("Tenes hasta el domingo a las 17hs para encontrar al culpable. Buena suerte!");
        mensaje.setWrapText(true);
        mensaje.setFont(Font.font(23));
        mensaje.setPrefWidth(400);

        contenedor.getChildren().add(mensaje);

        this.getChildren().add(contenedor);
    }

    private void configurarEstilo() throws MalformedURLException {
        this.setStyle("-fx-background-color: grey;");


        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/background.jpg").toURI().toURL();
        ImageView fondo = new ImageView(String.valueOf(url));
        fondo.setBlendMode(BlendMode.MULTIPLY);
        fondo.setFitHeight(566);
        fondo.setFitWidth(900);
        fondo.setLayoutY(-32);
        fondo.setPickOnBounds(true);
        fondo.setPreserveRatio(true);
        fondo.setScaleY(1.26);
        fondo.setStyle("-fx-translate-y: 100;");

        this.getChildren().add(fondo);

    }
}
