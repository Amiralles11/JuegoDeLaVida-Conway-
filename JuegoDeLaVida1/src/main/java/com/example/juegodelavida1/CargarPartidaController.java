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
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CargarPartidaController implements Initializable {
    private static int elementosPosibles;
    private static ListaEnlazada<String> partidas;
    private static final Logger log = LogManager.getLogger(CargarPartidaController.class);
    @FXML
    private GridPane gridPane;
    @FXML
    private Button siguiente;
    @FXML
    private ListaSimple<Button> botones = new ListaSimple<>(8);
    @FXML
    private Button anterior;
    @FXML
    protected void ButtonReferencia(int columna) {
        if ((elementosPosibles - 8 + columna) < partidas.getNumeroElementos()) {
            log.debug(partidas.getElemento(elementosPosibles - 8 + columna).getData() + ".json");
            PrincipalController pC = cargarObjetoDesdeArchivoPrincipalController(partidas.getElemento(elementosPosibles - 8 + columna).getData() + ".json",PrincipalController.class);
            TableroController tab = new TableroController();
            tab.start(new Tablero(pC.getListaCeldas().getElemento(0).getData().getNumeroElementos(),pC.getListaCeldas().getNumeroElementos()),pC.getIndividuoTipoBasico(),pC.getIndividuoTipoNormal(),
                    pC.getIndividuoTipoAvanzado(),pC.getRecursoAgua(),pC.getRecursoComida(),pC.getRecursoMontaña(),pC.getRecursoTesoro(),
                    pC.getRecursoBiblioteca(),pC.getRecursoPozo());
            for(int i=0;i<pC.getListaCeldas().getNumeroElementos();i++){
                for(int j=0;j< pC.getListaCeldas().getElemento(0).getData().getNumeroElementos();j++){
                    tab.getpC().getListaCeldas().getElemento(i).getData().getElemento(j).getData().setIndividuos(pC.getListaCeldas().getElemento(i).getData().getElemento(j).getData().getIndividuos());
                    tab.getpC().getListaCeldas().getElemento(i).getData().getElemento(j).getData().setRecursos(pC.getListaCeldas().getElemento(i).getData().getElemento(j).getData().getRecursos());
                }
            }
            for (int i = 0; i < tab.getpC().getListaCeldas().getNumeroElementos(); i++) {
                for (int j = 0; j < tab.getpC().getListaCeldas().getElemento(i).getData().getNumeroElementos(); j++) {
                    Celda actual = tab.getpC().getListaCeldas().getElemento(i).getData().getElemento(j).getData();
                    actual.updateGUIwithModel();
                }
            }
        }
    }
    @FXML
    protected void ButtonSiguiente(){
        log.info("Inciando metodo ButtonSiguiente");
        elementosPosibles+=8;
        anterior.setDisable(false);
        if(elementosPosibles>=partidas.getNumeroElementos()){
            siguiente.setDisable(true);
        }
        int j = 0;
        for(int i=elementosPosibles-8;(i<=(partidas.getNumeroElementos()-1))&&(i<elementosPosibles-1);i++){
            Text text = new Text();
            text.setText(partidas.getElemento(i).getData());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);
            j++;
        }
        if(j!=7){
            for(int i = j;i<=7;i++){
                Text text = new Text();
                text.setText("");
                log.debug(i);
                botones.getElemento(i).getData().setGraphic(text);
            }
        }
        log.info("Finalizando metodo ButtonSiguiente");


    }
    @FXML
    protected void ButtonAnterior(){
        log.info("Inciando metodo ButtonAnterior");
        elementosPosibles-=8;
        siguiente.setDisable(false);
        if(elementosPosibles==8){
            anterior.setDisable(true);
        }
        int j = 0;
        for(int i=elementosPosibles-8;(i<=(partidas.getNumeroElementos()-1))&&(i<elementosPosibles-1);i++){
            Text text = new Text();
            text.setText(partidas.getElemento(i).getData());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);
            j++;
        }
        if(j==7){
            Text text = new Text();
            text.setText(partidas.getElemento(j).getData());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);
        }
        log.info("Finalizando metodo ButtonSiguiente");
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Cargando partidas Guardadas");
        partidas = cargarObjetoDesdeArchivo("Partidas.json",ListaEnlazada.class);
        log.info("Inicializando GridPane");
        for (int i = 0; i < 8; i++) {
            final int j =i;
            final Button placeholder = new Button();
            placeholder.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ButtonReferencia(j);
                }
            });
            placeholder.setMinSize(320 * 3, 444 / 8); // Tamaño mínimo para visualización
            placeholder.setMaxSize(320 * 3, 444 / 8); // Tamaño máximo para visualización
            placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center");
            gridPane.add(placeholder, 0, i);
            if(i<partidas.getNumeroElementos()){
                Text text = new Text();
                text.setText(partidas.getElemento(i).getData());
                text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
                placeholder.setGraphic(text);
            }
            botones.add(placeholder);
        }
        log.info("GridPaneTerminado");
        log.debug(partidas.getNumeroElementos());
        siguiente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ButtonSiguiente();
            }
        });
        anterior.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ButtonAnterior();
            }
        });
        if(partidas.getNumeroElementos()<8){
            siguiente.setDisable(true);
        }
        anterior.setDisable(true);
        elementosPosibles = 8;
    }

    // Método para cargar un objeto desde un archivo JSON
    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static <T> T cargarObjetoDesdeArchivoPrincipalController(String rutaArchivo, Class<T> clase) {
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
