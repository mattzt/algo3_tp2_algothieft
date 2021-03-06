package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;

public class ComputadoraInterpol{
    private final Sospechosos sospechosos;

    public ComputadoraInterpol(Sospechosos listaDeSospechosos){
        sospechosos = listaDeSospechosos;
    }

    public void ingresarCaracteristica(Caracteristica unaCaracteristica){
        sospechosos.filtrar(unaCaracteristica);
    }

    public boolean sePuedeEmitirOrden(){
        return sospechosos.size() == 1;
    }

    public int cantidadSospechosos(){
        return sospechosos.size();
    }

    public void resetearSospechosos(){
        sospechosos.resetear();
    }

    public Criminal arrestar(OrdenDeArresto ordenDeArresto){
        NoEmitida noEmitida = new NoEmitida();
        if(noEmitida.equals(ordenDeArresto))
            return null;

        return sospechosos.arrestar();
    }
}
