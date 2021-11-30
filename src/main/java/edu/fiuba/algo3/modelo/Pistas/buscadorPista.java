package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class buscadorPista {

    public String obtenerPistaEdificio(Edificio edificio, ArrayList<String> pistas) {
        String buscado = obtenerTipoEdificio(edificio);
        Iterator<String> iterador = pistas.iterator();
        while(iterador.hasNext()){
            String pistaActual = iterador.next();
            if(pistaActual.contains(buscado)){
                pistaActual = pistaActual.replace(buscado, "");
                return pistaActual;
                break;
            }
        }
    }


    private String obtenerTipoEdificio(Edificio edificio){
        String buscado;
        if(Objects.equals(edificio.getClass(), Banco.class)){
            buscado = "|BANCO|";
        }
        if(Objects.equals(edificio.getClass(), Aeropuerto.class)){
            buscado = "|AEROPUERTO|";
        }
        if(Objects.equals(edificio.getClass(), Biblioteca.class)){
            buscado = "|BIBLIOTECA|";
        }
        if(Objects.equals(edificio.getClass(), Puerto.class)){
            buscado = "|PUERTO|";
        }
        return buscado;
    }
}