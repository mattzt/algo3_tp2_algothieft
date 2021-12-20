package edu.fiuba.algo3.Interfaz.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
}
