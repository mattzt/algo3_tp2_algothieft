package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Listable;

import java.util.ArrayList;

public class Sospechosos implements Listable {
    private ArrayList<Criminal> sospechosos;
    public ArrayList<Criminal> copia;

    public Sospechosos(){
        sospechosos = new ArrayList<>();
        copia = new ArrayList<>();
    }

    public void agregarSospechoso(Criminal criminal){
        sospechosos.add(criminal);
        copia.add(criminal);
    }

    public Sospechosos filtrar(Caracteristica caracteristica) {
        for (int i = 0; i < sospechosos.size(); i++) {
            Criminal criminal = sospechosos.get(i);
            if(!criminal.tieneCaracteristica(caracteristica)){
                sospechosos.remove(i);
                i--;
            }
        }
        return this;
    }

    @Override
    public int size() {
        return sospechosos.size();
    }

    public void resetear(){
        sospechosos = copia;
    }
}