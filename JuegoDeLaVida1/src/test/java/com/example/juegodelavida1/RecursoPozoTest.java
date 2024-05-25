package com.example.juegodelavida1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoPozoTest {
    RecursoPozo recursoAgua = new RecursoPozo(1,5,3);

    @Test
    void getPorcentajeAparicion2() {
        assertEquals(recursoAgua.getPorcentajeAparicion2(),3);
    }

    @Test
    void setPorcentajeAparicion2() {
        assertDoesNotThrow(()->recursoAgua.setPorcentajeAparicion2(20));
    }

    @Test
    void testToString() {
        assertEquals(recursoAgua.toString(),"RecursoPozo, turnosRestantes = 1");
    }
    @Test
    void getTurnosDeVida() {
        RecursoPozo recurso = new RecursoPozo(12,12,12);
        RecursoPozo recurso1 = new RecursoPozo(recurso);
    }
}