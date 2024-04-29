package com.example.juegodelavida1;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class TableroController implements Initializable {
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
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (tablero != null) {
            for (int i = 0; i < tablero.getColumnas(); i++) {
                for (int j = 0; j < tablero.getFilas(); j++) {
                    // Aquí podrías instanciar tu LetrasColoresGrid
                    // LetrasColoresGrid customComponent = new LetrasColoresGrid();
                    // mainGrid.add(customComponent, i, j);

                    // Ejemplo simplificado con un Label
                    Label placeholder = new Label("Celda " + i + "," + j);
                    placeholder.setMinSize(320 * 3 / tablero.getColumnas(), 461 / tablero.getFilas()); // Tamaño mínimo para visualización
                    placeholder.setMaxSize(320 * 3 / tablero.getColumnas(), 461 / tablero.getFilas()); // Tamaño mínimo para visualización
                    placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center;");
                    tableroDeJuego.add(placeholder, i, j);
                }
            }
        }
    }
}
