package com.example.juegodelavida1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoTesoroTest {
    RecursoTesoro recursoAgua = new RecursoTesoro(1,5,3,10);

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
        assertEquals(recursoAgua.toString(),"RecursoTesoro, turnosRestantes = 1");
    }
    @Test
    void getTurnosDeVida() {
        RecursoTesoro recurso = new RecursoTesoro(12,12,12 ,1);
        RecursoTesoro recurso1 = new RecursoTesoro(recurso);
        assertDoesNotThrow(()->recurso1.getPorcentajeReproduccion());
        assertDoesNotThrow(()->recurso1.setPorcentajeReproduccion(21));
    }
}