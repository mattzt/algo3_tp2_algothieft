package edu.fiuba.algo3.Interfaz;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Anillo;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Cicatriz;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Tatuaje;
import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.*;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Negro;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rojo;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Rubio;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Criminales.Sexo.SexoMasculino;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Deportivo;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Descapotable;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Limusina;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Moto;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControladorComputadora {

    private final Partida partida;

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
    public Button botonSexo, botonAccesorio, botonHobbie, botonPelo, botonVehiculo, resetearFiltros;

    @FXML
    public Label cantidadSospechosos;


    public ControladorComputadora() throws NoExisteError, IOException {
        partida = Partida.getInstance();
    }

    public void irAMenu(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/edu/fiuba/algo3/Interfaz/MenuPrincipal.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);

        Stage stage = (Stage) (((Node) event.getSource()).getScene().getWindow());
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void filtrarSexo(ActionEvent event) {
        if(masculino.isSelected())
            partida.filtrar(new SexoMasculino());
        else if(femenino.isSelected()) {
            partida.filtrar(new SexoFemenino());
        }

        cantidadSospechosos.setText("Cantidad de sospechosos: " + partida.cantidadSospechosos());
    }

    public void filtrarAccesorio(ActionEvent event){
        if(anillo.isSelected())
            partida.filtrar(new Anillo());
        else if(tatuaje.isSelected())
            partida.filtrar(new Tatuaje());
        else if(cicatriz.isSelected())
            partida.filtrar(new Cicatriz());
        else if(joyas.isSelected())
            partida.filtrar(new Joyas());

        cantidadSospechosos.setText("Cantidad de sospechosos: " + partida.cantidadSospechosos());
    }

    public void filtrarHobbie(ActionEvent event){
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
    }

    public void filtrarPelo(ActionEvent event){
        if(castanio.isSelected())
            partida.filtrar(new Castanio());
        else if(negro.isSelected())
            partida.filtrar(new Negro());
        else if(rojo.isSelected())
            partida.filtrar(new Rojo());
        else if(rubio.isSelected())
            partida.filtrar(new Rubio());
    }

    public void filtrarVehiculo(ActionEvent event){
        if(deportivo.isSelected())
            partida.filtrar(new Deportivo());
        else if(descapotable.isSelected())
            partida.filtrar(new Descapotable());
        else if(moto.isSelected())
            partida.filtrar(new Moto());
        else if(limusina.isSelected())
            partida.filtrar(new Limusina());
    }

    public void filtrar(){}

    public void resetearFiltros(ActionEvent event){
        partida.resetearFiltros();
        cantidadSospechosos.setText("Cantidad de sospechosos: " + partida.cantidadSospechosos());
    }
}
