package edu.fiuba.algo3.modelo.Personas;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;

public class Investigador implements Rango, Promovible {
    int arrestos;

    public Investigador() {
        arrestos = 10;
    }

    @Override
    public Caso nuevoCaso(Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos) {
        return new Caso();
    }

    @Override
    public int cantidadArrestos() {
        return arrestos;
    }

    @Override
    public Rango promover() {
        return new Sargento();
    }
}
