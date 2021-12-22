package edu.fiuba.algo3.modelo.Edificios;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public interface Edificio {

    Pista visitar(RepositorioPistas pistas, Pais siguientePais);

    String getNombre();

    default boolean equals(Edificio unEdificio){
        return this.getNombre().equals(unEdificio.getNombre());
    }
}
