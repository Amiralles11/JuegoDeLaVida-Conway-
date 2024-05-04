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
    private static final Logger log = LogManager.getLogger(CeldaController.class);
    private PrincipalController pC;
    private Celda celda;
    private Button button;
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

    protected void ButtonCelda(Celda celda, Button button,PrincipalController pC, IndividuoTipoBasico individuoTipoBasico,
                               IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                               RecursoAgua recursoAgua,  RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                               RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo){
        this.celda = celda;
        this.button = button;
        this.pC = pC;
        this.individuoTipoBasico = individuoTipoBasico;
        this.individuoTipoNormal = individuoTipoNormal;
        this.individuoTipoAvanzado = individuoTipoAvanzado;
        this.recursoAgua = recursoAgua;
        this.recursoBiblioteca = recursoBiblioteca;
        this.recursoComida = recursoComida;
        this.recursoMontaña = recursoMontaña;
        this.recursoPozo = recursoPozo;
        this.recursoTesoro = recursoTesoro;
    }
    @FXML
    protected void AñadirIndividuoBasico(Celda celda,Button button){
        log.info("Iniciando metodo AñadirIndividuoBasico");
    }
    @FXML
    protected void AñadirIndividuoNormal(Celda celda,Button button){

    }
    @FXML
    protected void AñadirIndividuoAvanzado(Celda celda,Button button){

    }
    @FXML
    protected void AñadirRecursoAgua(Celda celda,Button button){

    }
    @FXML
    protected void AñadirRecursoComida(Celda celda,Button button){

    }
    @FXML
    protected void AñadirRecursoMontaña(Celda celda,Button button){

    }
    @FXML
    protected void AñadirRecursoTesoro(Celda celda,Button button){

    }
    @FXML
    protected void AñadirRecursoBiblioteca(Celda celda,Button button){

    }
    @FXML
    protected void AñadirRecursoPozo(Celda celda,Button button){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicializando controlador de celda");
        AñadirIndividuoBasico.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirIndividuoBasico(celda,button);
            }
        });
        AñadirIndividuoNormal.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirIndividuoNormal(celda,button);
            }
        });
        AñadirIndividuoAvanzado.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirIndividuoAvanzado(celda,button);
            }
        });
        AñadirRecursoAgua.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirRecursoAgua(celda,button);
            }
        });
        AñadirRecursoComida.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirRecursoComida(celda,button);
            }
        });
        AñadirRecursoMontaña.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirRecursoMontaña(celda,button);
            }
        });
        AñadirRecursoTesoro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirRecursoTesoro(celda,button);
            }
        });
        AñadirRecursoBiblioteca.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirRecursoBiblioteca(celda,button);
            }
        });
        AñadirRecursoPozo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AñadirRecursoPozo(celda,button);
            }
        });

    }
}
