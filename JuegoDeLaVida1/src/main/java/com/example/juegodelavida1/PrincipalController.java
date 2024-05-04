package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;

public class PrincipalController {
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
    @FXML
    public void start(IndividuoTipoBasico individuoTipoBasico,
                      IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                      RecursoAgua recursoAgua, RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                      RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo,
                      ListaSimple<ListaSimple<Celda>> lista){
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
}
