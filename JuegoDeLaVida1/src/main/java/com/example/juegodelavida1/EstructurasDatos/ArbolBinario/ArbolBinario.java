package com.example.juegodelavida1.EstructurasDatos.ArbolBinario;

import com.example.juegodelavida1.EstructurasDatos.Grafo.ElementoRepetidoExcepcion;
import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;

public class ArbolBinario<TipoDato> {
    Nodo<TipoDato> raiz;

    public ArbolBinario() {
        raiz = null;
    }
    public void add(TipoDato dato) throws ElementoRepetidoExcepcion {
        Nodo<TipoDato> nuevonodo = new Nodo<>(dato);
        if (raiz == null) {
            raiz = nuevonodo;
        } else {
            raiz.add(nuevonodo);
        }
    }
    public ArbolBinario<TipoDato> getSubArbolIzquierda() {
        ArbolBinario<TipoDato> arbolIzquierda = new ArbolBinario<>();
        if (raiz != null&&raiz.izq != null){
            arbolIzquierda.raiz = this.raiz.izq;
            return arbolIzquierda;
        } else
            return null;
    }

    public void setArbolIzquierda(ArbolBinario<TipoDato> nuevaIzquierda) {
        this.raiz.izq = nuevaIzquierda.raiz;
    }
    public ArbolBinario<TipoDato> getSubArbolDerecha() {
        ArbolBinario<TipoDato> arbolDerecha = new ArbolBinario<>();
        if ((raiz != null)&&(raiz.drch != null)){
            arbolDerecha.raiz = raiz.drch;
            return arbolDerecha;
        } else
            return null;
    }

    public void setArbolDerecha(ArbolBinario<TipoDato> nuevaDerecha) {
        this.raiz.drch = nuevaDerecha.raiz;
    }
    public ListaEnlazada<TipoDato> getListaPreOrden() {
        ListaEnlazada<TipoDato> listaEl = new ListaEnlazada<>();

        return getListaPreOrden(this.raiz,listaEl);
    }

    private ListaEnlazada<TipoDato> getListaPreOrden(Nodo<TipoDato> n, ListaEnlazada<TipoDato> le){
        if (n != null) {
            le.add(n.dato);
            getListaPreOrden(n.izq,le);
            getListaPreOrden(n.drch,le);
        }
        return le;
    }
    public ListaEnlazada<TipoDato> getListaOrdenCentral() {
        ListaEnlazada<TipoDato> listaEl = new ListaEnlazada<>();

        return getListaOrdenCentral(this.raiz, listaEl);
    }

    private ListaEnlazada<TipoDato> getListaOrdenCentral(Nodo<TipoDato> n, ListaEnlazada<TipoDato> listaEl) {
        if (n != null) {
            getListaOrdenCentral(n.izq,listaEl);
            listaEl.add(n.dato);
            getListaOrdenCentral(n.drch,listaEl);
        }
        return listaEl;
    }
    public ListaEnlazada<TipoDato> getListaPostOrden() {
        ListaEnlazada<TipoDato> listaEl = new ListaEnlazada<>();
        return getListaPostOrden(this.raiz, listaEl);
    }

