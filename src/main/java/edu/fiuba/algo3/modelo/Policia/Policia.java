package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.*;
import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.IntervaloTiempo.*;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Reloj.DiaDeLaSemana;
import edu.fiuba.algo3.modelo.Reloj.Reloj;

import java.io.FileNotFoundException;


public class Policia {
    private String nombre = "";
    private Rango rango;
    private Pais paisEnDondeEstoy;
    private final Reloj reloj;
    private OrdenDeArresto ordenDeArresto;
    private ComputadoraInterpol computadora;


    public Policia(){
        rango = new Novato();
        reloj = new Reloj();
        ordenDeArresto = new NoEmitida();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setPaisInicial(Pais paisInicial){
        this.paisEnDondeEstoy = paisInicial;
    }

    public void viajarApais(Pais paisDestino) throws FileNotFoundException {
        reloj.avanzarReloj(new IntervaloTiempoViajeaPais(paisEnDondeEstoy.distanciaA(paisDestino),rango.velocidadViaje()));
        paisEnDondeEstoy = paisDestino;
    }

    public Pista visitarEdificio(Edificio unEdificio, RepositorioPistas pistas){
        reloj.avanzarReloj(new IntervaloTiempoExplorarEdificio( unEdificio.getVecesVisitado()));

        return paisEnDondeEstoy.visitarEdificio(unEdificio, pistas);
    }

    public void ingresarDato(Caracteristica caracteristica){
        computadora.ingresarCaracteristica(caracteristica);
    }

    public void emitirOrdenArresto(){
        if(computadora.sePuedeEmitirOrden()) {
            reloj.avanzarReloj(new IntervaloTiempoEmitirArresto());
            ordenDeArresto = new Emitida();
        }
    }

    public void rangoPoliciaEs(Rango rangoIngresado){
        rango = rangoIngresado;
    }

    public void dormir(){
        reloj.avanzarReloj(new IntervaloTiempoDormir());
    }

    public void recibirDanio(Arma armaAtacante){
        reloj.avanzarReloj(armaAtacante.tiempoIncapacitacion());
    }

    public Criminal arrestar(){
        rango = ordenDeArresto.evaluarRango(rango);
        Criminal resultado =  computadora.arrestar(ordenDeArresto);
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

    public Pais getPaisActual(){
        return paisEnDondeEstoy;
    }
}
