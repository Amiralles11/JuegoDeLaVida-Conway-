package com.example.juegodelavida1;

public class Tablero {
    int[] dimensiones = new int[2];

    public Tablero(int filas, int columnas) {
        this.dimensiones[0] = filas;
        this.dimensiones[1] = columnas;
    }

    public int[] getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(int[] dimensiones) {
        this.dimensiones = dimensiones;
    }
    public int getFilas() {
        return dimensiones[0];
    }
    public int getColumnas() {
        return dimensiones[1];
    }
    public void setFilas(int filas) {
        dimensiones[0] = filas;
    }
    public void setColumnas(int columnas) {
        dimensiones[1] = columnas;
    }

}
