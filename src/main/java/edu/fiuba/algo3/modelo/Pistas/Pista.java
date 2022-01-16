package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;

public abstract class Pista {
    protected String pista;
    protected String pais;

    public String darPista(){
        return pista;
    }

    public abstract Boolean esTipo(Edificio edificio);

    public boolean apuntaHacia(Pais siguiente){
        return (siguiente.getNombre().equals(pais));
    }
}
