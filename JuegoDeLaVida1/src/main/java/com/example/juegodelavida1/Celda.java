package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import com.google.gson.annotations.Expose;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Celda {
    private Rectangle rectangle;
    @Expose
    private final ListaSimple<Integer> coordenadas = new ListaSimple<>(2);
    @Expose
    private ListaEnlazada<Individuo> individuos = new ListaEnlazada<>();
    @Expose
    private ListaEnlazada<Recurso> recursos = new ListaEnlazada<>();

    public Celda(int fila, int columna){
        this.coordenadas.add(fila);
        this.coordenadas.add(columna);

    }
    public Celda(int fila, int columna,Rectangle rectangle){
        this.coordenadas.add(fila);
        this.coordenadas.add(columna);
        this.rectangle = rectangle;

    }

    public Integer getFilas() {
        return coordenadas.getElemento(0).getData();
    }
    public Integer getColumnas() {
        return coordenadas.getElemento(1).getData();
    }

    @Override
    public String toString() {
        return "Celda("+(getFilas()+1)+","+(getColumnas()+1)+"){" +
                "coordenadas=" + coordenadas +
                ", individuos=" + individuos +
                ", recursos=" + recursos +
                '}';
    }
    protected void add(Individuo individuo){
        individuos.add(individuo);
    }
    protected void add(Recurso recurso){
        recursos.add(recurso);
    }

    public ListaEnlazada<Individuo> getIndividuos() {
        return individuos;
    }

    public void setIndividuos(ListaEnlazada<Individuo> individuos) {
        this.individuos = individuos;
    }

    public ListaEnlazada<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(ListaEnlazada<Recurso> recursos) {
        this.recursos = recursos;
    }
    protected void updateGUIwithModel() {
        if (getIndividuos().getNumeroElementos() == 0) {
            rectangle.setFill(Color.WHITE);
        } else if (getIndividuos().getNumeroElementos() == 1) {
            rectangle.setFill(Color.LIGHTYELLOW);
        } else if (getIndividuos().getNumeroElementos() == 2) {
            rectangle.setFill(Color.YELLOW);
        } else if (getIndividuos().getNumeroElementos() == 3) {
            rectangle.setFill(Color.YELLOWGREEN);
        }
    }
}