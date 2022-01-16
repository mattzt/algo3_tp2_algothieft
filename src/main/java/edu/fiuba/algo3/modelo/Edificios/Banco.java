package edu.fiuba.algo3.modelo.Edificios;

public class Banco extends Edificio {

    public Banco() {
        nombre = "Banco";
        vecesVisitado = 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
