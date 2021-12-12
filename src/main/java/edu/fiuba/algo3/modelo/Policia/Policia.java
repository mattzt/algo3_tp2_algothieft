package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Reloj.Reloj;

import java.io.FileNotFoundException;


public class Policia {
    private final String nombre;
    private final Rango rango;
    private ComputadoraInterpol computadora;
    private Pais paisEnDondeEstoy;
    private Reloj reloj;
    private int horasAvanzar;


    public Policia(String nombrePolicia, Pais paisInicial){
        nombre = nombrePolicia;
        rango = new Novato();
        paisEnDondeEstoy = paisInicial;
        reloj = new Reloj();
        horasAvanzar = 1;
    }

    public void viajarApais(Pais paisDestino) throws FileNotFoundException {
        reloj.avanzarReloj(paisEnDondeEstoy.distanciaA(paisDestino) / rango.velocidadViaje());
        paisEnDondeEstoy = paisDestino;
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

    public boolean seEncuentraEn(String unaCiudad) {
        return paisEnDondeEstoy.equals(unaCiudad);
    }

    public int mirarLaHora(){
        return reloj.verHora();
    }

    public void resetearReloj() {
        reloj.reset();
    }
}
