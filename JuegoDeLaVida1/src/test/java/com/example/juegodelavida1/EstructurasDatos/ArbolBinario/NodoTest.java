package com.example.juegodelavida1.EstructurasDatos.ArbolBinario;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoTest {
    @Test
    void setData() {
        Nodo nodo = new Nodo(2);
        assertDoesNotThrow(()->nodo.setData(3));
    }
}