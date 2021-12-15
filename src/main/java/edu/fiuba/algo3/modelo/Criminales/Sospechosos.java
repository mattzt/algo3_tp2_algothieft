package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Policia.Rango;
import edu.fiuba.algo3.modelo.Randomizador;

import java.util.ArrayList;
import java.util.Random;

public class Sospechosos implements Listable {
    private ArrayList<Criminal> sospechosos;
    private final ArrayList<Criminal> copia;

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

    public String  getNombreCulpable(){
        Criminal criminal = sospechosos.get(0);
        return "El criminal era " + criminal.getNombre();
    }

    @Override
    public int size() {
        return sospechosos.size();
    }

    public void resetear(){
        sospechosos = copia;
    }

    public Criminal elegirCriminalAleatorio() {
        return sospechosos.get(Randomizador.indiceRandom(sospechosos));
    }
}