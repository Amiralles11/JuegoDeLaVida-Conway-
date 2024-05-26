package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.google.gson.annotations.Expose;

public class IndividuoTipoAvanzado extends Individuo{
    @Expose
    private int iD;
    public IndividuoTipoAvanzado(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        super(vidas, porcentajeReproduccion, porcentajeClonacion, porcentajeTipoAlReproducirse);
    }
    public IndividuoTipoAvanzado(int i, Individuo individuo, ListaEnlazada<String> cola) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
        super.setCola(cola);
    }
    @Override
    public String toString() {
        {
            return "IndividuoAvanzado"+" "+iD+", vidas= "+super.getVidas()+"";
        }
    }


    public IndividuoTipoAvanzado(int i, Individuo individuo) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
    }
    @Override
    public int getId() {
        return iD;
    }
}
