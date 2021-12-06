package edu.fiuba.algo3.modelo.Caso;

import edu.fiuba.algo3.modelo.Paises.Pais;

public class Objeto {
    String nombreObjeto;
    Pais origenObjeto;
    int valorObjeto;

    public Pais getCiudadDeOrigen(){
        return origenObjeto;
    }

    public int getValor(){
        return valorObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
    }

    public void setOrigenObjeto(Pais origenObjeto) {
        this.origenObjeto = origenObjeto;
    }

    public void setValorObjeto(int valorObjeto) {
        this.valorObjeto = valorObjeto;
    }
}
