package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public class Bolsa implements Edificio{

    private final String nombre = "Bolsa";

    @Override
    public Pista visitar(RepositorioPistas pistas) {
        return pistas.obtenerPistaPara(this);
    }

    @Override
    public String getNombre() {
        return nombre;
    }
}
