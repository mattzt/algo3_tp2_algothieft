package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Arma.ArmaBlanca;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.SingletonReloj;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SingletonRelojTest {

    SingletonReloj reloj = SingletonReloj.getInstance();
    Policia agenteTobias;
    Arma armaBlanca;

    @BeforeEach
    public void resetearReloj(){
        reloj.resetear();
        agenteTobias = new Policia("tobias", new Pais("Argentina","Buenos Aires"));
        armaBlanca = new ArmaBlanca();
    }

//    @Test
//    public void avanzarRelojFuncionamiento(){
//      assertEquals(0, reloj.darHora());
//      agenteTobias.recibirDanio(armaBlanca);
//      assertEquals(2, reloj.darHora());
//    }

    @Test
    public void darHora(){
        reloj.avanzarReloj(15);

        assertEquals(15, reloj.darHora());
    }

    @Test
    public void avanzaRelojPasaDeDiaCorrectamente(){
        assertEquals(0, reloj.darHora());

        reloj.avanzarReloj(22);
        assertEquals(22, reloj.darHora());

        reloj.avanzarReloj(3);
        assertEquals(1, reloj.darHora());
    }
}