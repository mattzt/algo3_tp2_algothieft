package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControladorMenu extends Controlador{

    public ControladorMenu() throws IOException, NoExisteError {
        partida = Partida.getInstance();
    }

    public void irAComputadora(ActionEvent event) throws IOException, NoExisteError {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/ComputadoraInterpol.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);

        Label hora = configurarHora();
        root.getChildren().add(hora);

        Label cantidadSospechosos = configurarSospechosos();
        root.getChildren().add(cantidadSospechosos);

        Label pais = configurarPais();
        root.getChildren().add(pais);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void irAEdificios(ActionEvent event) throws IOException, NoExisteError {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/Edificios.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);

        Label hora = configurarHora();
        root.getChildren().add(hora);

        Label pais = configurarPais();
        root.getChildren().add(pais);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
