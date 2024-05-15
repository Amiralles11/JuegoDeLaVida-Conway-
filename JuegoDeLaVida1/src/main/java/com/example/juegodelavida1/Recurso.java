package com.example.juegodelavida1;

import com.google.gson.annotations.Expose;

public abstract class Recurso {
    @Expose
    private int tiempoAparicion;
    @Expose
    private int porcentajeAparicion;

    public Recurso(int tiempoAparicion, int porcentajeAparicion) {
        this.tiempoAparicion = tiempoAparicion;
        this.porcentajeAparicion = porcentajeAparicion;
    }

    public int getTiempoAparicion() {
        return tiempoAparicion;
    }

    public int getPorcentajeAparicion() {
        return porcentajeAparicion;
    }

    public void setTiempoAparicion(int tiempoAparicion) {
        this.tiempoAparicion = tiempoAparicion;
    }

    public void setPorcentajeAparicion(int porcentajeAparicion) {
        this.porcentajeAparicion = porcentajeAparicion;
    }
    public abstract int getPorcentajeAparicion2();
    public abstract void setPorcentajeAparicion2(int porcentajeAparicion2);
    public abstract String toString();
}
