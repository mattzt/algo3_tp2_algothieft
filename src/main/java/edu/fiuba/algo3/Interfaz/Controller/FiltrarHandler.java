package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.*;
import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.*;
import edu.fiuba.algo3.modelo.Criminales.Pelo.*;
import edu.fiuba.algo3.modelo.Criminales.Sexo.*;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.*;
import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class FiltrarHandler implements EventHandler<ActionEvent> {

    private final ComboBox<String> sexo, accesorio, hobbie, pelo, vehiculo;
    private final Label etiquetaCantidad;
    private final Policia policia;

    public FiltrarHandler(ArrayList<ComboBox<String>> opciones, Label etiqueta, Policia policia){
        this.sexo = opciones.get(0);
        this.accesorio = opciones.get(1);
        this.hobbie = opciones.get(2);
        this.pelo = opciones.get(3);
        this.vehiculo = opciones.get(4);
        this.etiquetaCantidad = etiqueta;

        this.policia = policia;
    }

    @Override
    public void handle(ActionEvent event) {
        try {SonidosHandler.sonidoBoton();} catch (Exception e1) {e1.printStackTrace();}
        Caracteristica caracteristica;

        if((sexo.getValue() != null) && (!sexo.getValue().isEmpty())) {
            caracteristica = filtrarSexo(sexo);
            policia.ingresarDato(caracteristica);
        }

        if((accesorio.getValue() != null) && (!accesorio.getValue().isEmpty())) {
            caracteristica = filtrarAccesorio(accesorio);
            policia.ingresarDato(caracteristica);
        }

        if((hobbie.getValue() != null) && (!hobbie.getValue().isEmpty())) {
            caracteristica = filtrarHobbie(hobbie);
            policia.ingresarDato(caracteristica);
        }

        if((pelo.getValue() != null) && (!pelo.getValue().isEmpty())) {
            caracteristica = filtrarPelo(pelo);
            policia.ingresarDato(caracteristica);
        }

        if((vehiculo.getValue() != null) && (!vehiculo.getValue().isEmpty())) {
            caracteristica = filtrarVehiculo(vehiculo);
            policia.ingresarDato(caracteristica);
        }

        etiquetaCantidad.setText("Cantidad de sospechosos: " + policia.cantidadSospechosos());
    }

    private Caracteristica filtrarSexo(ComboBox<String> sexo){
        Caracteristica caracteristica = null;
        switch (sexo.getValue()) {
            case "Masculino":
                caracteristica = new SexoMasculino();
                break;
            case "Femenino":
                caracteristica = new SexoFemenino();
                break;
            }
        return caracteristica;
    }

    private Caracteristica filtrarAccesorio(ComboBox<String> accesorio){
        Caracteristica caracteristica = null;
        switch (accesorio.getValue()) {
            case "Anillo":
                caracteristica = new Anillo();
                break;
            case "Tatuaje":
                caracteristica = new Tatuaje();
                break;
            case "Joyas":
                caracteristica = new Joyas();
                break;
            case "Cicatriz":
                caracteristica = new Cicatriz();
                break;
        }
        return caracteristica;
    }

    private Caracteristica filtrarHobbie(ComboBox<String> hobbie){
        Caracteristica caracteristica = null;
        switch (hobbie.getValue()){
            case "Alpinismo":
                caracteristica = new Alpinismo();
                break;
            case "Croquet":
                caracteristica = new Croquet();
                break;
            case "Musica":
                caracteristica = new Musica();
                break;
            case "Natacion":
                caracteristica = new Natacion();
                break;
            case "Paracaidismo":
                caracteristica = new Paracaidismo();
                break;
            case "Tenis":
                caracteristica = new Tenis();
                break;
        }
        return caracteristica;
    }

    private Caracteristica filtrarPelo(ComboBox<String> pelo){
        Caracteristica caracteristica = null;
        switch (pelo.getValue()){
            case "Castanio":
                caracteristica = new Castanio();
                break;
            case "Negro":
                caracteristica = new Negro();
                break;
            case "Rubio":
                caracteristica = new Rubio();
                break;
            case "Rojo":
                caracteristica = new Rojo();
                break;
        }
        return caracteristica;
    }

    private Caracteristica filtrarVehiculo(ComboBox<String> vehiculo){
        Caracteristica caracteristica = null;
        switch (vehiculo.getValue()){
            case "Deportivo":
                caracteristica = new Deportivo();
                break;
            case "Descapotable":
                caracteristica = new Descapotable();
                break;
            case "Moto":
                caracteristica = new Moto();
                break;
            case "Limusina":
                caracteristica = new Limusina();
                break;
        }
        return caracteristica;
    }
}
