package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;

import java.util.ArrayList;

public class Policia {
    String nombre;
    Rango rango;
    public Policia(String nombrePolicia)
    {
        nombre = nombrePolicia;
        rango = new Novato();
    }
    public void viajarAciudad(Ciudad ciudadActual, Ciudad otraCiudad)
    {
        //int tiempo = ciudadActual.tiempoDeViaje(otraCiudad, rango.velocidadViaje());
        //esto deberia interactuar con el tiempo/reloj del juego
    }

    public void explorarEdificio(Edificio unEdificio, ArrayList<String> pistas)
    {
        Pista pistaDelEdificio = unEdificio.visitar(pistas);
        pistaDelEdificio.mostrar();

    }

}
