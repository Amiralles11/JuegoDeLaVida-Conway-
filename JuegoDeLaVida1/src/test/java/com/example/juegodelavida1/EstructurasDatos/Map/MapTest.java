package com.example.juegodelavida1.EstructurasDatos.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    @Test
    void isVacia() {
    }

    @Test
    void getPrimero() {
        Map<Integer, Integer> mapa = new Map<>();
        assertDoesNotThrow(()->mapa.getPrimero());
        assertDoesNotThrow(()->mapa.put(1, 2));
        assertDoesNotThrow(()->mapa.getPrimero());
    }

    @Test
    void getElemento() {
        Map<Integer, Integer> mapa = new Map<>();
        assertDoesNotThrow(()->mapa.getElemento(0));
        assertDoesNotThrow(()->mapa.put(1,45));
        assertDoesNotThrow(()->mapa.getElemento(0));
    }

    @Test
    void getPosicion() {
        Map<Integer, Integer> mapa = new Map<>();
        assertDoesNotThrow(()->mapa.getPosicion(2));
        assertDoesNotThrow(()->mapa.put(1,54));
        assertDoesNotThrow(()->mapa.put(3,32));
        assertDoesNotThrow(()->mapa.getPosicion(1));
        assertDoesNotThrow(()->mapa.del(0));
        assertDoesNotThrow(()->mapa.del(1));
    }

    @Test
    void del() {
    }

    @Test
    void put() {
    }

    @Test
    void get() {
    }

    @Test
    void keySet() {
    }

    @Test
    void isHashMapVacio() {
    }

    @Test
    void getNumElemMap() {
    }
}