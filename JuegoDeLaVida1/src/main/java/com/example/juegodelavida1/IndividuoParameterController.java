package com.example.juegodelavida1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class IndividuoParameterController implements Initializable {
    /**
     * Hooks de conexión entre los controles visuales y el código, llevan @FXML para identificarlos
     **/
    @FXML
    private Slider sliderVidas;
    @FXML
    private Label ValorSliderVidas;
    @FXML
    private Slider sliderPorcentajeReproduccion;
    @FXML
    private Label ValorSliderPReproduccion;
    @FXML
    private Slider sliderPorcentajeClonacion;
    @FXML
    private Label ValorSliderPClonacion;
    @FXML
    private Slider sliderPorcentajeTipoAlReproducirse;
    @FXML
    private Label ValorSliderPTipo;
    protected IntegerProperty medida1 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida2 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida3 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida4 = new SimpleIntegerProperty(0);


    /**
     * Controlador con modelo de datos en el que trabajar
     **/
    private IndividuoParametros model;
    private Stage scene;


    /** Métodos de respuesta a eventos: El GUI llama a estos métodos del controlador para realizar operaciones **/
    /**
     * La convención es llamarlos on+TipoControl+operacionalaqueresponde :
     * onMiBotonEjemploClick indica que es un "manejador de evento de tipo click" del botón MiBotonEjemplo del interfaz
     */


    @FXML
    protected void onBotonGuardarClick() {
        model.commit();
    }

    @FXML
    protected void onBotonReiniciarClick() {
        model.rollback();
    }


    /**
     * Este método se encarga de conectar los datos del modelo con el GUI
     **/
    protected void updateGUIwithModel() {
        sliderVidas.valueProperty().bindBidirectional(model.VidasProperty());
        sliderPorcentajeReproduccion.valueProperty().bindBidirectional(model.PorcentajeReproduccionProperty());
        sliderPorcentajeClonacion.valueProperty().bindBidirectional(model.PorcentajeClonacionProperty());
        sliderPorcentajeTipoAlReproducirse.valueProperty().bindBidirectional(model.PorcentajeTipoAlReproducirse());
    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(IndividuoParametros parametrosData) {
        this.model = parametrosData;
        this.updateGUIwithModel();
    }
    public void setStage(Stage s){
        this.scene = s;
    }
    /**
     * Métodos de configuración
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador de parámetros\n");

        if (model != null) {
            this.updateGUIwithModel();
        }
        sliderVidas.valueProperty().bindBidirectional(medida1);
        ValorSliderVidas.textProperty().bind(medida1.asString());

        sliderPorcentajeReproduccion.valueProperty().bindBidirectional(medida2);
        ValorSliderPReproduccion.textProperty().bind(medida2.asString());

        sliderPorcentajeClonacion.valueProperty().bindBidirectional(medida3);
        ValorSliderPClonacion.textProperty().bind(medida3.asString());

        sliderPorcentajeTipoAlReproducirse.valueProperty().bindBidirectional(medida4);
        ValorSliderPTipo.textProperty().bind(medida4.asString());
    }
}
