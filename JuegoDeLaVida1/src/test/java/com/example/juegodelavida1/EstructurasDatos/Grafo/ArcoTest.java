package com.example.juegodelavida1.EstructurasDatos.Grafo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArcoTest {

    @Test
    void setV1() {
        Arco<String> arco = new Arco<>(new Vertice<String>("Uno"), new Vertice<>("Dos"), 2.2, "Arco1");
        assertDoesNotThrow(()->arco.setV1(new Vertice<>("Vértice 3")));
        assertDoesNotThrow(()->arco.setV2(new Vertice<>("Vértice 4")));
        assertDoesNotThrow(()->arco.setDato(2.0));
        assertDoesNotThrow(()->arco.setEtiqueta("Arco2"));
        assertThrows(ElementoInexistenteExcepcion.class, ()->arco.getOtroVertice("AA"));
    }
}