package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.Policia.Policia;

public abstract class Arma {

    void hacerDanio(Policia agente) { agente.recibirDanio(this);}


    public abstract int tiempoIncapacitacion();
}
