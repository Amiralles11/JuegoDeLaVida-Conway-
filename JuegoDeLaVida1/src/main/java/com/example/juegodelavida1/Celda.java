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

    public Celda(int fila, int columna) {
        ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();
        ListaEnlazada<Recurso> listaRecursos = new ListaEnlazada<>();
        this.coordenadas.add(fila);
        this.coordenadas.add(columna);
        this.individuos = listaIndividuos;
        this.recursos = listaRecursos;
    }

    public Celda(int fila, int columna, Rectangle rectangle) {
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
        return "Celda(" + (getFilas() + 1) + "," + (getColumnas() + 1) + "){" +
                "coordenadas=" + coordenadas +
                ", individuos=" + individuos +
                ", recursos=" + recursos +
                '}';
    }

    protected void add(Individuo individuo) {
        individuos.add(individuo);
    }

    protected void add(Recurso recurso) {
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
            int zz = 0;
            if (getRecursos().getNumeroElementos() >= 1) {
                for (int i = 0; i < getRecursos().getNumeroElementos(); i++) {
                    if (getRecursos().getElemento(i).getData().getClass().descriptorString().contains("RecursoAgua")) {
                        if (zz < 1) {
                            zz = 1;
                        }
                    } else if (getRecursos().getElemento(i).getData().getClass().descriptorString().contains("RecursoComida")) {
                        if (zz < 1) {
                            zz = 1;
                        }
                    } else if (getRecursos().getElemento(i).getData().getClass().descriptorString().contains("RecursoBiblioteca")) {
                        if (zz < 1) {
                            zz = 1;
                        }

                    } else if (getRecursos().getElemento(i).getData().getClass().descriptorString().contains("RecursoMontaña")) {
                        if (zz < 2) {
                            zz = 2;
                        }
                    } else if (getRecursos().getElemento(i).getData().getClass().descriptorString().contains("RecursoPozo")) {
                        zz = 3;
                    } else if (getRecursos().getElemento(i).getData().getClass().descriptorString().contains("RecursoTesoro")) {
                        if (zz < 1) {
                            zz = 1;
                        }
                    }
                }
            }
            if(zz==0){
                rectangle.setFill(Color.WHITE);
            }
            else if (zz == 1) {
                rectangle.setFill(Color.LIGHTGREEN);
            } else if (zz == 2) {
                rectangle.setFill(Color.LIGHTCORAL);
            } else if (zz == 3) {
                rectangle.setFill(Color.BLACK);
            }
        } else if (getIndividuos().getNumeroElementos() == 1) {
            rectangle.setFill(Color.BLUE);
        } else if (getIndividuos().getNumeroElementos() == 2) {
            rectangle.setFill(Color.DARKBLUE);
        } else if (getIndividuos().getNumeroElementos() == 3) {
            rectangle.setFill(Color.MIDNIGHTBLUE);
        }

    }
}