package edu.fiuba.algo3.modelo.Mapa.Paises;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Listable;
import edu.fiuba.algo3.modelo.Randomizador;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Paises implements Listable {
    private final ArrayList<Pais> paises;

    public Paises() {
        paises = new ArrayList<>();
    }

    public void agregar(Pais nuevoPais) {
        paises.add(nuevoPais);
    }

    public Pais buscar(String nombrePais) throws NoExisteError {
        for(Pais pais: paises){
            if (nombrePais.equals(pais.getNombre())) return pais;
        }
        throw new NoExisteError("El país no esta creado");
    }

    public int size() {
        return paises.size();
    }

    public ArrayList<Pais> elegirRutaDeEscapePorNivel(Pais paisDelObjeto, int cantidadDePaisesDeEscape) {
        ArrayList<Pais> listaTodosLosPaises = new ArrayList<>(paises);
        ArrayList<Pais> rutaDeEscape = new ArrayList<>();
        rutaDeEscape.add(paisDelObjeto);
        listaTodosLosPaises.remove(paisDelObjeto);
        while (rutaDeEscape.size()!=cantidadDePaisesDeEscape){
            Pais nuevoPaisDeEscape = listaTodosLosPaises.remove(Randomizador.indiceRandom(listaTodosLosPaises));
            rutaDeEscape.add(nuevoPaisDeEscape);
        }
        return rutaDeEscape;
    }

    private Pais elegirPaisConMenosConexos(ArrayList<Pais> unaListaDePaises){
        int cantConexos = 3;
        for (Pais pais : unaListaDePaises){
            int cantConexosNuevoPais = pais.cantidadDePaisesConexos();
            if (cantConexosNuevoPais <= cantConexos){
                cantConexos = cantConexosNuevoPais;
            }
        }
        ArrayList<Pais> listaFinal = new ArrayList<>();
        for (Pais pais2 : unaListaDePaises){
            int cantConexosPais2 = pais2.cantidadDePaisesConexos();
            if (cantConexosPais2<=cantConexos) listaFinal.add(pais2);
        }
        return listaFinal.get(Randomizador.indiceRandom(listaFinal));
    }

    public void setPaisesConexos(){
        for (Pais pais : paises){
            ArrayList<Pais> copiaListaPaises = new ArrayList<>(paises);
            copiaListaPaises.remove(pais);
            while (pais.puedeAgregarConexos()){
                Pais unPaisConexo = elegirPaisConMenosConexos(copiaListaPaises);
                if (unPaisConexo.puedeAgregarConexos()){
                    pais.agregarPaisConexo(unPaisConexo);
                    unPaisConexo.agregarPaisConexo(pais);
                }
            }
        }
    }

    /** Test method only*/
    public boolean testConexosCompletos() {
        for (Pais pais : paises){
            if (pais.cantidadDePaisesConexos()!=3) return false;
        }
        return true;
    }
}
