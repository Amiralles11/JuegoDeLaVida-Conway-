package com.example.juegodelavida1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class CeldaController implements Initializable {
    private static int individuos = 0;
    private static final Logger log = LogManager.getLogger(CeldaController.class);
    private static PrincipalController pC;
    private static Celda celda;
    private static Rectangle rectangle;
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
    Label individuo1;
    @FXML
    Label recurso1;
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

    protected void ButtonCelda(Celda celda, Rectangle rectangle, PrincipalController pC){
        this.celda = celda;
        this.rectangle = rectangle;
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

    protected void updateGUIwithModel() {
        individuo1.setText(celda.getIndividuos().toString2());
        recurso1.setText(celda.getRecursos().toString2());
        if(celda.getIndividuos().getNumeroElementos()==0){
            rectangle.setFill(Color.WHITE);
        }
        else if(celda.getIndividuos().getNumeroElementos()==1){
            rectangle.setFill(Color.LIGHTYELLOW);
        }
        else if(celda.getIndividuos().getNumeroElementos()==2){
            rectangle.setFill(Color.YELLOW);
        }
        else if(celda.getIndividuos().getNumeroElementos()==3){
            rectangle.setFill(Color.YELLOWGREEN);
        }
    }
    @FXML
    protected void AñadirIndividuoBasico(){
        if(celda.getIndividuos().getNumeroElementos()<3) {
            log.info("Iniciando metodo AñadirIndividuoBasico");
            log.debug(celda);
            celda.add(new IndividuoTipoBasico(individuos++, individuoTipoBasico));
            log.debug(celda);
            log.info("Finalizando metodo AñadirIndividuoBasico");
            updateGUIwithModel();
        }
    }
    @FXML
    protected void AñadirIndividuoNormal(){
        if(celda.getIndividuos().getNumeroElementos()<3) {
            log.info("Iniciando metodo AñadirIndividuoNormal");
            log.debug(celda);
            celda.add(new IndividuoTipoNormal(individuos++, individuoTipoNormal));
            log.debug(celda);
            log.info("Finalizando metodo AñadirIndividuoNormal");
            updateGUIwithModel();
        }

    }
    @FXML
    protected void AñadirIndividuoAvanzado(){
            if(celda.getIndividuos().getNumeroElementos()<3) {
                log.info("Iniciando metodo AñadirIndividuoAvanzado");
                log.debug(celda);
                celda.add(new IndividuoTipoNormal(individuos++, individuoTipoAvanzado));
                log.debug(celda);
                log.info("Finalizando metodo AñadirIndividuoAvanzado");
                updateGUIwithModel();
            }
    }
    @FXML
    protected void AñadirRecursoAgua(){
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Iniciando metodo AñadirRecursoAgua");
            log.debug(celda);
            celda.add(recursoAgua);
            log.debug(celda);
            log.info("Finalizando metodo AñadirRecursoAgua");
            updateGUIwithModel();
        }

    }
    @FXML
    protected void AñadirRecursoComida(){
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Iniciando metodo AñadirRecursoComida");
            log.debug(celda);
            celda.add(recursoComida);
            log.debug(celda);
            log.info("Finalizando metodo AñadirRecursoComida");
            updateGUIwithModel();
        }

    }
    @FXML
    protected void AñadirRecursoMontaña(){
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Iniciando metodo AñadirRecursoMontaña");
            log.debug(celda);
            celda.add(recursoMontaña);
            log.debug(celda);
            log.info("Finalizando metodo AñadirRecursoMontaña");
            updateGUIwithModel();
        }
    }
    @FXML
    protected void AñadirRecursoTesoro(){
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Iniciando metodo AñadirRecursoTesoro");
            log.debug(celda);
            celda.add(recursoTesoro);
            log.debug(celda);
            log.info("Finalizando metodo AñadirRecursoTesoro");
            updateGUIwithModel();
        }

    }
    @FXML
    protected void AñadirRecursoBiblioteca(){
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Iniciando metodo AñadirRecursoBiblioteca");
            log.debug(celda);
            celda.add(recursoBiblioteca);
            log.debug(celda);
            log.info("Finalizando metodo AñadirRecursoBiblioteca");
            updateGUIwithModel();
        }
    }
    @FXML
    protected void AñadirRecursoPozo(){
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Iniciando metodo AñadirRecursoPozo");
            log.debug(celda);
            celda.add(recursoPozo);
            log.debug(celda);
            log.info("Finalizando metodo AñadirRecursoPozo");
            updateGUIwithModel();
        }}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateGUIwithModel();
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
