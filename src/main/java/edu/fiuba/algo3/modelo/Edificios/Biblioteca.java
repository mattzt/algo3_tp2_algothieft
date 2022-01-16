package edu.fiuba.algo3.modelo.Edificios;

public class Biblioteca extends Edificio {

    public Biblioteca() {
        nombre = "Biblioteca";
        vecesVisitado = 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}