package com.example.juegodelavida1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoMontañaTest {
    RecursoMontaña recursoAgua = new RecursoMontaña(1,5,3,10);

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
        assertEquals(recursoAgua.toString(),"RecursoMontaña, turnosRestantes = 1");
    }
    @Test
    void getTurnosDeVida() {
        RecursoMontaña recurso = new RecursoMontaña(12,12,12 ,1);
        RecursoMontaña recurso1 = new RecursoMontaña(recurso);
        assertDoesNotThrow(()->recurso1.getTurnosVida());
        assertDoesNotThrow(()->recurso1.setTurnosVida(12));
    }
}