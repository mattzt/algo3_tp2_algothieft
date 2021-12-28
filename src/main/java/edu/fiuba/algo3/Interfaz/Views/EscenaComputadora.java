package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.BotonCiudadHandler;
import edu.fiuba.algo3.Interfaz.Controller.BotonMenuHandler;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class EscenaComputadora extends AnchorPane {

    Stage stage;
    Policia policia;

    public EscenaComputadora(Stage stage) throws NoExisteError, IOException {
        policia = Partida.getInstance().getPolicia();
        this.setPrefHeight(700);
        this.setPrefWidth(900);
        this.stage = stage;

        configurarMenu();
        setearOpciones();
        setHora();
        setPais();
    }

    private void configurarMenu(){
        HBox contenedorBotones = new HBox();
        contenedorBotones.setPrefHeight(100);
        contenedorBotones.setPrefWidth(550);
        contenedorBotones.setLayoutX(335);
        contenedorBotones.setLayoutY(586);

        Button botonMenu = new Button("Menu Principal");
        Button botonViajar = new Button("Viajar");
        Button botonCiudad = new Button("Explorar Ciudad");

        botonMenu.setOnAction(new BotonMenuHandler(stage));
        botonCiudad.setOnAction(new BotonCiudadHandler(stage));

        botonMenu.setPrefHeight(100);
        botonMenu.setPrefWidth(200);
        botonViajar.setPrefHeight(100);
        botonViajar.setPrefWidth(200);
        botonCiudad.setPrefHeight(100);
        botonCiudad.setPrefWidth(200);

        contenedorBotones.getChildren().addAll(botonMenu, botonCiudad, botonViajar);

        botonCiudad.setOnAction(new BotonCiudadHandler(stage));

        this.getChildren().add(contenedorBotones);
    }

    private void agregarSexo(VBox contenedorPrincipal){
        HBox opcionSexo = new HBox();
        opcionSexo.setAlignment(Pos.CENTER);
        opcionSexo.setPrefHeight(110);
        opcionSexo.setPrefWidth(550);
        opcionSexo.setSpacing(20);

        ComboBox<String> sexo = new ComboBox<>();
        sexo.setPromptText("Sexo");
        sexo.getItems().addAll(null, "Masculino", "Femenino");

        opcionSexo.getChildren().add(sexo);
        contenedorPrincipal.getChildren().add(opcionSexo);
    }

    private void agregarAccesorios(VBox contenedorPrincipal){
        HBox opcionAccesorios = new HBox();
        opcionAccesorios.setAlignment(Pos.CENTER);
        opcionAccesorios.setPrefHeight(110);
        opcionAccesorios.setPrefWidth(550);
        opcionAccesorios.setSpacing(20);

        ComboBox<String> accesorios = new ComboBox<>();
        accesorios.setPromptText("Accesorio");
        accesorios.getItems().addAll(null, "Anillo", "Tatuaje", "Joyas", "Cicatriz");

        opcionAccesorios.getChildren().add(accesorios);
        contenedorPrincipal.getChildren().add(opcionAccesorios);
    }

    private void agregarHobbie(VBox contenedorPrincipal){
        HBox opcionHobbie = new HBox();
        opcionHobbie.setAlignment(Pos.CENTER);
        opcionHobbie.setPrefHeight(110);
        opcionHobbie.setPrefWidth(550);
        opcionHobbie.setSpacing(20);

        ComboBox<String> hobbie = new ComboBox<>();
        hobbie.setPromptText("Hobbie");
        hobbie.getItems().addAll(null, "Alpinismo", "Croquet", "Musica", "Natacion", "Paracaidismo", "Tenis");

        opcionHobbie.getChildren().add(hobbie);
        contenedorPrincipal.getChildren().add(opcionHobbie);
    }

    private void agregarPelo(VBox contenedorPrincipal){
        HBox opcionPelo = new HBox();
        opcionPelo.setAlignment(Pos.CENTER);
        opcionPelo.setPrefHeight(110);
        opcionPelo.setPrefWidth(550);
        opcionPelo.setSpacing(20);

        ComboBox<String> pelo = new ComboBox<>();
        pelo.setPromptText("Pelo");
        pelo.getItems().addAll(null, "Castanio", "Negro", "Rubio", "Rojo");

        opcionPelo.getChildren().add(pelo);
        contenedorPrincipal.getChildren().add(opcionPelo);
    }

    private void agregarVehiculo(VBox contenedorPrincipal){
        HBox opcionVehiculo = new HBox();
        opcionVehiculo.setAlignment(Pos.CENTER);
        opcionVehiculo.setPrefHeight(110);
        opcionVehiculo.setPrefWidth(550);
        opcionVehiculo.setSpacing(20);

        ComboBox<String> vehiculo = new ComboBox<>();
        vehiculo.setPromptText("Vehiculo");
        vehiculo.getItems().addAll(null, "Deportivo", "Descapotable", "Moto", "Limusina");

        opcionVehiculo.getChildren().add(vehiculo);
        contenedorPrincipal.getChildren().add(opcionVehiculo);

    }

    private void setearOpciones(){
        VBox contenedorPrincipal = new VBox();
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setLayoutX(336);
        contenedorPrincipal.setLayoutY(6);
        contenedorPrincipal.setPrefHeight(570);
        contenedorPrincipal.setPrefWidth(550);

        Label filtrarSospechosos = new Label("Filtrar sospechosos");
        filtrarSospechosos.setFont(Font.font(24));
        contenedorPrincipal.getChildren().add(filtrarSospechosos);

        agregarSexo(contenedorPrincipal);
        agregarAccesorios(contenedorPrincipal);
        agregarHobbie(contenedorPrincipal);
        agregarPelo(contenedorPrincipal);
        agregarVehiculo(contenedorPrincipal);

        Label cantidadSospechosos = new Label("Cantidad de sospechosos: " + policia.cantidadSospechosos());
        cantidadSospechosos.setFont(Font.font(14));
        contenedorPrincipal.getChildren().add(cantidadSospechosos);

        setearBotonesPolicia(contenedorPrincipal);


        this.getChildren().add(contenedorPrincipal);
    }

    private void setearBotonesPolicia(VBox contenedor){
        HBox opciones = new HBox();
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(20);
        opciones.setPrefHeight(100);
        opciones.setPrefWidth(200);

        Button resetFiltros = new Button("Resetear filtros");
        Button arrestar = new Button("Arrestar");
        Button emitirOrden = new Button("Emitir orden");

        opciones.getChildren().addAll(resetFiltros, arrestar, emitirOrden);

        contenedor.getChildren().add(opciones);
    }

    private void setHora(){
        Label hora = new Label();
        String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";

        hora.setText(fecha);
        hora.setLayoutX(23);
        hora.setLayoutY(28);
        hora.setPrefHeight(140);
        hora.setPrefWidth(230);
        hora.setAlignment(Pos.CENTER);
        hora.setFont(Font.font(25));

        this.getChildren().add(hora);
    }

    private void setPais(){
        Label pais = new Label();

        pais.setText("Pais actual: " + policia.getPaisActual().getNombre());
        pais.setFont(Font.font(25));
        pais.setAlignment(Pos.CENTER);
        pais.setLayoutX(20);
        pais.setLayoutY(600);

        this.getChildren().add(pais);
    }
}
