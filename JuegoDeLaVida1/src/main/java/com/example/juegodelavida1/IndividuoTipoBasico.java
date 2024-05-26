package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.google.gson.annotations.Expose;

import java.util.Random;

public class IndividuoTipoBasico extends Individuo{
    @Expose
    private int iD;
    public IndividuoTipoBasico(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        super(vidas, porcentajeReproduccion, porcentajeClonacion, porcentajeTipoAlReproducirse);
    }

    public IndividuoTipoBasico(int i, Individuo individuo, ListaEnlazada<String> cola) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
        super.setCola(cola);
    }
    @Override
    public String toString() {
        {
            return "IndividuoBasico"+" "+iD+", vidas= "+super.getVidas();
        }
    }

    public IndividuoTipoBasico(int i,Individuo individuo) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
    }
    @Override
    public int getId() {
        return iD;
    }
}
