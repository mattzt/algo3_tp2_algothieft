package edu.fiuba.algo3.modelo.Pistas;

import java.util.ArrayList;

public class Pistas {
    private ArrayList<Pista> pistas;

    public Pista darUnaPista() {
        return new PistaBandera();
    }
}
