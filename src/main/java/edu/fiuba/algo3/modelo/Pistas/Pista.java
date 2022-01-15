package edu.fiuba.algo3.modelo.Pistas;


import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;

public abstract class Pista {
    public String pista;
    public String pais;

    public Boolean es(Pista pista){
        return (pista==this);
    }


    public String darPista(){
        return pista;
    }

    public abstract Boolean esTipo(Edificio edificio);

    public boolean apuntaHacia(Pais siguiente){
        return (siguiente.getNombre().equals(pais));
    }
}
