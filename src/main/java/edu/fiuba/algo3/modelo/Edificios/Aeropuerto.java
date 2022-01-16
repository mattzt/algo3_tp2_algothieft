package edu.fiuba.algo3.modelo.Edificios;

public class Aeropuerto extends Edificio {

    public Aeropuerto() {
        nombre = "Aeropuerto";
        vecesVisitado = 0;
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
