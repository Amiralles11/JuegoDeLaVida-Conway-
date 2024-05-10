package com.example.juegodelavida1;

public class RecursoAgua extends Recurso{
    private int porcentajeAparicion2;
    private int turnosVida;
    public RecursoAgua(int tiempoAparicion, int porcentajeAparicion, int porcentajeAparicion2,int turnosVida) {
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
        return "RecursoAgua, turnosRestantes = "+super.getTiempoAparicion();
    }
}
