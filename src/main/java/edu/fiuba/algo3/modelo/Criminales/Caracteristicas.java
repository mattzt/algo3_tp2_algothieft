package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Criminales.Accesorios.Accesorios;
import edu.fiuba.algo3.modelo.Criminales.Hobbies.Hobbies;
import edu.fiuba.algo3.modelo.Criminales.Pelo.Pelo;
import edu.fiuba.algo3.modelo.Criminales.Sexo.Sexo;
import edu.fiuba.algo3.modelo.Criminales.Vehiculo.Vehiculos;

import java.util.ArrayList;

public class Caracteristicas {
    private final ArrayList<Caracteristica> caracteristicas;

    public Caracteristicas(Sexo nuevoSexo, Pelo nuevoPelo, Hobbies nuevoHobbie, Accesorios nuevoAccesorio, Vehiculos nuevoVehiculo){
        caracteristicas = new ArrayList<>();
        caracteristicas.add(nuevoSexo);
        caracteristicas.add(nuevoPelo);
        caracteristicas.add(nuevoHobbie);
        caracteristicas.add(nuevoAccesorio);
        caracteristicas.add(nuevoVehiculo);
    }

    public boolean tiene(Caracteristica buscada){
        int i = 0;
        boolean encontrada = false;
        Caracteristica leida;

        while((!encontrada) && (i < caracteristicas.size())){
            leida = caracteristicas.get(i);
            if(leida.valor().equals(buscada.valor()))
                encontrada = true;
            i++;
        }

        return encontrada;
    }

    public ArrayList<String> hacerPistas(){
        ArrayList<String> pistasCaracteristicas = new ArrayList<>();

        for(Caracteristica caracteristica : caracteristicas){
            String pista = caracteristica.crearPista();
            pistasCaracteristicas.add(pista);
        }
        return pistasCaracteristicas;
    }
}


