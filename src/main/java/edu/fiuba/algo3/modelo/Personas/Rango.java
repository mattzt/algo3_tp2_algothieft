package edu.fiuba.algo3.modelo.Personas;
import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;

public interface Rango {
    Caso nuevoCaso(Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos);

    default boolean equals(Rango unRango){
        return unRango.getClass() == this.getClass();
    }

    int cantidadArrestos();
}
