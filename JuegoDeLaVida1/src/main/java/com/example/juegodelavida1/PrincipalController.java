package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.Grafo.*;
import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import com.example.juegodelavida1.EstructurasDatos.Map.ElementoHashMap;
import com.google.gson.annotations.Expose;
import javafx.application.Platform;
import com.example.juegodelavida1.EstructurasDatos.Map.Map;
import javafx.fxml.FXML;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class PrincipalController {
    private static final Logger log = LogManager.getLogger(PrincipalController.class);
    private static  TableroController tab;
    private ListaEnlazada<Individuo> supervivientes = new ListaEnlazada<>();
    @Expose
    private ListaEnlazada<Individuo> individuosTotales;
    private boolean finPartida;

    private int tiempoEspera;
    private Map<Individuo, ListaEnlazada<Celda>> rutaAvanzada;
    @Expose
    private int idIndividuos = 0;

    private static int idArcos = 0;
    @Expose
    private int turnos;
    private boolean pausa;
    @Expose
    private ListaSimple<ListaSimple<Celda>> listaCeldas;
    @Expose
    private IndividuoTipoBasico individuoTipoBasico;
    @Expose
    private IndividuoTipoNormal individuoTipoNormal;
    @Expose
    private IndividuoTipoAvanzado individuoTipoAvanzado;
    @Expose
    private RecursoAgua recursoAgua;
    @Expose
    private RecursoBiblioteca recursoBiblioteca;
    @Expose
    private RecursoComida recursoComida;
    @Expose
    private RecursoMontaña recursoMontaña;
    @Expose
    private RecursoPozo recursoPozo;
    @Expose
    private RecursoTesoro recursoTesoro;

    public PrincipalController(Boolean pausa,IndividuoTipoBasico individuoTipoBasico,
                      IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                      RecursoAgua recursoAgua, RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                      RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo,
                      ListaSimple<ListaSimple<Celda>> lista,int i, int j, int k, TableroController tableroController,
                               ListaEnlazada<Individuo> individuosTotales){
        ListaEnlazada<Celda> rutaAvanzada = new ListaEnlazada<>();
        this.finPartida = false;
        Map<Individuo, ListaEnlazada<Celda>> rutasAvanzadas = new Map<>();
        this.rutaAvanzada = rutasAvanzadas;
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
        this.idIndividuos = i;
        this.idArcos = j;
        this.turnos = k;
        this.tab = tableroController;
        this.tiempoEspera = 1000;
        this.individuosTotales = individuosTotales;
    }

    public void setTiempoEspera() {
        if(this.tiempoEspera==1000) {
            this.tiempoEspera = 250;
        }else if(this.tiempoEspera==250){
            this.tiempoEspera = 1000;
        }
    }

    public ListaEnlazada<Individuo> getIndividuosTotales() {
        return individuosTotales;
    }

    public ListaEnlazada<Individuo> getSupervivientes() {
        return supervivientes;
    }

    public static TableroController getTab() {
        return tab;
    }

    public int getIdIndividuos() {
        return idIndividuos;
    }

    public static int getIdArcos() {
        return idArcos;
    }

    public int identificadorIndividuos(){
        return idIndividuos++;
    }

    public int identificadorArcos() {
        return idArcos++;
    }
    public int getTurnos(){
        return turnos;
    }
    public int identificadorTurnos(){
        return turnos++;
    }
    public ListaSimple<ListaSimple<Celda>> getListaCeldas() {
        return listaCeldas;
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

    public IndividuoTipoAvanzado getIndividuoTipoAvanzado() {
        return individuoTipoAvanzado;
    }

    public RecursoAgua getRecursoAgua() {
        return recursoAgua;
    }

    public RecursoBiblioteca getRecursoBiblioteca() {
        return recursoBiblioteca;
    }

    public RecursoComida getRecursoComida() {
        return recursoComida;
    }

    public RecursoMontaña getRecursoMontaña() {
        return recursoMontaña;
    }

    public RecursoPozo getRecursoPozo() {
        return recursoPozo;
    }

    public RecursoTesoro getRecursoTesoro() {
        return recursoTesoro;
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
                if (finPartida()<0) {
                    comprobacionFinal.set(false);
                }
                pasarTurno();

                Platform.runLater(() -> {
                    tab.setTurnos();
                    for (int i = 0; i < listaCeldas.getNumeroElementos(); i++) {
                        for (int j = 0; j < listaCeldas.getElemento(i).getData().getNumeroElementos(); j++) {
                            Celda actual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                            actual.updateGUIwithModel();
                        }
                    }
                    if (finPartida()==-2||(getFinPartida())) {
                        FinalPartidaController fC = new FinalPartidaController();
                        fC.start(this);
                    }
                    log.debug("turno= "+(turnos-1));
                    log.debug("Individuos vivos= "+supervivientes.getNumeroElementos());
                    log.debug("Individuos totales= "+individuosTotales.getNumeroElementos());
                    if ((finPartida()<0)||(getFinPartida())) {
                        comprobacionFinal.set(false);
                    }
                });
                esperar(tiempoEspera);
            }
        });
        juegoThread.start();
    }
    private int finPartida() {
            if (!pausa && numeroIndividuos()) {
                return 1;
            } else if (!numeroIndividuos()) {
                return -2;
            } else {
                return -1;
            }
    }
    private boolean getFinPartida(){
        return finPartida;
    }

    public void setFinPartida(boolean finPartida) {
        this.finPartida = finPartida;
    }

    private boolean numeroIndividuos() {
        supervivientes.vaciar();
        int cont = 0;
        for (int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; listaCeldas.getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda actual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                cont += actual.getIndividuos().getNumeroElementos();
                if(actual.getIndividuos().getNumeroElementos()!=0){
                    for(int z = 0; z<actual.getIndividuos().getNumeroElementos();z++){
                        supervivientes.add(actual.getIndividuos().getElemento(z).getData());
                    }
                }
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
                        actual.getCola().add("Vida total= "+actual.getVidas());
                        actual.setVidas(actual.getVidas() - 1);
                        actual.setAñosVividos(actual.getAñosVividos()+1);
                        actual.setPorcentajeReproduccion(actual.getPorcentajeReproduccion() - 10);
                        actual.setPorcentajeClonacion(actual.getPorcentajeClonacion() - 10);
                        if (actual.getPorcentajeClonacion() <= 0) {
                            actual.setPorcentajeClonacion(0);
                        }
                        if (actual.getPorcentajeReproduccion() <= 0) {
                            actual.setPorcentajeReproduccion(0);
                        }
                        if (actual.getVidas() == 0) {
                            actual.getCola().add("Muere por causas naturales, turno: "+turnos);
                        }
                    }
                    while (!listaIndividuos.isVacia()) {
                        celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(listaIndividuos.getPrimero()));
                        listaIndividuos.del(0);
                        for (int t = 0; ; t++) {

                        }
                    }
                }
            }
        }
    }

    private void tiempoRecursoActualicer() {
        for (int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; listaCeldas.getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
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
        for (int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; listaCeldas.getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();
                for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                    Individuo individuoActual = celdaActual.getIndividuos().getElemento(h).getData();
                    if (!individuoActual.isMovido()) {
                        listaIndividuos.add(individuoActual);
                    }
                }
                while (!listaIndividuos.isVacia()) {
                    Individuo actual = listaIndividuos.getElemento(0).getData();
                    if (actual instanceof IndividuoTipoBasico && !actual.isMovido()) {
                        moverBasico(actual, celdaActual.getFilas(), celdaActual.getColumnas(), celdaActual);
                        listaIndividuos.del(0);
                    } else if (actual instanceof IndividuoTipoNormal && !actual.isMovido()) {
                        moverNormal(actual, celdaActual.getFilas(), celdaActual.getColumnas(), celdaActual);
                        listaIndividuos.del(0);
                    } else if (!actual.isMovido()){
                        encontrarActual(actual);
                        moverAvanzado(actual, celdaActual);
                        listaIndividuos.del(0);
                    }
                }
            }
        }
        setMovFalse();
    }

    private void encontrarActual(Individuo actual) {
        if (rutaAvanzada.get(actual) == null) {
            ListaEnlazada<Celda> nuevaRuta = new ListaEnlazada<>();
            rutaAvanzada.put(actual, nuevaRuta);
        }
    }

    private void moverAvanzado(Individuo actual, Celda celdaActual) {
        try {
            if (!rutaAvanzada.get(actual).isVacia()) {
                if (rutaAvanzada.get(actual).getPrimero().getData() == celdaActual) {
                    rutaAvanzada.get(actual).del(0);
                }
                if (!rutaAvanzada.get(actual).isVacia()) {
                    Celda nuevaCelda = rutaAvanzada.get(actual).getPrimero().getData();
                    listaCeldas.getElemento(nuevaCelda.getColumnas()).getData().getElemento(nuevaCelda.getFilas()).getData().add(actual);
                    actual.setMovido(true);
                    celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
                } else {
                    Grafo<Celda> mapaActual = getGrafo();
                    Vertice<Celda> verticeIni = null;
                    for (int i = 0; mapaActual.getVertices().getNumeroElementos() != i; i++) {
                        Vertice<Celda> verticeActual = mapaActual.getVertices().getElemento(i).getData();
                        if (verticeActual.getDato().getFilas().equals(celdaActual.getFilas()) && verticeActual.getDato().getColumnas().equals(celdaActual.getColumnas())) {
                            verticeIni = verticeActual;
                        }
                    }
                    rutaAvanzada.del(rutaAvanzada.getPosicion(actual));
                    assert verticeIni != null;
                    rutaAvanzada.put(actual, encontrarNuevoDestino(verticeIni.getDato(), mapaActual));
                }
            } else {
                Grafo<Celda> mapaActual = getGrafo();

                Vertice<Celda> verticeIni = null;
                for (int i = 0; mapaActual.getVertices().getNumeroElementos() != i; i++) {
                    Vertice<Celda> verticeActual = mapaActual.getVertices().getElemento(i).getData();
                    if (verticeActual.getDato().getFilas().equals(celdaActual.getFilas()) && verticeActual.getDato().getColumnas().equals(celdaActual.getColumnas())) {
                        verticeIni = verticeActual;
                    }
                }
                rutaAvanzada.del(rutaAvanzada.getPosicion(actual));
                assert verticeIni != null;
                rutaAvanzada.put(actual, encontrarNuevoDestino(verticeIni.getDato(), mapaActual));
            }
        } catch (ElementoRepetidoExcepcion e) {
            System.out.println("Se ha intentado añadir un elemento ya existente");
        }

    }

    private Grafo<Celda> getGrafo() throws ElementoRepetidoExcepcion {
        Grafo<Celda> grafoFinal = new Grafo<>();
        for (int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; listaCeldas.getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                grafoFinal.add(celdaActual);

                if (i > 0) {
                    Celda celdaContraria = listaCeldas.getElemento(i - 1).getData().getElemento(j).getData();
                    int peso = pesoArco(celdaActual, celdaContraria, recursoMontaña.getTurnosVida());
                    grafoFinal.addArco(celdaActual, celdaContraria, peso);
                    identificadorArcos();
                }
                if (j > 0) {
                    Celda celdaContraria = listaCeldas.getElemento(i).getData().getElemento(j - 1).getData();
                    int peso = pesoArco(celdaActual, celdaContraria, recursoMontaña.getTurnosVida());
                    grafoFinal.addArco(celdaActual, celdaContraria, peso);
                    identificadorArcos();
                }
                if (i > 0 && j > 0) {
                    Celda celdaContraria = listaCeldas.getElemento(i - 1).getData().getElemento(j - 1).getData();
                    int peso = pesoArco(celdaActual, celdaContraria, recursoMontaña.getTurnosVida());
                    grafoFinal.addArco(celdaActual, celdaContraria, peso);
                    identificadorArcos();
                }
                if (i > 0 && j < listaCeldas.getElemento(i).getData().getNumeroElementos() - 1) {
                    Celda celdaContraria = listaCeldas.getElemento(i - 1).getData().getElemento(j + 1).getData();
                    int peso = pesoArco(celdaActual, celdaContraria, recursoMontaña.getTurnosVida());
                    grafoFinal.addArco(celdaActual, celdaContraria, peso);
                    identificadorArcos();
                }
            }
        }
        return grafoFinal;
    }

    private int pesoArco (Celda celda1, Celda celda2, int retraso) {
        int peso = 1;
        peso = añadirPeso(peso, celda1, retraso);
        peso = añadirPeso(peso, celda2, retraso);
        return peso;
    }

    private int añadirPeso (int peso, Celda celda, int retraso) {
        for (int i = 0; celda.getRecursos().getNumeroElementos() != i; i++) {
            Recurso actual = celda.getRecursos().getElemento(i).getData();
            if (actual instanceof RecursoMontaña) {
                if (peso < Integer.MAX_VALUE / 2) {
                    peso += retraso;
                }
            } else if (actual instanceof RecursoPozo) {
                peso = Integer.MAX_VALUE / 2;
            }
        }
        return peso;
    }

    private ListaEnlazada<Celda> encontrarNuevoDestino(Celda celdaActual, Grafo<Celda> grafoActual) {
        try {
            ListaEnlazada<Celda> celdasFavorables = new ListaEnlazada<>();
            for (int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
                for (int j = 0; listaCeldas.getElemento(i).getData().getNumeroElementos() != j; j++) {
                    boolean add = false;
                    boolean notAdd = false;
                    Celda celda = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                    if (celda != celdaActual) {
                        for (int k = 0; celda.getRecursos().getNumeroElementos() != k; k++) {
                            Recurso recActual = celda.getRecursos().getElemento(k).getData();
                            if (recActual instanceof RecursoAgua || recActual instanceof RecursoComida) {
                                add = true;
                            }
                            if (recActual instanceof RecursoPozo) {
                                notAdd = true;
                            }
                        }
                        if (!notAdd && add) {
                            celdasFavorables.add(celda);
                        }
                    }
                }
            }
            Map<Celda, ListaEnlazada<Celda>> posiblesCaminos = new Map<>();
            Vertice<Celda> verticeInicio = grafoActual.getVertice(celdaActual);

            for (int v = 0; celdasFavorables.getNumeroElementos() != v; v++) {
                ListaEnlazada<Celda> nuevoCamino = grafoActual.getCamino(verticeInicio, grafoActual.getVertice(celdasFavorables.getElemento(v).getData()));
                posiblesCaminos.put(celdasFavorables.getElemento(v).getData(), nuevoCamino);
            }
            if (!posiblesCaminos.isVacia()) {
                ListaEnlazada<Celda> listaMinima = posiblesCaminos.getPrimero().getDato();
                for (int v = 0; posiblesCaminos.getNumElemMap() != v ; v++) {
                    if (posiblesCaminos.getElemento(v).getDato().getNumeroElementos() < listaMinima.getNumeroElementos()) {
                        listaMinima = posiblesCaminos.getElemento(v).getDato();
                    }
                }
                return listaMinima;
            }
        } catch (ElementoInexistenteExcepcion e) {
            System.out.println("Elemento no encontrado en el grafo.");
        }
        return new ListaEnlazada<>();
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
        if (mov == 0 && fila != 0) {   //Arriba
            listaCeldas.getElemento(columna).getData().getElemento(fila - 1).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            antigua.getIndividuos().del(antigua.getIndividuos().getPosicion(actual));
        } else if (mov == 1 && fila != listaCeldas.getElemento(columna).getData().getNumeroElementos() - 1) {    //Abajo
            listaCeldas.getElemento(columna).getData().getElemento(fila + 1).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            antigua.getIndividuos().del(antigua.getIndividuos().getPosicion(actual));
        } else if (mov == 2 && columna != 0) {   //Izquierda
            listaCeldas.getElemento(columna - 1).getData().getElemento(fila).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            antigua.getIndividuos().del(antigua.getIndividuos().getPosicion(actual));
        } else if (mov == 3 && columna != listaCeldas.getNumeroElementos() - 1) {   //Derecha
            listaCeldas.getElemento(columna + 1).getData().getElemento(fila).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            antigua.getIndividuos().del(antigua.getIndividuos().getPosicion(actual));
        } else {
            moverBasico(actual, fila, columna, antigua);
        }
    }

    private Celda celdaMover(Celda salida) {
        ListaEnlazada<Celda> celdasRecursos = new ListaEnlazada<>();
        for (int i = 0; this.getListaCeldas().getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                boolean insert = false;
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                for (int k = 0; celdaActual.getRecursos().getNumeroElementos() != k; k ++) {
                    Recurso recursoActual = celdaActual.getRecursos().getElemento(k).getData();
                    if ((recursoActual instanceof RecursoAgua || recursoActual instanceof RecursoComida) && celdaActual != salida) {
                        insert = true;
                    }
                }
                if (insert) {
                    celdasRecursos.add(celdaActual);
                }
            }
        }
        if (!celdasRecursos.isVacia()) {
            if (celdasRecursos.getNumeroElementos() == 1) {
                return celdasRecursos.getElemento(0).getData();
            }
            Random r = new Random();
            int celdaAleatoria = r.nextInt(0, celdasRecursos.getNumeroElementos() - 1);
            return celdasRecursos.getElemento(celdaAleatoria).getData();
        }
        return salida;
    }

    private void moverNormal(Individuo actual, int fila, int columna, Celda celdaActual) {
        if (actual.getRuta().getElemento(0).getData().equals(0) && actual.getRuta().getElemento(1).getData().equals(0)) {
            Celda celdaMover = celdaMover(celdaActual);
            ListaSimple<Integer> nuevaRuta = new ListaSimple<>(2);
            nuevaRuta.insert(celdaMover.getFilas() - fila, 0);
            nuevaRuta.insert(celdaMover.getColumnas() - columna, 1);
            actual.setRuta(nuevaRuta);
        }
        if (actual.getRuta().getElemento(0).getData() > 0) {   //Abajo
            listaCeldas.getElemento(columna).getData().getElemento(fila + 1).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            ListaSimple<Integer> nuevaRuta = new ListaSimple<>(2);
            nuevaRuta.add(actual.getRuta().getElemento(0).getData() - 1);
            nuevaRuta.add(actual.getRuta().getElemento(1).getData());
            actual.setRuta(nuevaRuta);
            celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
        } else if (actual.getRuta().getElemento(0).getData() < 0) { //Arriba
            listaCeldas.getElemento(columna).getData().getElemento(fila - 1).getData().getIndividuos().add(actual);
            actual.setMovido(true);
            ListaSimple<Integer> nuevaRuta = new ListaSimple<>(2);
            nuevaRuta.add(actual.getRuta().getElemento(0).getData() + 1);
            nuevaRuta.add(actual.getRuta().getElemento(1).getData());
            actual.setRuta(nuevaRuta);
            celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
        } else {
            if (actual.getRuta().getElemento(1).getData() > 0) {   //Derecha
                listaCeldas.getElemento(columna + 1).getData().getElemento(fila).getData().getIndividuos().add(actual);
                actual.setMovido(true);
                ListaSimple<Integer> nuevaRuta = new ListaSimple<>(2);
                nuevaRuta.add(actual.getRuta().getElemento(0).getData());
                nuevaRuta.add(actual.getRuta().getElemento(1).getData() - 1);
                actual.setRuta(nuevaRuta);
                celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
            } else if (actual.getRuta().getElemento(1).getData() < 0) {   //Izquierda
                listaCeldas.getElemento(columna - 1).getData().getElemento(fila).getData().getIndividuos().add(actual);
                actual.setMovido(true);
                ListaSimple<Integer> nuevaRuta = new ListaSimple<>(2);
                nuevaRuta.add(actual.getRuta().getElemento(0).getData());
                nuevaRuta.add(actual.getRuta().getElemento(1).getData() + 1);
                actual.setRuta(nuevaRuta);
                celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(actual));
            }
        }
    }

    private void interaccionRecursos() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                boolean visitado = false;
                ListaEnlazada<Recurso> desaparecerB = new ListaEnlazada<>();
                Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                for (int k = 0; celdaActual.getRecursos().getNumeroElementos() != k; k++) {
                    Recurso recursoActual = celdaActual.getRecursos().getElemento(k).getData();
                    if (recursoActual instanceof RecursoPozo) {
                        for(int zz=0;zz<celdaActual.getIndividuos().getNumeroElementos();zz++){
                            celdaActual.getIndividuos().getElemento(zz).getData().getCola().add("Muere por caerse a un pozo");
                            log.trace("Alguien se ha caido al pozo");
                        }
                        celdaActual.getIndividuos().vaciar();
                    } else if (recursoActual instanceof RecursoAgua) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() + recursoAgua.getTurnosVida());
                            actual.getCola().add("Agua consumida, turnos ganados "+recursoAgua.getTurnosVida()+", turno: "+turnos);
                            log.trace("agua consumida");
                        }
                    } else if (recursoActual instanceof RecursoComida) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() + recursoComida.getTurnosVida());
                            actual.getCola().add("Comida consumida, turnos ganados "+recursoComida.getTurnosVida()+", turno: "+turnos);
                            log.trace("comida consumida");
                        }
                    } else if (recursoActual instanceof RecursoBiblioteca && !visitado) {
                        ListaEnlazada<Individuo> desaparecer = new ListaEnlazada<>();
                        ListaEnlazada<Individuo> añadir = new ListaEnlazada<>();
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setPorcentajeClonacion(actual.getPorcentajeClonacion() + recursoBiblioteca.getPorcentajeClonacion());
                            actual.getCola().add("Biblioteca leída, clonación aumentado en: "+recursoBiblioteca.getPorcentajeClonacion());
                            if ((actual instanceof IndividuoTipoBasico)) {
                                IndividuoTipoNormal nuevo1 = new IndividuoTipoNormal(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                                IndividuoTipoNormal nuevo = new IndividuoTipoNormal(nuevo1.getId(), nuevo1);
                                añadir.add(nuevo);
                                desaparecer.add(actual);
                                desaparecerB.add(recursoActual);
                            } else if ((actual instanceof IndividuoTipoNormal)){
                                IndividuoTipoAvanzado nuevo1 = new IndividuoTipoAvanzado(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                                IndividuoTipoAvanzado nuevo = new IndividuoTipoAvanzado(nuevo1.getId(), nuevo1);
                                añadir.add(nuevo);
                                desaparecer.add(actual);
                                desaparecerB.add(recursoActual);
                            }
                            visitado = true;
                        }
                        while (!desaparecer.isVacia()) {
                            Individuo pendiente = desaparecer.getElemento(0).getData();
                            celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(pendiente));
                            desaparecer.del(0);
                        }
                        while (!añadir.isVacia()) {
                            Individuo pendiente = añadir.getElemento(0).getData();
                            celdaActual.getIndividuos().add(pendiente);
                            añadir.del(0);
                        }
                        visitado = true;
                    } else if (recursoActual instanceof RecursoMontaña) {
                        ListaEnlazada<Individuo> listaIndividuos = new ListaEnlazada<>();
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setVidas(actual.getVidas() - recursoMontaña.getTurnosVida());
                            listaIndividuos.add(actual);
                            actual.getCola().add("Montaña escalada, turnos perdidos "+recursoMontaña.getTurnosVida()+", turno: "+turnos);
                            log.trace("Montaña escalada");
                        }
                        for (int h = 0; listaIndividuos.getNumeroElementos() != h; h++) {
                            if (listaIndividuos.getElemento(h).getData().getVidas() <= 0) {
                                celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(listaIndividuos.getElemento(h).getData()));
                                listaIndividuos.getElemento(h).getData().getCola().add("Muere intenando escalar una montaña, turno: "+turnos);
                            }
                        }
                    } else if (recursoActual instanceof RecursoTesoro) {
                        for (int h = 0; celdaActual.getIndividuos().getNumeroElementos() != h; h++) {
                            Individuo actual = celdaActual.getIndividuos().getElemento(h).getData();
                            actual.setPorcentajeReproduccion(actual.getPorcentajeReproduccion() + recursoTesoro.getPorcentajeReproduccion());
                            celdaActual.getIndividuos().getElemento(h).getData().getCola().add("Tesoro encontrado, porcentaje de reproducción aumentado: "+recursoTesoro.getPorcentajeReproduccion()+" %"+", turno: "+turnos);
                            log.trace("Tesoro encontrado");

                        }
                    }
                }
                while (!desaparecerB.isVacia()) {
                    Recurso recursoDesaparecer = desaparecerB.getElemento(0).getData();
                    if (celdaActual.getRecursos().getPosicion(recursoDesaparecer) != null) {
                        celdaActual.getRecursos().del(celdaActual.getRecursos().getPosicion(recursoDesaparecer));
                    }
                    desaparecerB.del(0);
                }

            }
        }
    }

    private void reproduccionClonacion() {
        for (int i = 0; this.listaCeldas.getNumeroElementos() != i; i++) {
            for (int j = 0; this.getListaCeldas().getElemento(i).getData().getNumeroElementos() != j; j++) {
                ListaEnlazada<Individuo> nuevos = new ListaEnlazada<>();
                ListaEnlazada<Individuo> eliminar = new ListaEnlazada<>();
                Celda celdaActual = this.getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                if (celdaActual.getIndividuos().getNumeroElementos() > 1) {
                    reproducir(celdaActual);
                }
                for (int k = 0; celdaActual.getIndividuos().getNumeroElementos() != k; k++) {
                    Individuo actual = celdaActual.getIndividuos().getElemento(k).getData();
                    if (actual.getVidas() <= 0) {
                        eliminar.add(actual);
                    } else {
                        nuevos = clonar(actual, celdaActual);
                    }
                }
                while (!nuevos.isVacia()) {
                    celdaActual.getIndividuos().add(nuevos.getPrimero().getData());
                    nuevos.del(0);
                }
                while (!eliminar.isVacia()) {
                    celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(eliminar.getPrimero()));
                    eliminar.del(0);
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
                    padre1.getCola().add("Ha tenido un hijo con individuo "+padre2.getId()+", turno:"+turnos);
                    padre2.getCola().add("Ha tenido un hijo con individuo "+padre1.getId()+", turno:"+turnos);
                    log.trace("Dos indiviudos se han reproducido");
                    if (padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoBasico) {
                        IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                        IndividuoTipoBasico hijo1 = new IndividuoTipoBasico(idIndividuos, hijo);
                        identificadorIndividuos();
                        hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                        celdaActual.getIndividuos().add(hijo1);
                        individuosTotales.add(hijo1);
                    } else if (padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoNormal) {
                        IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                        IndividuoTipoNormal hijo1 = new IndividuoTipoNormal(idIndividuos, hijo);
                        identificadorIndividuos();
                        hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                        celdaActual.getIndividuos().add(hijo1);
                        individuosTotales.add(hijo1);
                    } else if (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoAvanzado) {
                        IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                        IndividuoTipoAvanzado hijo1 = new IndividuoTipoAvanzado(idIndividuos, hijo);
                        identificadorIndividuos();
                        hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                        celdaActual.getIndividuos().add(hijo1);
                        individuosTotales.add(hijo1);
                    } else if ((padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoNormal) || (padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoBasico)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                            IndividuoTipoNormal hijo1 = new IndividuoTipoNormal(idIndividuos, hijo);
                            identificadorIndividuos();
                            hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                            celdaActual.getIndividuos().add(hijo1);
                            individuosTotales.add(hijo1);
                        } else {
                            IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                            IndividuoTipoBasico hijo1 = new IndividuoTipoBasico(idIndividuos, hijo);
                            identificadorIndividuos();
                            hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                            celdaActual.getIndividuos().add(hijo1);
                            individuosTotales.add(hijo1);
                        }
                    } else if ((padre1 instanceof IndividuoTipoBasico && padre2 instanceof IndividuoTipoAvanzado) || (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoBasico)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                            IndividuoTipoAvanzado hijo1 = new IndividuoTipoAvanzado(idIndividuos, hijo);
                            identificadorIndividuos();
                            hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                            celdaActual.getIndividuos().add(hijo1);
                            individuosTotales.add(hijo1);
                        } else {
                            IndividuoTipoBasico hijo = new IndividuoTipoBasico(individuoTipoBasico.getVidas(), individuoTipoBasico.getPorcentajeReproduccion(),individuoTipoBasico.getPorcentajeClonacion(), individuoTipoBasico.getPorcentajeTipoAlReproducirse());
                            IndividuoTipoBasico hijo1 = new IndividuoTipoBasico(idIndividuos, hijo);
                            identificadorIndividuos();
                            hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                            celdaActual.getIndividuos().add(hijo1);
                            individuosTotales.add(hijo1);
                        }
                    } else if ((padre1 instanceof IndividuoTipoNormal && padre2 instanceof IndividuoTipoAvanzado) || (padre1 instanceof IndividuoTipoAvanzado && padre2 instanceof IndividuoTipoNormal)) {
                        Random r3 = new Random();
                        int prob3 = r3.nextInt(1, 100);
                        if (padre1.getPorcentajeTipoAlReproducirse() >= prob3) {
                            IndividuoTipoAvanzado hijo = new IndividuoTipoAvanzado(individuoTipoAvanzado.getVidas(), individuoTipoAvanzado.getPorcentajeReproduccion(),individuoTipoAvanzado.getPorcentajeClonacion(), individuoTipoAvanzado.getPorcentajeTipoAlReproducirse());
                            IndividuoTipoAvanzado hijo1 = new IndividuoTipoAvanzado(idIndividuos, hijo);
                            identificadorIndividuos();
                            hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                            celdaActual.getIndividuos().add(hijo1);
                            individuosTotales.add(hijo1);
                        } else {
                            IndividuoTipoNormal hijo = new IndividuoTipoNormal(individuoTipoNormal.getVidas(), individuoTipoNormal.getPorcentajeReproduccion(),individuoTipoNormal.getPorcentajeClonacion(), individuoTipoNormal.getPorcentajeTipoAlReproducirse());
                            IndividuoTipoNormal hijo1 = new IndividuoTipoNormal(idIndividuos, hijo);
                            identificadorIndividuos();
                            hijo1.getCola().add("Acaba de nacer por reproducción, padres: individuo "+padre1.getId()+",individuo "+padre2.getId()+", turno:"+turnos);
                            celdaActual.getIndividuos().add(hijo1);
                            individuosTotales.add(hijo1);
                        }
                    }
                }
            }

        } else {
            reproducir(celdaActual);
        }
    }

    private ListaEnlazada<Individuo> clonar(Individuo actual, Celda celdaActual) {
        ListaEnlazada<Individuo> individuosNuevos = new ListaEnlazada<>();
        Random r = new Random();
        int prob = r.nextInt(1, 100);
        if (actual.getPorcentajeClonacion() >= prob) {
            actual.getCola().add(("Se ha clonado y ha tenido un hijo, turno: "+turnos));
            if (actual instanceof IndividuoTipoBasico) {
                IndividuoTipoBasico nuevo = new IndividuoTipoBasico(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                IndividuoTipoBasico nuevo1 = new IndividuoTipoBasico(idIndividuos, nuevo);
                identificadorIndividuos();
                nuevo1.getCola().add("Acaba de nacer por clonación, padre: individuo "+actual.getId()+", turno:"+turnos);
                individuosNuevos.add(nuevo1);
                individuosTotales.add(nuevo1);
            } else if (actual instanceof IndividuoTipoNormal) {
                IndividuoTipoNormal nuevo = new IndividuoTipoNormal(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                IndividuoTipoNormal nuevo1 = new IndividuoTipoNormal(idIndividuos, nuevo);
                identificadorIndividuos();
                nuevo1.getCola().add("Acaba de nacer por clonación, padre: individuo "+actual.getId()+", turno:"+turnos);
                individuosNuevos.add(nuevo1);
                individuosTotales.add(nuevo1);
            } else {
                IndividuoTipoAvanzado nuevo = new IndividuoTipoAvanzado(actual.getVidas(), actual.getPorcentajeReproduccion(), actual.getPorcentajeClonacion(), actual.getPorcentajeTipoAlReproducirse());
                IndividuoTipoAvanzado nuevo1 = new IndividuoTipoAvanzado(idIndividuos, nuevo);
                identificadorIndividuos();
                nuevo1.getCola().add("Acaba de nacer por clonación, padre: individuo "+actual.getId()+", turno:"+turnos);
                individuosNuevos.add(nuevo1);
                individuosTotales.add(nuevo1);
            }
        }
        return individuosNuevos;
    }

    private void hacerEspacio1() {
        for(int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for(int j = 0; listaCeldas.getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                while (celdaActual.getIndividuos().getNumeroElementos() > 3) {
                    Individuo sanPedro = celdaActual.getIndividuos().getPrimero().getData();
                    for (int k = 1; celdaActual.getIndividuos().getNumeroElementos() != k; k++) {
                        Individuo candidato = celdaActual.getIndividuos().getElemento(k).getData();
                        if (candidato.getVidas() < sanPedro.getVidas()) {
                            sanPedro = candidato;
                        }
                    }
                    celdaActual.getIndividuos().del(celdaActual.getIndividuos().getPosicion(sanPedro));
                    sanPedro.getCola().add(("Muere porque hay más de 3 individuos en la misma casilla, turno: ")+turnos);
                }
            }
        }
    }

    private void hacerEspacio2 () {
        for(int i = 0; listaCeldas.getNumeroElementos() != i; i++) {
            for(int j = 0; listaCeldas.getElemento(i).getData().getNumeroElementos() != j; j++) {
                Celda celdaActual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                if (celdaActual.getRecursos().getNumeroElementos() < 3) {
                    Random r = new Random();
                    int prob = r.nextInt(1, 100);
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
