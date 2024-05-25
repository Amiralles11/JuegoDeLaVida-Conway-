package com.example.juegodelavida1.EstructurasDatos.ArbolBinario;

import com.example.juegodelavida1.EstructurasDatos.Grafo.ElementoRepetidoExcepcion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArbolBinarioTest {
    @Test
    void add() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.add(2));
        assertThrows(ElementoRepetidoExcepcion.class,()-> a.add(2));
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.add(1));
        assertDoesNotThrow(()->a.add(0));
        assertDoesNotThrow(()->a.add(12));

    }

    @Test
    void getSubArbolIzquierda() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.getSubArbolIzquierda());
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.add(1));
        assertDoesNotThrow(()->a.getSubArbolIzquierda());
    }

    @Test
    void getSubArbolDerecha() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.getSubArbolDerecha());
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.getSubArbolDerecha());
    }

    @Test
    void getListaPreOrden() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.add(6));
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.getListaPreOrden());
    }

    @Test
    void getListaOrdenCentral() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.add(6));
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.getListaOrdenCentral());
    }

    @Test
    void getListaPostOrden() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.add(6));
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.getListaPostOrden());
    }

    @Test
    void getGrado() {
        ArbolBinario a = new ArbolBinario();
        ArbolBinario b = new ArbolBinario();
        assertDoesNotThrow(()->a.getGrado());
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.getGrado());
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.add(1));
        assertDoesNotThrow(()->a.getGrado());
        assertDoesNotThrow(()->a.add(0));
        assertDoesNotThrow(()->a.getGrado());
        assertDoesNotThrow(()->a.add(6));
        assertDoesNotThrow(()->a.getGrado());
        assertDoesNotThrow(()->b.add(5));
        assertDoesNotThrow(()->b.add(7));
        assertDoesNotThrow(()->b.add(8));
        assertDoesNotThrow(()->b.add(3));
        assertDoesNotThrow(()->b.getGrado());

    }

    @Test
    void getAltura() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.getAltura());
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.getAltura());
    }

    @Test
    void getListaDatosNivel() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.getListaDatosNivel(1));
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.getListaDatosNivel(1));
        assertDoesNotThrow(()->a.getListaDatosNivel(0));
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.getListaDatosNivel(2));
    }

    @Test
    void getListaNodosNivel() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.getListaNodosNivel(1));
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.getListaNodosNivel(1));
        assertDoesNotThrow(()->a.getListaNodosNivel(0));
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.getListaNodosNivel(2));
    }

    @Test
    void isArbolCompleto() {
        ArbolBinario a = new ArbolBinario();
        assertDoesNotThrow(()->a.isArbolCompleto());
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.isArbolCompleto());
    }

    @Test
    void isArbolHomogeneo() {
        ArbolBinario a = new ArbolBinario();
        ArbolBinario b = new ArbolBinario();
        assertDoesNotThrow(()->a.isArbolHomogeneo());
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.isArbolHomogeneo());
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.isArbolHomogeneo());
        assertDoesNotThrow(()->a.add(2));
        assertDoesNotThrow(()->a.add(4));
        assertDoesNotThrow(()->a.isArbolHomogeneo());
        assertDoesNotThrow(()->a.add(7));
        assertDoesNotThrow(()->a.isArbolHomogeneo());
        assertDoesNotThrow(()->a.add(6));
        assertDoesNotThrow(()->a.add(8));
        assertDoesNotThrow(()->a.isArbolHomogeneo());
        assertDoesNotThrow(()->b.add(5));
        assertDoesNotThrow(()->b.add(7));
        assertDoesNotThrow(()->b.isArbolHomogeneo());
        assertDoesNotThrow(()->b.add(8));
        assertDoesNotThrow(()->b.isArbolHomogeneo());
        assertDoesNotThrow(()->b.add(6));
        assertDoesNotThrow(()->b.isArbolHomogeneo());
    }

    @Test
    void getCamino() {
        ArbolBinario a = new ArbolBinario();
        ArbolBinario b = new ArbolBinario();
        assertDoesNotThrow(()->b.getCamino(5));
        assertDoesNotThrow(()->a.getCamino(null));
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.getCamino(5));
        assertDoesNotThrow(()->a.add(7));
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.getCamino(7));
        assertDoesNotThrow(()->a.getCamino(3));
    }

    @Test
    void isArbolCasiCompleto() {
        ArbolBinario a = new ArbolBinario();
        ArbolBinario b = new ArbolBinario();
        ArbolBinario c = new ArbolBinario();
        ArbolBinario d = new ArbolBinario();
        ArbolBinario e = new ArbolBinario();
        ArbolBinario f = new ArbolBinario();
        ArbolBinario g = new ArbolBinario();
        ArbolBinario h = new ArbolBinario();
        assertDoesNotThrow(()->a.isArbolCasiCompleto());
        assertDoesNotThrow(()->a.add(5));
        assertDoesNotThrow(()->a.isArbolCasiCompleto());
        assertDoesNotThrow(()->a.add(3));
        assertDoesNotThrow(()->a.isArbolCasiCompleto());
        assertDoesNotThrow(()->a.add(7));
        assertDoesNotThrow(()->a.isArbolCasiCompleto());
        assertDoesNotThrow(()->b.add(5));
        assertDoesNotThrow(()->b.add(7));
        assertDoesNotThrow(()->b.isArbolCasiCompleto());
        assertDoesNotThrow(()->c.add(5));
        assertDoesNotThrow(()->c.add(3));
        assertDoesNotThrow(()->c.add(7));
        assertDoesNotThrow(()->c.add(2));
        assertDoesNotThrow(()->c.add(4));
        assertDoesNotThrow(()->c.isArbolCasiCompleto());
        assertDoesNotThrow(()->d.add(5));
        assertDoesNotThrow(()->d.add(3));
        assertDoesNotThrow(()->d.add(2));
        assertDoesNotThrow(()->d.isArbolCasiCompleto());
        assertDoesNotThrow(()->e.add(5));
        assertDoesNotThrow(()->e.add(3));
        assertDoesNotThrow(()->e.add(7));
        assertDoesNotThrow(()->e.add(2));
        assertDoesNotThrow(()->e.add(6));
        assertDoesNotThrow(()->e.isArbolCasiCompleto());
        assertDoesNotThrow(()->e.add(4));
        assertDoesNotThrow(()->e.add(8));
        assertDoesNotThrow(()->e.isArbolCasiCompleto());
        assertDoesNotThrow(()->f.add(5));
        assertDoesNotThrow(()->f.add(3));
        assertDoesNotThrow(()->f.add(7));
        assertDoesNotThrow(()->f.add(2));
        assertDoesNotThrow(()->f.isArbolCasiCompleto());
        assertDoesNotThrow(()->g.add(5));
        assertDoesNotThrow(()->g.add(3));
        assertDoesNotThrow(()->g.add(7));
        assertDoesNotThrow(()->g.add(4));
        assertDoesNotThrow(()->g.isArbolCasiCompleto());
        assertDoesNotThrow(()->e.add(1));
        assertDoesNotThrow(()->e.isArbolCasiCompleto());
    }
}