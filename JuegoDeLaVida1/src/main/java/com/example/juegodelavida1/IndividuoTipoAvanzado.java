package com.example.juegodelavida1;

import com.google.gson.annotations.Expose;

public class IndividuoTipoAvanzado extends Individuo{
    @Expose
    private int iD;
    public IndividuoTipoAvanzado(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        super(vidas, porcentajeReproduccion, porcentajeClonacion, porcentajeTipoAlReproducirse);
    }
    @Override
    public String toString() {
        {
            return "IndividuoAvanzado"+" "+iD+", vidas= "+super.getVidas()+"";
        }
    }

    public IndividuoTipoAvanzado(int i,Individuo individuo) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
    }

    @Override
    public void move() {

    }
}
