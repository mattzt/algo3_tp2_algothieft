package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControladorEdificios extends Controlador{
    
    @FXML
    public Button aeropuerto, biblioteca, bolsa, banco, puerto;

    public ControladorEdificios() throws NoExisteError, IOException {
        this.partida = Partida.getInstance();
    }

    public void irAMenu(ActionEvent event) throws IOException, NoExisteError {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/MenuPrincipal.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);
        Label hora = configurarHora();
        root.getChildren().add(hora);


        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void irAComputadora(ActionEvent event) throws IOException, NoExisteError {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/ComputadoraInterpol.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);

        Label hora = configurarHora();
        root.getChildren().add(hora);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void actualizarPantalla(ActionEvent event, String pista) throws NoExisteError, IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/Edificios.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);

        Label hora = configurarHora();
        root.getChildren().add(hora);

        HBox contenedor = new HBox();
        contenedor.setAlignment(Pos.CENTER);
        contenedor.setLayoutX(335);
        contenedor.setLayoutY(350);

        Label labelPista = new Label();
        labelPista.setText(pista);
        labelPista.setAlignment(Pos.CENTER);
        labelPista.setLayoutX(500);
        labelPista.setLayoutY(200);

        contenedor.getChildren().add(labelPista);
        root.getChildren().add(contenedor);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void visitarEdificio(ActionEvent event) throws NoExisteError, IOException {
        Edificio edificio = null;
        if(aeropuerto == event.getTarget())
            edificio = new Aeropuerto();
        else if(biblioteca == event.getTarget())
            edificio = new Biblioteca();
        else if(banco == event.getTarget())
            edificio = new Banco();
        else if(bolsa == event.getTarget())
            edificio = new Bolsa();
        else if(puerto == event.getTarget())
            edificio = new Puerto();
        
        String pista = partida.visitarEdificio(edificio).darPista();

        actualizarPantalla(event, pista);
    }
}
