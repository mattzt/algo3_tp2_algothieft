package edu.fiuba.algo3.modelo.Policia;
import edu.fiuba.algo3.modelo.Arma.Arma;
import edu.fiuba.algo3.modelo.Criminales.Accesorios.Accesorios;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Hobbies;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Pelo;
import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Vehiculos;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Reloj.Reloj;

import java.io.FileNotFoundException;


public class Policia {
    private final String nombre;
    private Rango rango;
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

    public void agregarDatoSospechosoAccesorio(ComputadoraInterpol computadora, Accesorios accesorio){
        computadora.ingresarDatosAccesorios(accesorio);
    }
    public void agregarDatoSospechosoHobbie(ComputadoraInterpol computadora, Hobbies hobbie){
        computadora.ingresarDatosHobbies(hobbie);
    }
    public void agregarDatoSospechosoPelo(ComputadoraInterpol computadora, Pelo pelo){
        computadora.ingresarDatosPelo(pelo);
    }
    public void agregarDatoSospechosoVehiculo(ComputadoraInterpol computadora, Vehiculos vehiculo){
        computadora.ingresarDatosVehiculo(vehiculo);
    }
    public void agregarDatoSospechosoSexo(ComputadoraInterpol computadora, Sexo sexo){
        computadora.ingresarDatosSexo(sexo);
    }


    public void emitirOrdenArresto(){
        if(computadora.sePuedeEmitirOrden()) {
            reloj.avanzarReloj(3);
        }
    }

    public ComputadoraInterpol obtenerComputadora(){
        return computadora;
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

    public Rango presentarPlaca(){
        return rango;
    }

    public boolean seEncuentraEn(Pais unaCiudad) {
        return paisEnDondeEstoy.equals(unaCiudad);
    }

    public int mirarLaHora(){
        return reloj.verHora();
    }

    public void resetearReloj() {
        reloj.reset();
    }
}
