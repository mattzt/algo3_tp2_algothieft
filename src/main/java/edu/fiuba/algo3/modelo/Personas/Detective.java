package edu.fiuba.algo3.modelo.Personas;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;

public class Detective implements Rango, Promovible {
    int arrestos;

    public Detective(){
        arrestos = 5;
    }

    @Override
    public Caso nuevoCaso(Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos) {
        return new Caso(listaDeSospechosos,listaDeObjetos,2);
    }

    @Override
    public int cantidadArrestos() {
        return arrestos;
    }

    @Override
    public Rango promover() {
        return new Investigador();
    }
}
