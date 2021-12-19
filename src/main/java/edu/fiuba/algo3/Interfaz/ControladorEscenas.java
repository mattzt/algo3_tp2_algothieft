package edu.fiuba.algo3.Interfaz;

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

    public void irAComputadora(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/ComputadoraInterpol.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
