package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import edu.fiuba.algo3.modelo.Accesorios.Anillo;
import edu.fiuba.algo3.modelo.Accesorios.Cicatriz;
import edu.fiuba.algo3.modelo.Accesorios.Joyas;
import edu.fiuba.algo3.modelo.Accesorios.Tatuaje;
import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Hobbies.*;
import edu.fiuba.algo3.modelo.Pelo.Castanio;
import edu.fiuba.algo3.modelo.Pelo.Negro;
import edu.fiuba.algo3.modelo.Pelo.Rojo;
import edu.fiuba.algo3.modelo.Pelo.Rubio;
import edu.fiuba.algo3.modelo.Sexo.SexoFemenino;
import edu.fiuba.algo3.modelo.Sexo.SexoMasculino;
import edu.fiuba.algo3.modelo.Vehiculo.Deportivo;
import edu.fiuba.algo3.modelo.Vehiculo.Descapotable;
import edu.fiuba.algo3.modelo.Vehiculo.Limusina;
import edu.fiuba.algo3.modelo.Vehiculo.Moto;

public class ProcesadorInput {

    public Caracteristicas procesarSexo(int opcion){
        Caracteristicas caracteristica = null;
        if (opcion == 1)
            caracteristica = new SexoMasculino();

        else if(opcion == 2)
            caracteristica = new SexoFemenino();

        return caracteristica;
    }

    public Caracteristicas procesarHobbie(int opcion){
        Caracteristicas caracteristica;
        switch (opcion){
            case 1:
                caracteristica = new Alpinismo();
                break;
            case 2:
                caracteristica = new Tenis();
                break;
            case 3:
                caracteristica = new Croquet();
                break;
            case 4:
                caracteristica = new Musica();
                break;
            case 5:
                caracteristica = new Natacion();
                break;
            case 6:
                caracteristica = new Paracaidismo();
                break;
            default:
                caracteristica = null;
                break;
        }
        return caracteristica;
    }

    public Caracteristicas procesarPelo(int opcion){
        Caracteristicas caracteristica = null;
        if (opcion == 1)
            caracteristica = new Rubio();

        else if(opcion == 2)
            caracteristica = new Negro();

        else if(opcion == 3)
            caracteristica = new Rojo();

        else if(opcion == 4)
            caracteristica = new Castanio();

        return caracteristica;
    }

    public Caracteristicas procesarAccesorio(int opcion){
        Caracteristicas caracteristica = null;
        if (opcion == 1)
            caracteristica = new Tatuaje();

        else if(opcion == 2)
            caracteristica = new Anillo();

        else if(opcion == 3)
            caracteristica = new Joyas();

        else if(opcion == 4)
            caracteristica = new Cicatriz();

        return caracteristica;
    }

    public Caracteristicas procesarVehiculo(int opcion){
        Caracteristicas caracteristica = null;
        if (opcion == 1)
            caracteristica = new Limusina();

        else if(opcion == 2)
            caracteristica = new Descapotable();

        else if(opcion == 3)
            caracteristica = new Moto();

        else if(opcion == 4)
            caracteristica = new Deportivo();

        return caracteristica;
    }
}
