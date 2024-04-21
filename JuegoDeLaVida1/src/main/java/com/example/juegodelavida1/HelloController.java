package com.example.juegodelavida1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private Individuo parametrosData = new IndividuoTipoBasico(20, 50,20,80 );
    private Recurso parametrosData2 = new RecursoAgua(20, 50,-1 );
    private RecursoAgua parametrosDataAgua = new RecursoAgua(-1, -1,20 );
    private RecursoComida parametrosDataComida = new RecursoComida(-1, -1,20 );
    private RecursoMontaña parametrosDataMontaña = new RecursoMontaña(-1, -1,20 );
    private RecursoTesoro parametrosDataTesoro = new RecursoTesoro(-1, -1,20 );
    private RecursoBiblioteca parametrosDataBiblioteca = new RecursoBiblioteca(-1, -1,20 );
    private RecursoPozo parametrosDataPozo = new RecursoPozo(-1, -1,20 );
    private IndividuoParametros modeloParaGUICompartido = new IndividuoParametros(parametrosData);
    private RecursoParametros modeloParaGUICompartido2 = new RecursoParametros(parametrosData2);
    private RecursoParametros.RecursoParametrosAgua modeloParaGUICompartidoAgua = new RecursoParametros.RecursoParametrosAgua(parametrosDataAgua);
    private RecursoParametros.RecursoParametrosComida modeloParaGUICompartidoComida = new RecursoParametros.RecursoParametrosComida(parametrosDataComida);
    private RecursoParametros.RecursoParametrosMontaña modeloParaGUICompartidoMontaña = new RecursoParametros.RecursoParametrosMontaña(parametrosDataMontaña);
    private RecursoParametros.RecursoParametrosTesoro modeloParaGUICompartidoTesoro = new RecursoParametros.RecursoParametrosTesoro(parametrosDataTesoro);
    private RecursoParametros.RecursoParametrosBiblioteca modeloParaGUICompartidoBiblioteca = new RecursoParametros.RecursoParametrosBiblioteca(parametrosDataBiblioteca);
    private RecursoParametros.RecursoParametrosPozo modeloParaGUICompartidoPozo = new RecursoParametros.RecursoParametrosPozo(parametrosDataPozo);
        @FXML
        protected void NuevaPartidaButton() {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("VentanaNuevaPartida.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
                stage.setTitle("Establezca parámetros: ");
                stage.setScene(scene);
                ParameterController p = fxmlLoader.getController();
                p.loadUserData(this.modeloParaGUICompartido,this.modeloParaGUICompartido2,this.modeloParaGUICompartidoAgua,this.modeloParaGUICompartidoComida,this.modeloParaGUICompartidoMontaña,this.modeloParaGUICompartidoTesoro,this.modeloParaGUICompartidoBiblioteca,this.modeloParaGUICompartidoPozo); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
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