package edu.fiuba.algo3.modelo.Edificios;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public abstract class Edificio {
    protected int vecesVisitado = 0;
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

    public boolean equals(Edificio unEdificio){
        return this.getNombre().equals(unEdificio.getNombre());
    }
}
