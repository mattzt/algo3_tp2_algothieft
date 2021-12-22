package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;

import java.util.ArrayList;
import java.util.Iterator;

public class RepositorioPistas implements Listable {
    ArrayList<Pista> posiblesPistas;

    public RepositorioPistas(ArrayList<Pista> pistas) {
        posiblesPistas = pistas;
    }


    public Pista obtenerPistaPara(Pais siguiente, Edificio edificio){
        Iterator<Pista> iterador = posiblesPistas.iterator();
        Pista pistaActual = null;
        while(iterador.hasNext()){
            pistaActual = iterador.next();
            if((pistaActual.esTipo(edificio)) && (pistaActual.apuntaHacia(siguiente))){
//                posiblesPistas.remove(pistaActual);
                break;
            }
        }
        return pistaActual;
    }


    @Override
    public int size() {
        return posiblesPistas.size();
    }
}
