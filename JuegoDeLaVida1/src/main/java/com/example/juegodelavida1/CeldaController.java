package com.example.juegodelavida1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class CeldaController implements Initializable {
    private static int individuos = 0;
    private static final Logger log = LogManager.getLogger(CeldaController.class);
    private static PrincipalController pC;
    private static Celda celda;
    private static Button button;
    private static IndividuoTipoBasico individuoTipoBasico;
    private static IndividuoTipoNormal individuoTipoNormal;
    private static IndividuoTipoAvanzado individuoTipoAvanzado;
    private static RecursoAgua recursoAgua;
    private static RecursoBiblioteca recursoBiblioteca;
    private static RecursoComida recursoComida;
    private static RecursoMontaña recursoMontaña;
    private static RecursoPozo recursoPozo;
    private static RecursoTesoro recursoTesoro;
    @FXML
    Label titulo;
    @FXML
    Label Individuos;
    @FXML
    Label Recursos;
    @FXML
    MenuItem AñadirIndividuoBasico;
    @FXML
    MenuItem AñadirIndividuoNormal;
    @FXML
    MenuItem AñadirIndividuoAvanzado;
    @FXML
    MenuItem AñadirRecursoAgua;
    @FXML
    MenuItem AñadirRecursoComida;
    @FXML
    MenuItem AñadirRecursoMontaña;
    @FXML
    MenuItem AñadirRecursoTesoro;
    @FXML
    MenuItem AñadirRecursoBiblioteca;
    @FXML
    MenuItem AñadirRecursoPozo;

    protected void ButtonCelda(Celda celda,Button button,PrincipalController pC){
        this.celda = celda;
        this.button = button;
        this.pC = pC;
        this.individuoTipoBasico = pC.getIndividuoTipoBasico();
        this.individuoTipoNormal = pC.getIndividuoTipoNormal();
        this.individuoTipoAvanzado = pC.getIndividuoTipoAvanzado();
        this.recursoAgua = pC.getRecursoAgua();
        this.recursoBiblioteca = pC.getRecursoBiblioteca();
        this.recursoComida = pC.getRecursoComida();
        this.recursoMontaña = pC.getRecursoMontaña();
        this.recursoPozo = pC.getRecursoPozo();
        this.recursoTesoro = pC.getRecursoTesoro();
    }
    @FXML
    protected void AñadirIndividuoBasico(){
        log.info("Iniciando metodo AñadirIndividuoBasico");
        log.debug(celda);
        celda.add(new IndividuoTipoBasico(individuos++,individuoTipoBasico));
        log.debug(celda);
        log.info("Finalizando metodo AñadirIndividuoBasico");
    }
    @FXML
    protected void AñadirIndividuoNormal(){
        log.info("Iniciando metodo AñadirIndividuoNormal");
        log.debug(celda);
        celda.add(new IndividuoTipoNormal(individuos++,individuoTipoNormal));
        log.debug(celda);
        log.info("Finalizando metodo AñadirIndividuoNormal");

    }
    @FXML
    protected void AñadirIndividuoAvanzado(){
        log.info("Iniciando metodo AñadirIndividuoAvanzado");
        log.debug(celda);
        celda.add(new IndividuoTipoNormal(individuos++,individuoTipoAvanzado));
        log.debug(celda);
        log.info("Finalizando metodo AñadirIndividuoAvanzado");
    }
    @FXML
    protected void AñadirRecursoAgua(){

    }
    @FXML
    protected void AñadirRecursoComida(){

    }
    @FXML
    protected void AñadirRecursoMontaña(){

    }
    @FXML
    protected void AñadirRecursoTesoro(){

    }
    @FXML
    protected void AñadirRecursoBiblioteca(){

    }
    @FXML
    protected void AñadirRecursoPozo(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            log.info("Inicializando controlador de celda");
            AñadirIndividuoBasico.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirIndividuoBasico();
                }
            });
            AñadirIndividuoNormal.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirIndividuoNormal();
                }
            });
            AñadirIndividuoAvanzado.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirIndividuoAvanzado();
                }
            });
            AñadirRecursoAgua.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirRecursoAgua();
                }
            });
            AñadirRecursoComida.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirRecursoComida();
                }
            });
            AñadirRecursoMontaña.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirRecursoMontaña();
                }
            });
            AñadirRecursoTesoro.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirRecursoTesoro();
                }
            });
            AñadirRecursoBiblioteca.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirRecursoBiblioteca();
                }
            });
            AñadirRecursoPozo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    AñadirRecursoPozo();
                }
            });
        }
}
