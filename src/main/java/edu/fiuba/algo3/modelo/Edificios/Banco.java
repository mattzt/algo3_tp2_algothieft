package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.BaseDatosPistas;
import edu.fiuba.algo3.modelo.Pistas.Pista;

import java.util.ArrayList;

public class Banco implements Edificio{

    @Override
    public Pista visitar(BaseDatosPistas pistas) {
        Pista pista = new Pista();
        return pista.obtenerPistaBanco(pistas);
    }
}
