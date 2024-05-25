package com.example.juegodelavida1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;



public class FinalPartidaController implements Initializable {
    private static Stage stage;
    @FXML
    Text supervivienteUltimo;
    @FXML
    Text masSupervivientes;
    private static final Logger log = LogManager.getLogger(FinalPartidaController.class);
    private static PrincipalController pC;
    @FXML
    public void start(PrincipalController principalController){
        this.pC = principalController;
        pC.getTab().getBotonPausa().setDisable(true);
        pC.getTab().getBotonTerminar().setDisable(true);
        pC.getTab().getBotonContinuar().setDisable(true);
        pC.getTab().getBotonGuardar().setDisable(true);
        pC.getTab().getBotonAjustes().setDisable(true);
        pC.getTab().getBotonAcelerar().setDisable(true);
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(FinalPartidaController.class.getResource("VentanaFinal.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 480, 360);
            stage.setTitle("Fin de la partida");
            stage.setScene(scene);
            stage.show();
            fxmlLoader.setController(this);
            this.stage = stage;
        } catch (Exception e) {
            log.error("VentanaCargarPartida.fxml no encontrada");
            e.printStackTrace();
        }
    }
    @FXML
    protected void ButtonSI() {
        log.info("Iniciando metodo ButtonSI");
        InformaciónFinal iF = new InformaciónFinal();
        iF.start(pC);
        this.stage.close();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Incializando ventanaFinal");
        if(pC.getSupervivientes().getNumeroElementos()==0) {
            supervivienteUltimo.setText("Parece que no ha sobrevivido nadie...");
        }else if(pC.getSupervivientes().getNumeroElementos()==1) {
            supervivienteUltimo.setText("Individuo "+pC.getSupervivientes().getPrimero().getData().getId()+", edad "+pC.getSupervivientes().getPrimero().getData().getAñosVividos()+" años");
        }else{
            supervivienteUltimo.setText("Individuo "+pC.getSupervivientes().getUltimo().getData());
            masSupervivientes.setText("y "+(pC.getSupervivientes().getNumeroElementos()-1)+" más");
        }
    }
}
