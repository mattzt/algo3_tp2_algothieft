package edu.fiuba.algo3.Interfaz.Views;

import edu.fiuba.algo3.Interfaz.Controller.*;
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
import java.util.ArrayList;

public class EscenaComputadora extends AnchorPane {

    Stage stage;
    Policia policia;
    ComboBox<String> sexo, accesorio, hobbie, pelo, vehiculo;
    Label cantidadSospechosos;

    public EscenaComputadora(Stage stage) throws NoExisteError, IOException {
        policia = Partida.getInstance().getPolicia();
        this.setPrefHeight(700);
        this.setPrefWidth(900);
        this.stage = stage;

        configurarMenu();
        setearContenedorPrincipal();
        setInfo();
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
        botonMenu.setFont(Font.font(14));

        botonViajar.setPrefHeight(100);
        botonViajar.setPrefWidth(200);
        botonViajar.setFont(Font.font(14));

        botonCiudad.setPrefHeight(100);
        botonCiudad.setPrefWidth(200);
        botonCiudad.setFont(Font.font(14));

        contenedorBotones.getChildren().addAll(botonMenu, botonCiudad, botonViajar);

        botonCiudad.setOnAction(new BotonCiudadHandler(stage));
        botonMenu.setOnAction(new BotonMenuHandler(stage));
        botonViajar.setOnAction(new BotonEscenaViajarHandler(stage));

        this.getChildren().add(contenedorBotones);
    }

    private void agregarSexo(VBox contenedorPrincipal){
        HBox opcionSexo = new HBox();
        opcionSexo.setAlignment(Pos.CENTER);
        opcionSexo.setPrefHeight(110);
        opcionSexo.setPrefWidth(550);
        opcionSexo.setSpacing(20);

        sexo = new ComboBox<>();
        sexo.setPrefWidth(200);
        sexo.setPrefHeight(30);
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

        accesorio = new ComboBox<>();
        accesorio.setPrefWidth(200);
        accesorio.setPrefHeight(30);
        accesorio.setPromptText("Accesorio");

        accesorio.getItems().addAll(null, "Anillo", "Tatuaje", "Joyas", "Cicatriz");

        opcionAccesorios.getChildren().add(accesorio);
        contenedorPrincipal.getChildren().add(opcionAccesorios);
    }

    private void agregarHobbie(VBox contenedorPrincipal){
        HBox opcionHobbie = new HBox();
        opcionHobbie.setAlignment(Pos.CENTER);
        opcionHobbie.setPrefHeight(110);
        opcionHobbie.setPrefWidth(550);
        opcionHobbie.setSpacing(20);

        hobbie = new ComboBox<>();
        hobbie.setPrefWidth(200);
        hobbie.setPrefHeight(30);
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

        pelo = new ComboBox<>();
        pelo.setPrefWidth(200);
        pelo.setPrefHeight(30);
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

        vehiculo = new ComboBox<>();
        vehiculo.setPrefWidth(200);
        vehiculo.setPrefHeight(30);
        vehiculo.setPromptText("Vehiculo");

        vehiculo.getItems().addAll(null, "Deportivo", "Descapotable", "Moto", "Limusina");

        opcionVehiculo.getChildren().add(vehiculo);
        contenedorPrincipal.getChildren().add(opcionVehiculo);

    }

    private void setearContenedorPrincipal(){
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

        cantidadSospechosos = new Label("Cantidad de sospechosos: " + policia.cantidadSospechosos());
        cantidadSospechosos.setFont(Font.font(16));
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
        Button emitirOrden = new Button("Emitir orden");
        Button arrestar = new Button("Arrestar");
        Button filtrar = new Button("Filtrar");

        resetFiltros.setFont(Font.font(14));
        emitirOrden.setFont(Font.font(14));
        arrestar.setFont(Font.font(14));
        filtrar.setFont(Font.font(14));

        ArrayList<ComboBox<String>> listaOpciones = new ArrayList<>();
        listaOpciones.add(sexo);
        listaOpciones.add(accesorio);
        listaOpciones.add(hobbie);
        listaOpciones.add(pelo);
        listaOpciones.add(vehiculo);

        ResetearFiltrosHandler resetHandler = new ResetearFiltrosHandler(stage, policia);
        FiltrarHandler filtrarHandler = new FiltrarHandler(listaOpciones, cantidadSospechosos, policia);

        resetFiltros.setOnAction(resetHandler);
        filtrar.setOnAction(filtrarHandler);

        opciones.getChildren().addAll(resetFiltros, emitirOrden, arrestar, filtrar);

        contenedor.getChildren().add(opciones);
    }

    private void setInfo(){
        VBox contenedor = new VBox();
        contenedor.setPrefWidth(300);
        contenedor.setPrefHeight(250);
        contenedor.setAlignment(Pos.TOP_CENTER);
        contenedor.setSpacing(10);

        Label hora = new Label();
        String fecha = policia.mirarDia().diaDeHoy() + ", " + policia.mirarLaHora() + "hs";

        hora.setText(fecha);
        hora.setAlignment(Pos.CENTER);
        hora.setFont(Font.font(25));
        hora.setPrefWidth(300);

        contenedor.getChildren().add(hora);


        Label pais = new Label();

        pais.setText("Pais actual: " + policia.getPaisActual().getNombre());
        pais.setFont(Font.font(25));
        pais.setAlignment(Pos.CENTER);
        pais.setPrefWidth(300);

        contenedor.getChildren().add(pais);

        this.getChildren().add(contenedor);
    }
}
