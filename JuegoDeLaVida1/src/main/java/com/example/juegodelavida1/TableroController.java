package com.example.juegodelavida1;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;


public class TableroController implements Initializable {
    private static int ventanas = 1;
    private static final Logger log = LogManager.getLogger(TableroController.class);
    private static Tablero tablero;
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
    private GridPane tableroDeJuego;

    public TableroController() {
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
            stage.setTitle("Tablero");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("Tablero.fxml no encontrado");
            e.printStackTrace();
        }
    }
    @FXML
    protected void ButtonCelda(){
        log.info("Iniciando metodo ButtonCelda");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("zVentanaVidas.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 240, 320);
            stage.setTitle("Vidas");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            log.error("zVentanaVidas.fxml no encontrado");
            e.printStackTrace();
        }
        log.info("Finalizando metodo ButtonCelda");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicializando tablero");
        if (tablero != null) {
            for (int i = 0; i < tablero.getColumnas(); i++) {
                //LDE = new ListaDoblementeEnlazada()...
                for (int j = 0; j < tablero.getFilas(); j++) {
                    // Aquí podrías instanciar tu LetrasColoresGrid
                    // LetrasColoresGrid customComponent = new LetrasColoresGrid();
                    // mainGrid.add(customComponent, i, j);

                    // Ejemplo simplificado con un label
                    Button placeholder = new Button();
                    placeholder.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            ButtonCelda();
                        }
                    });
                    placeholder.setMinSize(320 * 3 / tablero.getColumnas(), 461 / tablero.getFilas()); // Tamaño mínimo para visualización
                    placeholder.setMaxSize(320 * 3 / tablero.getColumnas(), 461 / tablero.getFilas()); // Tamaño mínimo para visualización
                    placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");
                    tableroDeJuego.add(placeholder, i, j);
                    Celda celda = new Celda(i,j,placeholder);
                    //LDE.add(celda)...
                }
            }
        }
        log.info("Tablero terminado");
    }
}
