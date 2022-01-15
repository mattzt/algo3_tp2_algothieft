package edu.fiuba.algo3.modelo.Criminales.Accesorios;

public class Tatuaje implements Accesorios{

    @Override
    public String valor() {
        return "Tattoo";
    }

    @Override
    public String crearPista() {
        return "Si, tenia un gran tatuaje en el cuello";
    }

}
