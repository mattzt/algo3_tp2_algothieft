package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Pistas.Pista;

import java.util.ArrayList;
import java.util.Iterator;

public class Sospechosos {
    ArrayList<Criminal> sospechosos;

    public Sospechosos(){
        sospechosos = new ArrayList<>();
    }

    public void agregarSospechoso(Criminal criminal){
        sospechosos.add(criminal);
    }

    public int cantidadSospechosos(){
        return sospechosos.size();
    }

    public Sospechosos cumplenConCaracteristicas(Caracteristicas caracteristicas) {
        Sospechosos nuevosSospechosos = new Sospechosos();
        Iterator<Criminal> iterador = sospechosos.iterator();
        Criminal criminalActual = null;
        while(iterador.hasNext()){
            criminalActual = iterador.next();
            if(criminalActual.tieneCaracteristica(caracteristicas)){
                nuevosSospechosos.agregarSospechoso(criminalActual);
            }
        }
        return nuevosSospechosos;
    }
}