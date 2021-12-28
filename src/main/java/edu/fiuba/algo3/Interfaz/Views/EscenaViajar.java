package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonCiudadHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonComputadoraHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonMenuHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonParaViajarHandler;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
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

public class EscenaViajar extends AnchorPane {

    Stage stage;
    Policia policia;

    public EscenaViajar(Stage stage) throws NoExisteError, IOException {
        this.stage = stage;
        this.setPrefHeight(700);
        this.setPrefWidth(900);
        policia = Partida.getInstance().getPolicia();

        configurarMenu();
        setBotonesPaises();
        setInfo();
        setBotonesPaises();
    }

    private void configurarMenu(){
        HBox contenedorBotones = new HBox();
        contenedorBotones.setPrefHeight(100);
        contenedorBotones.setPrefWidth(550);
        contenedorBotones.setLayoutX(335);
        contenedorBotones.setLayoutY(586);

        Button botonMenu = new Button("Menu Principal");
        Button botonCiudad = new Button("Explorar Ciudad");
        Button botonComputadora = new Button("Computadora Interpol");

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

        contenedorBotones.getChildren().addAll(botonMenu, botonComputadora, botonCiudad);

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

    private void setBotonesPaises(){
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
            contenedor.getChildren().add(boton);
        }
        this.getChildren().add(contenedor);
    }
}
