package com.example.juegodelavida1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class CeldaController implements Initializable {
    private static int ventanas = 0;
    private static final Logger log = LogManager.getLogger(CeldaController.class);
    private static PrincipalController pC;
    private static Celda celda;
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
    MenuButton botonPrincipal;
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

    protected void ButtonCelda(Celda celda, PrincipalController pC){
        log.info("Inicalizando controlador de Celdas"+ventanas++);
        this.celda = celda;
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
        log.info("Actualizando Labels y color de la celda");
        individuo1.setText(celda.getIndividuos().toString2());
        recurso1.setText(celda.getRecursos().toString2());
        if(pC.isPausa()) {
            celda.updateGUIwithModel();
        }
        log.info("Labels y color de la celda actualizados");
    }
    @FXML
    protected void AñadirIndividuoBasico(){
        log.info("Iniciando metodo AñadirIndividuoBasico");
        if(celda.getIndividuos().getNumeroElementos()<3) {
            log.info("Añadiendo IndividuoBasico");
            log.debug(celda);
            IndividuoTipoBasico nuevo = new IndividuoTipoBasico(pC.identificadorIndividuos(), individuoTipoBasico);
            celda.add(nuevo);
            pC.getIndividuosTotales().add(nuevo);
            log.debug(celda);
            updateGUIwithModel();
            log.info("IndividuoBasico Añadido");
        }
        else{
            log.warn("IndividuoBasico no añadido");
        }
        log.info("Finalizando metodo AñadirIndividuoBasico");
    }
    @FXML
    protected void AñadirIndividuoNormal(){
        log.info("Iniciando metodo AñadirIndividuoNormal");
        if(celda.getIndividuos().getNumeroElementos()<3) {
            log.info("Añadiendo IndividuoNormal");
            log.debug(celda);
            IndividuoTipoNormal nuevo = new IndividuoTipoNormal(pC.identificadorIndividuos(), individuoTipoNormal);
            celda.add(nuevo);
            pC.getIndividuosTotales().add(nuevo);
            log.debug(celda);
            updateGUIwithModel();
            log.info("IndividuoNormal Añadido");
        }
        else{
            log.warn("IndividuoNormal no añadido");
        }
        log.info("Finalizando metodo AñadirIndividuoNormal");
    }
    @FXML
    protected void AñadirIndividuoAvanzado(){
        log.info("Iniciando metodo AñadirIndividuoAvanzado");
            if(celda.getIndividuos().getNumeroElementos()<3) {
                log.info("Añadiendo IndividuoAvanzado");
                log.debug(celda);
                IndividuoTipoAvanzado nuevo = new IndividuoTipoAvanzado(pC.identificadorIndividuos(), individuoTipoAvanzado);
                celda.add(nuevo);
                pC.getIndividuosTotales().add(nuevo);
                log.debug(celda);
                updateGUIwithModel();
                log.info("IndividuoAvanzado Añadido");
            }
            else{
                log.warn("IndividuoAvanzado no añadido");
            }
        log.info("Finalizando metodo AñadirIndividuoAvanzado");
    }
    @FXML
    protected void AñadirRecursoAgua(){
        log.info("Iniciando metodo AñadirRecursoAgua");
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Añadiendo RecursoAgua");
            log.debug(celda);
            celda.add(new RecursoAgua(recursoAgua));
            log.debug(celda);
            updateGUIwithModel();
            log.info("RecursoAgua Añadido");
        }
        else{
            log.warn("RecursoAgua no añadido");
        }
        log.info("Finalizando metodo AñadirRecursoAgua");

    }
    @FXML
    protected void AñadirRecursoComida(){
        log.info("Iniciando metodo AñadirRecursoComida");
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Añadiendo RecursoComida");
            log.debug(celda);
            celda.add(new RecursoComida(recursoComida));
            log.debug(celda);
            updateGUIwithModel();
            log.info("RecursoComida Añadido");
        }
        else{
            log.warn("RecursoComida no añadido");
        }
        log.info("Finalizando metodo AñadirRecursoComida");

    }
    @FXML
    protected void AñadirRecursoMontaña(){
        log.info("Iniciando metodo AñadirRecursoMontaña");
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Añadiendo RecursoMontaña");
            log.debug(celda);
            celda.add(new RecursoMontaña(recursoMontaña));
            log.debug(celda);
            updateGUIwithModel();
            log.info("RecursoMontaña Añadido");
        }
        else{
            log.warn("RecursoMontaña no añadido");
        }
        log.info("Finalizando metodo AñadirRecursoMontaña");
    }
    @FXML
    protected void AñadirRecursoTesoro(){
        log.info("Iniciando metodo AñadirRecursoTesoro");
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Añadiendo RecursoTesoro");
            log.debug(celda);
            celda.add(new RecursoTesoro(recursoTesoro));
            log.debug(celda);
            updateGUIwithModel();
            log.info("RecursoTesoro Añadido");
        }
        else{
            log.warn("RecursoTesoro no añadido");
        }
        log.info("Finalizando metodo AñadirRecursoTesoro");

    }
    @FXML
    protected void AñadirRecursoBiblioteca(){
        log.info("Iniciando metodo AñadirRecursoBiblioteca");
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Añadiendo RecursoBiblioteca");
            log.debug(celda);
            celda.add(new RecursoBiblioteca(recursoBiblioteca));
            log.debug(celda);
            updateGUIwithModel();
            log.info("RecursoBiblioteca Añadido");
        }
        else{
            log.warn("RecursoBiblioteca no añadido");
        }
        log.info("Finalizando metodo AñadirRecursoBiblioteca");
    }
    @FXML
    protected void AñadirRecursoPozo(){
        log.info("Iniciando metodo AñadirRecursoPozo");
        if(celda.getRecursos().getNumeroElementos()<3) {
            log.info("Añadiendo RecursoPozo");
            log.debug(celda);
            celda.add(new RecursoPozo(recursoPozo));
            log.debug(celda);
            updateGUIwithModel();
            log.info("RecursoPozo Añadido");
        }
        else{
            log.warn("RecursoPozo no añadido");
        }
        log.info("Finalizando metodo AñadirRecursoPozo");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicializando controlador de celda");
        if(!pC.isPausa()){
            botonPrincipal.setDisable(true);
        }
        updateGUIwithModel();
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
