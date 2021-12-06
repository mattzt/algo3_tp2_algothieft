package edu.fiuba.algo3.modelo.Edificios;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public interface Edificio {

    Pista visitar(RepositorioPistas pistas);
}
