package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.*;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.Pista;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.Momento;
import java.io.IOException;

public class Partida {
    private final Policia policia;
    private final RepositorioPistas repositorioPistas;
    private Paises paises;
    private ObjetosValiosos listaDeObjetos;
    private static Partida instance;
    private Caso casoActual;
    private Sospechosos sospechosos;

    private Partida() throws IOException, NoExisteError {
        policia = new Policia();

        CreadorCriminales factoryCriminales = new CreadorCriminales();
        sospechosos = factoryCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt");
        policia.setComputadora(new ComputadoraInterpol(sospechosos));

        CreadorPaises factoryPaises = new CreadorPaises();
        paises = factoryPaises.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");

        CreadorObjetos factoryObjetos = new CreadorObjetos(paises);
        listaDeObjetos = factoryObjetos.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/ObjetosValiosos.txt");

        policia.setPaisInicial(paises.paisRandom());

        CreadorPistas factoryPistas = new CreadorPistas();
        repositorioPistas = (RepositorioPistas) factoryPistas.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/PistasFaciles.txt");

        casoActual = new Caso(sospechosos,listaDeObjetos,paises,policia.presentarPlaca());
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

    public void filtrar(Caracteristica caracteristica){
        policia.ingresarDato(caracteristica);
    }

    public int cantidadSospechosos(){
        return policia.cantidadSospechosos();
    }

    public void resetearFiltros(){
        policia.resetearSospechosos();
    }

    public Criminal arrestar(){
        return policia.arrestar();
    }

    public void emitirOrden(){
        policia.emitirOrdenArresto();
    }

    public Pista visitarEdificio(Edificio edificio){
        return policia.visitarEdificio(edificio, repositorioPistas);
    }

    public Criminal getCriminalActual(){
        return casoActual.getCriminal();
    }

    public void nuevoCaso() {
        casoActual = new Caso(sospechosos, listaDeObjetos, paises, policia.presentarPlaca());
        policia.resetearReloj();
        policia.resetearSospechosos();
        policia.setPaisInicial(paises.paisRandom());
    }

    public Policia getPolicia(){
        return policia;
    }
}
