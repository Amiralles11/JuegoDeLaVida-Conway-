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

public class InformaciónIndividuosController implements Initializable {
    private static final Logger log = LogManager.getLogger(InformaciónIndividuosController.class);
    private static Individuo individuoQueMasAguaIndividuo;
    private static Individuo individuoQueMasClonacionIndividuo;
    private static Individuo individuoQueMasReproduccionIndividuo;
    private static Individuo individuoQueMasVidaTotalIndividuo;
    private static Individuo individuoMasViejo;
    private static int vidaIndividuo;
    private static int reproduccionIndividuo;
    private static int clonacionIndividuo;
    private static int aguaIndividuo;
    @FXML
    Text agua;
    @FXML
    Text clonacion;
    @FXML
    Text reproduccion;
    @FXML
    Text vida;
    @FXML
    Text años;

    protected void start(Individuo agua, Individuo clonacion, Individuo reproduccion,
                         Individuo vida, Individuo viejo, int aguaInt, int reproduccionInt, int clonacionInt, int vidaInt){
        log.info("Incializando ventana InformaciónIndividuos");
        this.individuoQueMasAguaIndividuo = agua;
        this.individuoQueMasClonacionIndividuo = clonacion;
        this.individuoQueMasReproduccionIndividuo = reproduccion;
        this.individuoQueMasVidaTotalIndividuo = vida;
        this.individuoMasViejo = viejo;
        this.aguaIndividuo = aguaInt;
        this.vidaIndividuo = vidaInt;
        this.reproduccionIndividuo = reproduccionInt;
        this.clonacionIndividuo = clonacionInt;

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GuardarPartidaController.class.getResource("VentanaIndividuosInformación.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            stage.setTitle("Información de los individuos");
            stage.setScene(scene);
            fxmlLoader.setController(this);
            stage.show();
        } catch (Exception e) {
            log.error("VentanaIndividuosInformación.fxml no encontrada");
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        agua.setText("Individuo "+individuoQueMasAguaIndividuo.getId()+", Agua bebida= "+aguaIndividuo);
        clonacion.setText("Individuo "+individuoQueMasClonacionIndividuo.getId()+", veces que se ha clonado= "+clonacionIndividuo);
        reproduccion.setText("Individuo "+individuoQueMasReproduccionIndividuo.getId()+", veces que se ha reproducido= "+reproduccionIndividuo);
        vida.setText("Individuo "+individuoQueMasVidaTotalIndividuo.getId()+", Vida maxima= "+vidaIndividuo);
        años.setText("Individuo "+individuoMasViejo.getId()+", años= "+individuoMasViejo.getAñosVividos());

    }
}
