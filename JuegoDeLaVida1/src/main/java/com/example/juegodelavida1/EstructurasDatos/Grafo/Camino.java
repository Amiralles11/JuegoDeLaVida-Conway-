package com.example.juegodelavida1.EstructurasDatos.Grafo;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;

public class Camino<TipoDato> {
    ListaEnlazada<Vertice<TipoDato>> camino;
    double peso;

    public Camino(ListaEnlazada<Vertice<TipoDato>> camino, double peso) {
        this.camino = camino;
        this.peso = peso;
    }

    public ListaEnlazada<Vertice<TipoDato>> getCamino() {
        return camino;
    }
}
