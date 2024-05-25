package com.example.juegodelavida1.EstructurasDatos.ListaEnlazada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaEnlazadaTest {

    @Test
    void vaciar() {
        ListaEnlazada<Integer> lista = new ListaEnlazada<>();
        assertDoesNotThrow(()->lista.add(2));
        assertDoesNotThrow(()->lista.add(4));
        assertDoesNotThrow(()->lista.add(6));
        assertDoesNotThrow(()->lista.toString2());
        assertDoesNotThrow(()->lista.vaciar());
        assertDoesNotThrow(()->lista.getElemento(0));
    }

    @Test
    void getElemento() {
    }
}