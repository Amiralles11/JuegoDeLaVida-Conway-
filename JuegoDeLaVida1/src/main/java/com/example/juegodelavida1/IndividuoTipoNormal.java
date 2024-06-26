package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.google.gson.annotations.Expose;

import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;

public class IndividuoTipoNormal extends Individuo{
    @Expose
    private int iD;
    public IndividuoTipoNormal(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        super(vidas, porcentajeReproduccion, porcentajeClonacion, porcentajeTipoAlReproducirse);
    }

    @Override
    public String toString() {
        {
            return "IndividuoNormal"+" "+iD+", vidas= "+super.getVidas();
        }
    }

    public IndividuoTipoNormal(int i,Individuo individuo) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
    }
    public IndividuoTipoNormal(int i, Individuo individuo, ListaEnlazada<String> cola) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
        super.setCola(cola);
    }
    @Override
    public int getId() {
        return iD;
    }
}
