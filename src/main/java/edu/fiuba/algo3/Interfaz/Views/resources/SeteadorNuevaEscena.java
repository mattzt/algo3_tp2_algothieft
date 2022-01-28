package edu.fiuba.algo3.Interfaz.Views.resources;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class SeteadorNuevaEscena {

    private final AnchorPane root;

    public SeteadorNuevaEscena(AnchorPane root){
        this.root = root;
    }

    public void setearFondo() throws MalformedURLException {
        root.setStyle("-fx-background-color: grey;");

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

        root.getChildren().add(fondo);
    }

    public void setInfo(Policia policia, Label hora, Label pais) throws MalformedURLException {
        URL css = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/resources/darkTheme.css").toURI().toURL();

        VBox contenedor = new VBox();
        contenedor.setPrefWidth(300);
        contenedor.setPrefHeight(250);
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setSpacing(20);

        String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";

        hora.setText(fecha);
        hora.setAlignment(Pos.CENTER);
        hora.setFont(Font.font(25));
        hora.setPrefWidth(280);
        hora.setPrefHeight(50);
        hora.setTextFill(Paint.valueOf("WHITE"));

        contenedor.getChildren().add(hora);

        pais.setText("Pais actual: " + policia.getPaisActual().getNombre());
        pais.setFont(Font.font(25));
        pais.setAlignment(Pos.CENTER);
        pais.setPrefWidth(280);
        pais.setPrefHeight(50);
        pais.setTextFill(Paint.valueOf("WHITE"));

        contenedor.getStylesheets().add(String.valueOf(css));
        contenedor.getChildren().add(pais);

        root.getChildren().add(contenedor);

        VBox infoAgente = new VBox();
        infoAgente.setLayoutX(80);
        infoAgente.setLayoutY(600);

        Label nombreAgente = new Label("Agente: " + policia.getNombre() + "\n Rango: " + policia.getRango().getNombre());
        nombreAgente.getStylesheets().add(String.valueOf(css));
        nombreAgente.setTextFill(Paint.valueOf("WHITE"));

        infoAgente.getChildren().add(nombreAgente);

        root.getChildren().add(infoAgente);
    }
}
