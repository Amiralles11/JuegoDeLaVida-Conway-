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

public class ParameterController implements Initializable {
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





//SLIDERS DE RECURSO:::::

    @FXML
    private Slider sliderTiempoAparicion;
    @FXML
    private Label ValorTiempoAparicion;
    @FXML
    private Slider sliderPorcentajeAparicion;
    @FXML
    private Label ValorSliderPorcentajeAparicion;
    @FXML
    private Slider sliderPorcentajeAparicionAgua;
    @FXML
    private Label ValorSliderPorcentajeAparicionAgua;
    @FXML
    private Slider sliderPorcentajeAparicionComida;
    @FXML
    private Label ValorSliderPorcentajeAparicionComida;
    @FXML
    private Slider sliderPorcentajeAparicionMontaña;
    @FXML
    private Label ValorSliderPorcentajeAparicionMontaña;
    @FXML
    private Slider sliderPorcentajeAparicionTesoro;
    @FXML
    private Label ValorSliderPorcentajeAparicionTesoro;
    @FXML
    private Slider sliderPorcentajeAparicionBiblioteca;
    @FXML
    private Label ValorSliderPorcentajeAparicionBiblioteca;
    @FXML
    private Slider sliderPorcentajeAparicionPozo;
    @FXML
    private Label ValorSliderPorcentajeAparicionPozo;
    protected IntegerProperty medida11 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida12 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida13 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida14 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida15 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida16 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida17 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida18 = new SimpleIntegerProperty(0);




    //TABLERO:::
    @FXML
    private Slider sliderColumnas;
    @FXML
    private Label ValorColumnas;
    @FXML
    private Slider sliderFilas;
    @FXML
    private Label ValorFilas;
    protected IntegerProperty medida21 = new SimpleIntegerProperty(0);
    protected IntegerProperty medida22 = new SimpleIntegerProperty(0);
    /**
     * Controlador con modelo de datos en el que trabajar
     **/
    private IndividuoParametros model;

    private RecursoParametros model2;

    private RecursoParametros.RecursoParametrosAgua modelAgua;
    private RecursoParametros.RecursoParametrosComida modelComida;
    private RecursoParametros.RecursoParametrosMontaña modelMontaña;
    private RecursoParametros.RecursoParametrosTesoro modelTesoro;
    private RecursoParametros.RecursoParametrosBiblioteca modelBiblioteca;
    private RecursoParametros.RecursoParametrosPozo modelPozo;

    private TableroParametros modelTablero;
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
    protected void onBotonGuardarClick2() {
        model2.commit();
        modelAgua.commit();
        modelComida.commit();
        modelMontaña.commit();
        modelBiblioteca.commit();
        modelPozo.commit();
        modelTesoro.commit();
    }
    @FXML
    protected void onBotonGuardarClick3() {
        modelTablero.commit();
    }

    @FXML
    protected void onBotonReiniciarClick() {
        model.rollback();
    }
    @FXML
    protected void onBotonReiniciarClick2() {
        model2.rollback();
        modelAgua.rollback();
        modelComida.rollback();
        modelMontaña.rollback();
        modelBiblioteca.rollback();
        modelPozo.rollback();
        modelTesoro.rollback();
    }
    @FXML
    protected void onBotonReiniciarClick3() {
        modelTablero.rollback();
    }


    /**
     * Este método se encarga de conectar los datos del modelo con el GUI
     **/
    protected void updateGUIwithModel() {
        sliderVidas.valueProperty().bindBidirectional(model.VidasProperty());
        sliderPorcentajeReproduccion.valueProperty().bindBidirectional(model.PorcentajeReproduccionProperty());
        sliderPorcentajeClonacion.valueProperty().bindBidirectional(model.PorcentajeClonacionProperty());
        sliderPorcentajeTipoAlReproducirse.valueProperty().bindBidirectional(model.PorcentajeTipoAlReproducirse());

        sliderTiempoAparicion.valueProperty().bindBidirectional(model2.TiempoAparicionProperty());
        sliderPorcentajeAparicion.valueProperty().bindBidirectional(model2.PorcentajeAparicionProperty());

        sliderPorcentajeAparicionAgua.valueProperty().bindBidirectional(modelAgua.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionComida.valueProperty().bindBidirectional(modelComida.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionMontaña.valueProperty().bindBidirectional(modelMontaña.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionTesoro.valueProperty().bindBidirectional(modelTesoro.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionBiblioteca.valueProperty().bindBidirectional(modelBiblioteca.PorcentajeAparicion2Property());
        sliderPorcentajeAparicionPozo.valueProperty().bindBidirectional(modelPozo.PorcentajeAparicion2Property());

        sliderFilas.valueProperty().bindBidirectional(modelTablero.FilasProperty());
        sliderColumnas.valueProperty().bindBidirectional(modelTablero.ColumnasProperty());
    }

    /**
     * Este método recibe los datos del modelo y los establece
     **/
    public void loadUserData(IndividuoParametros parametrosData, RecursoParametros parametrosData2, RecursoParametros.RecursoParametrosAgua parametrosAgua, RecursoParametros.RecursoParametrosComida parametrosComida,
                             RecursoParametros.RecursoParametrosMontaña parametrosMontaña, RecursoParametros.RecursoParametrosTesoro parametrosTesoro,
                             RecursoParametros.RecursoParametrosBiblioteca parametrosBiblioteca, RecursoParametros.RecursoParametrosPozo parametrosPozo,
                             TableroParametros tableroParametros) {
        this.model = parametrosData;
        this.model2 = parametrosData2;
        this.modelAgua = parametrosAgua;
        this.modelComida = parametrosComida;
        this.modelMontaña = parametrosMontaña;
        this.modelTesoro = parametrosTesoro;
        this.modelBiblioteca = parametrosBiblioteca;
        this.modelPozo = parametrosPozo;
        this.modelTablero = tableroParametros;
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

        sliderTiempoAparicion.valueProperty().bindBidirectional(medida11);
        ValorTiempoAparicion.textProperty().bind(medida11.asString());

        sliderPorcentajeAparicion.valueProperty().bindBidirectional(medida12);
        ValorSliderPorcentajeAparicion.textProperty().bind(medida12.asString());

        sliderPorcentajeAparicionAgua.valueProperty().bindBidirectional(medida13);
        ValorSliderPorcentajeAparicionAgua.textProperty().bind(medida13.asString());

        sliderPorcentajeAparicionComida.valueProperty().bindBidirectional(medida14);
        ValorSliderPorcentajeAparicionComida.textProperty().bind(medida14.asString());

        sliderPorcentajeAparicionMontaña.valueProperty().bindBidirectional(medida15);
        ValorSliderPorcentajeAparicionMontaña.textProperty().bind(medida15.asString());

        sliderPorcentajeAparicionTesoro.valueProperty().bindBidirectional(medida16);
        ValorSliderPorcentajeAparicionTesoro.textProperty().bind(medida16.asString());

        sliderPorcentajeAparicionBiblioteca.valueProperty().bindBidirectional(medida17);
        ValorSliderPorcentajeAparicionBiblioteca.textProperty().bind(medida17.asString());

        sliderPorcentajeAparicionPozo.valueProperty().bindBidirectional(medida18);
        ValorSliderPorcentajeAparicionPozo.textProperty().bind(medida18.asString());

        sliderFilas.valueProperty().bindBidirectional(medida21);
        ValorFilas.textProperty().bind(medida21.asString());

        sliderColumnas.valueProperty().bindBidirectional(medida22);
        ValorColumnas.textProperty().bind(medida22.asString());

    }
}
