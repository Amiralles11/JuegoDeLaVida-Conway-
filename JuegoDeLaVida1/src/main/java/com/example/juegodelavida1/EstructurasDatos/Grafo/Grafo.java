package com.example.juegodelavida1.EstructurasDatos.Grafo;

import com.example.juegodelavida1.PrincipalController;
import com.example.juegodelavida1.EstructurasDatos.Map.Map;
import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;

import java.util.Objects;

public class Grafo<TipoDato> {
    private ListaEnlazada<Vertice<TipoDato>> vertices;
    private ListaEnlazada<Arco<TipoDato>> arcos;

    public Grafo() {
        vertices = new ListaEnlazada<>();
        arcos = new ListaEnlazada<>();
    }

    public ListaEnlazada<Vertice<TipoDato>> getVertices() {
        return vertices;
    }

    public ListaEnlazada<Arco<TipoDato>> getArcos() {
        return arcos;
    }

    public Vertice<TipoDato> getVertice(TipoDato dato) {
        for (int i = 0; vertices.getNumeroElementos() != i; i++) {
            if (vertices.getElemento(i).getData().getDato() == dato) {
                return vertices.getElemento(i).getData();
            }
        }
        return null;
    }

    public void add(TipoDato dato) throws ElementoRepetidoExcepcion {
        if (vertices.isVacia()) {
            Vertice<TipoDato> vertice1 = new Vertice<>(dato);
            vertices.add(vertice1);
        } else {
            int pos = 0;
            while (pos <= vertices.getNumeroElementos() - 1 && vertices.getElemento(pos).getData().getDato() != dato) {
                pos++;
            }
            if (pos == vertices.getNumeroElementos() ) {
                Vertice<TipoDato> vertice1 = new Vertice<>(dato);
                vertices.add(vertice1);
            } else if (vertices.getElemento(pos).getData().getDato() == dato) {
                throw new ElementoRepetidoExcepcion("Error, se ha intentado añadir un elemento ya existente.");
            }
        }
    }

    public void add(Vertice<TipoDato> vertice) throws ElementoRepetidoExcepcion {
        if (vertices.isVacia()) {
            vertices.add(vertice);
        } else {
            int pos = 0;
            while (pos <= vertices.getNumeroElementos() - 1 && !Objects.equals(vertices.getElemento(pos).getData().getDato(), vertice.getDato())) {
                pos++;
            }
            if (pos == vertices.getNumeroElementos()) {
                vertices.add(vertice);
            } else if (vertices.getUltimo().getData() != vertice.getDato()){
                throw new ElementoRepetidoExcepcion("Error, se ha intentado añadir un elemento ya existente.");
            }
        }
    }

    public void add(Arco<TipoDato> arco) throws ElementoRepetidoExcepcion {
        if (arcos.isVacia()) {
            arcos.add(arco);
        } else {
            int pos = 0;
            while (pos <= arcos.getNumeroElementos() - 1 && !arcos.getElemento(pos).getData().getEtiqueta().equals(arco.getEtiqueta())) {
                pos++;
            }
            if (pos >= arcos.getNumeroElementos() - 1 && !arcos.getUltimo().getData().getEtiqueta().equals(arco.getEtiqueta())) {
                arcos.add(arco);
            } else {
                throw new ElementoRepetidoExcepcion("Error, se ha intentado añadir un elemento ya existente.");
            }
        }
        if (vertices.isVacia() || vertices.getPosicion(arco.getV1()) == null) {
            vertices.add(arco.getV1());
        }
        if (vertices.isVacia() || vertices.getPosicion(arco.getV2()) == null) {
            vertices.add(arco.getV2());
        }
        arco.getV1().addFrontera(arco);
        arco.getV2().addFrontera(arco);
    }

    public void addArco(TipoDato dato1, TipoDato dato2, double peso) throws ElementoRepetidoExcepcion {
        Vertice<TipoDato> vertice1 = new Vertice<>(dato1);
        Vertice<TipoDato> vertice2 = new Vertice<>(dato2);
        if (this.getVertice(dato1) != null) {
            vertice1 = this.getVertice(dato1);
        }
        if (this.getVertice(dato2) != null) {
            vertice2 = this.getVertice(dato2);
        }
        Arco<TipoDato> nuevoArco = new Arco<>(vertice1, vertice2, peso, ""+PrincipalController.getIdArcos());
        this.add(nuevoArco);
    }

    public void del(Arco<TipoDato> arco) throws ElementoInexistenteExcepcion {
        if (arcos.isVacia() || arcos.getPosicion(arco) == null) {
            throw new ElementoInexistenteExcepcion("No se ha encontrado el elemento en el grafo.");
        } else {
            arco.getV1().getFrontera().del(arco.getV1().getFrontera().getPosicion(arco));
            arco.getV2().getFrontera().del(arco.getV2().getFrontera().getPosicion(arco));
            arcos.del(arcos.getPosicion(arco));
        }
    }

