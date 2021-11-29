package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Personas.Agente;

public class Pista{

    public String darPista(Edificio edificio, Agente agente) {
        String pista = buscarPistaPara(edificio, agente);
        return pista;
    }

    private String buscarPistaPara(Edificio edificio, Agente agente) {
        int arrestos = agente.cantidadDeArrestos();
        RangoPista pista;

        if(arrestos < 5){
            pista = new PistasFacil();
        }
        else if(arrestos < 15){
            pista = new PistasMedio();
        }
        else{
            pista = new PistasDificil();
        }
        return pista.ObtenerPistaEdificio(edificio);
    }

}
