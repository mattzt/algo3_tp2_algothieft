package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Policia.Rango;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class RepositorioPistas {
    ArrayList<Pista> posiblesPistas;

    public RepositorioPistas(ArrayList<Pista> pistas) {
        posiblesPistas = pistas;
    }


    public Pista obtenerPistaPara(Edificio edificio){
        Iterator<Pista> iterador = posiblesPistas.iterator();
        Pista pistaActual = null;
        while(iterador.hasNext()){
            pistaActual = iterador.next();
            if(pistaActual.esTipo(edificio)){
//                posiblesPistas.remove(pistaActual);
                break;
            }
        }
        return pistaActual;
    }



}
