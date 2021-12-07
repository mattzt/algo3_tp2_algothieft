package edu.fiuba.algo3.modelo.Criminales;

import edu.fiuba.algo3.modelo.Caso.Objeto;
import edu.fiuba.algo3.modelo.Sexo.Sexo;

import java.util.ArrayList;

public class Criminal {
    ArrayList<Caracteristicas> caracteristicas;

    public Criminal(String[] dataSexo,String[] dataHobbie,String[] dataPelo,String[] dataAccesorios,String[] dataVehiculo){
        caracteristicas = new ArrayList<>();
        String sexo = dataSexo[0], pistaSexo = dataSexo[1];
        Sexo sexoDelCriminal = Sexo.establecer(sexo,pistaSexo);
        caracteristicas.add(sexoDelCriminal);
    }

    public String sexo() {
        int indexSexo = 0;
        return caracteristicas.get(indexSexo).valor();
    }
}