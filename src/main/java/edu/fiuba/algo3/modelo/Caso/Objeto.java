package edu.fiuba.algo3.modelo.Caso;

import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Personas.Novato;

public class Objeto {
    Ciudad origen;
    int valor;
    private final String nombre;

    public Objeto(String nombreTesoro){
        nombre = nombreTesoro;
    }

    public Ciudad getCiudadDeOrigen(){
        return origen;
    }

    public int getValor(){
        return valor;
    }

}
