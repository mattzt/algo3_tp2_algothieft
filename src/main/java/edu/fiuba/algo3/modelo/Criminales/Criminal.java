package edu.fiuba.algo3.modelo.Criminales;

public class Criminal {
    private String nombre;
    public Caracteristicas caracteristicas;

    public Criminal(String nombreCriminal,Caracteristicas nuevasCaracteristicas){
        nombre = nombreCriminal;
        caracteristicas = nuevasCaracteristicas;
    }


    public boolean tieneCaracteristica(Caracteristica buscada){
        return caracteristicas.tiene(buscada);
    }

    public boolean es(Criminal otroCriminal) {
        return nombre.equals(otroCriminal.nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public boolean equals(Criminal otroCriminal){
        return this.getNombre().equals(otroCriminal.getNombre());
    }
}
