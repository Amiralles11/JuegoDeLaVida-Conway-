package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;

import com.google.gson.annotations.Expose;

public abstract class Individuo {
    @Expose
    private int vidas;
    @Expose
    private int porcentajeReproduccion;
    @Expose
    private int porcentajeClonacion;
    @Expose
    private int porcentajeTipoAlReproducirse;
    private boolean movido;
    private ListaSimple<Integer> ruta = new ListaSimple<>(2);

    public Individuo(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        ListaSimple<Integer> nuevaRuta = new ListaSimple<>(2);
        nuevaRuta.add(0);
        nuevaRuta.add(0);
        this.vidas = vidas;
        this.porcentajeReproduccion = porcentajeReproduccion;
        this.porcentajeClonacion = porcentajeClonacion;
        this.porcentajeTipoAlReproducirse = porcentajeTipoAlReproducirse;
        this.movido = false;
        this.ruta = nuevaRuta;
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


    public ListaSimple<Integer> getRuta() {
        return ruta;
    }

    public void setRuta(ListaSimple<Integer> ruta) {
        this.ruta = ruta;
    }

}
