package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public class Banco extends Edificio {

    @Override
    public Pista visitar(RepositorioPistas pistas)
    {
        vecesVisitado += 1;
        return pistas.obtenerPistaPara(this);
    }
}
