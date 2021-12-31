package edu.fiuba.algo3;

import edu.fiuba.algo3.Interfaz.Views.EscenaMenuPrincipal;
import edu.fiuba.algo3.Interfaz.Views.PantallaInicial;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException, NoExisteError {
//        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/PantallaInicial.fxml").toURI().toURL();
//        AnchorPane root = FXMLLoader.load(url);

//        EscenaMenuPrincipal root = new EscenaMenuPrincipal(stage);
//        Scene scene = new Scene(root);
        PantallaInicial pantallaInicial = new PantallaInicial(stage);
        Scene scene = new Scene(pantallaInicial);

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

        stage.setOnCloseRequest(e->{e.consume();
        cerrarPrograma(stage);});
    }

    private void cerrarPrograma(Stage ventana) {
        Alert.AlertType tipo = Alert.AlertType.CONFIRMATION;
        Alert alerta = new Alert(tipo, "");
        alerta.initModality(Modality.APPLICATION_MODAL);
        alerta.initOwner(ventana);
        alerta.getDialogPane().setContentText("Desea Cerrar?");
        alerta.getDialogPane().setHeaderText("SALIR");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) { ventana.close();}
    }

    public static void main(String[] args) {
        launch(args);
    }

}