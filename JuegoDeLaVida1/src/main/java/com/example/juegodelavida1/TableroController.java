package com.example.juegodelavida1;


import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;


public class TableroController implements Initializable {
    URL linkNuevoPausa = getClass().getResource("/imagenes/boton-de-pausa.png");
    Image imagenPausa = new Image(linkNuevoPausa.toString(),35,35,false,true);
    URL linkNuevoContinuar = getClass().getResource("/imagenes/boton-de-play.png");
    Image imagenContinuar = new Image(linkNuevoContinuar.toString(),30,30,false,true);
    URL linkNuevoAcelerar = getClass().getResource("/imagenes/delantero.png");
    Image imagenAcelerar = new Image(linkNuevoAcelerar.toString(),32,32,false,true);
    URL linkNuevoTerminar = getClass().getResource("/imagenes/caja.png");
    Image imagenTerminar = new Image(linkNuevoTerminar.toString(),30,30,false,true);
    URL linkNuevoGuardar = getClass().getResource("/imagenes/guardar-el-archivo.png");
    Image imagenGuardar = new Image(linkNuevoGuardar.toString(),30,30,false,true);
    URL linkNuevoAjustes = getClass().getResource("/imagenes/configuracion.png");
    Image imagenAjustes = new Image(linkNuevoAjustes.toString(),30,30,false,true);
    URL linkNuevoGuia = getClass().getResource("/imagenes/guia.png");
    Image imagenGuia = new Image(linkNuevoGuia.toString(),50,50,false,true);
    @FXML
    Button botonPausa;
    @FXML
    Button botonContinuar;
    @FXML
    Button botonAcelerar;
    @FXML
    Button botonTerminar;
    @FXML
    Button botonAjustes;
    @FXML
    Button botonGuardar;
    @FXML
    Button botonGuia;
    @FXML
    Label turnos;
    private static Stage stageTablero;
    private PrincipalController pC;
    private ListaEnlazada<Stage> celdaVentanas = new ListaEnlazada<>();
    private static ListaEnlazada<Individuo> individuosTotales;
    private static ListaSimple<ListaSimple<Celda>> listaCeldas;
    private static ListaSimple<ListaSimple<Celda>> listaCeldas2;
    private static int ventanas = 1;
    private static final Logger log = LogManager.getLogger(TableroController.class);
    private static int idIndividuos;
    private static int turnosValor;
    private static int idArcos;
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

