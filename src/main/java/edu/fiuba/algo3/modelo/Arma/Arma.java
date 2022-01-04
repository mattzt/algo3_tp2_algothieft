package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.IntervaloTiempo.IntervaloTiempo;
import edu.fiuba.algo3.modelo.Policia.Policia;

public abstract class Arma {

    public void hacerDanio(Policia agente) { agente.recibirDanio(this);}


    public abstract IntervaloTiempo tiempoIncapacitacion();
}
