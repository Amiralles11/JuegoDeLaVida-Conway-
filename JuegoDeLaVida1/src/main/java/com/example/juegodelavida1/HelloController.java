package com.example.juegodelavida1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Individuo parametrosData = new Individuo(20, 50,20,80 );
    private IndividuoParametros modeloParaGUICompartido = new IndividuoParametros(parametrosData);
        @FXML
        protected void NuevaPartidaButton() {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VentanaNuevaPartida.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
                stage.setTitle("Establezca parámetros: ");
                stage.setScene(scene);
                IndividuoParameterController p = fxmlLoader.getController();
                p.loadUserData(this.modeloParaGUICompartido); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
                p.setStage(stage);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    @FXML
    protected void CargarPartidaButton() {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VentanaCargarPartida.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
            stage.setTitle("Cargar Partida");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.print("Inicialización en ejecución del controlador\n");
    }
}