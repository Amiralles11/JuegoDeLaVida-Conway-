package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class GuardarPartidaController {
    private static ListaEnlazada<String> partidas;
    private static Stage stage;
    private static final Logger log = LogManager.getLogger(GuardarPartidaController.class);
    @FXML
    TextField textField;
    @FXML
    Label errorGuardar;
    private static PrincipalController pC;
    protected void loadUserData(PrincipalController pC, Stage stage){
        this.pC = pC;
        this.stage = stage;
    }
    @FXML
    protected void GuardarPartidaButton() {
        if(Objects.equals(textField.getText(), "")){
            log.warn("texto no valido");
            errorGuardar.setText("Texto introducido no valido");
        }else {
            log.info("Guardando Partida");
            log.debug(pC.getListaCeldas());
            partidas = cargarObjetoDesdeArchivo("Partidas.json",ListaEnlazada.class);
            guardarObjetoEnArchivoPrincipalController(textField.getText()+".json",pC);
            if(partidas.getPosicion(textField.getText())==null){
                log.debug(partidas);
                partidas.add(textField.getText());
                log.debug(partidas);
                guardarObjetoEnArchivo("Partidas.json",partidas);
                log.info("Datos de partida guardados en nueva ruta");
            }else{log.info("Datos de partida sobreescritos en ruta ya creada");}
            stage.close();
            log.info("VentanaGuardarPartida cerrada");
        }
    }
    // Método para guardar un objeto en un archivo JSON
    public static <T> void guardarObjetoEnArchivoPrincipalController(String rutaArchivo, T objeto) {
        com.google.gson.Gson gson = new com.google.gson.GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
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
}
