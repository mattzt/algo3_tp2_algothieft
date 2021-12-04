package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Pistas.Pistas;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.io.IOException;

public class Partida {
    private Policia policia;
    private Pistas pistas;

    public Partida(Policia policia) throws IOException {
        pistas = new Pistas(policia);
    }

    public Pistas obtenerPistas(){
        return pistas;
    }

}
