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

import java.io.File;
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
    private ListaSimple<Button> botones2 = new ListaSimple<>(8);
    @FXML
    private Button anterior;
    private Stage scene;
    @FXML
    protected void ButtonReferencia(int columna) {
        log.info("Cargando partida");
        if ((elementosPosibles - 8 + columna) < partidas.getNumeroElementos()) {
            log.debug(partidas.getElemento(elementosPosibles - 8 + columna).getData() + ".json");
            PrincipalController pC = cargarObjetoDesdeArchivoPrincipalController(partidas.getElemento(elementosPosibles - 8 + columna).getData() + ".json",PrincipalController.class);
            TableroController tab = new TableroController();
            tab.start2(new Tablero(pC.getListaCeldas().getElemento(0).getData().getNumeroElementos(),pC.getListaCeldas().getNumeroElementos()),pC.getIndividuoTipoBasico(),pC.getIndividuoTipoNormal(),
                    pC.getIndividuoTipoAvanzado(),pC.getRecursoAgua(),pC.getRecursoComida(),pC.getRecursoMontaña(),pC.getRecursoTesoro(),
                    pC.getRecursoBiblioteca(),pC.getRecursoPozo(),pC.getListaCeldas(),pC.getIdIndividuos());
            scene.close();
            log.info("Partida cargada");
        }

    }
    protected void UpdateGuiWithModel() {
        if(elementosPosibles>=partidas.getNumeroElementos()) {
            siguiente.setDisable(true);
        }
        log.info("Actualizando texto en los botones");
        int j = 0;
        for (int i = elementosPosibles - 8; (i <= (partidas.getNumeroElementos() - 1)) && (i < elementosPosibles - 1); i++) {
            Text text = new Text();
            text.setText(partidas.getElemento(i).getData());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);
            j++;
            if((j==7)&&(partidas.getNumeroElementos()>=8)){
                Text text2 = new Text();
                text2.setText(partidas.getElemento(7).getData());
                text2.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
                botones.getElemento(7).getData().setGraphic(text2);
            }else if((j==7)&&(partidas.getNumeroElementos()<8)){
                Text text2 = new Text();
                text2.setText("");
                botones.getElemento(7).getData().setGraphic(text2);
                botones2.getElemento(7).getData().setGraphic(text2);
            }
        }
        if (j != 7) {
            for (int i = j; i <= 7; i++) {
                Text text = new Text();
                text.setText("");
                log.debug(i);
                botones.getElemento(i).getData().setGraphic(text);
                botones2.getElemento(i).getData().setGraphic(text);
            }
        }
    }
    @FXML
    protected void ButtonSiguiente(){
        log.info("Inciando metodo ButtonSiguiente");
        log.debug("Numero de partidas="+partidas.getNumeroElementos());
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

            Text text2 = new Text();
            text2.setText("*");
            text2.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones2.getElemento(j).getData().setGraphic(text2);
            j++;
        }
        if(j!=7){
            for(int i = j;i<=7;i++){
                Text text = new Text();
                text.setText("");
                botones.getElemento(i).getData().setGraphic(text);
                botones2.getElemento(i).getData().setGraphic(text);
            }
        }
        log.info("Finalizando metodo ButtonSiguiente");


    }
    @FXML
    protected void ButtonEliminar(int columna){
        if ((elementosPosibles - 8 + columna) < partidas.getNumeroElementos()) {
            log.info("Iniciando metodo eliminar partida");
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(WindowsController.class.getResource("ConfirmacionBorrarPartida.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 320, 240);
                stage.setTitle("Confirmación");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                log.error("ConfirmacionBorrarPartida.fxml no encontrado");
                e.printStackTrace();
            }
            WindowsController windowsController = fxmlLoader.getController();
            windowsController.ConfirmacionBorrarPartida(partidas,elementosPosibles,columna,this,stage);

        }
    }
    @FXML
    protected void ButtonAnterior(){
        log.info("Inciando metodo ButtonAnterior");
        elementosPosibles-=8;
        siguiente.setDisable(false);
        if(elementosPosibles==8){
            anterior.setDisable(true);
        }
        if(elementosPosibles== partidas.getNumeroElementos()){
            siguiente.setDisable(true);
        }
        int j = 0;
        for(int i=elementosPosibles-8;(i<=(partidas.getNumeroElementos()-1))&&(i<elementosPosibles-1);i++){
            Text text = new Text();
            text.setText(partidas.getElemento(i).getData());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);

            Text text2 = new Text();
            text2.setText("*");
            text2.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones2.getElemento(j).getData().setGraphic(text2);
            j++;
        }
        if(j==7){
            Text text = new Text();
            text.setText(partidas.getElemento(j).getData());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);

            Text text2 = new Text();
            text2.setText("*");
            text2.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones2.getElemento(j).getData().setGraphic(text2);
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
            placeholder.setMinSize(300 * 3, 444 / 8); // Tamaño mínimo para visualización
            placeholder.setMaxSize(300 * 3, 444 / 8); // Tamaño máximo para visualización
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
        for (int i = 0; i < 8; i++) {
            final int j =i;
            final Button placeholder = new Button();
            placeholder.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ButtonEliminar(j);
                }
            });
            placeholder.setMinSize(60, 444 / 8); // Tamaño mínimo para visualización
            placeholder.setMaxSize(60, 444 / 8); // Tamaño máximo para visualización
            placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center");
            gridPane.add(placeholder, 1, i);
            if(i<partidas.getNumeroElementos()){
                Text text = new Text();
                text.setText("*");
                text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
                placeholder.setGraphic(text);
            }
            botones2.add(placeholder);
        }
        log.info("GridPaneTerminado");
        log.debug("Numero de partidas cargadas="+partidas.getNumeroElementos());
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
        if(partidas.getNumeroElementos()<=8){
            siguiente.setDisable(true);
        }
        anterior.setDisable(true);
        elementosPosibles = 8;
        log.info("partidas cargadas");
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
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().registerTypeAdapter(Individuo.class,new IndividuoJsonAdapter()).
                registerTypeAdapter(Recurso.class,new RecursoJsonAdapter()).excludeFieldsWithoutExposeAnnotation().create();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setScene(Stage scene) {
        this.scene = scene;
    }
}
