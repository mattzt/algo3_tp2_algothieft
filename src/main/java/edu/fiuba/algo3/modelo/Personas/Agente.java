package edu.fiuba.algo3.modelo.Personas;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.Paises.Pais;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Agente{
    private final String nombre;
    private Rango rango;
    private Pais paisActual;
    private Caso casoAsignado;

    public Agente(String nombreAgente){
        nombre = nombreAgente;
        rango = new Novato();
    }

    public int viajarACiudad(Pais unPais){
        int horasDeViaje = paisActual.distanciaA(unPais);
        casoAsignado.avanzarReloj(horasDeViaje);
        paisActual = unPais;
        return horasDeViaje;
    }

    public void nuevoCaso(Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos){
        casoAsignado = rango.nuevoCaso(listaDeSospechosos,listaDeObjetos);
    }

    public void visitarEdificio(Edificio unEdificio){
        int cantVisitas = unEdificio.visitar();
        casoAsignado.avanzarReloj(cantVisitas);
    }

    public boolean es(String unNombre){
        return nombre.equals(unNombre);
    }

    public boolean esRango(Rango unRango) {
        return rango.equals(unRango);
    }

    public boolean tieneArrestos(int arrestos) {
        return rango.cantidadArrestos() == arrestos;
    }
}
