package edu.fiuba.algo3.modelo.Criminales.Pelo;

public class Negro implements Pelo{

    @Override
    public String valor() {
        return "Negro";
    }

    @Override
    public String crearPista() {
        return "Si, era una persona con pelo negro";
    }

}
