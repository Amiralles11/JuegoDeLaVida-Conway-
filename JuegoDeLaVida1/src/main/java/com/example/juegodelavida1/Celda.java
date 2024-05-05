package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.scene.control.Button;

public class Celda {
    private final Button button;
    private final ListaSimple<Integer> coordenadas = new ListaSimple<>(2);
    private ListaSimple<Integer> individuos;
    private ListaSimple<Integer> recursos;

    public Celda(int fila, int columna, Button button) {
        this.coordenadas.add(fila);
        this.coordenadas.add(columna);
        this.button = button;
    }

    public Button getButton() {
        return button;
    }
}