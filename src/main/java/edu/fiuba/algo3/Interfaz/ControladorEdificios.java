package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControladorEdificios {
    private final Partida partida;

    public ControladorEdificios() throws NoExisteError, IOException {
        this.partida = Partida.getInstance();


    }


    public void irAMenu(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/MenuPrincipal.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void irAComputadora(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/ComputadoraInterpol.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
