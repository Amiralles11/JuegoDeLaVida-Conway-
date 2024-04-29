package com.example.juegodelavida1;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ParameterController implements Initializable {
    /**
     * Hooks de conexión entre los controles visuales y el código, llevan @FXML para identificarlos
     **/


    //SLIDEERS VALORES Y MEDIDAS DE INDIVIDUO
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
    protected IntegerProperty medidaVidas = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaReproduccion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaClonacion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaTipoAlReproducirse = new SimpleIntegerProperty(0);


//SLIDERS;VALORES Y MEDIDAS DE RECURSO:::::

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
    protected IntegerProperty medidaTiempoAparicion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicion = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionAgua = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionComida = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionMontaña = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionTesoro = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionBiblioteca = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaPorcentajeAparicionPozo = new SimpleIntegerProperty(0);


    //TABLERO:::
    @FXML
    private Slider sliderColumnas;
    @FXML
    private Label ValorColumnas;
    @FXML
    private Slider sliderFilas;
    @FXML
    private Label ValorFilas;
    protected IntegerProperty medidaFilas = new SimpleIntegerProperty(0);
    protected IntegerProperty medidaColumnas = new SimpleIntegerProperty(0);


    /**
     * Controlador con modelo de datos en el que trabajar
     **/
    //MODELS DE CADA PARAMETRO
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

    public void setStage(Stage s) {
        this.scene = s;
    }

    /**
     * Métodos de configuración
     **/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador de parámetros\n");
        if((model!=null)&&(model2!=null)&&(modelAgua!=null)&&(modelComida!=null)&&(modelMontaña!=null)&&(modelTesoro !=null)
                &&(modelBiblioteca!=null)&&(modelPozo!=null)&&(modelTablero!=null)){
            this.updateGUIwithModel();
        }
        sliderVidas.valueProperty().bindBidirectional(medidaVidas);
        ValorSliderVidas.textProperty().bind(medidaVidas.asString());

        sliderPorcentajeReproduccion.valueProperty().bindBidirectional(medidaReproduccion);
        ValorSliderPReproduccion.textProperty().bind(medidaReproduccion.asString());

        sliderPorcentajeClonacion.valueProperty().bindBidirectional(medidaClonacion);
        ValorSliderPClonacion.textProperty().bind(medidaClonacion.asString());

        sliderPorcentajeTipoAlReproducirse.valueProperty().bindBidirectional(medidaTipoAlReproducirse);
        ValorSliderPTipo.textProperty().bind(medidaTipoAlReproducirse.asString());

        sliderTiempoAparicion.valueProperty().bindBidirectional(medidaTiempoAparicion);
        ValorTiempoAparicion.textProperty().bind(medidaTiempoAparicion.asString());

        sliderPorcentajeAparicion.valueProperty().bindBidirectional(medidaPorcentajeAparicion);
        ValorSliderPorcentajeAparicion.textProperty().bind(medidaPorcentajeAparicion.asString());

        sliderPorcentajeAparicionAgua.valueProperty().bindBidirectional(medidaPorcentajeAparicionAgua);
        ValorSliderPorcentajeAparicionAgua.textProperty().bind(medidaPorcentajeAparicionAgua.asString());

        sliderPorcentajeAparicionComida.valueProperty().bindBidirectional(medidaPorcentajeAparicionComida);
        ValorSliderPorcentajeAparicionComida.textProperty().bind(medidaPorcentajeAparicionComida.asString());

        sliderPorcentajeAparicionMontaña.valueProperty().bindBidirectional(medidaPorcentajeAparicionMontaña);
        ValorSliderPorcentajeAparicionMontaña.textProperty().bind(medidaPorcentajeAparicionMontaña.asString());

        sliderPorcentajeAparicionTesoro.valueProperty().bindBidirectional(medidaPorcentajeAparicionTesoro);
        ValorSliderPorcentajeAparicionTesoro.textProperty().bind(medidaPorcentajeAparicionTesoro.asString());

        sliderPorcentajeAparicionBiblioteca.valueProperty().bindBidirectional(medidaPorcentajeAparicionBiblioteca);
        ValorSliderPorcentajeAparicionBiblioteca.textProperty().bind(medidaPorcentajeAparicionBiblioteca.asString());

        sliderPorcentajeAparicionPozo.valueProperty().bindBidirectional(medidaPorcentajeAparicionPozo);
        ValorSliderPorcentajeAparicionPozo.textProperty().bind(medidaPorcentajeAparicionPozo.asString());

        sliderFilas.valueProperty().bindBidirectional(medidaFilas);
        ValorFilas.textProperty().bind(medidaFilas.asString());

        sliderColumnas.valueProperty().bindBidirectional(medidaColumnas);
        ValorColumnas.textProperty().bind(medidaColumnas.asString());

    }

    @FXML
    protected void ButtonGuiaVidas() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaVidas.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Vidas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void ButtonGuiaReproduccion() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaReproduccion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Reproducción");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaClonacion() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaClonacion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Clonación");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void ButtonGuiaTipo() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaTipo.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Tipo al reproducirse");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    protected void ButtonGuiaTiempoAparicion() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaTiempoAparicion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Tiempo de aparición");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    protected void ButtonGuiaPropabilidadAparicion() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaProbabilidadAparicion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Probabilidad de aparición");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaAgua() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaAgua.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Agua");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaComida() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaComida.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Comida");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaMontaña() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaMontaña.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Montaña");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaTesoro() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaTesoro.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Tesoro");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaBiblioteca() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaBiblioteca.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Biblioteca");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaPozo() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaPozo.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Pozo");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    protected void ButtonGuiaFilas() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaFilas.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Filas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    protected void ButtonGuiaColumnas() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaColumnas.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Columnas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void ButtonOnClickTablero() {
        TableroController tab = new TableroController();
        tab.start(modelTablero.getOriginal(),(new IndividuoTipoBasico(model.getOriginal().getVidas(),model.getOriginal().getPorcentajeReproduccion(),model.getOriginal().getPorcentajeClonacion(),model.getOriginal().getPorcentajeTipoAlReproducirse())),
                (new IndividuoTipoNormal(model.getOriginal().getVidas(),model.getOriginal().getPorcentajeReproduccion(),model.getOriginal().getPorcentajeClonacion(),model.getOriginal().getPorcentajeTipoAlReproducirse())),
                (new IndividuoTipoAvanzado(model.getOriginal().getVidas(),model.getOriginal().getPorcentajeReproduccion(),model.getOriginal().getPorcentajeClonacion(),model.getOriginal().getPorcentajeTipoAlReproducirse())),
                (new RecursoAgua(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),modelAgua.getOriginal().getPorcentajeAparicion2())),
                (new RecursoComida(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),modelComida.getOriginal().getPorcentajeAparicion2())),
                (new RecursoMontaña(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),modelMontaña.getOriginal().getPorcentajeAparicion2())),
                (new RecursoTesoro(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),modelTesoro.getOriginal().getPorcentajeAparicion2())),
                (new RecursoBiblioteca(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),modelBiblioteca.getOriginal().getPorcentajeAparicion2())),
                (new RecursoPozo(model2.getOriginal().getTiempoAparicion(),model2.getOriginal().getPorcentajeAparicion(),modelPozo.getOriginal().getPorcentajeAparicion2())));
    }
}
