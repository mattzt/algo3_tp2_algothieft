package edu.fiuba.algo3.modelo.ComputadoraInterpol;

import java.io.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Scanner;

public class ComputadoraInterpol
{

    private ArrayList<String[]> matrizAtributos = new ArrayList();
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
                matrizAtributos.add(index, lineaProcesada);
                index++;
            }
            lector.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void IngresarDatos() 
    {
        System.out.println("Seleccion con boto 0 al n, el atributo deseado o enter para nulo");
        for (String[] atributos: matrizAtributos)
        {
            for (String dato: atributos)
            {
                System.out.print(dato + " ");
            }
            Scanner entrada = new Scanner(System.in);
            System.out.println("\n" + entrada.nextInt());
            System.out.println("");
        }
    }
}
