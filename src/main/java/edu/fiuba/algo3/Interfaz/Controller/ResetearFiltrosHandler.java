package edu.fiuba.algo3.Interfaz.Controller;

import edu.fiuba.algo3.modelo.Policia.Policia;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

public class ResetearFiltrosHandler implements EventHandler<ActionEvent> {

    private final Label sospechosos;
    private final Policia policia;

    public ResetearFiltrosHandler(Label sospechosos, Policia policia){
        this.sospechosos = sospechosos;
        this.policia = policia;
    }

    @Override
    public void handle(ActionEvent event) {
        try {SonidosHandler.sonidoBoton();} catch (Exception e1) {e1.printStackTrace();}
        policia.resetearSospechosos();

        sospechosos.setText("Cantidad de sospechosos: " + policia.cantidadSospechosos());
    }
}
