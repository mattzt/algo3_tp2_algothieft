package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.EstadoJuego.AtrapoCorrecto;
import edu.fiuba.algo3.modelo.EstadoJuego.AtrapoIncorrecto;
import edu.fiuba.algo3.modelo.EstadoJuego.FinDelJuego;
import edu.fiuba.algo3.modelo.EstadoJuego.SinTiempo;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.*;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.Domingo;
import edu.fiuba.algo3.modelo.Reloj.Lunes;

import java.io.IOException;

public class Partida {
    private final Policia policia;
    private RepositorioPistas repositorioPistas;
    private final Paises paises;
    private final ObjetosValiosos listaDeObjetos;
    private static Partida instance;
    private Caso casoActual;
    private final Sospechosos sospechosos;
    private FinDelJuego estado;

    private Partida() throws IOException, NoExisteError {
        policia = new Policia();
        estado = null;

        CreadorCriminales factoryCriminales = new CreadorCriminales();
        sospechosos = factoryCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/Sospechosos.txt");
        policia.setComputadora(new ComputadoraInterpol(sospechosos));

        CreadorPaises factoryPaises = new CreadorPaises();
        paises = factoryPaises.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");

        CreadorObjetos factoryObjetos = new CreadorObjetos(paises);
        listaDeObjetos = factoryObjetos.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/ObjetosValiosos.txt");

        policia.setPaisEnDondeEstoy(paises.paisRandom());

        casoActual = new Caso(sospechosos, listaDeObjetos, policia);

        CreadorPistas factoryPistas = new CreadorPistas(casoActual);
        repositorioPistas = (RepositorioPistas) factoryPistas.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/PistasFaciles.txt");

        casoActual.crearRutaDeEscape(repositorioPistas, paises);
    }

    public static Partida getInstance() throws NoExisteError, IOException {
        if(instance == null){
            instance = new Partida();
        }
        return instance;
    }

    public RepositorioPistas obtenerPistas(){
        return repositorioPistas;
    }

    public void nuevoCaso() throws IOException {
        policia.resetearSospechosos();
        casoActual = new Caso(sospechosos, listaDeObjetos, policia);

        CreadorPistas factoryPistas = new CreadorPistas(casoActual);
        repositorioPistas = (RepositorioPistas) factoryPistas.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/PistasFaciles.txt");

        policia.resetearReloj();
        policia.setPaisEnDondeEstoy(paises.paisRandom());
        casoActual.crearRutaDeEscape(repositorioPistas, paises);
        estado = null;
    }

    public Policia getPolicia(){
        return policia;
    }

    public String nombreCriminalActual(){
        return casoActual.getCriminal().getNombre();
    }

    public void evaluarEstado(Criminal atrapado){
        if(policia.mirarDia().equals(new Domingo()) && policia.mirarLaHora() > 17){
            estado = new SinTiempo();
        }
        else if(policia.mirarDia().equals(new Lunes()) && policia.mirarLaHora() < 7){
            estado = new SinTiempo();
        }

        if(atrapado != null){
            if(atrapado.equals(casoActual.getCriminal()))
                estado = new AtrapoCorrecto();
            else
                estado = new AtrapoIncorrecto();
        }
    }

    public boolean terminoJuego(){
        return estado != null;
    }

    public String mensajeFinal() throws NoExisteError, IOException {
        return estado.mensaje(nombreCriminalActual());
    }

    public String nombreObjetoRobado() {
        return casoActual.nombreObjeto();
    }

    public boolean estaEnUltimoPais(){
        return repositorioPistas.estaEnUltimoPais();
    }
}
