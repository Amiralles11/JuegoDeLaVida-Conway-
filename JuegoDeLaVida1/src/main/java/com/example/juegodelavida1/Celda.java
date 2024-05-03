package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.scene.control.Button;

public class Celda {
    private final ListaSimple<Integer> coordenadas = new ListaSimple<>(2);
    private ListaSimple<Integer> individuos;
    private ListaSimple<Integer> recursos;

    public Celda(int fila, int columna) {
        this.coordenadas.add(fila);
        this.coordenadas.add(columna);
    }

    public Integer getFilas() {
        return coordenadas.getElemento(0).getData();
    }
    public Integer getColumnas() {
        return coordenadas.getElemento(1).getData();
    }

    @Override
    public String toString() {
        return "Celda{" +
                "coordenadas=" + coordenadas +
                ", individuos=" + individuos +
                ", recursos=" + recursos +
                '}';
    }
}

