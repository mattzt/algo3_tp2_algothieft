package edu.fiuba.algo3.modelo.Factory;

import edu.fiuba.algo3.modelo.Criminales.Caracteristicas;
import edu.fiuba.algo3.modelo.Criminales.Criminal;
import edu.fiuba.algo3.modelo.Criminales.Sospechosos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreadorCriminales implements Factory{

    @Override
    public Sospechosos crear(String rutaArchivoSospechosos) throws FileNotFoundException {
        File archivoData = new File(rutaArchivoSospechosos);
        Scanner scanner = new Scanner(archivoData);
        Sospechosos listaDeSospechosos = new Sospechosos();

        scanner.nextLine();
        while (scanner.hasNextLine()){
            String[] dataSospechosos = scanner.nextLine().split(",");
            String nombreSospechoso = dataSospechosos[0];
            String sexoSospechoso = dataSospechosos[1];
            String hobbieSospechoso = dataSospechosos[2];
            String peloSospechoso = dataSospechosos[3];
            String accesorioSospechoso = dataSospechosos[4];
            String vehiculoSospechoso = dataSospechosos[5];

            CreadorCaracteristicas creadorCar = new CreadorCaracteristicas();
            Caracteristicas caracteristicasCriminal = creadorCar.crear(sexoSospechoso,hobbieSospechoso,peloSospechoso,accesorioSospechoso,vehiculoSospechoso);
            Criminal criminal = new Criminal(nombreSospechoso,caracteristicasCriminal);
            listaDeSospechosos.agregarSospechoso(criminal);
        }
        return listaDeSospechosos;
    }
}
