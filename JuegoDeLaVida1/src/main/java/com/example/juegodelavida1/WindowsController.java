package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WindowsController implements Initializable {
    private static final Logger log = LogManager.getLogger(WindowsController.class);
    private Individuo parametrosData = new IndividuoTipoBasico(20, 50,20,80);
    private Recurso parametrosData2 = new RecursoPozo(20, 50,-1 );
    private RecursoAgua parametrosDataAgua = new RecursoAgua(-1, -1,50,5);
    private RecursoComida parametrosDataComida = new RecursoComida(-1, -1,50,10);
    private RecursoMontaña parametrosDataMontaña = new RecursoMontaña(-1, -1,50,5);
    private RecursoTesoro parametrosDataTesoro = new RecursoTesoro(-1, -1,50,50);
    private RecursoBiblioteca parametrosDataBiblioteca = new RecursoBiblioteca(-1, -1,50,50);
    private RecursoPozo parametrosDataPozo = new RecursoPozo(-1, -1,50 );
    private Tablero parametrosTablero = new Tablero(10, 20);
    private IndividuoParametros modeloParaGUICompartido = new IndividuoParametros(parametrosData);
    private RecursoParametros modeloParaGUICompartido2 = new RecursoParametros(parametrosData2);
    private RecursoParametros.RecursoParametrosAgua modeloParaGUICompartidoAgua = new RecursoParametros.RecursoParametrosAgua(parametrosDataAgua);
    private RecursoParametros.RecursoParametrosComida modeloParaGUICompartidoComida = new RecursoParametros.RecursoParametrosComida(parametrosDataComida);
    private RecursoParametros.RecursoParametrosMontaña modeloParaGUICompartidoMontaña = new RecursoParametros.RecursoParametrosMontaña(parametrosDataMontaña);
    private RecursoParametros.RecursoParametrosTesoro modeloParaGUICompartidoTesoro = new RecursoParametros.RecursoParametrosTesoro(parametrosDataTesoro);
    private RecursoParametros.RecursoParametrosBiblioteca modeloParaGUICompartidoBiblioteca = new RecursoParametros.RecursoParametrosBiblioteca(parametrosDataBiblioteca);
    private RecursoParametros.RecursoParametrosPozo modeloParaGUICompartidoPozo = new RecursoParametros.RecursoParametrosPozo(parametrosDataPozo);
    private TableroParametros modeloParaGUICompartidoTablero = new TableroParametros(parametrosTablero);

    @FXML
        protected void NuevaPartidaButton() {
        log.info("Inicializando ventana NuevaPartida");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ParameterController.class.getResource("VentanaNuevaPartida.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320 * 3, 240 * 3);
            stage.setTitle("Establezca parámetros: ");
            stage.setScene(scene);
            ParameterController p = fxmlLoader.getController();
            log.debug("Guardando valores predeterminados (loadUserData)");
            p.loadUserData(this.modeloParaGUICompartido, this.modeloParaGUICompartido2, this.modeloParaGUICompartidoAgua,
                    this.modeloParaGUICompartidoComida, this.modeloParaGUICompartidoMontaña, this.modeloParaGUICompartidoTesoro,
                    this.modeloParaGUICompartidoBiblioteca, this.modeloParaGUICompartidoPozo, this.modeloParaGUICompartidoTablero); //Carga los datos del modelo en el gui, todas las ventanas comparten el mismo en este caso
            p.setStage(stage);
            stage.show();
        } catch (Exception e) {
            log.error("VentanaNuevaPartida.fxml no encontrada");
            e.printStackTrace();
        }
    }
    @FXML
    protected void CargarPartidaButton() {
        log.info("Inicializando ventana CargarPartida");
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(GuardarPartidaController.class.getResource("VentanaCargarPartida.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 320*3, 240*3);
            stage.setTitle("Cargar Partida");
            stage.setScene(scene);
            CargarPartidaController controller = fxmlLoader.getController();
            controller.setScene(stage);
            stage.show();
        } catch (Exception e) {
            log.error("VentanaCargarPartida.fxml no encontrada");
            e.printStackTrace();
        }
    }
    private ListaEnlazada<String> partidas;
    private int elementosPosibles;
    private int columna;
    private CargarPartidaController cargarPartidaController;
    private Stage stage2;
    protected void ConfirmacionBorrarPartida(ListaEnlazada<String> partidas,int elementosPosibles,int columna,CargarPartidaController cargarPartidaController,Stage stage){
        this.partidas = partidas;
        this.elementosPosibles = elementosPosibles;
        this.columna = columna;
        this.cargarPartidaController = cargarPartidaController;
        this.stage2 = stage;
    }
    @FXML protected void ConfirmacionBorrarPartidaSI(){
        log.info("Borrando partida");
        log.debug(partidas.getElemento(elementosPosibles - 8 + columna).getData() + ".json");
        File file = new File(partidas.getElemento(elementosPosibles - 8 + columna).getData() + ".json");
        if(file.delete()){
            log.info("Partida borrada correctamente");
        }else{
            log.warn("Partida no borrada correctamente");
        }
        partidas.del(elementosPosibles - 8 + columna);
        guardarObjetoEnArchivo("Partidas.json",partidas);
        log.info("referencia a la parrtida borrada correctamente");
        cargarPartidaController.UpdateGuiWithModel();
        stage2.close();
    }
    @FXML protected void ConfirmacionBorrarPartidaNO(){
        log.info("partida no borrada por petición del usuario");
        stage2.close();
    }
    public static <T> void guardarObjetoEnArchivo(String rutaArchivo, T objeto) {
        com.google.gson.Gson gson = new com.google.gson.Gson();
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            gson.toJson(objeto, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        log.info("Inicialización en ejecución del controlador (WindowsController)");
    }

}