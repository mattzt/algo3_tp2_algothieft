package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Personas.Agente;
import edu.fiuba.algo3.modelo.Personas.Novato;
import edu.fiuba.algo3.modelo.Personas.Rango;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AgenteTest {
    private Agente agente1;

    @BeforeEach
    public void setUp() {
        agente1 = new Agente("Matias");
    }

    @Test
    public void seCreaAgenteCorrectamente() {
        Rango novato = new Novato();
        assertTrue(agente1.es("Matias"));
        assertTrue(agente1.esRango(novato));
        assertTrue(agente1.tieneArrestos(0));
    }
}
