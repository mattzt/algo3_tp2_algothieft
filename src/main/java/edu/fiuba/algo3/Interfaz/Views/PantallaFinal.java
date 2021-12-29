package edu.fiuba.algo3.Interfaz.Views;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaFinal extends AnchorPane {

    Stage stage;
    VBox contenedor;

    public PantallaFinal(Stage stage, Label estadoJuego){
        this.stage = stage;
        this.setPrefHeight(700);
        this.setPrefWidth(900);

        contenedor = new VBox();
        contenedor.getChildren().addAll(estadoJuego);

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

        nuevoCaso.setPrefWidth(150);
        nuevoCaso.setPrefHeight(50);

        salir.setPrefWidth(150);
        salir.setPrefHeight(50);



        contenedor.getChildren().addAll(nuevoCaso, salir);

        this.getChildren().add(contenedor);
    }
}