    private ListaEnlazada<TipoDato> getListaPostOrden(Nodo<TipoDato> n, ListaEnlazada<TipoDato> listaEl) {
        if (n != null) {
            getListaPostOrden(n.izq,listaEl);
            getListaPostOrden(n.drch,listaEl);
            listaEl.add(n.dato);
        }
        return listaEl;
    }
    public int getGrado() {
        if (this.raiz == null){
            return 0;
        }else {
            return Math.max(this.raiz.getGrado(),this.getGradoHijos(this));
        }
    }
    private int getGradoHijos(ArbolBinario<TipoDato> arbol) {
        if ((arbol.getSubArbolIzquierda() != null)&&(arbol.getSubArbolDerecha() != null)) {
            if ((arbol.getSubArbolIzquierda().getGrado()==0)&&(arbol.getSubArbolDerecha().getGrado()==0)) {
                return 0;
            } else if ((arbol.getSubArbolIzquierda().getGrado()!=0)&&(arbol.getSubArbolDerecha().getGrado()==0)) {
                return getGradoHijos(arbol.getSubArbolIzquierda());
            } else if ((arbol.getSubArbolIzquierda().getGrado()==0)&&(arbol.getSubArbolDerecha().getGrado()!=0)) {
                return getGradoHijos(arbol.getSubArbolDerecha());
            } else {
                return Math.max(getGradoHijos(arbol.getSubArbolIzquierda()), getGradoHijos(arbol.getSubArbolDerecha()));
            }
        } else if ((arbol.getSubArbolIzquierda() == null)&&(arbol.getSubArbolDerecha() != null)) {
            return arbol.getSubArbolDerecha().getGrado();
        } else if ((arbol.getSubArbolIzquierda() != null)&&(arbol.getSubArbolDerecha() == null)) {
            return arbol.getSubArbolIzquierda().getGrado();
        } else {
            return 0;
        }
    }
    public int getAltura() {
        return getAltura(raiz);
    }
    private int getAltura(Nodo<TipoDato> nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int alturaIzq = getAltura(nodo.izq);
            int alturaDrch = getAltura(nodo.drch);
            return Math.max(alturaIzq, alturaDrch) + 1;
        }
    }
    public ListaEnlazada<Nodo<TipoDato>> getListaDatosNivel(int niv) {
        if ((niv > 0 )&&(niv < this.getAltura() + 1)) {
            ListaEnlazada<Nodo<TipoDato>> datn = new ListaEnlazada<>();
            return listaDatosNivel(raiz, niv, datn);
        } else {
            return null;
        }
    }
    private ListaEnlazada<Nodo<TipoDato>> listaDatosNivel(Nodo<TipoDato> nodo, int nivel, ListaEnlazada<Nodo<TipoDato>> listaDatos) {
        if (nodo!=null){
            if (nivel == 1) {
                listaDatos.add(nodo);
            } else if (nivel > 1) {
                listaDatosNivel(nodo.izq, nivel-1, listaDatos);
                listaDatosNivel(nodo.drch, nivel-1, listaDatos);
            }
        }
        return listaDatos;
    }
    public ListaEnlazada<Nodo<TipoDato>> getListaNodosNivel(int niv) {
        if ((niv > 0 )&&(niv < this.getAltura() + 1)) {
            ListaEnlazada<Nodo<TipoDato>> datn = new ListaEnlazada<>();
            return listaNodosNivel(raiz, niv, datn);
        } else {
            return null;
        }
    }
    private ListaEnlazada<Nodo<TipoDato>> listaNodosNivel(Nodo<TipoDato> nodo, int nivel, ListaEnlazada<Nodo<TipoDato>> listaDatos) {
        if (nodo!=null){
            if (nivel == 1) {
                listaDatos.add(nodo);
            } else if (nivel > 1) {
                listaNodosNivel(nodo.izq, nivel-1, listaDatos);
                listaNodosNivel(nodo.drch, nivel-1, listaDatos);
            }
        }
        return listaDatos;
    }
    public boolean isArbolCompleto() {
        int cont = 0;
        while(cont < this.getAltura()) {
            if (Math.pow(2, cont) == this.getListaDatosNivel(cont+1).getNumeroElementos()) {
                cont++;
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean isArbolHomogeneo() {
        if (this.isArbolCompleto()) {
            return true;
        } else return this.arbolGradoUno(this.raiz);
    }
    private boolean arbolGradoUno(Nodo<TipoDato> nodo) {
        if ((nodo.izq != null)&&(nodo.drch != null)) {
            return false;
        } else if ((nodo.izq == null)&&(nodo.drch != null)) {
            return (arbolGradoDrch(nodo.drch));
        } else {
            return (arbolGradoIzq(nodo.izq));
        }
    }
    private boolean arbolGradoDrch(Nodo<TipoDato> nodoD) {
        if (nodoD != null) {
            if (nodoD.izq != null) {
                return false;
            } else {
                return arbolGradoDrch(nodoD.drch);
            }
        }
        return true;
    }
    private boolean arbolGradoIzq(Nodo<TipoDato> nodoI) {
        if (nodoI != null) {
            if (nodoI.drch != null) {
                return false;
            } else {
                return arbolGradoIzq(nodoI.izq);
            }
        }
        return true;
    }
    public ListaEnlazada<TipoDato> getCamino(TipoDato nodo) {
        ListaEnlazada<TipoDato> camino = new ListaEnlazada<>();
        if (nodo != null) {
            return getCaminos(camino, nodo, raiz);
        }
        return null;
    }
    private ListaEnlazada<TipoDato> getCaminos(ListaEnlazada<TipoDato> datosLista, TipoDato nodoBuscar, Nodo<TipoDato> comparable) {
        if (comparable != null) {
            Comparable miDato = (Comparable) nodoBuscar;
            Comparable nuevoDato = (Comparable) comparable.dato;
            if (miDato.compareTo(nuevoDato) == 0) {
                datosLista.add(comparable.getData());
                return datosLista;
            } else {
                datosLista.add(comparable.getData());
                if (comparable.drch != null && miDato.compareTo(nuevoDato) > 0) {
                    return getCaminos(datosLista, nodoBuscar, comparable.drch);
                }
                if (comparable.izq != null && miDato.compareTo(nuevoDato) < 0) {
                    return getCaminos(datosLista, nodoBuscar, comparable.izq);
                }
            }
        }
        return datosLista;
    }
    public boolean isArbolCasiCompleto() {
        ListaEnlazada<Nodo<TipoDato>> listaDatos;
        if (this.raiz == null) {
            return false;
        }else if (this.getAltura() == 1) {
            return true;
        } else {
            listaDatos = this.getListaNodosNivel(this.getAltura()-1);
        }
        if (this.getAltura() == 2) {
            if (this.getGrado() == 2) {
                return false;
            } else return this.getGrado() != 1 || raiz.drch == null;
        } else if (listaDatos.getNumeroElementos() == Math.pow(2, this.getAltura()-2)) {
            return casiCompletoRecursivo1(listaDatos, listaDatos.getPrimero().getData());
        } else {
            return false;
        }
    }
    private boolean casiCompletoRecursivo1(ListaEnlazada<Nodo<TipoDato>> lista, Nodo<TipoDato> nodo) {
        if (nodo.getGrado() == 2) {
            lista.del(0);
            if (lista.isVacia()) {
                return false;
            } else {
                return casiCompletoRecursivo1(lista, lista.getPrimero().getData());
            }
        } else {
            if (nodo.getGrado() == 1 && nodo.izq == null) {
                return false;
            } else {
                lista.del(0);
                if (lista.isVacia()) {
                    return true;
                } else {
                    return casiCompletoRecursivo2(lista, lista.getPrimero().getData());
                }
            }
        }
    }
    private boolean casiCompletoRecursivo2(ListaEnlazada<Nodo<TipoDato>> lista, Nodo<TipoDato> nodo) {
        if (nodo.getGrado() == 0) {
            lista.del(0);
            if (!lista.isVacia()) {
                return casiCompletoRecursivo2(lista, lista.getPrimero().getData());
            } else {
                return true;
            }
        } else {
            return false;
        }

    }
}
