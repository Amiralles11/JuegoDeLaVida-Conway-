package com.example.juegodelavida1;

import com.google.gson.annotations.Expose;

public class RecursoTesoro extends Recurso{
    @Expose
    private int porcentajeAparicion2;
    @Expose
    private int porcentajeReproduccion;
    public RecursoTesoro(int tiempoAparicion, int porcentajeAparicion, int porcentajeAparicion2,int porcentajeReproduccion) {
        super(tiempoAparicion, porcentajeAparicion);
        this.porcentajeAparicion2 = porcentajeAparicion2;
        this.porcentajeReproduccion = porcentajeReproduccion;
    }

    @Override
    public int getPorcentajeAparicion2() {
        return porcentajeAparicion2;
    }

    @Override
    public void setPorcentajeAparicion2(int porcentajeAparicion2) {
        this.porcentajeAparicion2=porcentajeAparicion2;

    }

    public int getPorcentajeReproduccion() {
        return porcentajeReproduccion;
    }

    public void setPorcentajeReproduccion(int porcentajeReproduccion) {
        this.porcentajeReproduccion = porcentajeReproduccion;
    }

    @Override
    public String toString() {
        return "RecursoTesoro, turnosRestantes = "+super.getTiempoAparicion();
    }
}
