package com.example.juegodelavida1.EstructurasDatos.Map;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ElementoLE;
import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;

public class Map<T, E> {
    private ElementoHashMap<T, E> primero;

    public boolean isVacia() {
        return primero == null;
    }

    public Map() {

    }

    public ElementoHashMap<T, E> getPrimero() {
        return primero;
    }

    public ElementoHashMap<T, E> getElemento(int posicion) {
        if (isVacia()) {
            return null;
        }else{
            ElementoHashMap<T, E> first = this.primero;
            for (int i=0; i != posicion; i++) {
                first = first.getSiguiente();
            }
            return first;
        }
    }

    public Integer getPosicion(T el) {
        if (!this.isVacia()) {
            int pos = 0;
            ElementoHashMap<T, E> first = this.primero;
            for (int i = 0; (pos < this.getNumElemMap()) && (first.getIndice() != el); i++) {
                first = first.getSiguiente();
                pos += 1;
            }
            if ((pos >= getNumElemMap())&&(el != this.getElemento(this.getNumElemMap() - 1))) {
                return null;
            }
            return pos;
        }
        return null;
    }

    public void del(int pos) {
        if (pos == 0) {
            primero = primero.getSiguiente();
        }else{
            ElementoHashMap<T, E> first = this.primero;
            for (int i=0; i != pos - 1; i++) {
                first = first.getSiguiente();
                if (first.getSiguiente().getSiguiente() == null) {
                    first.setSiguiente(null);
                }
            }
            if (pos == this.getPosicion(first.getIndice())) {
                first.setSiguiente(first.getSiguiente().getSiguiente());
            }
        }
    }

    public void put(T indice, E dato) {
        if (!this.isVacia()) {
            ElementoHashMap<T, E> actual = this.primero;
            while (actual.getSiguiente() != null) {
                if (actual.getIndice() == indice) {
                    actual.setDato(dato);
                    return;
                }
                actual = actual.getSiguiente();
            }
            if (actual.getIndice() == indice) {
                actual.setDato(dato);
            } else {
                ElementoHashMap<T, E> nuevoElemento = new ElementoHashMap<>(indice, dato);
                actual.setSiguiente(nuevoElemento);
            }
        } else {
            ElementoHashMap<T, E> nuevoElemento = new ElementoHashMap<>(indice, dato);
            this.primero = nuevoElemento;
        }
    }
    public E get(T indice) {
        if (this.primero == null) {
            return null;
        }
        ElementoHashMap<T, E> actual = this.primero;
        while (actual.getSiguiente() != null && actual.getIndice() != indice) {
            actual = actual.getSiguiente();
        }
        if (actual.getIndice() == indice) {
            return actual.getDato();
        } else {
            return null;
        }
    }

    public ListaEnlazada<T> KeySet() {
        ListaEnlazada<T> listaClaves = new ListaEnlazada<>();
        ElementoHashMap<T, E> actual = this.primero;
        while (actual != null) {
            listaClaves.add(actual.getIndice());
            actual = actual.getSiguiente();
        }
        return listaClaves;
    }

    public Boolean isHashMapVacio() {
        return primero == null;
    }

    public int getNumElemMap() {
        if (isHashMapVacio()) {
            return 0;
        }else{
            int elem = 0;
            ElementoHashMap<T, E> first = primero;
            while (first != null) {
                elem += 1;
                first = first.getSiguiente();
            }
            return elem;
        }
    }
}
