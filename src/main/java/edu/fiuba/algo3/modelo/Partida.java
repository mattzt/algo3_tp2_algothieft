package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Factory.CreadorObjetos;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Factory.CreadorPistas;
import edu.fiuba.algo3.modelo.Factory.Factory;
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

    public Partida(Policia nuevoPoli) throws IOException, NoExisteError {
        CreadorPaises factoryPaises = new CreadorPaises();
        paises = factoryPaises.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt");
        CreadorObjetos factoryObjetos = new CreadorObjetos(paises);
        listaDeObjetos = factoryObjetos.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/ObjetosValiosos.txt");
        CreadorPistas factoryPistas = new CreadorPistas();
        repositorioPistas = (RepositorioPistas) factoryPistas.crear("src/main/java/edu/fiuba/algo3/modelo/Resources/PistasFaciles.txt");
    }

    public RepositorioPistas obtenerPistas(){
        return repositorioPistas;
    }

    public Momento obtenerMomento(){

        return new Momento(policia.mirarDia(), policia.mirarLaHora());
    }

}
