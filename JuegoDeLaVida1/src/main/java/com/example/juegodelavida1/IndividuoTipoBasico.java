package com.example.juegodelavida1;

import com.google.gson.annotations.Expose;

import java.util.Random;

public class IndividuoTipoBasico extends Individuo{
    @Expose
    private int iD;
    public IndividuoTipoBasico(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        super(vidas, porcentajeReproduccion, porcentajeClonacion, porcentajeTipoAlReproducirse);
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
    public void move() {
        Random r = new Random();
        int valor = r.nextInt(1, 4);
        if (valor == 1) {

        } else if (valor == 2) {

        } else if (valor == 3) {

        } else {

        }
    }

    @Override
    public int getId() {
        return iD;
    }
}
