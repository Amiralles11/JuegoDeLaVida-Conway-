package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndividuoTest {
    Individuo individuo = new IndividuoTipoBasico(1,2,3,4);

    @Test
    void getVidas() {
        assertEquals(individuo.getVidas(),1);
    }

    @Test
    void getPorcentajeReproduccion() {
        assertEquals(individuo.getPorcentajeReproduccion(),2);
    }

    @Test
    void getPorcentajeClonacion() {
        assertEquals(individuo.getPorcentajeClonacion(),3);
    }

    @Test
    void getPorcentajeTipoAlReproducirse() {
        assertEquals(individuo.getPorcentajeTipoAlReproducirse(),4);
    }

    @Test
    void setVidas() {
        assertDoesNotThrow(()->individuo.setVidas(10));
    }

    @Test
    void setPorcentajeReproduccion() {
        assertDoesNotThrow(()->individuo.setPorcentajeReproduccion(10));
    }

    @Test
    void setPorcentajeClonacion() {
        assertDoesNotThrow(()->individuo.setPorcentajeClonacion(10));
    }

    @Test
    void setPorcentajeTipoAlReproducirse() {
        assertDoesNotThrow(()->individuo.setPorcentajeTipoAlReproducirse(10));
    }

    @Test
    void isMovido() {
        assertDoesNotThrow(()->individuo.isMovido());
        assertDoesNotThrow(()->individuo.setMovido(true));
        assertDoesNotThrow(()->individuo.isMovido());
    }

    @Test
    void getAñosVivido() {
        assertDoesNotThrow(()->individuo.getAñosVividos());
        assertDoesNotThrow(()->individuo.setAñosVividos(32));
        assertDoesNotThrow(()->individuo.getAñosVividos());
        assertDoesNotThrow(()-> individuo.getCola());
    }

    @Test
    void getRuta() {
        assertDoesNotThrow(()-> individuo.getRuta());
        assertDoesNotThrow(()-> individuo.setRuta(new ListaSimple<>(2)));
        ListaEnlazada<Integer> l = new ListaEnlazada<>();
        assertDoesNotThrow(()->l.getPosicion(l.getPrimero()));
        assertDoesNotThrow(()->l.add(2));
        assertDoesNotThrow(()->l.add(3));
        assertDoesNotThrow(()->l.add(4));
        assertDoesNotThrow(()->l.getPosicion(l.getElemento(2)));
    }
}