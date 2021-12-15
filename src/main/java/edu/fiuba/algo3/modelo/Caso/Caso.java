package edu.fiuba.algo3.modelo.Caso;

import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.Reloj;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;

public class Caso {
    private final Reloj reloj;
    private final Objeto objetoRobado;
    private Policia policia;

    public Caso (Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos){
        reloj = new Reloj();
        objetoRobado = listaDeObjetos.robar();
    }

    public Caso(Objeto objetoRobado){
        reloj = new Reloj();
        this.objetoRobado = objetoRobado;
    }

    public void asignarCasoAPolicia(Policia nuevoPolicia){
        policia = nuevoPolicia;
    }

}
