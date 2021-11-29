package edu.fiuba.algo3.modelo.Pistas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Personas.Novato;

public class Pista{
    tipoPista tipo;

    public String darPista(Edificio edificio, Agente agente) {
        String pista = buscarPistaPara(edificio, agente);
        return pista;
    }

    private String buscarPistaPara(Edificio edificio, Agente agente) {
        int arrestos = agente.cantidadArrestos();
        tipo = new tipoPista(arrestos);
        return tipo.obtenerPistaEdificio(edificio);
    }

}

