package edu.fiuba.algo3.modelo.Criminales.Sexo;

public class SexoFemenino implements Sexo{

    @Override
    public String valor() {
        return "Femenino";
    }

    @Override
    public String crearPista() {
        return "Si, era una mujer";
    }

}
