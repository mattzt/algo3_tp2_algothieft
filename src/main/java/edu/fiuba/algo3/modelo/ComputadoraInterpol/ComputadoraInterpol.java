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
        if(sospechosos.size() != 1) {
            System.out.println("Aun no podes emitir una orden de arresto! Quedan mas de 1 sospechosos posibles\n");
            return false;
        }
        return true;
    }

    public int cantidadSospechosos(){
        return sospechosos.size();
    }

    public void resetearSospechosos(){
        sospechosos.resetear();
    }

    public Criminal arrestar(OrdenDeArresto ordenDeArresto){
        if(ordenDeArresto.equals(new NoEmitida()))
            return null;

        return sospechosos.arrestar();
    }
}
