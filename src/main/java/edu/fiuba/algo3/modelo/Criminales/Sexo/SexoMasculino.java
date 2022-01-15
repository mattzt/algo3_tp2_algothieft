package edu.fiuba.algo3.modelo.Criminales.Sexo;

public class SexoMasculino implements Sexo{

    @Override
    public String valor() {
        return "Masculino";
    }

    @Override
    public String crearPista() {
        return "Recuerdo que era hombre, no mucho mas";
    }


}
