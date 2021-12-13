package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Listable;

import java.util.ArrayList;
import java.util.Iterator;

public class Sospechosos implements Listable {
    private ArrayList<Criminal> sospechosos;

    public Sospechosos(){
        sospechosos = new ArrayList<>();
    }

    public void agregarSospechoso(Criminal criminal){
        sospechosos.add(criminal);
    }

    public Sospechosos cumplenConCaracteristicas(Caracteristicas caracteristicas) {
        Sospechosos nuevosSospechosos = new Sospechosos();
        Iterator<Criminal> iterador = sospechosos.iterator();
        Criminal criminalActual;
        while(iterador.hasNext()){
            criminalActual = iterador.next();
            if(criminalActual.tieneCaracteristica(caracteristicas)){
                nuevosSospechosos.agregarSospechoso(criminalActual);
            }
        }
        return nuevosSospechosos;
    }

    @Override
    public int size() {
        return sospechosos.size();
    }
}