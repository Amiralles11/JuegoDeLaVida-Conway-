package com.example.juegodelavida1.EstructurasDatos.ListaSimple;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaSimpleTest {

    @Test
    void isVacia() {
        ListaSimple j = new ListaSimple(12);
        assertTrue(j.isVacia());
        j.add("Primer el");
        j.add("Segundo ele");
        j.add(3);
        j.add(4);
        assertFalse(j.isVacia());
    }

    @Test
    void vaciar() {
        ListaSimple l = new ListaSimple(12);
        assertDoesNotThrow(()->l.vaciar());
    }

    @Test
    void del() {
        ListaSimple j = new ListaSimple(2);
        j.add(2);
        j.del(0);
        assertEquals(0,j.del(0));
        j.add(0);
        assertEquals(0,j.del(3));
    }

    @Test
    void getPosicion() {
        ListaSimple<Integer> j = new ListaSimple<>(12);
        assertDoesNotThrow(()->j.getPosicion(1));
        j.add(1);
        assertDoesNotThrow(()->j.getPosicion(0));
    }

    @Test
    void getPrimero() {
        ListaSimple<Integer> l = new ListaSimple<>(12);
        l.vaciar();
        l.add(2);
        assertDoesNotThrow(l::getPrimero);

    }

    @Test
    void getSiguiente() {
        ListaSimple j = new ListaSimple(4);
        j.insert(1, 0);
        j.insert(2,1);
        j.insert(3,2);
        assertEquals(2,j.getSiguiente(1).getData());
        assertEquals(3,j.getSiguiente(2).getData());
        assertNull(j.getSiguiente(12));
    }

    @Test
    void getElemento() {
        ListaSimple j = new ListaSimple(12);
        j.add(2);
        assertDoesNotThrow(()->j.getElemento(0));
        assertDoesNotThrow(()->j.getElemento(2));

    }

}