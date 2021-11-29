package edu.fiuba.algo3.Policia;

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
        int tiempo = ciudadActual.tiempoDeViaje(otraCiudad, rango.velocidadViaje());
        //esto deberia interactuar con el tiempo/reloj del juego
    }
    public void explorarSitio(Sitio unSitio)
    {
        Pista pistaDeSitio = unSitio.damePista();
        pistaDeSitio.mostrarEnJuego;

    }

}
