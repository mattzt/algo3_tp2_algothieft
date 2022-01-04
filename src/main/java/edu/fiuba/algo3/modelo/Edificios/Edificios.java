package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;

import java.util.ArrayList;

public class Edificios {
    private final ArrayList<Edificio> edificios;

    public Edificios (){
        edificios = new ArrayList<>();
    }

    public void agregar(Edificio unEdificio)
    {
        edificios.add(unEdificio);
    }

    public ArrayList<String> nombres() {
        ArrayList<String> nombres = new ArrayList<>();
        for(Edificio e : edificios){
            nombres.add(e.getNombre());
        }
        return nombres;
    }

    public Pista visitarEdificio(Edificio unEdificio, RepositorioPistas pistas, Pais siguientePais){
        int i = 0;
        boolean encontrado = false;
        Pista resultado = null;

        while ((!encontrado && i < edificios.size())){
            Edificio leido = edificios.get(i);
            if(unEdificio.equals(leido)){
                resultado = leido.visitar(pistas, siguientePais);
                encontrado = true;
            }
            i++;
        }
        return resultado;
    }

    public int visitasTotales(){
        int vecesTotales = 0;

        for(Edificio edificio : edificios){
            vecesTotales += edificio.getVecesVisitado();
        }

        return vecesTotales;
    }
}
