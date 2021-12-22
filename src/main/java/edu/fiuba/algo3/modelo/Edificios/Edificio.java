package edu.fiuba.algo3.modelo.Edificios;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public abstract class Edificio {
    protected int vecesVisitado = 0;
    abstract public Pista visitar(RepositorioPistas pistas);
    public int getVecesVisitado()
    {
        return vecesVisitado;
    }

}
