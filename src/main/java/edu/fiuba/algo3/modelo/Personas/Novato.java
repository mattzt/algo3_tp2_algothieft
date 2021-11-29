package edu.fiuba.algo3.modelo.Personas;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;

public class Novato implements Rango, Promovible {
    private int arrestos;

    public Novato(){
        arrestos = 0;
    }

    @Override
    public Caso nuevoCaso(Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos) {
        return new Caso(listaDeSospechosos,listaDeObjetos,1);
    }

    @Override
    public int cantidadArrestos() {
        return arrestos;
    }

    @Override
    public Rango promover() {
        return new Detective();
    }
}
