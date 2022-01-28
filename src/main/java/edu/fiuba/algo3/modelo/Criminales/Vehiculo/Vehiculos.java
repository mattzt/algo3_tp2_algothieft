package edu.fiuba.algo3.modelo.Criminales.Vehiculo;

import edu.fiuba.algo3.modelo.Criminales.Caracteristica;

public interface Vehiculos extends Caracteristica {

    static Vehiculos crear(String tipoVehiculo){
        if (tipoVehiculo.equals("Deportivo")) return new Deportivo();
        if (tipoVehiculo.equals("Descapotable")) return new Descapotable();
        if (tipoVehiculo.equals("Limusina")) return new Limusina();
        return new Moto();
    }
}