    public void del(Vertice<TipoDato> vertice) throws ElementoInexistenteExcepcion {
        if (vertices.getPosicion(vertice) == null) {
            throw new ElementoInexistenteExcepcion("No se ha encontrado el elemento en el grafo.");
        } else {
            while (!vertice.getFrontera().isVacia()) {
                Arco<TipoDato> arcoEliminar = vertice.getFrontera().getElemento(0).getData();
                arcoEliminar.getOtroVertice(vertice.getDato()).getFrontera().del(arcoEliminar.getOtroVertice(vertice.getDato()).getFrontera().getPosicion(arcoEliminar));
                arcos.del(arcos.getPosicion(arcoEliminar));
                vertice.getFrontera().del(vertice.getFrontera().getPosicion(arcoEliminar));
            }
            vertices.del(vertices.getPosicion(vertice));
        }
    }
    public Map<Vertice<TipoDato>, Camino<TipoDato>> getDijkstra(Vertice<TipoDato> verticeOrigen) throws ElementoInexistenteExcepcion{
        Map<Vertice<TipoDato>, Double> distancias = new Map<>();
        ListaEnlazada<Vertice<TipoDato>> colaPendientes = new ListaEnlazada<>();
        Map<Vertice<TipoDato>, Vertice<TipoDato>> verticesAnteriores = new Map<>();

        this.dijkstra_Init(verticeOrigen, distancias, colaPendientes, verticesAnteriores);
        this.dijkstra_calcula(distancias, colaPendientes, verticesAnteriores);
        return this.dijkstra_ProcesaResultados(distancias, verticesAnteriores);
    }

    protected void dijkstra_Init(Vertice<TipoDato> origen, Map<Vertice<TipoDato>, Double> distancias, ListaEnlazada<Vertice<TipoDato>> colaPendientes, Map<Vertice<TipoDato>, Vertice<TipoDato>> verticesAnteriores) {
        for (int i = 0; vertices.getElemento(i) != null; i ++) {
            distancias.put(vertices.getElemento(i).getData(), Double.MAX_VALUE);
        }
        distancias.put(origen, 0.0);
        colaPendientes.add(origen);
    }

    protected void dijkstra_calcula(Map<Vertice<TipoDato>, Double>distancias, ListaEnlazada<Vertice<TipoDato>> colaPendientes, Map<Vertice<TipoDato>, Vertice<TipoDato>> verticesAnteriores) throws ElementoInexistenteExcepcion {
        while (!colaPendientes.isVacia()) {
            Vertice<TipoDato> verticeActual = colaPendientes.getUltimo().getData();
            colaPendientes.del(colaPendientes.getNumeroElementos()-1);
            for (int i = 0; verticeActual.getFrontera().getElemento(i) != null; i ++) {
                Arco<TipoDato> arco = verticeActual.getFrontera().getElemento(i).getData();
                Vertice<TipoDato> verticeVecino = arco.getOtroVertice(verticeActual.getDato());
                double nuevoCalculoDistancia1 = distancias.get(verticeActual) + arco.getDato();

                if (nuevoCalculoDistancia1 < distancias.get(verticeVecino)) {
                    distancias.put(verticeVecino, nuevoCalculoDistancia1);
                    verticesAnteriores.put(verticeVecino, verticeActual);
                    colaPendientes.insert(verticeVecino, 0);
                }
            }
        }
    }
    protected Map<Vertice<TipoDato>, Camino<TipoDato>> dijkstra_ProcesaResultados(Map<Vertice<TipoDato>, Double> distancias, Map<Vertice<TipoDato>, Vertice<TipoDato>> verticesAnteriores) {
        Map<Vertice<TipoDato>, Camino<TipoDato>> caminos = new Map<>();
        ListaEnlazada<Vertice<TipoDato>> listaVertices = verticesAnteriores.KeySet();

        for (int i = 0; listaVertices.getElemento(i) != null; i ++) {
            Vertice<TipoDato> verticeDestino = listaVertices.getElemento(i).getData();
            ListaEnlazada<Vertice<TipoDato>> caminoCalculado = new ListaEnlazada<>();
            Vertice<TipoDato> v = verticeDestino;
            while (v != null) {
                caminoCalculado.add(v);
                v = verticesAnteriores.get(v);
            }
            ListaEnlazada<Vertice<TipoDato>> listaOrdenada = caminoCalculado.reverse(caminoCalculado);
            caminos.put(verticeDestino, new Camino<>(listaOrdenada, distancias.get(verticeDestino)));
        }
        return caminos;
    }

    public ListaEnlazada<Vertice<TipoDato>> getCaminoVertices(Vertice<TipoDato> salida, Vertice<TipoDato> llegada) throws ElementoInexistenteExcepcion {
        if (vertices.getPosicion(salida) != null && vertices.getPosicion(llegada) != null) {
            return this.getDijkstra(salida).get(llegada).getCamino();
        } else {
            throw new ElementoInexistenteExcepcion("Error, alguno de los datos no están en el grafo");
        }
    }

    public ListaEnlazada<TipoDato> getCamino(Vertice<TipoDato> salida, Vertice<TipoDato> llegada) throws ElementoInexistenteExcepcion {
        ListaEnlazada<TipoDato> camino = new ListaEnlazada<>();
        ListaEnlazada<Vertice<TipoDato>> caminoVertices = getCaminoVertices(salida, llegada);
        for (int i = 0; i < caminoVertices.getNumeroElementos(); i ++) {
            camino.add(caminoVertices.getElemento(i).getData().getDato());
        }
        return camino;
    }
}
