package com.example.juegodelavida1;

import com.google.gson.annotations.Expose;

public class RecursoPozo extends Recurso{
    @Expose
    private int porcentajeAparicion2;
    public RecursoPozo(int tiempoAparicion, int porcentajeAparicion, int porcentajeAparicion2) {
        super(tiempoAparicion, porcentajeAparicion);
        this.porcentajeAparicion2 = porcentajeAparicion2;
    }

    @Override
    public int getPorcentajeAparicion2() {
        return porcentajeAparicion2;
    }

    @Override
    public void setPorcentajeAparicion2(int porcentajeAparicion2) {
        this.porcentajeAparicion2=porcentajeAparicion2;

    }
    @Override
    public String toString() {
        return "RecursoPozo, turnosRestantes = "+super.getTiempoAparicion();
    }
}
