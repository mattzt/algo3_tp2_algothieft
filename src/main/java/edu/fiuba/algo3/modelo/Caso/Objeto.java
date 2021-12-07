package edu.fiuba.algo3.modelo.Caso;

import edu.fiuba.algo3.modelo.Paises.Pais;

public class Objeto {
    String nombreObjeto;
    Pais origenObjeto;
    int valorObjeto;

    public Objeto(String nombre, Pais paisOrigen, int valor){
        nombreObjeto = nombre;
        origenObjeto = paisOrigen;
        valorObjeto = valor;
    }

    public boolean equals(String nombre) {
        return nombreObjeto.equals(nombre);
    }
}
