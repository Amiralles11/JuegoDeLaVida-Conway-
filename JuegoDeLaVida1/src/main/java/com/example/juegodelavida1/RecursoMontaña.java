package com.example.juegodelavida1;

public class RecursoMontaña extends Recurso{
    private int porcentajeAparicion2;
    public RecursoMontaña(int tiempoAparicion, int porcentajeAparicion, int porcentajeAparicion2) {
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
}
