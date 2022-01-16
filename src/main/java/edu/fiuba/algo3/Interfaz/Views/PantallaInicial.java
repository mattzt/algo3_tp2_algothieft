package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonLogInHandler;
import edu.fiuba.algo3.Interfaz.Controller.TextoLogInHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class PantallaInicial extends AnchorPane {

    Stage stage;

    public PantallaInicial(Stage stage) throws MalformedURLException {
        this.stage = stage;
        crearContenedorPrincipal();

        inicializarRectangulos();
        insertarImagen();
        inicializarTextos();
        crearLogIn();
    }

    private void crearContenedorPrincipal(){
        this.setPrefHeight(317);
        this.setPrefWidth(600);

        this.setStyle("-fx-background-color: #000000; -fx-border-color: #ffffffff; -fx-border-radius: 5;");
    }

    private void inicializarRectangulos() {
        Rectangle rectangulo1 = new Rectangle();
        rectangulo1.setArcHeight(20);
        rectangulo1.setArcWidth(20);
        rectangulo1.setHeight(87);
        rectangulo1.setWidth(328);
        rectangulo1.setLayoutX(24);
        rectangulo1.setLayoutY(60);
        rectangulo1.setStroke(Paint.valueOf("BLACK"));
        rectangulo1.setStrokeType(StrokeType.INSIDE);
        rectangulo1.setFill(Paint.valueOf("#ffffffe3"));

        Rectangle rectangulo2 = new Rectangle();
        rectangulo2.setArcHeight(20);
        rectangulo2.setArcWidth(20);
        rectangulo2.setHeight(169);
        rectangulo2.setWidth(195);
        rectangulo2.setLayoutX(392);
        rectangulo2.setLayoutY(21);
        rectangulo2.setStroke(Paint.valueOf("WHITE"));
        rectangulo2.setStrokeType(StrokeType.INSIDE);
        rectangulo2.setFill(Paint.valueOf("#ffffffe3"));

        this.getChildren().addAll(rectangulo1, rectangulo2);
    }

    private void insertarImagen() throws MalformedURLException {
        URL url = new File("src/main/java/edu/fiuba/algo3/modelo/Resources/Img/interpolLogo.png").toURI().toURL();
        ImageView imagen = new ImageView(String.valueOf(url));
        imagen.setFitHeight(130);
        imagen.setFitHeight(180);
        imagen.setLayoutX(393);
        imagen.setLayoutY(15);
        imagen.setPickOnBounds(true);
        imagen.setPreserveRatio(true);

        this.getChildren().add(imagen);
    }

    private void inicializarTextos(){
        Text texto1 = new Text("POLICE");
        texto1.setFill(Paint.valueOf("#1e3561"));
        texto1.setLayoutX(24);
        texto1.setLayoutY(140);
        texto1.setStroke(Paint.valueOf("#ffffffe3"));
        texto1.setStrokeLineCap(StrokeLineCap.ROUND);
        texto1.setStrokeLineJoin(StrokeLineJoin.ROUND);
        texto1.setStrokeType(StrokeType.OUTSIDE);
        texto1.setStrokeWidth(0);
        texto1.setTextAlignment(TextAlignment.CENTER);
        texto1.setWrappingWidth(328);
        texto1.setFont(Font.font("Nirmala UI Bold", 96));

        this.getChildren().add(texto1);

        Text texto2 = new Text("Bienvenido a la oficina virtual de la interpol");
        texto2.setFill(Paint.valueOf("WHITE"));
        texto2.setLayoutX(24);
        texto2.setLayoutY(240);
        texto2.setStrokeType(StrokeType.OUTSIDE);
        texto2.setStrokeWidth(0);
        texto2.setWrappingWidth(353.47265625);
        texto2.setFont(Font.font(17));

        this.getChildren().add(texto2);

        Text texto3 = new Text("Ingrese su nombre de agente");
        texto3.setFill(Paint.valueOf("WHITE"));
        texto3.setLayoutX(24);
        texto3.setLayoutY(267);
        texto3.setStrokeType(StrokeType.OUTSIDE);
        texto3.setStrokeWidth(0);
        texto3.setTextAlignment(TextAlignment.CENTER);
        texto3.setFont(Font.font(17));

        this.getChildren().add(texto3);
    }

    private void crearLogIn(){
        Button botonLog = new Button("Log In");
        botonLog.setLayoutX(438);
        botonLog.setLayoutY(246);
        botonLog.setMnemonicParsing(false);

        TextField cuadroDeTexto = new TextField();
        cuadroDeTexto.setAlignment(Pos.CENTER);
        cuadroDeTexto.setLayoutX(266);
        cuadroDeTexto.setLayoutY(248);
        cuadroDeTexto.setPromptText("Nombre Agente");

        BotonLogInHandler logInHandler = new BotonLogInHandler(stage, cuadroDeTexto);
        TextoLogInHandler textoLogInHandler = new TextoLogInHandler(stage, cuadroDeTexto);

        botonLog.setOnAction(logInHandler);
        cuadroDeTexto.setOnKeyPressed(textoLogInHandler);

        this.getChildren().addAll(botonLog, cuadroDeTexto);
    }
}
