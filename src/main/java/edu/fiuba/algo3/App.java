package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws NoExisteError, IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/MenuPrincipal.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(e->{e.consume();
        cerrarPrograma(stage);});
    }


    private void cerrarPrograma(Stage ventana) {
        Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
        Alert  alerta = new Alert(tipo, "");
        alerta.initModality(Modality.APPLICATION_MODAL);
        alerta.initOwner(ventana);
        alerta.getDialogPane().setContentText("Desea Cerrar?");
        alerta.getDialogPane().setHeaderText("SALIR");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.get() == ButtonType.OK) { ventana.close();}
    }

    public static void main(String[] args) {
        launch(args);
    }

}