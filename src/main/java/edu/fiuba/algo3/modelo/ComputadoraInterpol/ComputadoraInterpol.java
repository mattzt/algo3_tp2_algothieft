package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;

public class ComputadoraInterpol{
    Sospechosos sospechosos;
    Caracteristicas caracteristicas;

    public ComputadoraInterpol(Sospechosos listaDeSospechosos){
        sospechosos = listaDeSospechosos;
        caracteristicas = new Caracteristicas(null,null,null,null,null);
    }

    public Sospechosos ingresarCaracteristica(Caracteristica unaCaracteristica){
        return sospechosos.filtrar(unaCaracteristica);
    }

    public boolean sePuedeEmitirOrden(){
        if(sospechosos.size() != 1) {
            System.out.println("Aun no podes emitir una orden de arresto! Quedan mas de 1 sospechosos posibles\n");
            return false;
        }
        return true;
    }
}
