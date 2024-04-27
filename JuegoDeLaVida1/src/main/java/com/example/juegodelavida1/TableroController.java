package com.example.juegodelavida1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TableroController {
    @FXML
    private GridPane tableroDeJuego;
    protected void InicializarTablero(Tablero tablero) {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Tablero.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
            stage.setTitle("Tablero");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < tablero.getColumnas(); i++) {
            for (int j = 0; j < tablero.getFilas(); j++) {
                // Aquí podrías instanciar tu LetrasColoresGrid
                // LetrasColoresGrid customComponent = new LetrasColoresGrid();
                // mainGrid.add(customComponent, i, j);

                // Ejemplo simplificado con un Label
                Label placeholder = new Label("Celda " + i + "," + j);
                placeholder.setMinSize(10, 10); // Tamaño mínimo para visualización
                placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");
                tableroDeJuego.add(placeholder, i, j);
                }
            }


        /**
         En este ejemplo, vamos a crear programáticamente la ventan en la que trabajaremos.
         */
    }
}

