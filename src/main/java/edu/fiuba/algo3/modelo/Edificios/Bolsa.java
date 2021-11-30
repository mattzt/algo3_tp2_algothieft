package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.BuscadorPista;
import edu.fiuba.algo3.modelo.Pistas.Pista;

import java.util.ArrayList;

public class Bolsa implements Edificio{
    private BuscadorPista buscador;

    public Bolsa(){
        buscador = new BuscadorPista();
    }

    @Override
    public Pista visitar(ArrayList<String> pistas){
        String pistaEdificio = buscador.obtenerPistaEdificio(this, pistas);

        return new Pista(this, pistaEdificio);
    }
}
