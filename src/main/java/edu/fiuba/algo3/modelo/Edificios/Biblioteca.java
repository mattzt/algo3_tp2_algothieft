package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.BuscadorPista;

import java.util.ArrayList;

public class Biblioteca implements Edificio{
    private BuscadorPista buscador;

    public Biblioteca(){
        buscador = new BuscadorPista();
    }

    @Override
    public Pista visitar(ArrayList<String> pistas){
        String pistaEdificio = buscador.obtenerPistaEdificio(this, pistas);

        return new Pista(this, pistaEdificio);
    }
}
