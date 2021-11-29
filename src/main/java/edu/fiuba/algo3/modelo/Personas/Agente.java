package edu.fiuba.algo3.modelo.Personas;

import edu.fiuba.algo3.modelo.Caso.Caso;
import edu.fiuba.algo3.modelo.Caso.ObjetosValiosos;
import edu.fiuba.algo3.modelo.Ciudades.Ciudad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Estados.Estado;

public class Agente{
    private final String nombre;
    private Rango rango;
    private Ciudad ciudadActual;
    private Caso casoAsignado;

    public Agente(String nombreAgente){
        nombre = nombreAgente;
        rango = new Novato();
    }

    public int viajarACiudad(Ciudad unaCiudad){
        int horasDeViaje = ciudadActual.distanciaA(unaCiudad);
        casoAsignado.avanzarReloj(horasDeViaje);
        ciudadActual = unaCiudad;
        return horasDeViaje;
    }

    public void nuevoCaso(Sospechosos listaDeSospechosos, ObjetosValiosos listaDeObjetos){
        casoAsignado = rango.nuevoCaso(listaDeSospechosos,listaDeObjetos);
    }

    public void visitarEdificio(Edificio unEdificio){
        int cantVisitas = unEdificio.visitar(this);
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
