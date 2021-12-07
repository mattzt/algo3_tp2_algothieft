package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;

import java.io.IOException;

public class Partida {
    private Policia policia;
    private RepositorioPistas repositorioPistas;

    public Partida(Policia policia) throws IOException {
        repositorioPistas = new RepositorioPistas(policia);
    }

    public RepositorioPistas obtenerPistas(){
        return repositorioPistas;
    }

}
