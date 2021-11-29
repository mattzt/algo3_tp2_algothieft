package edu.fiuba.algo3.modelo.Personas;

import edu.fiuba.algo3.modelo.Arma.*;
import edu.fiuba.algo3.modelo.Sexo.*;
public class Criminal {
    Sexo sexo;

    public Criminal(){
        sexo = new SexoFemenino();
    }

    public void atacarCon(Agente agente, Arma arma){
        arma.hacerDanio(agente);
    }


}
