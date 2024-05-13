package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.application.Platform;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrincipalController {
    private boolean pausa;
    private ListaSimple<ListaSimple<Celda>> listaCeldas;
    private IndividuoTipoBasico individuoTipoBasico;
    private IndividuoTipoNormal individuoTipoNormal;
    private IndividuoTipoAvanzado individuoTipoAvanzado;
    private RecursoAgua recursoAgua;
    private RecursoBiblioteca recursoBiblioteca;
    private RecursoComida recursoComida;
    private RecursoMontaña recursoMontaña;
    private RecursoPozo recursoPozo;
    private RecursoTesoro recursoTesoro;

    public PrincipalController(Boolean pausa,IndividuoTipoBasico individuoTipoBasico,
                      IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                      RecursoAgua recursoAgua, RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                      RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo,
                      ListaSimple<ListaSimple<Celda>> lista){
        this.pausa = pausa;
        this.individuoTipoBasico = individuoTipoBasico;
        this.individuoTipoNormal = individuoTipoNormal;
        this.individuoTipoAvanzado = individuoTipoAvanzado;
        this.recursoAgua = recursoAgua;
        this.recursoBiblioteca = recursoBiblioteca;
        this.recursoComida = recursoComida;
        this.recursoMontaña = recursoMontaña;
        this.recursoPozo = recursoPozo;
        this.recursoTesoro = recursoTesoro;
        this.listaCeldas = lista;
    }

    public ListaSimple<ListaSimple<Celda>> getListaCeldas() {
        return listaCeldas;
    }

    public void setListaCeldas(ListaSimple<ListaSimple<Celda>> listaCeldas) {
        this.listaCeldas = listaCeldas;
    }

    public IndividuoTipoBasico getIndividuoTipoBasico() {
        return individuoTipoBasico;
    }

    public void setIndividuoTipoBasico(IndividuoTipoBasico individuoTipoBasico) {
        this.individuoTipoBasico = individuoTipoBasico;
    }

    public IndividuoTipoNormal getIndividuoTipoNormal() {
        return individuoTipoNormal;
    }

    public void setIndividuoTipoNormal(IndividuoTipoNormal individuoTipoNormal) {
        this.individuoTipoNormal = individuoTipoNormal;
    }

    public IndividuoTipoAvanzado getIndividuoTipoAvanzado() {
        return individuoTipoAvanzado;
    }

    public void setIndividuoTipoAvanzado(IndividuoTipoAvanzado individuoTipoAvanzado) {
        this.individuoTipoAvanzado = individuoTipoAvanzado;
    }

    public RecursoAgua getRecursoAgua() {
        return recursoAgua;
    }

    public void setRecursoAgua(RecursoAgua recursoAgua) {
        this.recursoAgua = recursoAgua;
    }

    public RecursoBiblioteca getRecursoBiblioteca() {
        return recursoBiblioteca;
    }

    public void setRecursoBiblioteca(RecursoBiblioteca recursoBiblioteca) {
        this.recursoBiblioteca = recursoBiblioteca;
    }

    public RecursoComida getRecursoComida() {
        return recursoComida;
    }

    public void setRecursoComida(RecursoComida recursoComida) {
        this.recursoComida = recursoComida;
    }

    public RecursoMontaña getRecursoMontaña() {
        return recursoMontaña;
    }

    public void setRecursoMontaña(RecursoMontaña recursoMontaña) {
        this.recursoMontaña = recursoMontaña;
    }

    public RecursoPozo getRecursoPozo() {
        return recursoPozo;
    }

    public void setRecursoPozo(RecursoPozo recursoPozo) {
        this.recursoPozo = recursoPozo;
    }

    public RecursoTesoro getRecursoTesoro() {
        return recursoTesoro;
    }

    public void setRecursoTesoro(RecursoTesoro recursoTesoro) {
        this.recursoTesoro = recursoTesoro;
    }

    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public boolean isPausa() {
        return pausa;
    }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public void bucleControl() {
        AtomicBoolean comprobacionFinal = new AtomicBoolean(true);
        Thread juegoThread = new Thread(() -> {
            while (comprobacionFinal.get()) {
                pasarTurno();
                Platform.runLater(() -> {
                    for (int i = 0; i < listaCeldas.getNumeroElementos(); i++) {
                        for (int j = 0; j < listaCeldas.getElemento(i).getData().getNumeroElementos(); j++) {
                            Celda actual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                            actual.updateGUIwithModel();
                        }
                    }
                });
                esperar(1000);
                if (!finPartida()) {
                    comprobacionFinal.set(false);
                }
            }
        });
        juegoThread.start();
    }

    private boolean finPartida() {
        if (!pausa && numeroIndividuos()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean numeroIndividuos() {
        int cont = 0;
        for (int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; listaCeldas.getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda actual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                cont += actual.getIndividuos().getNumeroElementos();
            }
        }
        if (cont > 1) {
            return true;
        } else {
            return false;
        }
    }

    private void pasarTurno() {
        vidaActualicer();
        tiempoRecursoActualicer();
        mover();
        interaccionRecursos();
        reproduccionClonacion();
        hacerEspacio1();
        hacerEspacio2();
    }

    private void vidaActualicer() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                if (!celdaActual.getIndividuos().isVacia()) {
                    ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();
                    for (int k = 0; celdaActual.getIndividuos().getNumeroElementos() != k; k++) {
                        Individuo actual = celdaActual.getIndividuos().getElemento(k).getData();
                        actual.setVidas(actual.getVidas() - 1);
                        actual.setPorcentajeReproduccion(actual.getPorcentajeReproduccion() - 10);
                        actual.setPorcentajeClonacion(actual.getPorcentajeClonacion() - 10);
                        if (actual.getPorcentajeClonacion() <= 0) {
                            actual.setPorcentajeClonacion(0);
                        }
                        if (actual.getPorcentajeReproduccion() <= 0) {
                            actual.setPorcentajeReproduccion(0);
                        }
                        if (actual.getVidas() == 0) {
                            listaIndividuos.add(actual);
                        }
                    }
                    while (!listaIndividuos.isVacia()) {
                        celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(listaIndividuos.getPrimero()));
                        listaIndividuos.del(0);
                    }
                }
            }
        }
    }

    private void tiempoRecursoActualicer() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                ListaEnlazada<Recurso> listaRecursosDesaparecer = new ListaEnlazada<>();
                for (int k = 0; celdaActual.getRecursos().getNumeroElementos() != k; k++) {
                    Recurso actual = celdaActual.getRecursos().getElemento(k).getData();
                    actual.setTiempoAparicion(actual.getTiempoAparicion() - 1);
                    if (actual.getTiempoAparicion() <= 0) {
                        listaRecursosDesaparecer.add(actual);
                    }
                }
                while (!listaRecursosDesaparecer.isVacia()) {
                    celdaActual.getRecursos().del(celdaActual.getRecursos().getPosicion(listaRecursosDesaparecer.getPrimero()));
                    listaRecursosDesaparecer.del(0);
                }
            }
        }
    }

    private void mover() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();
                for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                    Individuo individuoActual = celdaActual.getIndividuos().getElemento(h).getData();
                    if (!individuoActual.isMovido()) {
                        listaIndividuos.add(individuoActual);
                    }
                }
                if (!listaIndividuos.isVacia()) {
                    for (int k = 0; listaIndividuos.getNumeroElementos() != k; k++) {
                        Individuo actual = listaIndividuos.getElemento(k).getData();
                        if (actual instanceof IndividuoTipoBasico && !actual.isMovido()) {
                            moverBasico(actual, celdaActual.getFilas(), celdaActual.getColumnas(), celdaActual);
                        } else if (actual instanceof IndividuoTipoNormal && !actual.isMovido()) {
                            Celda celdaMover = celdaMover(celdaActual);
                            moverNormal(actual, celdaActual.getFilas(), celdaActual.getColumnas(), celdaMover);
                        } else if (!actual.isMovido()){

                        }
                    }
                }
            }
        }
        setMovFalse();
    }

    private void setMovFalse() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                if (!celdaActual.getIndividuos().isVacia()) {
                    for (int k = 0; this.getListaCeldas().getElemento(i).getData().getElemento(j).getData().getIndividuos().getNumeroElementos() != k; k++) {
                        Individuo actual = listaCeldas.getElemento(i).getData().getElemento(j).getData().getIndividuos().getElemento(k).getData();
                        actual.setMovido(false);
                    }
                }
            }
        }
    }

    private void moverBasico(Individuo actual, int fila, int columna, Celda antigua) {
        Random r = new Random();
        int mov = r.nextInt(4);
        if (mov == 0 && fila != 0) {
            listaCeldas.getElemento(columna).getData().getElemento(fila - 1).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            antigua.getIndividuos().del(antigua.getIndividuos().getPosicion(actual));
        } else if (mov == 1 && fila != listaCeldas.getElemento(columna).getData().getNumeroElementos() - 1) {
            listaCeldas.getElemento(columna).getData().getElemento(fila + 1).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            antigua.getIndividuos().del(antigua.getIndividuos().getPosicion(actual));
        } else if (mov == 2 && columna != 0) {
            listaCeldas.getElemento(columna - 1).getData().getElemento(fila).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            antigua.getIndividuos().del(antigua.getIndividuos().getPosicion(actual));
        } else if (mov == 3 && columna != listaCeldas.getNumeroElementos() - 1) {
            listaCeldas.getElemento(columna + 1).getData().getElemento(fila).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            antigua.getIndividuos().del(antigua.getIndividuos().getPosicion(actual));
        } else {
            moverBasico(actual, fila, columna, antigua);
        }
    }

    private Celda celdaMover(Celda salida) {
        ListaEnlazada<Celda> celdasRecursos = new ListaEnlazada<>();
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                boolean insert = false;
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                for (int k = 0; celdaActual.getRecursos().getNumeroElementos() != k; k ++) {
                    if ((celdaActual.getRecursos().getElemento(k).getData() instanceof RecursoAgua || celdaActual.getRecursos().getElemento(k).getData() instanceof RecursoComida) && celdaActual != salida) {
                        insert = true;
                    }
                }
                if (insert) {
                    celdasRecursos.add(celdaActual);
                }
            }
        }
        Random r = new Random();
        int celdaAleatoria = r.nextInt(0, celdasRecursos.getNumeroElementos() - 1);
        return celdasRecursos.getElemento(celdaAleatoria).getData();
    }

    private void moverNormal(Individuo actual, int filas, int columnas, Celda celdaMover) {

    }

    private void interaccionRecursos() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                for (int k = 0; celdaActual.getRecursos().getNumeroElementos() != k; k++) {
                    Recurso recursoActual = celdaActual.getRecursos().getElemento(k).getData();
                    if (recursoActual instanceof RecursoPozo) {
                        celdaActual.getIndividuos().vaciar();
                    } else if (recursoActual instanceof RecursoAgua) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() + recursoAgua.getTurnosVida());
                        }
                    } else if (recursoActual instanceof RecursoComida) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() + recursoComida.getTurnosVida());
                        }
                    } else if (recursoActual instanceof RecursoBiblioteca) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setPorcentajeClonacion(actual.getPorcentajeClonacion() + recursoBiblioteca.getPorcentajeClonacion());
                            if (actual instanceof IndividuoTipoBasico) {
                                IndividuoTipoNormal nuevo = new IndividuoTipoNormal(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                                celdaActual.getIndividuos().insert(nuevo, celdaActual.getIndividuos().getPosicion(actual));
                                celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
                            } else if (actual instanceof IndividuoTipoNormal){
                                IndividuoTipoAvanzado nuevo = new IndividuoTipoAvanzado(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                                celdaActual.getIndividuos().insert(nuevo, celdaActual.getIndividuos().getPosicion(actual));
                                celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
                            }
                        }
                    } else if (recursoActual instanceof RecursoMontaña) {
                        ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() - recursoMontaña.getTurnosVida());
                            listaIndividuos.add(actual);
                        }
                        for (int h = 0; listaIndividuos.getNumeroElementos() != h; h++) {
                            if (listaIndividuos.getElemento(h).getData().getVidas() <= 0) {
                                celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(listaIndividuos.getElemento(h).getData()));
                            }
                        }
                    } else if (recursoActual instanceof RecursoTesoro) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setPorcentajeReproduccion(actual.getPorcentajeReproduccion() + recursoTesoro.getPorcentajeReproduccion());
                        }
                    }
                }
            }
        }
    }

    private void reproduccionClonacion() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                if (celdaActual.getIndividuos().getNumeroElementos() > 1) {
                    reproducir(celdaActual);
                }
                for (int k = 0; celdaActual.getIndividuos().getNumeroElementos() != k; k++) {
                    Individuo actual = celdaActual.getIndividuos().getElemento(k).getData();
                    clonar(actual, celdaActual);
                }
            }
        }
    }
    private void reproducir(Celda celdaActual) {
        Random r = new Random();
        int valor1 = r.nextInt(0, 2);
        int valor2 = r.nextInt(0, 2);
        if (valor1 != valor2 && celdaActual.getIndividuos().getElemento(valor1) != null && celdaActual.getIndividuos().getElemento(valor2) != null) {
            Random r1 = new Random();
            int prob1 = r1.nextInt(1, 100);
            if (celdaActual.getIndividuos().getElemento(valor1).getData().getPorcentajeReproduccion() >= prob1) {
                Random r2 = new Random();
                int prob2 = r2.nextInt(1, 100);
                if (celdaActual.getIndividuos().getElemento(valor2).getData().getPorcentajeReproduccion() >= prob2) {
                    Individuo padre1 = celdaActual.getIndividuos().getElemento(valor1).getData();
                    Individuo padre2 = celdaActual.getIndividuos().getElemento(valor2).getData();
                    if (padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoBasico) {
                        IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                        celdaActual.getIndividuos().add(hijo);
                    } else if (padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoNormal) {
                        IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                        celdaActual.getIndividuos().add(hijo);
                    } else if (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoAvanzado) {
                        IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                        celdaActual.getIndividuos().add(hijo);
                    } else if ((padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoNormal) || (padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoBasico)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        } else {
                            IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        }
                    } else if ((padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoAvanzado) || (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoBasico)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        } else {
                            IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        }
                    } else if ((padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoAvanzado) || (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoNormal)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        } else {
                            IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                            celdaActual.getIndividuos().add(hijo);
                        }
                    }
                }
            }

        } else {
            reproducir(celdaActual);
        }
    }

    private void clonar(Individuo actual, Celda celdaActual) {
        Random r = new Random();
        int prob = r.nextInt(1, 100);
        if (actual.getPorcentajeClonacion() >= prob) {
            if (actual instanceof IndividuoTipoBasico) {
                IndividuoTipoBasico nuevo = new IndividuoTipoBasico(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                celdaActual.getIndividuos().add(nuevo);
            } else if (actual instanceof IndividuoTipoNormal) {
                IndividuoTipoNormal nuevo = new IndividuoTipoNormal(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                celdaActual.getIndividuos().add(nuevo);
            } else {
                IndividuoTipoAvanzado nuevo = new IndividuoTipoAvanzado(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                celdaActual.getIndividuos().add(nuevo);
            }
        }
    }

    private void hacerEspacio1() {
        for(int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for(int j = 0; listaCeldas.getElemento(j).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                while (celdaActual.getIndividuos().getNumeroElementos() > 3) {
                    Individuo SanPedro = celdaActual.getIndividuos().getPrimero().getData();
                    for (int k = 0; celdaActual.getIndividuos().getNumeroElementos() != k; k++) {
                        if (celdaActual.getIndividuos().getElemento(k).getData().getVidas() < SanPedro.getVidas()) {
                            SanPedro = celdaActual.getIndividuos().getElemento(k).getData();
                        }
                    }
                    celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(SanPedro));
                }
            }
        }
    }

    private void hacerEspacio2 () {
        for(int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for(int j = 0; listaCeldas.getElemento(j).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                if (celdaActual.getRecursos().getNumeroElementos() < 3) {
                    Random r = new Random();
                    int prob = r.nextInt(0, 100);
                    RecursoAgua nuevo = new RecursoAgua(recursoAgua.getTiempoAparicion(), recursoAgua.getPorcentajeAparicion(), recursoAgua.getPorcentajeAparicion2(), recursoAgua.getTurnosVida());
                    if (prob <= nuevo.getPorcentajeAparicion()) {
                        Random s = new Random();
                        int prob2 = s.nextInt(0, recursoAgua.getPorcentajeAparicion2() + recursoBiblioteca.getPorcentajeAparicion2() + recursoTesoro.getPorcentajeAparicion2() + recursoMontaña.getPorcentajeAparicion2() + recursoPozo.getPorcentajeAparicion2() + recursoComida.getPorcentajeAparicion2());
                        if (prob2 <= recursoAgua.getPorcentajeAparicion2()) {
                            RecursoAgua nuevoAgua = new RecursoAgua(recursoAgua.getTiempoAparicion(), recursoAgua.getPorcentajeAparicion(), recursoAgua.getPorcentajeAparicion2(), recursoAgua.getTurnosVida());
                            celdaActual.getRecursos().add(nuevoAgua);
                        } else {
                            prob2 -= recursoAgua.getPorcentajeAparicion2();
                            if (prob2 <= recursoBiblioteca.getPorcentajeAparicion2()) {
                                RecursoBiblioteca nuevaBiblioteca = new RecursoBiblioteca(recursoBiblioteca.getTiempoAparicion(), recursoBiblioteca.getPorcentajeAparicion(), recursoBiblioteca.getPorcentajeAparicion2(), recursoBiblioteca.getPorcentajeClonacion());
                                celdaActual.getRecursos().add(nuevaBiblioteca);
                            } else {
                                prob2 -= recursoBiblioteca.getPorcentajeAparicion2();
                                if (prob2 <= recursoTesoro.getPorcentajeAparicion2()) {
                                    RecursoTesoro nuevoTesoro = new RecursoTesoro(recursoTesoro.getTiempoAparicion(), recursoTesoro.getPorcentajeAparicion(), recursoTesoro.getPorcentajeAparicion2(), recursoTesoro.getPorcentajeReproduccion());
                                    celdaActual.getRecursos().add(nuevoTesoro);
                                } else {
                                    prob2 -= recursoTesoro.getPorcentajeAparicion2();
                                    if (prob2 <= recursoMontaña.getPorcentajeAparicion2()) {
                                        RecursoMontaña nuevaMontaña = new RecursoMontaña(recursoMontaña.getTiempoAparicion(), recursoMontaña.getPorcentajeAparicion(), recursoMontaña.getPorcentajeAparicion2(), recursoMontaña.getTurnosVida());
                                        celdaActual.getRecursos().add(nuevaMontaña);
                                    } else {
                                        prob2 -= recursoMontaña.getPorcentajeAparicion2();
                                        if (prob2 <= recursoPozo.getPorcentajeAparicion2()) {
                                            RecursoPozo nuevoPozo = new RecursoPozo(recursoPozo.getTiempoAparicion(), recursoPozo.getPorcentajeAparicion(), recursoPozo.getPorcentajeAparicion2());
                                            celdaActual.getRecursos().add(nuevoPozo);
                                        } else {
                                            RecursoComida nuevaComida = new RecursoComida(recursoComida.getTiempoAparicion(), recursoComida.getPorcentajeAparicion(), recursoComida.getPorcentajeAparicion2(), recursoComida.getTurnosVida());
                                            celdaActual.getRecursos().add(nuevaComida);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