    public TableroController(){
    }
    @FXML
    public void start2(Tablero tablero, IndividuoTipoBasico individuoTipoBasico,
                      IndividuoTipoNormal individuoTipoNormal, IndividuoTipoAvanzado individuoTipoAvanzado,
                      RecursoAgua recursoAgua,  RecursoComida recursoComida, RecursoMontaña recursoMontaña,
                      RecursoTesoro recursoTesoro, RecursoBiblioteca recursoBiblioteca, RecursoPozo recursoPozo,ListaSimple<ListaSimple<Celda>> lista,
                       int idIndividuos2,int turnosValor2, int idArcos, ListaEnlazada<Individuo> individuosTotales) {
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
        this.listaCeldas2 = lista;
        this.idIndividuos = idIndividuos2;
        this.turnosValor = turnosValor2;
        this.idArcos = idArcos;
        this.individuosTotales = individuosTotales;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("Tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
            stage.setTitle("Tablero");
            stage.setScene(scene);
            fxmlLoader.setController(this);
            stage.show();
        } catch (Exception e) {
            log.error("Tablero.fxml no encontrado");
            e.printStackTrace();
        }
        this.stageTablero = stage;
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
        this.listaCeldas2 = null;
        this.idIndividuos = 0;
        this.idArcos = 0;
        this.turnosValor = 0;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(TableroController.class.getResource("Tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
            stage.setTitle("Tablero");
            stage.setScene(scene);
            fxmlLoader.setController(this);
            stage.show();
        } catch (Exception e) {
            log.error("Tablero.fxml no encontrado");
            e.printStackTrace();
        }
        this.stageTablero = stage;
    }
    @FXML
    protected void RectangleOnDragEntered(Rectangle rectange){
        rectange.setFill(Color.DARKGREY);
    }
    @FXML
    protected void RectangleOnDragExited(Celda celda){
        celda.updateGUIwithModel();
    }
    @FXML
    protected void Aceleracion(){
        log.info("Cambiando tiempo entre cada turno");
        pC.setTiempoEspera();
        log.info("Tiempo entre cada turno cambiado");
    }
    @FXML
    public void setTurnos(){
        turnos.setText(pC.identificadorTurnos()+"");
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
            fxmlLoader.setController(cD);
            celdaVentanas.add(stage);
            stage.show();
        } catch (Exception e) {
            log.error("ButtonCelda.fxml no encontrado");
            e.printStackTrace();
        }

        log.info("Finalizando metodo ButtonCelda");
    }
    @FXML
    protected void ButtonGuia(){
        log.info("Iniciando metodo ButtonGuia");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(CeldaController.class.getResource("zAVentanaGuia.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 960, 720);
            stage.setTitle("Guia");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zAVentanaGuia.fxml no encontrado");
            e.printStackTrace();
        }

        log.info("Finalizando metodo ButtonGuia");
    }
    @FXML
    protected void ButtonPausar(){
        for(int i = 0;i< celdaVentanas.getNumeroElementos();i++){
            celdaVentanas.getElemento(i).getData().close();
        }
        celdaVentanas.vaciar();
        pC.setPausa(true);
    }
    @FXML
    protected void ButtonContinuar(){
        for(int i = 0;i< celdaVentanas.getNumeroElementos();i++){
            celdaVentanas.getElemento(i).getData().close();
        }
        celdaVentanas.vaciar();
        pC.setPausa(false);
        pC.bucleControl();
    }
    @FXML
    protected void ButtonConfiguracion(){
        if(pC.isPausa()) {
            log.info("Iniciando metodo ButtonConfiguracion");
            for(int i = 0;i< celdaVentanas.getNumeroElementos();i++){
                celdaVentanas.getElemento(i).getData().close();
            }
            celdaVentanas.vaciar();
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
                        modeloParaGUICompartidoBiblioteca, modeloParaGUICompartidoPozo, stage,pC); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
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

    @FXML
    protected void ButtonTerminarPartida(){
        log.info("Iniciando metodo finalizar partida");
        pC.setFinPartida(true);
        if(pC.isPausa()){
            FinalPartidaController fC = new FinalPartidaController();
            fC.start(pC);
        }
    }
    @FXML
    protected void ButtonGuardar(){
        if(pC.isPausa()){
            log.info("Iniciando metodo ButtonGuardar");
            GuardarPartidaController partida = new GuardarPartidaController();
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(partida.getClass().getResource("VentanaGuardarPartida.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 480, 360);
                stage.setTitle("Guardar Partida");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                log.error("VentanaGuardarPartida.fxml no encontrado");
                e.printStackTrace();
            }
            partida.loadUserData(pC,stage);
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
                    Rectangle rectangle = new Rectangle(310 * 3 / tablero.getColumnas(), 441 / tablero.getFilas(),Color.WHITE);
                    final Button placeholder = new Button();
                    Celda celda = new Celda(j,i,rectangle);
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda(celda);
                        }
                    });
                    placeholder.setOnMouseEntered(mouseEvent -> {
                                RectangleOnDragEntered(rectangle);
                            });
                    placeholder.setOnMouseExited(mouseEvent -> {
                        RectangleOnDragExited(celda);
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
            botonPausa.setGraphic(new ImageView(imagenPausa));
            botonContinuar.setGraphic(new ImageView(imagenContinuar));
            botonAcelerar.setGraphic(new ImageView(imagenAcelerar));
            botonTerminar.setGraphic(new ImageView(imagenTerminar));
            botonGuardar.setGraphic(new ImageView(imagenGuardar));
            botonAjustes.setGraphic(new ImageView(imagenAjustes));
            botonGuia.setGraphic(new ImageView(imagenGuia));
        log.info("Tablero terminado");
            if(listaCeldas2==null) {
                pC = new PrincipalController(true, individuoTipoBasico, individuoTipoNormal, individuoTipoAvanzado, recursoAgua, recursoComida, recursoMontaña,
                        recursoTesoro, recursoBiblioteca, recursoPozo, listaCeldas,idIndividuos, idArcos, 1,this,new ListaEnlazada<>());
                turnos.setText(0+"");
            }else{
                for(int i=0;i<tablero.getColumnas();i++){
                    for(int j=0;j< tablero.getFilas();j++){
                        listaCeldas.getElemento(i).getData().getElemento(j).getData().setIndividuos(listaCeldas2.getElemento(i).getData().getElemento(j).getData().getIndividuos());
                        listaCeldas.getElemento(i).getData().getElemento(j).getData().setRecursos(listaCeldas2.getElemento(i).getData().getElemento(j).getData().getRecursos());
                    }
                }
                for (int i = 0; i < tablero.getColumnas(); i++) {
                    for (int j = 0; j < tablero.getFilas(); j++) {
                        Celda actual = listaCeldas.getElemento(i).getData().getElemento(j).getData();
                        actual.updateGUIwithModel();
                    }
                }
                pC = new PrincipalController(true, individuoTipoBasico, individuoTipoNormal, individuoTipoAvanzado, recursoAgua, recursoComida, recursoMontaña,
                        recursoTesoro, recursoBiblioteca, recursoPozo, listaCeldas,idIndividuos, idArcos,turnosValor,this,individuosTotales);
                for(int i=0;i<listaCeldas2.getNumeroElementos();i++){
                    listaCeldas2.del(i);
                }
                listaCeldas2 = null;
                log.debug("listaCeldas2 es nulo? "+listaCeldas2);
                turnos.setText(turnosValor-1+"");
            }
     }

    public PrincipalController getpC() {
        return pC;
    }

    public Button getBotonPausa() {
        return botonPausa;
    }

    public Button getBotonContinuar() {
        return botonContinuar;
    }

    public Button getBotonAcelerar() {
        return botonAcelerar;
    }

    public Button getBotonTerminar() {
        return botonTerminar;
    }

    public Button getBotonAjustes() {
        return botonAjustes;
    }

    public Button getBotonGuardar() {
        return botonGuardar;
    }

    public static Stage getStageTablero() {
        return stageTablero;
    }
}
