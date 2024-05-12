package com.example.juegodelavida1;


import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;


public class TableroController implements Initializable {
    private static Stage stageTablero;
    private PrincipalController pC;
    private static ListaSimple<ListaSimple<Celda>> listaCeldas;
    private static int ventanas = 1;
    private static final Logger log = LogManager.getLogger(TableroController.class);
    private static Tablero tablero;
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
    private GridPane tableroDeJuego;

    public TableroController() {
    }
    public void update(IndividuoTipoBasico individuoTipoBasico,
                       IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                       RecursoAgua recursoAgua,  RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                       RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo){
        this.individuoTipoBasico = individuoTipoBasico;
        this.individuoTipoNormal = individuoTipoNormal;
        this.individuoTipoAvanzado = individuoTipoAvanzado;
        this.recursoAgua = recursoAgua;
        this.recursoBiblioteca = recursoBiblioteca;
        this.recursoComida = recursoComida;
        this.recursoMontaña = recursoMontaña;
        this.recursoPozo = recursoPozo;
        this.recursoTesoro = recursoTesoro;
        stageTablero.show();
    }
    @FXML
    public void start(Tablero tablero, IndividuoTipoBasico individuoTipoBasico,
                      IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                      RecursoAgua recursoAgua,  RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                      RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo) {
        log.info("Iniciando controlador de tablero, ventana: "+ventanas++);
        this.tablero = tablero;
        this.individuoTipoBasico = individuoTipoBasico;
        this.individuoTipoNormal = individuoTipoNormal;
        this.individuoTipoAvanzado = individuoTipoAvanzado;
        this.recursoAgua = recursoAgua;
        this.recursoBiblioteca = recursoBiblioteca;
        this.recursoComida = recursoComida;
        this.recursoMontaña = recursoMontaña;
        this.recursoPozo = recursoPozo;
        this.recursoTesoro = recursoTesoro;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("Tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
            stage.setTitle("Tablero");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("Tablero.fxml no encontrado");
            e.printStackTrace();
        }
        this.stageTablero = stage;
    }
    @FXML
    protected void RectangleOnDragEntered(Rectangle rectange, Celda celda){
        rectange.setFill(Color.DARKGREY);
    }
    @FXML
    protected void RectangleOnDragExited(Rectangle rectange, Celda celda){
        if(celda.getIndividuos().getNumeroElementos()==0){
            rectange.setFill(Color.WHITE);
        }
        else if(celda.getIndividuos().getNumeroElementos()==1){
            rectange.setFill(Color.LIGHTYELLOW);
        }
        else if(celda.getIndividuos().getNumeroElementos()==2){
            rectange.setFill(Color.YELLOW);
        }
        else if(celda.getIndividuos().getNumeroElementos()==3){
            rectange.setFill(Color.YELLOWGREEN);
        }
    }
    @FXML
    protected void ButtonCelda(Celda celda){
        log.info("Iniciando metodo ButtonCelda");
        CeldaController cD = new CeldaController();
        cD.ButtonCelda(celda,pC);
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(CeldaController.class.getResource("ButtonCelda.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.setTitle("Celda" + "(" + (celda.getFilas()+1) + "," + (celda.getColumnas()+1) + ")");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("ButtonCelda.fxml no encontrado");
            e.printStackTrace();
        }
        log.info("Finalizando metodo ButtonCelda");
    }
    @FXML
    protected void ButtonPausar(){
        pC.setPausa(true);
    }
    @FXML
    protected void ButtonContinuar(){
        pC.setPausa(false);
    }
    @FXML
    protected void ButtonConfiguracion(){
        if(pC.isPausa()) {
            log.info("Iniciando metodo ButtonConfiguracion");
            IndividuoParametros modeloParaGUICompartido = new IndividuoParametros(individuoTipoBasico);
            RecursoParametros modeloParaGUICompartido2 = new RecursoParametros(recursoPozo);
            RecursoParametros.RecursoParametrosAgua modeloParaGUICompartidoAgua = new RecursoParametros.RecursoParametrosAgua(recursoAgua);
            RecursoParametros.RecursoParametrosComida modeloParaGUICompartidoComida = new RecursoParametros.RecursoParametrosComida(recursoComida);
            RecursoParametros.RecursoParametrosMontaña modeloParaGUICompartidoMontaña = new RecursoParametros.RecursoParametrosMontaña(recursoMontaña);
            RecursoParametros.RecursoParametrosTesoro modeloParaGUICompartidoTesoro = new RecursoParametros.RecursoParametrosTesoro(recursoTesoro);
            RecursoParametros.RecursoParametrosBiblioteca modeloParaGUICompartidoBiblioteca = new RecursoParametros.RecursoParametrosBiblioteca(recursoBiblioteca);
            RecursoParametros.RecursoParametrosPozo modeloParaGUICompartidoPozo = new RecursoParametros.RecursoParametrosPozo(recursoPozo);
            log.debug(individuoTipoBasico);
            log.debug(recursoPozo);
            log.debug(recursoAgua);
            log.debug(recursoComida);
            log.debug(recursoMontaña);
            log.debug(recursoTesoro);
            log.debug(recursoBiblioteca);
            log.debug(recursoPozo);
            log.info("parametros guardados");
            log.info("Inicializando ventana Configuracion");
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(ConfiguracionController.class.getResource("VentanaConfiguracion.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 320 * 3, 240 * 3);
                stage.setTitle("Establezca parámetros: ");
                stage.setScene(scene);
                ConfiguracionController p = fxmlLoader.getController();
                log.debug("Guardando valores predeterminados (loadUserData)");
                p.loadUserData(this, modeloParaGUICompartido, modeloParaGUICompartido2, modeloParaGUICompartidoAgua,
                        modeloParaGUICompartidoComida, modeloParaGUICompartidoMontaña, modeloParaGUICompartidoTesoro,
                        modeloParaGUICompartidoBiblioteca, modeloParaGUICompartidoPozo, stage); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                p.setStage(stage);
                stage.show();
            } catch (Exception e) {
                log.error("VentanaNuevaPartida.fxml no encontrada");
                e.printStackTrace();
            }
            log.info("Finalizando metodo ButtonConfiguracion");
            stageTablero.close();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicializando tablero");
            listaCeldas = new ListaSimple<>(tablero.getColumnas());
            for (int i = 0; i < tablero.getColumnas(); i++) {
                ListaSimple<Celda> listaS = new ListaSimple<>(tablero.getFilas());
                //LDE = new ListaDoblementeEnlazada()...
                for (int j = 0; j < tablero.getFilas(); j++) {
                    // Aquí podrías instanciar tu LetrasColoresGrid
                    // LetrasColoresGrid customComponent = new LetrasColoresGrid();
                    // mainGrid.add(customComponent, i, j);

                    // Ejemplo simplificado con un label
                    Rectangle rectangle = new Rectangle(310 * 3 / tablero.getColumnas(), 450 / tablero.getFilas(),Color.WHITE);
                    final Button placeholder = new Button();
                    Celda celda = new Celda(j,i,rectangle);
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celda);
                        }
                    });
                    placeholder.setOnMouseEntered(mouseEvent -> {
                                RectangleOnDragEntered(rectangle,celda);
                            });
                    placeholder.setOnMouseExited(mouseEvent -> {
                        RectangleOnDragExited(rectangle,celda);
                    });
                    placeholder.setMinSize(320 * 3 / tablero.getColumnas(), 461 / tablero.getFilas()); // Tamaño mínimo para visualización
                    placeholder.setMaxSize(320 * 3 / tablero.getColumnas(), 461 / tablero.getFilas()); // Tamaño máximo para visualización
                    placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center");
                    placeholder.setGraphic(rectangle);
                    tableroDeJuego.add(placeholder, i, j);
                    listaS.add(celda);
                    //LDE.add(celda)...
                }
                listaCeldas.add(listaS);
            }
        log.info("Tablero terminado");
        pC = new PrincipalController(true,individuoTipoBasico,individuoTipoNormal,individuoTipoAvanzado,recursoAgua,recursoComida,recursoMontaña,
                recursoTesoro,recursoBiblioteca,recursoPozo,listaCeldas);
     }

    public PrincipalController getpC() {
        return pC;
    }
}
