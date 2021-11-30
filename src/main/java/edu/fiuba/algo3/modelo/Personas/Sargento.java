package edu.fiuba.algo3.modelo.Personas;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;

public class Sargento implements Rango {
    int arrestos;

    public Sargento() {
        arrestos = 20;
    }

    @Override
    public Caso nuevoCaso(Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos) {
        return new Caso();
    }

    @Override
    public int cantidadArrestos() {
        return arrestos;
    }
}
