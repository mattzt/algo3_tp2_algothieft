package edu.fiuba.algo3.modelo.Reloj;

import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Policia.Policia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingletonRelojTest {

    SingletonReloj reloj = SingletonReloj.getInstance();
    Policia agenteTobias = new Policia("tobias",new Ciudad());
    Arma armaBlanca = new ArmaBlanca();

    @BeforeEach
    public void resetearReloj(){
        reloj.resetear();
    }


    @Test
    void getInstance()
    {
    }

    @Test
    void avanzarRelojFuncionamiento(){
      assertEquals(0, reloj.darHora());
      agenteTobias.recibirDanio(armaBlanca);
      assertEquals(2, reloj.darHora());
    }

    @Test
    void darHora(){
        reloj.avanzarReloj(15);

        assertEquals(15, reloj.darHora());
    }

    @Test
    void avanzaRelojPasaDeDiaCorrectamente(){
        assertEquals(0, reloj.darHora());

        reloj.avanzarReloj(22);
        assertEquals(22, reloj.darHora());

        reloj.avanzarReloj(3);
        assertEquals(1, reloj.darHora());
    }
}