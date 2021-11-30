package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Fachada.Fachada;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class FachadaTest {
    Fachada calcDistancia;

    @BeforeEach
    public void setUp() {
        calcDistancia = new Fachada();
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
}