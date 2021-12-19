package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControladorEscenas {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void irAComputadora(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/ComputadoraInterpol.fxml").toURI().toURL();
        root = FXMLLoader.load(url);

        stage = (Stage) (((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void irAMenu(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/MenuPrincipal.fxml").toURI().toURL();
        root = FXMLLoader.load(url);

        stage = (Stage) (((Node)event.getSource()).getScene().getWindow());
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
