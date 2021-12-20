package edu.fiuba.algo3.Interfaz.Controller;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControladorPantallaInicial extends Controlador {

    public Button loguearse;
    public TextField unNombre;

    public void clickLogIn(ActionEvent event) throws IOException {
        if (!nombreCorrecto(unNombre.getText())) logIn(event);
    }

    public void enterKey(KeyEvent keyEvent) throws IOException {
        if (!nombreCorrecto(unNombre.getText()) && keyEvent.getCode() == KeyCode.ENTER ) logIn(keyEvent);
    }

    private void logIn(Event unEvento) throws IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/MenuPrincipal.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);

        Stage stage = (Stage) (((Node) unEvento.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    private boolean nombreCorrecto(String texto){
        return texto.isBlank();
    }
}
