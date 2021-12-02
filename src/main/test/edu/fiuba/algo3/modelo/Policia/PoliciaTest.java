package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import javafx.beans.binding.When;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class PoliciaTest {
     Edificio EdifcioMock = Mockito.mock(Edificio.class);
     Pista pistaMock = Mockito.mock(Pista.class);
     Policia agente = new Policia("tobias", new Ciudad());
    @Test
    void viajarAciudad() {
    }

    @Test
    void explorarSitio()
    {
        when(EdifcioMock.visitar()).thenReturn(pistaMock);
        when(pistaMock.DarPista()).thenReturn("hola");
        assertEquals("hola", agente.explorarSitio(EdifcioMock).DarPista());
    }
}