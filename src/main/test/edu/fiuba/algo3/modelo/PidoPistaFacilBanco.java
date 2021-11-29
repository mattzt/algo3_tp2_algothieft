package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Edificios.Banco;
import edu.fiuba.algo3.modelo.Personas.Novato;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import org.junit.jupiter.api.Test;

public class PidoPistaFacilBanco {

    @Test
    public class pidoPistaFacil{
        Novato novato = Novato new();
        Banco banco = Banco new();
        Pista pista = Pista new();
        String resultado = pista.buscarPistaPara(banco, novato);
        String parcial = "Dijo que queria cambiar su dinero por Rublos";
        assertTrue(resultado==parcial);

    }
}
