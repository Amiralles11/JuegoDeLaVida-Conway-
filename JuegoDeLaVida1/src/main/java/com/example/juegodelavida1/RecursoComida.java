package com.example.juegodelavida1;

import com.google.gson.annotations.Expose;

public class RecursoComida extends Recurso{
    @Expose
    private int porcentajeAparicion2;
    @Expose
    private int turnosVida;
    public RecursoComida(int tiempoAparicion, int porcentajeAparicion, int porcentajeAparicion2, int turnosVida) {
        super(tiempoAparicion, porcentajeAparicion);
        this.porcentajeAparicion2 = porcentajeAparicion2;
        this.turnosVida = turnosVida;
    }

    @Override
    public int getPorcentajeAparicion2() {
        return porcentajeAparicion2;
    }

    @Override
    public void setPorcentajeAparicion2(int porcentajeAparicion2) {
        this.porcentajeAparicion2=porcentajeAparicion2;

    }

    public int getTurnosVida() {
        return turnosVida;
    }

    public void setTurnosVida(int turnosVida) {
        this.turnosVida = turnosVida;
    }

    @Override
    public String toString() {
        return "RecursoComida, turnosRestantes = "+super.getTiempoAparicion();
    }
}
