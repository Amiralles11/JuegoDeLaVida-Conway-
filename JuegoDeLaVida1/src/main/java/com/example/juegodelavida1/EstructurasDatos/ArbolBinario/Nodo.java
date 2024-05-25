package com.example.juegodelavida1.EstructurasDatos.ArbolBinario;

import com.example.juegodelavida1.EstructurasDatos.Grafo.ElementoRepetidoExcepcion;

public class Nodo<TipoDato> {
    public TipoDato dato;
    public Nodo<TipoDato> izq;
    public Nodo<TipoDato> drch;
    public Nodo(TipoDato dato) {
        this.dato = dato;
        this.izq = null;
        this.drch = null;
    }
    public void add(Nodo<TipoDato> nuevonodo) throws ElementoRepetidoExcepcion {
        Comparable midato = (Comparable) this.dato;
        Comparable nuevoDato = (Comparable) nuevonodo.dato;

        int rdo = midato.compareTo(nuevoDato);

        if (rdo == 0){
            // Son iguales, devuelvo un error
            throw new ElementoRepetidoExcepcion("Error, se ha intentado añadir un elemento ya existente al árbol.");
        }
        if (rdo > 0){
            if (this.izq!=null)
                this.izq.add(nuevonodo);
            else
                this.izq=nuevonodo;
        } else {
            if (this.drch!=null)
                this.drch.add(nuevonodo);
            else
                this.drch=nuevonodo;
        }
    }
    public TipoDato getData() {
        return this.dato;
    }
    public void setData(TipoDato nuevoDato) {
        this.dato = nuevoDato;
    }
    public int getGrado() {
        if ((this.izq==null)&&(this.drch==null)) {
            return 0;
        } else if ((this.drch==null)||(this.izq==null)) {
            return 1;
        } else {
            return 2;
        }
    }

    public TipoDato getDato() {
        return dato;
    }

    public Nodo<TipoDato> getIzq() {
        return izq;
    }

    public Nodo<TipoDato> getDrch() {
        return drch;
    }
}
