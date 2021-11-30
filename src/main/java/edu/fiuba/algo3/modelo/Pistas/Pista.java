package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.util.ArrayList;

public class Pista {
    String pista;
    Edificio edificioOrigen;
    Ciudad ciudadOrigen;

    public Pista(Ciudad ciudad, Edificio edificio, ArrayList<String> pistas){
        BuscadorPista buscador = new BuscadorPista();
        pista = buscador.obtenerPistaEdificio(edificio);
        edificioOrigen = edificio;
        ciudadOrigen = ciudad;
    }


    public String darPista(Pista pista){
        return pista.pista;
    }

    public Ciudad obtenerCiudadDePista(Pista pista){
        return pista.ciudadOrigen;
    }

    public Edificio obtenerEdificioDePista(Pista pista){
        return pista.edificioOrigen;
    }

}
