package com.example.juegodelavida1;

public class RecursoBiblioteca extends Recurso{
    private int porcentajeAparicion2;
    public RecursoBiblioteca(int tiempoAparicion, int porcentajeAparicion, int porcentajeAparicion2) {
        super(tiempoAparicion, porcentajeAparicion);
        this.porcentajeAparicion2 = porcentajeAparicion2;
    }
    public RecursoBiblioteca(Recurso recurso){
        super(recurso.getTiempoAparicion(), recurso.getPorcentajeAparicion());
        this.porcentajeAparicion2 = recurso.getPorcentajeAparicion2();
    }

    @Override
    public int getPorcentajeAparicion2() {
        return porcentajeAparicion2;
    }

    @Override
    public void setPorcentajeAparicion2(int porcentajeAparicion2) {
        this.porcentajeAparicion2=porcentajeAparicion2;

    }
    public String toString2() {
        return "RecursoBiblioteca{TiempoAparicion = "+super.getTiempoAparicion()+"," +
                " PorcentajeAparicionAgua = "+porcentajeAparicion2+"}";
    }
    @Override
    public String toString() {
        return "RecursoBiblioteca, turnosRestantes = "+super.getTiempoAparicion();
    }
}
