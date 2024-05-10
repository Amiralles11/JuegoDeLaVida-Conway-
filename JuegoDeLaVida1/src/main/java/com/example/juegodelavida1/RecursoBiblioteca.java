package com.example.juegodelavida1;

public class RecursoBiblioteca extends Recurso{
    private int porcentajeAparicion2;
    private int porcentajeClonacion;
    public RecursoBiblioteca(int tiempoAparicion, int porcentajeAparicion, int porcentajeAparicion2, int porcentajeClonacion) {
        super(tiempoAparicion, porcentajeAparicion);
        this.porcentajeAparicion2 = porcentajeAparicion2;
        this.porcentajeClonacion = porcentajeClonacion;
    }

    @Override
    public int getPorcentajeAparicion2() {
        return porcentajeAparicion2;
    }

    @Override
    public void setPorcentajeAparicion2(int porcentajeAparicion2) {
        this.porcentajeAparicion2=porcentajeAparicion2;

    }

    public int getPorcentajeClonacion() {
        return porcentajeClonacion;
    }

    public void setPorcentajeClonacion(int porcentajeClonacion) {
        this.porcentajeClonacion = porcentajeClonacion;
    }

    @Override
    public String toString() {
        return "RecursoBiblioteca, turnosRestantes = "+super.getTiempoAparicion();
    }
}
