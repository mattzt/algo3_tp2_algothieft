package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class PidoPistaFacilBanco {

    @Test
    public void pidoPistaFacil(){
        Agente agente = mock(Agente.class);
        Banco banco = new Banco();
        Partida partida = new Partida();
        ArrayList<String> pistas;
        String pista;
        Pista resultado;

        pistas = partida.asignarAgente(agente);

        resultado = banco.visitar(pistas);
        pista = resultado.mostrar();

        assertTrue(pista == "|BANCO|Dijo que queria cambiar su dinero por Rublos");
    }
}
