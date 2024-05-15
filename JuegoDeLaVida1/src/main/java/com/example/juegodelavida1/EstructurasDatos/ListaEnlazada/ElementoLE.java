package com.example.juegodelavida1.EstructurasDatos.ListaEnlazada;

import com.google.gson.annotations.Expose;

public class ElementoLE<TipoDato> {
    @Expose
    private TipoDato data;
    @Expose
    private ElementoLE<TipoDato> siguiente;


    protected void insertarmeEn(ElementoLE<TipoDato> el) {
        this.siguiente = el.siguiente;
        el.siguiente = this;
    }

    public ElementoLE<TipoDato> getSiguiente() {
        return this.siguiente;
    }

    protected void setSiguiente(ElementoLE<TipoDato> el) {
        this.siguiente = el;
    }

    public TipoDato getData() {
        return this.data;
    }
    public void setData(TipoDato newData) {
        this.data = newData;
    }
}
