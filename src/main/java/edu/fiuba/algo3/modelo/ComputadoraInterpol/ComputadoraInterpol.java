package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Accesorios;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Hobbies;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Pelo;
import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Vehiculos;

public class ComputadoraInterpol{
    Sospechosos sospechosos;
    Caracteristicas caracteristicas;

    public ComputadoraInterpol(Sospechosos listaDeSospechosos){
        sospechosos = listaDeSospechosos;
        caracteristicas = new Caracteristicas(null,null,null,null,null);
    }


    public Sospechosos buscarSospechosos(){
        return sospechosos.cumplenConCaracteristicas(caracteristicas);
    }

    public void ingresarDatosPelo(Pelo pelo){
        caracteristicas.establecerPelo(pelo);
    }

    public void ingresarDatosHobbies(Hobbies hobbie){
        caracteristicas.establecerHobbies(hobbie);
    }

    public void ingresarDatosAccesorios(Accesorios accesorio){
        caracteristicas.establecerAccesorio(accesorio);
    }

    public void ingresarDatosVehiculo(Vehiculos vehiculo){
        caracteristicas.establecerVehiculo(vehiculo);
    }

    public void ingresarDatosSexo(Sexo sexo){
        caracteristicas.establecerSexo(sexo);
    }

    public boolean sePuedeEmitirOrden(){
        if(sospechosos.size() != 1) {
            System.out.println("Aun no podes emitir una orden de arresto! Quedan mas de 1 sospechosos posibles\n");
            return false;
        }
        return true;
    }
}
