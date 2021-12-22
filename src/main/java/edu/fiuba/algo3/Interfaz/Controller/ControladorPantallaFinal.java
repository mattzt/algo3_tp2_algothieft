package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

public class ControladorPantallaFinal extends Controlador{
    @FXML
    public Button botonSalida, botonCaso;

    public void salir(ActionEvent event){
        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
        Alert  alerta = new Alert(tipo, "");

        alerta.initModality(Modality.APPLICATION_MODAL);
        alerta.initOwner(stage);
        alerta.getDialogPane().setContentText("Desea Cerrar?");
        alerta.getDialogPane().setHeaderText("SALIR");

        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            stage.close();
        }
    }

    public void irAMenu(ActionEvent event) throws IOException, NoExisteError {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/MenuPrincipal.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);

        partida = Partida.getInstance();
        partida.nuevoCaso();

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
