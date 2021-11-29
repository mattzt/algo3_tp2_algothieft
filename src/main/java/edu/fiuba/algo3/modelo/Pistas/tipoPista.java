package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class tipoPista {
    ArrayList<String> pistas;

    private tipoPista (int arrestos){
        pistaDificultad dificultad = new pistaDificultad();
        pistas = dificultad.obtenerPistasDeDificultad(arrestos);
    }

    public String obtenerPistaEdificio(Edificio edificio) {
        String buscado = obtenerTipoEdificio(edificio);
        Iterator<String> iterador = pistas.iterator();
        while(iterador.hasNext()){
            String pistaActual = iterador.next();
            if(pistaActual.contains(buscado)){
                pistaActual = pistaActual.replace(buscado, "");
                return pistaActual;
            }
        }
    }

    private String obtenerTipoEdificio(Edificio edificio){
        String buscado;
        if(Objects.equals(edificio.getClass(), Banco.class)){
            buscado = "|BANCO|";
        }
        else if(Objects.equals(edificio.getClass(), Aeropuerto.class)){
            buscado = "|AEROPUERTO|";
        }
        else if(Objects.equals(edificio.getClass(), Biblioteca.class)){
            buscado = "|BIBLIOTECA|";
        }
        else if(Objects.equals(edificio.getClass(), Puerto.class)){
            buscado = "|PUERTO|";
        }
        else{
            buscado = "|BOLsA|";
        }
        return buscado;
    }
}
