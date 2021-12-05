package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Reloj.SingletonReloj;


public class Policia {
    private final String nombre;
    private final Rango rango;
    private ComputadoraInterpol computadora;
    private Ciudad ciudadEnDondeEstoy;
    private SingletonReloj reloj;
    private int horasAvanzar;


    public Policia(String nombrePolicia, Ciudad ciudadInicial){
        nombre = nombrePolicia;
        rango = new Novato();
        ciudadEnDondeEstoy = ciudadInicial;
        reloj = SingletonReloj.getInstance();
        horasAvanzar = 1;
    }

    public void viajarApais(Ciudad ciudadActual, Ciudad otraCiudad){
        reloj.avanzarReloj(ciudadActual.distanciaA(otraCiudad) * rango.velocidadViaje());
        ciudadEnDondeEstoy = otraCiudad;
    }

    public Pista explorarSitio(Edificio unEdificio, RepositorioPistas pistas){
        reloj.avanzarReloj(horasAvanzar);

        if((horasAvanzar + 1) > 3)
            horasAvanzar = 1;
        else
            horasAvanzar++;

        return unEdificio.visitar(pistas);
    }

    public void computarDatosLadron(){
        computadora.IngresarDatos();
    }

    public void dormir(){
        reloj.avanzarReloj(8);
    }

    public void recibirDanio(Arma armaAtacante){
        reloj.avanzarReloj(armaAtacante.tiempoIncapacitacion());
    }

    public Rango presentarPlaca(){
        return rango;
    }
}
