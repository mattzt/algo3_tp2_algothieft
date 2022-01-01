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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class EscenaMenuPrincipal extends AnchorPane {

    Stage stage;
    Policia policia;
    Partida partida;

    public EscenaMenuPrincipal(Stage stage) throws NoExisteError, IOException {
        partida = Partida.getInstance();
        policia = partida.getPolicia();
        this.stage = stage;
        this.setPrefHeight(700);
        this.setPrefWidth(900);

        setBotones();
        setInfo();
        setObjetoRobado();
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
        botonViajar.setOnAction(new BotonEscenaViajarHandler(stage));

        botonCiudad.setPrefHeight(100);
        botonCiudad.setPrefWidth(200);
        botonCiudad.setFont(Font.font(14));

        botonViajar.setPrefHeight(100);
        botonViajar.setPrefWidth(200);
        botonViajar.setFont(Font.font(14));

        botonComputadora.setPrefHeight(100);
        botonComputadora.setPrefWidth(200);
        botonComputadora.setFont(Font.font(14));

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
}
