package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;


public class Banco extends Edificio {
    private final String nombre;
    public Pista pista;


    public Banco() {
        nombre = "Banco";
        vecesVisitado = 0;
    }

    @Override
    public String getNombre() {
        return nombre;

    }
}
