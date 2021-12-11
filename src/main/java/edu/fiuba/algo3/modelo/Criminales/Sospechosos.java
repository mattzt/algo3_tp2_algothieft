package edu.fiuba.algo3.modelo.Criminales;

import java.util.ArrayList;

public class Sospechosos {
    ArrayList<Criminal> sospechosos;

    public Sospechosos(){
        sospechosos = new ArrayList<>();
    }

    public Criminal buscarSospechosoLibre() {
        return new Criminal(null,null,null,null,null);
    }

    public void filtrarSospechosos(Caracteristicas caracteristica){
        Criminal criminal;
        for(int i = 0; i < sospechosos.size(); i++){
            criminal = sospechosos.get(i);

            if(!criminal.tieneCaracteristica(caracteristica)){
                sospechosos.remove(i);
                i--;
            }
        }
    }

    public int cantidadSospechosos(){
        return sospechosos.size();
    }
}