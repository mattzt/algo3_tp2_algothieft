package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.ComputadoraInterpol.ComputadoraInterpol;
import edu.fiuba.algo3.modelo.Criminales.Caracteristica;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.*;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import edu.fiuba.algo3.modelo.Pistas.RepositorioPistas;
import edu.fiuba.algo3.modelo.Policia.Policia;
import edu.fiuba.algo3.modelo.Reloj.DiaDeLaSemana;
import edu.fiuba.algo3.modelo.Reloj.Momento;

import java.io.IOException;

public class Partida {
    private Policia policia;
    private RepositorioPistas repositorioPistas;
    private Paises paises;
    private ObjetosValiosos listaDeObjetos;
    private static Partida instance;

    private Partida() throws IOException, NoExisteError {
        policia = new Policia("Pepe", new Pais("Francia", "Paris"));

        CreadorCriminales factoryCriminales = new CreadorCriminales();
        Sospechosos sospechosos = factoryCriminales.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/sospechosos.txt");
        policia.setComputadora(new ComputadoraInterpol(sospechosos));

        CreadorPaises factoryPaises = new CreadorPaises();
        paises = factoryPaises.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");
        CreadorObjetos factoryObjetos = new CreadorObjetos(paises);
        listaDeObjetos = factoryObjetos.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/ObjetosValiosos.txt");
        CreadorPistas factoryPistas = new CreadorPistas();
        repositorioPistas = (RepositorioPistas) factoryPistas.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/PistasFaciles.txt");
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

    public Momento obtenerMomento(){

        return new Momento(policia.mirarDia(), policia.mirarLaHora());
    }

    public Policia getPolicia(){
        return policia;
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

}
