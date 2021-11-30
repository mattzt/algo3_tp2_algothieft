package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class ComputadoraInterpol
{

    private ArrayList MatrizAtributos = new ArrayList();
    public ComputadoraInterpol(String rutaAtributos)  {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(rutaAtributos));
            String linea;
            String[] lineaProcesada;
            int index = 0;
            while ((linea = lector.readLine()) != null)
            {

                linea = lector.readLine();
                lineaProcesada = linea.split(",");
                MatrizAtributos.add(index, new ArrayList());
                MatrizAtributos.add(index, );
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void IngresarDatos() 
    {
        System.out.println("Sexo: \n");
        for ( String dato: (String[]) atributos.get("posible Sexo") )
        {
            System.out.println(dato);
        }
        System.out.println()
    }
}
