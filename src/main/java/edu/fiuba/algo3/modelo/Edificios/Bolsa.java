package edu.fiuba.algo3.modelo.Edificios;


import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;

public class Bolsa extends Edificio {
    private final String nombre;
    public Pista pista;


    public Bolsa() {
        nombre = "Bolsa";
        vecesVisitado = 0;
    }

    @Override
    public Pista visitar(RepositorioPistas pistas, Pais siguiente) {
        pista = pistas.obtenerPistaPara(siguiente, this);
        return pista;
    }

    @Override
    public String getNombre() {
        return nombre;

    }
}
