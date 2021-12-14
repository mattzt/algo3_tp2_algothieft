package edu.fiuba.algo3.modelo.Criminales;

public class Criminal {
    String nombre;
    Caracteristicas caracteristicas;

    public Criminal(String nombreCriminal,Caracteristicas nuevasCaracteristicas){
        nombre = nombreCriminal;
        caracteristicas = nuevasCaracteristicas;
    }


    public boolean tieneCaracteristica(Caracteristica buscada){
        return caracteristicas.tiene(buscada);
    }
}
