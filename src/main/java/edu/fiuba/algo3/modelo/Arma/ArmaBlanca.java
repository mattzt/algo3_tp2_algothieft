package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.Policia.*;

public class ArmaBlanca extends Arma{

    public ArmaBlanca(){
    }

    @Override
    public int tiempoIncapacitacion() {
        return 2;
    }

}
