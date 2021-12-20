package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.Emitida;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.NoEmitida;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.OrdenDeArresto;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Accesorios;
import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Hobbies;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Pelo;
import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Vehiculos;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Reloj.DiaDeLaSemana;
import edu.fiuba.algo3.modelo.Reloj.Reloj;
import javafx.scene.SnapshotResult;

import java.io.FileNotFoundException;


public class Policia {
    private final String nombre;
    private Rango rango;
    private Pais paisEnDondeEstoy;
    private final Reloj reloj;
    private int horasAvanzar;
    private OrdenDeArresto ordenDeArresto;
    private ComputadoraInterpol computadora;


    public Policia(String nombrePolicia, Pais paisInicial){
        nombre = nombrePolicia;
        rango = new Novato();
        paisEnDondeEstoy = paisInicial;
        reloj = new Reloj();
        horasAvanzar = 1;
        ordenDeArresto = new NoEmitida();
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

    public void ingresarDato(Caracteristica caracteristica){
        computadora.ingresarCaracteristica(caracteristica);
    }

    public void emitirOrdenArresto(){
        if(computadora.sePuedeEmitirOrden()) {
            reloj.avanzarReloj(3);
            ordenDeArresto = new Emitida();
        }
    }

    public void rangoPoliciaEs(Rango rangoIngresado){
        rango = rangoIngresado;
    }

    public void dormir(){
        reloj.avanzarReloj(8);
    }

    public void recibirDanio(Arma armaAtacante){
        reloj.avanzarReloj(armaAtacante.tiempoIncapacitacion());
    }

    public String arrestar(){
        rango.aumentarCasosResueltos();
        rango = rango.promover();
        String resultado =  computadora.arrestar(ordenDeArresto);
        ordenDeArresto = new NoEmitida();

        return resultado;
    }

    public void resetearSospechosos(){
        computadora.resetearSospechosos();
    }

    public Rango presentarPlaca(){
        return rango;
    }

    public boolean seEncuentraEn(Pais unaCiudad) {
        return paisEnDondeEstoy.equals(unaCiudad);
    }

    public int mirarLaHora(){
        return reloj.verHora();
    }

    public DiaDeLaSemana mirarDia(){
        return reloj.verDia();
    }

    public void resetearReloj() {
        reloj.reset();
    }

    public void setComputadora(ComputadoraInterpol computadora){
        this.computadora = computadora;
    }

    public int cantidadSospechosos(){
        return computadora.cantidadSospechosos();
    }
}
