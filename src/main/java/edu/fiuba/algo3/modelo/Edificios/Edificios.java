package edu.fiuba.algo3.modelo.Edificios;

import java.util.ArrayList;

public class Edificios {
    private ArrayList<Edificio> edificios;

    public Edificios (){
        edificios = new ArrayList<>();
    }

    public void agregar(Edificio unEdificio) {
        edificios.add(unEdificio);
    }
}
