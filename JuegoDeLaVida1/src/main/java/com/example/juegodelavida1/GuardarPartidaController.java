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
        }
        else if(textField.getText().matches("[^A-Za-z]")){
            log.warn("texto no valido");
            errorGuardar.setText("Texto introducido no valido");
        } else {
            log.info("Guardando Partida");
            log.debug(pC.getListaCeldas());
            partidas = cargarObjetoDesdeArchivo("Partidas.json",ListaEnlazada.class);
            guardarObjetoEnArchivoPrincipalController(textField.getText()+".json",pC);
            int j=0;
            for(int i=0;i<partidas.getNumeroElementos();i++){
                if(Objects.equals(partidas.getElemento(i).getData(), textField.getText())){
                    log.info("Datos de partida sobreescritos en ruta ya creada");
                    j = -1;
                }
                j++;
                log.debug(j);
            }
            if((partidas.isVacia())||(j==partidas.getNumeroElementos())&&(!Objects.equals(partidas.getUltimo().getData(), textField.getText()))){
                log.info("Datos guardados en nueva ruta");
                log.debug(partidas);
                partidas.add(textField.getText());
                guardarObjetoEnArchivo("Partidas.json",partidas);
                log.debug(partidas);
            }
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
