package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;

import static org.mockito.Mockito.mock;

public class Policia {
    private final String nombre;
    private final Rango rango;
    private ComputadoraInterpol computadora;

    public Policia(String nombrePolicia)
    {
        nombre = nombrePolicia;
        rango = new Novato();


    }

    public void viajarApais(Pais paisActual, Pais otraPais)
    {
        int tiempo = paisActual.distanciaA(otraPais) * rango.velocidadViaje();
        //esto deberia ser resposabilidad de tiempo creo interactuar con el tiempo/reloj del juego
    }
    public void explorarSitio(Edificio unEdificio)
    {
        Pista pistaSitio = unEdificio.Visitar(this);
    }
    public void computarDatosLadron()
    {
        computadora.IngresarDatos();
    }
}
