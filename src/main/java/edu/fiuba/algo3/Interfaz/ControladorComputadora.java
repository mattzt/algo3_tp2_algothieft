package edu.fiuba.algo3.Interfaz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControladorComputadora {

    @FXML
    public RadioButton masculino, femenino;

    @FXML
    public RadioButton anillo, tatuaje, cicatriz, joyas;

    @FXML
    public RadioButton alpinismo, croquet, musica, natacion, paracaidismo, tenis;

    @FXML
    public RadioButton castanio, negro, rojo, rubio;

    @FXML
    public RadioButton deportivo, descapotable, moto, limusina;

    @FXML
    public Button botonSexo, botonAccesorio, botonHobbie, botonPelo, botonVehiculo;

    public void irAMenu(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/MenuPrincipal.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void filtrar(ActionEvent event) {
        if(botonSexo.isPressed()){
            if(masculino.isSelected())
                System.out.println("Masculino");
            else if(femenino.isSelected())
                System.out.println("Femenino");
            else
                System.out.println("Elija");
        }
    }
}
