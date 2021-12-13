package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Exceptions.NoExisteError;
import edu.fiuba.algo3.modelo.Mapa.Mapa;
import edu.fiuba.algo3.modelo.Factory.CreadorPaises;
import edu.fiuba.algo3.modelo.Factory.Factory;
import edu.fiuba.algo3.modelo.Mapa.Paises.Paises;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FachadaTest {
    Mapa calcDistancia;

    @BeforeEach
    public void setUp() {
        calcDistancia = new Mapa();
    }

    @Test
    public void calculaDistanciaCorrectamente01() throws FileNotFoundException {
       int distanciaArgentinaPeru =  calcDistancia.calcularDistanciaDeHasta("Argentina","Peru");
        Assertions.assertEquals(3138,distanciaArgentinaPeru);
    }

    @Test
    public void calculaDistanciaCorrectamente02() throws FileNotFoundException {
        int distanciaIrakGrecia =  calcDistancia.calcularDistanciaDeHasta("Irak","Grecia");
        Assertions.assertEquals(1934,distanciaIrakGrecia);
    }

    @Test
    public void calculaDistanciaCorrectamente03() throws FileNotFoundException {
        int distanciaJaponTailandia =  calcDistancia.calcularDistanciaDeHasta("Japon","Tailandia");
        Assertions.assertEquals(4603,distanciaJaponTailandia);
    }

    @Test
    public void distanciaJPNTAIigualATAIJPN() throws FileNotFoundException {
        int distanciaJaponTailandia =  calcDistancia.calcularDistanciaDeHasta("Tailandia","Japon");
        Assertions.assertEquals(4603,distanciaJaponTailandia);
    }

    @Test
    public void crearPaisesFuncionaCorrectamente() throws IOException, NoExisteError {
        Factory factory = new CreadorPaises();
        String rutaDataPaises = "src/main/java/edu/fiuba/algo3/modelo/Resources/DataPaises.txt";
        Paises paises = (Paises) factory.crear(rutaDataPaises);
        Assertions.assertEquals(30,paises.size());
    }
}