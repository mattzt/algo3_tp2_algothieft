package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Reloj.SingletonReloj;

import static org.mockito.Mockito.mock;

public class Policia {
    private final String nombre;
    private final Rango rango;
    private ComputadoraInterpol computadora;
    private Ciudad ciudadEnDondeEstoy;
    private SingletonReloj reloj;


    public Policia(String nombrePolicia, Ciudad ciudadInicial)
    {
        nombre = nombrePolicia;
        rango = new Novato();
        ciudadEnDondeEstoy = ciudadInicial;
        reloj = SingletonReloj.getInstance();
    }

    public void viajarApais(Ciudad ciudadActual, Ciudad otraCiudad)
    {
        reloj.avanzarReloj(ciudadActual.distanciaA(otraCiudad) * rango.velocidadViaje());
        ciudadEnDondeEstoy = otraCiudad;
    }
    public Pista explorarSitio(Edificio unEdificio, RepositorioPistas pistas)
    {
        reloj.avanzarReloj(3);
        return unEdificio.visitar(pistas);
    }
    public void computarDatosLadron()
    {
        computadora.IngresarDatos();
    }
    public void dormir()
    {
        reloj.avanzarReloj(8);
    }

    public void recibirDanio(Arma armaAtacante)
    {
        reloj.avanzarReloj(armaAtacante.tiempoIncapacitacion());
    }

    public int cantidadArrestos() {
        return rango.casosResueltos();
    }
}
