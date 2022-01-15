package edu.fiuba.algo3.modelo.Edificios;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public abstract class Edificio {

    protected int vecesVisitado;
    protected String nombre;

    public Pista visitar(RepositorioPistas pistas){
        Pista pista = pistas.obtenerPistaPara(this);
        vecesVisitado++;
        return pista;
    }

    public int getVecesVisitado() {
        return vecesVisitado;
    }

    public String getNombre(){
        return nombre;
    }

    boolean equals(Edificio unEdificio){
        return this.getNombre().equals(unEdificio.getNombre());
    }
}
