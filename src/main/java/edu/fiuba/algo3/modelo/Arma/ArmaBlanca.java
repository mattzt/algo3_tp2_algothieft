package edu.fiuba.algo3.modelo.Arma;

import edu.fiuba.algo3.modelo.Personas.Agente;

public class ArmaBlanca implements Arma{

    public ArmaBlanca(){
    }

    @Override
    public void hacerDanio(Agente agente){
        agente.recibirDanio();
    }

}
