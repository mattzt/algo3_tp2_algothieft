package edu.fiuba.algo3.modelo.Caso;

import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;

public class Objeto {
    private final String nombreObjeto;
    public Pais origenObjeto;
    private final int valorObjeto;

    public Objeto(String nombre, Pais paisOrigen, int valor){
        nombreObjeto = nombre;
        origenObjeto = paisOrigen;
        valorObjeto = valor;
    }

    public boolean equals(String nombre) {
        return nombreObjeto.equals(nombre);
    }

    public boolean tieneValor(int unValor) {
        return valorObjeto==unValor;
    }

    public Pais paisDeOrigen(){
        return origenObjeto;
    }

    public int cantidadDePaisesDeEscape(){
        if (valorObjeto==1) return 4;
        if (valorObjeto==2) return 5;
        return 7;
    }

    public String getNombreObjeto(){
        return nombreObjeto;
    }
}
