package com.example.juegodelavida1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoComidaTest {
    RecursoComida recursoAgua = new RecursoComida(1,5,3,10);

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
        assertEquals(recursoAgua.toString(),"RecursoComida, turnosRestantes = 1");
    }
    @Test
    void getTurnosDeVida() {
        RecursoComida recurso = new RecursoComida(12,12,12 ,1);
        RecursoComida recurso1 = new RecursoComida(recurso);
        assertDoesNotThrow(()->recurso1.getTurnosVida());
        assertDoesNotThrow(()->recurso1.setTurnosVida(12));
    }
}