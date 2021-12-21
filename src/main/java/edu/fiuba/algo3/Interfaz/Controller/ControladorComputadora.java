package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.*;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.*;
import edu.fiuba.algo3.modelo.Criminales.Pelo.*;
import edu.fiuba.algo3.modelo.Criminales.Sexo.*;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.*;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ControladorComputadora extends Controlador{
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
    public Button botonSexo, botonAccesorio, botonHobbie, botonPelo, botonVehiculo, resetearFiltros, emitirOrden, arrestar;

    public ControladorComputadora() throws NoExisteError, IOException {
        partida = Partida.getInstance();
    }

    public void irAMenu(ActionEvent event) throws IOException, NoExisteError {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/MenuPrincipal.fxml").toURI().toURL();
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

    public void irAPantallaFinal(ActionEvent event) throws NoExisteError, IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/PantallaFinal.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);

        Label hora = configurarHora();
        root.getChildren().add(hora);

        Label mensajeFinal = configurarMensajeFinal();
        root.getChildren().add(mensajeFinal);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void filtrarSexo(ActionEvent event) throws NoExisteError, IOException {
        if(masculino.isSelected())
            partida.filtrar(new SexoMasculino());
        else if(femenino.isSelected()) {
            partida.filtrar(new SexoFemenino());
        }
        actualizarPantalla(event);
    }

    public void filtrarAccesorio(ActionEvent event) throws NoExisteError, IOException {
        if(anillo.isSelected())
            partida.filtrar(new Anillo());
        else if(tatuaje.isSelected())
            partida.filtrar(new Tatuaje());
        else if(cicatriz.isSelected())
            partida.filtrar(new Cicatriz());
        else if(joyas.isSelected())
            partida.filtrar(new Joyas());

        actualizarPantalla(event);
    }

    public void filtrarHobbie(ActionEvent event) throws NoExisteError, IOException {
        if(alpinismo.isSelected())
            partida.filtrar(new Alpinismo());
        else if(croquet.isSelected())
            partida.filtrar(new Croquet());
        else if(musica.isSelected())
            partida.filtrar(new Musica());
        else if(natacion.isSelected())
            partida.filtrar(new Natacion());
        else if(paracaidismo.isSelected())
            partida.filtrar(new Paracaidismo());
        else if(tenis.isSelected())
            partida.filtrar(new Tenis());

        actualizarPantalla(event);
    }

    public void filtrarPelo(ActionEvent event) throws NoExisteError, IOException {
        if(castanio.isSelected())
            partida.filtrar(new Castanio());
        else if(negro.isSelected())
            partida.filtrar(new Negro());
        else if(rojo.isSelected())
            partida.filtrar(new Rojo());
        else if(rubio.isSelected())
            partida.filtrar(new Rubio());

        actualizarPantalla(event);
    }

    public void filtrarVehiculo(ActionEvent event) throws NoExisteError, IOException {
        if(deportivo.isSelected())
            partida.filtrar(new Deportivo());
        else if(descapotable.isSelected())
            partida.filtrar(new Descapotable());
        else if(moto.isSelected())
            partida.filtrar(new Moto());
        else if(limusina.isSelected())
            partida.filtrar(new Limusina());

        actualizarPantalla(event);
    }

    public void resetearFiltros(ActionEvent event) throws NoExisteError, IOException {
        partida.resetearFiltros();
        actualizarPantalla(event);
    }

    public void arrestar(ActionEvent event) throws NoExisteError, IOException {
        partida.arrestar();
        irAPantallaFinal(event);
    }

    private void actualizarPantalla(ActionEvent event) throws IOException, NoExisteError {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/Views/ComputadoraInterpol.fxml").toURI().toURL();
        AnchorPane root = FXMLLoader.load(url);

        Label hora = configurarHora();
        root.getChildren().add(hora);

        Label sospechosos = configurarSospechosos();
        root.getChildren().add(sospechosos);

        Label pais = configurarPais();
        root.getChildren().add(pais);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void emitirOrden(ActionEvent event) throws IOException, NoExisteError {
        partida.emitirOrden();
        actualizarPantalla(event);
    }
}
