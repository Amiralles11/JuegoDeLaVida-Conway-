package com.example.juegodelavida1;

public abstract class Individuo {
    private int vidas;
    private int porcentajeReproduccion;
    private int porcentajeClonacion;
    private int porcentajeTipoAlReproducirse;

    private boolean movido;

    public Individuo(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        this.vidas = vidas;
        this.porcentajeReproduccion = porcentajeReproduccion;
        this.porcentajeClonacion = porcentajeClonacion;
        this.porcentajeTipoAlReproducirse = porcentajeTipoAlReproducirse;
        this.movido = false;
    }

    public int getVidas() {
        return vidas;
    }

    public int getPorcentajeReproduccion() {
        return porcentajeReproduccion;
    }

    public int getPorcentajeClonacion() {
        return porcentajeClonacion;
    }

    public int getPorcentajeTipoAlReproducirse() {
        return porcentajeTipoAlReproducirse;
    }

    public boolean isMovido() {
        return movido;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public void setPorcentajeReproduccion(int porcentajeReproduccion) {
        this.porcentajeReproduccion = porcentajeReproduccion;
    }

    public void setPorcentajeClonacion(int porcentajeClonacion) {
        this.porcentajeClonacion = porcentajeClonacion;
    }

    public void setPorcentajeTipoAlReproducirse(int porcentajeTipoAlReproducirse) {
        this.porcentajeTipoAlReproducirse = porcentajeTipoAlReproducirse;
    }

    public void setMovido(boolean movido) {
        this.movido = movido;
    }

    public abstract String toString();
    public abstract void move();

}
