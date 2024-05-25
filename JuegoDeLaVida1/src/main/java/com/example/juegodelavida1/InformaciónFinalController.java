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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URL;
import java.util.ResourceBundle;

public class InformaciónFinalController implements Initializable {
    @FXML
    private GridPane gridPane;
    @FXML
    private Button siguiente;
    @FXML
    private Button anterior;
    private static final Logger log = LogManager.getLogger(InformaciónFinalController.class);
    private static int elementosPosibles;
    @FXML
    private ListaSimple<Button> botones = new ListaSimple<>(8);
    private static PrincipalController pC;
    private static ListaSimple<ListaEnlazada<Individuo>> arbolesGenealogicos;
    private static Individuo individuoQueMasAguaIndividuo;
    private static Individuo individuoQueMasClonacionIndividuo;
    private static Individuo individuoQueMasReproduccionIndividuo;
    private static Individuo individuoQueMasVidaTotalIndividuo;
    private static Individuo individuoMasViejo;
    private static int vidaIndividuo;
    private static int reproduccionIndividuo;
    private static int clonacionIndividuo;
    private static int aguaIndividuo;
    private static int reproducciones=0;
    @FXML
    private Text reproduccionesText;
    private static int clonaciones=0;
    @FXML
    private Text clonacionesText;
    private static int aguaBebida=0;
    @FXML
    private Text aguaBebidaText;
    private static int comidaConsumida=0;
    @FXML
    private Text comidaConsumidaText;
    private static int montañaEscalada=0;
    @FXML
    private Text montañaEscaladaText;
    private static int tesorosEncontrados=0;
    @FXML
    private Text tesorosEncontradosText;
    private static int muertesPozo=0;
    @FXML
    private Text muertesPozoText;
    private static int muertesMontaña=0;
    @FXML
    private Text muertesMontañaText;
    private static int muertesNaturales =0;
    @FXML
    private Text muertesNaturalesText;
    private static int muertesSobrepobladas =0;
    @FXML
    private Text muertesSobrepobladasText;
    protected void start(PrincipalController pC,int reproducciones, int clonaciones, int aguaBebida, int comidaConsumida,
                         int montañaEscalada, int tesorosEncontrados, int muertesMontaña, int muertesPozo, int muertesSobrepobladas,
                         int muertesNaturales, Individuo individuoAgua, Individuo individuoReproduccion, Individuo indivduoClonacion,
                         Individuo individuoVida, Individuo individuoMasViejo,int agua,int clonacion,int reproduccion,int vida){
        this.pC = pC;
        this.reproducciones = reproducciones;
        this.clonaciones = clonaciones;
        this.aguaBebida = aguaBebida;
        this.comidaConsumida = comidaConsumida;
        this.montañaEscalada = montañaEscalada;
        this.tesorosEncontrados = tesorosEncontrados;
        this.muertesMontaña = muertesMontaña;
        this.muertesPozo = muertesPozo;
        this.muertesSobrepobladas = muertesSobrepobladas;
        this.muertesNaturales = muertesNaturales;
        this.individuoQueMasAguaIndividuo = individuoAgua;
        this.individuoQueMasClonacionIndividuo = indivduoClonacion;
        this.individuoQueMasReproduccionIndividuo = individuoReproduccion;
        this.individuoQueMasVidaTotalIndividuo = individuoVida;
        this.individuoMasViejo = individuoMasViejo;
        this.aguaIndividuo = agua;
        this.reproduccionIndividuo = reproduccion;
        this.clonacionIndividuo = clonacion;
        this.vidaIndividuo = vida;
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GuardarPartidaController.class.getResource("VentanaInformacion.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320 * 3, 240 * 3);
            stage.setTitle("Información de la partida");
            stage.setScene(scene);
            fxmlLoader.setController(this);
            stage.show();
        } catch (Exception e) {
            log.error("VentanaInformacion.fxml no encontrada");
            e.printStackTrace();
        }
    }
    @FXML
    protected void ButtonReferencia(int columna) {
        log.info("Cargando arbol genealógico del individuo");
        if ((elementosPosibles - 8 + columna) < pC.getSupervivientes().getNumeroElementos()) {
            Individuo actual = pC.getSupervivientes().getElemento(elementosPosibles - 8 + columna).getData();
        }

    }
    @FXML
    protected void ButtonSiguiente() {
        log.info("Inciando metodo ButtonSiguiente");
        log.debug("Numero de partidas=" + pC.getSupervivientes().getNumeroElementos());
        elementosPosibles += 8;
        anterior.setDisable(false);
        if (elementosPosibles >= pC.getSupervivientes().getNumeroElementos()) {
            siguiente.setDisable(true);
        }
        int j = 0;
        for (int i = elementosPosibles - 8; (i <= (pC.getSupervivientes().getNumeroElementos() - 1)) && (i < elementosPosibles - 1); i++) {
            Text text = new Text();
            text.setText("Individuo " + pC.getSupervivientes().getElemento(i).getData().getId());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);
            j++;
        }
        if(j==7){
            Text text = new Text();
            text.setText("Individuo "+pC.getSupervivientes().getElemento(elementosPosibles-1).getData().getId());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);
        } else if (j != 7) {
            for (int i = j; i <= 7; i++) {
                Text text = new Text();
                text.setText("");
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
        if(elementosPosibles== pC.getSupervivientes().getNumeroElementos()){
            siguiente.setDisable(true);
        }
        int j = 0;
        for(int i=elementosPosibles-8;(i<=(pC.getSupervivientes().getNumeroElementos()-1))&&(i<elementosPosibles-1);i++){
            Text text = new Text();
            text.setText("Individuo "+pC.getSupervivientes().getElemento(i).getData().getId());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);
            j++;
        }
        if(j==7){
            Text text = new Text();
            text.setText("Individuo "+pC.getSupervivientes().getElemento(elementosPosibles-1).getData().getId());
            text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
            botones.getElemento(j).getData().setGraphic(text);
        }
        log.info("Finalizando metodo ButtonSiguiente");
    }
    @FXML
    protected void verIndividuosEspeciales(){
        InformaciónIndividuosController iF = new InformaciónIndividuosController();
        iF.start(individuoQueMasAguaIndividuo,individuoQueMasClonacionIndividuo,individuoQueMasReproduccionIndividuo,
                individuoQueMasVidaTotalIndividuo,individuoMasViejo,aguaIndividuo,reproduccionIndividuo,
                clonacionIndividuo,vidaIndividuo);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reproduccionesText.setText(reproducciones + "");
        clonacionesText.setText(clonaciones + "");
        aguaBebidaText.setText(aguaBebida + "");
        comidaConsumidaText.setText(comidaConsumida + "");
        montañaEscaladaText.setText(montañaEscalada + "");
        tesorosEncontradosText.setText(tesorosEncontrados + "");
        muertesMontañaText.setText(muertesMontaña + "");
        muertesPozoText.setText(muertesPozo + "");
        muertesSobrepobladasText.setText(muertesSobrepobladas + "");
        muertesNaturalesText.setText(muertesNaturales + "");
        for (int i = 0; i < 8; i++) {
            final int j = i;
            final Button placeholder = new Button();
            placeholder.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    ButtonReferencia(j);
                }
            });
            placeholder.setMinSize(470, 517 / 8); // Tamaño mínimo para visualización
            placeholder.setMaxSize(470, 517 / 8); // Tamaño máximo para visualización
            placeholder.setStyle("-fx-border-color: black; -fx-text-alignment: center");
            gridPane.add(placeholder, 0, i);
            if (i < pC.getSupervivientes().getNumeroElementos()) {
                Text text = new Text();
                text.setText("Individuo "+pC.getSupervivientes().getElemento(i).getData().getId());
                text.setStyle("-fx-font-family: 'Britannic Bold';-fx-font-size:25 ");
                placeholder.setGraphic(text);
            }
            botones.add(placeholder);

        }
        if(pC.getSupervivientes().getNumeroElementos()<=8){
            siguiente.setDisable(true);
        }
        anterior.setDisable(true);
        elementosPosibles = 8;
        log.info("partidas cargadas");
    }
}
