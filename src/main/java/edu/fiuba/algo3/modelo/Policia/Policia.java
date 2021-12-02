package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;

import static org.mockito.Mockito.mock;

public class Policia {
    private final String nombre;
    private final Rango rango;
    private ComputadoraInterpol computadora;
    private Ciudad ciudadEnDondeEstoy;

    public Policia(String nombrePolicia, Ciudad ciudadInicial)
    {
        nombre = nombrePolicia;
        rango = new Novato();
        ciudadEnDondeEstoy = ciudadInicial;
    }

    public void viajarApais(Ciudad ciudadActual, Ciudad otraCiudad)
    {
        int tiempo = ciudadActual.distanciaA(otraCiudad) * rango.velocidadViaje();
        //esto deberia ser resposabilidad de tiempo creo interactuar con el tiempo/reloj del juego
        ciudadEnDondeEstoy = otraCiudad;
    }
    public Pista explorarSitio(Edificio unEdificio)
    {
        return unEdificio.visitar();
    }
    public void computarDatosLadron()
    {
        computadora.IngresarDatos();
    }
    public void dormir()
    {
        //tiempo.pasar(8) aca deberian pasar 8 horas.
    }
    public void recibirDanio(Arma armaAtacante)
    {
        int tiempoTranscurrido = armaAtacante.tiempoIncapacitacion();
    }
}
