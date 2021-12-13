package edu.fiuba.algo3.modelo.Caso;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Mapa.Paises.Pais;

import java.util.ArrayList;

public class ObjetosValiosos implements Listable {
    ArrayList<Objeto> listaDeObjetosValiosos;

    public ObjetosValiosos() {
        listaDeObjetosValiosos = new ArrayList<>();
    }

    public void agregar(Objeto nuevoObjeto) {
        listaDeObjetosValiosos.add(nuevoObjeto);
    }

    public Objeto buscar(String nombreObjeto) throws NoExisteError {
        for(Objeto objeto: listaDeObjetosValiosos){
            if (objeto.equals(nombreObjeto)) return objeto;
        }
        throw new NoExisteError("El objeto no esta creado");
    }

    @Override
    public int size() {
        return listaDeObjetosValiosos.size();
    }

    public Objeto robar(int nivelAgente) {
        return new Objeto("TestRobado",new Pais("TestPais","TestCiudad"),1);
    }
}
