package com.example.juegodelavida1.EstructurasDatos.Grafo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrafoTest {

    @Test
    void getVertices() {
    }

    @Test
    void getArcos() {
    }

    @Test
    void getVertice() {
        Grafo<String> g = new Grafo<>();
        assertDoesNotThrow(()->g.getVertice(""));
        Arco<String> arco1 = new Arco<>(new Vertice<>("Casablanca"), new Vertice<>("Lomas 1253"), 1.7, "Calle16");
        assertDoesNotThrow(()->g.add(arco1));
        assertDoesNotThrow(()->g.getVertice("Casablanca"));
    }

    @Test
    void add() {
    }

    @Test
    void testAdd() {
    }

    @Test
    void testAdd1() {
    }

    @Test
    void addArco() {
        Grafo<String> g = new Grafo<>();
        assertDoesNotThrow(()->g.addArco("dato1", "dato2", 2.4));
    }

    @Test
    void del() {
        Grafo<String> g = new Grafo<>();
        Arco<String> arco1 = new Arco<>(new Vertice<>("Casablanca"), new Vertice<>("Lomas 1253"), 1.7, "Calle16");
        assertThrows(ElementoInexistenteExcepcion.class, ()->g.del(arco1));
        assertDoesNotThrow(()->g.add(arco1));
        assertDoesNotThrow(()->g.del(arco1));
        Vertice<String> v1 = new Vertice<>("A");
        Vertice<String> v2 = new Vertice<>("B");
        Arco<String> arco = new Arco<>(v1, v2, 2.0, "Calle 13");
        assertThrows(ElementoInexistenteExcepcion.class,()->g.del(v1));
        assertDoesNotThrow(()->g.add(new Arco<>(v1, new Vertice<>("2"), 2.2, "Calle 32")));
        assertDoesNotThrow(()-> g.getArcos());
        assertDoesNotThrow(()-> g.del(v1));
    }

    @Test
    void testDel() {
    }

    @Test
    void getDijkstra() {
    }

    @Test
    void getCaminoVertices() {
        Grafo<String> g = new Grafo<>();
        assertThrows(ElementoInexistenteExcepcion.class, ()->g.getCaminoVertices(null, null));
    }

    @Test
    void getCamino() {
        Grafo<String> g = new Grafo<>();
        Vertice<String> v1 = new Vertice<>("A");
        Vertice<String> v2 = new Vertice<>("B");
        Vertice<String> v3 = new Vertice<>("C");
        Vertice<String> v4 = new Vertice<>("D");
        Vertice<String> v5 = new Vertice<>("E");
        Vertice<String> v6 = new Vertice<>("F");
        Vertice<String> v7 = new Vertice<>("G");
        Vertice<String> v8 = new Vertice<>("H");

        assertDoesNotThrow(()->g.add("Casa de las Carcasas"));
        assertDoesNotThrow(()-> g.del(g.getVertices().getPrimero().getData()));
        assertDoesNotThrow(()->g.add(v1));
        assertDoesNotThrow(()->g.add(v2));
        assertDoesNotThrow(()->g.add(v3));
        assertDoesNotThrow(()->g.add(v4));
        assertDoesNotThrow(()->g.add(v5));
        assertDoesNotThrow(()->g.add(v6));
        assertDoesNotThrow(()->g.add(v7));
        assertDoesNotThrow(()->g.add(v8));
        assertDoesNotThrow(()->g.add("Frutería"));
        assertThrows(ElementoRepetidoExcepcion.class,()-> g.add(v1));
        assertThrows(ElementoRepetidoExcepcion.class,()-> g.add("Frutería"));

        assertDoesNotThrow(()->g.add(new Arco<>(v1, v2, 1.0, "Calle1")));
        assertDoesNotThrow(()->g.add(new Arco<>(v2, v3, 1.5, "Calle2")));
        assertDoesNotThrow(()->g.add(new Arco<>(v3, v4, 2.0, "Calle4")));
        assertDoesNotThrow(()->g.add(new Arco<>(v4, v5, 1.0, "Calle5")));
        assertDoesNotThrow(()->g.add(new Arco<>(v5, v6, 0.5, "Calle6")));
        assertDoesNotThrow(()->g.add(new Arco<>(v6, v7, 1.0, "Calle7")));
        assertDoesNotThrow(()->g.add(new Arco<>(v7, v8, 1.5, "Calle8")));
        assertDoesNotThrow(()->g.add(new Arco<>(v8, v1, 2.5, "Calle9")));
        assertDoesNotThrow(()->g.add(new Arco<>(v1, v3, 1.8, "Calle10")));
        assertDoesNotThrow(()->g.add(new Arco<>(v2, v4, 2.2, "Calle11")));
        assertDoesNotThrow(()->g.add(new Arco<>(v3, v5, 0.9, "Calle12")));
        assertDoesNotThrow(()->g.add(new Arco<>(v4, v6, 1.1, "Calle13")));
        assertDoesNotThrow(()->g.add(new Arco<>(v5, v7, 2.0, "Calle14")));
        assertDoesNotThrow(()->g.add(new Arco<>(v6, v8, 1.7, "Calle15")));
        assertDoesNotThrow(()->g.add(new Arco<>(new Vertice<>("Casablanca"), new Vertice<>("Lomas 1253"), 1.7, "Calle16")));
        assertThrows(ElementoRepetidoExcepcion.class,()->g.add(new Arco<>(new Vertice<>("Casablanca"), new Vertice<>("Lomas 1253"), 1.7, "Calle15")));

        assertDoesNotThrow(()->g.getCamino(v1, v8));
    }
}