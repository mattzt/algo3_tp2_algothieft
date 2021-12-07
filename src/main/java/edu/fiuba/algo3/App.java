package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        var javaVersion = SystemInfo.javaVersion();
        var javafxVersion = SystemInfo.javafxVersion();

        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");

        VBox miniMenu = new VBox();
        Button botonViajesDisponibles = new Button("Ver Posibles viajes");
        Button botonViajarOtroPais = new Button("Viajar");
        Button botonExplorarCiudad = new Button("Explorar Ciudad");
        miniMenu.getChildren().addAll(botonViajesDisponibles, botonViajarOtroPais, botonExplorarCiudad);


        var scene = new Scene(miniMenu, 640, 480);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e->{e.consume();
        cerrarPrograma(stage);});
    }

    private void cerrarPrograma(Stage ventana)
    {
        Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
        Alert  alerta = new Alert(tipo, "");
        alerta.initModality(Modality.APPLICATION_MODAL);
        alerta.initOwner(ventana);
        alerta.getDialogPane().setContentText("Desea Cerar?");
        alerta.getDialogPane().setHeaderText("SALIR");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.get() == ButtonType.OK) { ventana.close();}
    }

    public static void main(String[] args) {
        launch();
    }

}