package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Personas.Novato;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PidoPistaFacilBanco {

    @Test
    public void pidoPistaFacil(){
        Novato novato = new Novato();
        Banco banco = new Banco();
        Pista pista = new Pista();
        String resultado = pista.buscarPistaPara(banco, novato);
        String parcial = "Dijo que queria cambiar su dinero por Rublos";
        assertTrue(resultado == parcial);

    }
}
