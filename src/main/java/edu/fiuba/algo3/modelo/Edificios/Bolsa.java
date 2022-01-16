package edu.fiuba.algo3.modelo.Edificios;

public class Bolsa extends Edificio {

    public Bolsa() {
        nombre = "Bolsa";
        vecesVisitado = 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
