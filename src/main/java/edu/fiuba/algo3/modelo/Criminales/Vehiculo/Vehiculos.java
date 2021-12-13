package edu.fiuba.algo3.modelo.Criminales.Vehiculo;
public interface Vehiculos {

    static Vehiculos crear(String tipoVehiculo){
        if (tipoVehiculo.equals("Deportivo")) return new Deportivo();
        if (tipoVehiculo.equals("Descapotable")) return new Descapotable();
        if (tipoVehiculo.equals("Limusina")) return new Limusina();
        return new Moto();
    }
    String valor();


    default boolean vehiculoEsIgualA(Vehiculos vehiculo){
        return this.valor().equals(vehiculo.valor());
    }
}
