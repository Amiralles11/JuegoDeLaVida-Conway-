package com.example.juegodelavida1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecursoBibliotecaTest {
    RecursoBiblioteca recursoAgua = new RecursoBiblioteca(1,5,3,10);

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
        assertEquals(recursoAgua.toString(),"RecursoBiblioteca, turnosRestantes = 1");
    }
    @Test
    void getTurnosDeVida() {
        RecursoBiblioteca recurso = new RecursoBiblioteca(12,12,12 ,1);
        RecursoBiblioteca recurso1 = new RecursoBiblioteca(recurso);
        assertDoesNotThrow(()->recurso1.getPorcentajeClonacion());
        assertDoesNotThrow(()->recurso1.setPorcentajeClonacion(12));
    }
}