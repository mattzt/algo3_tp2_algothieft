package edu.fiuba.algo3.modelo.Criminales.Accesorios;

public class Joyas implements Accesorios{

    @Override
    public String valor() {
        return "Joyas";
    }

    @Override
    public String crearPista() {
        return "Llevaba muchas joyas, seguramente muy caras";
    }

}
