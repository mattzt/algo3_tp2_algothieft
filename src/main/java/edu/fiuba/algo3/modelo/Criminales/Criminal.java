package edu.fiuba.algo3.modelo.Criminales;

public class Criminal {
    private String nombre;
    private Caracteristicas caracteristicas;

    public Criminal(String nombreCriminal,Caracteristicas nuevasCaracteristicas){
        nombre = nombreCriminal;
        caracteristicas = nuevasCaracteristicas;
    }


    public boolean tieneCaracteristica(Caracteristica buscada){
        return caracteristicas.tiene(buscada);
    }

    public String getNombre(){
        return nombre;
    }
}
