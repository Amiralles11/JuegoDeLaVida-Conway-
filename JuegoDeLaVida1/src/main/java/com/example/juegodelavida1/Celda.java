package com.example.juegodelavida1;

import javafx.scene.control.Button;

public class Celda {
    private final Button button;
    private final int[] coordenadas = new int[2];
    private Individuo[] individuos;
    private Recurso[] recursos;

    public Celda(int fila, int columna, Button button) {
        this.coordenadas[0] = fila;
        this.coordenadas[1] = columna;
        this.button = button;
    }

    public Button getButton() {
        return button;
    }
}
