package com.example.juegodelavida1;

import com.example.juegodelavida1.EstructurasDatos.ListaEnlazada.ListaEnlazada;
import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
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

public class InformaciónFinal {
    private static final Logger log = LogManager.getLogger(InformaciónFinal.class);
    private static PrincipalController pC;
    private static ListaSimple<ListaEnlazada<Individuo>> arbolesGenealogicos;
    private static ListaSimple<Integer> individuoQueMasAgua;
    private Individuo individuoQueMasAguaIndividuo;
    private int aguaIndividuo;
    private static ListaSimple<Integer> individuoQueMasClonacion;
    private Individuo individuoQueMasClonacionIndividuo;
    private int clonacionIndividuo;
    private static ListaSimple<Integer> individuoQueMasReproduccion;
    private Individuo individuoQueMasReproduccionIndividuo;
    private int reproduccionIndividuo;
    private static ListaSimple<Integer> individuoQueMasVidaTotal;
    private Individuo individuoQueMasVidaTotalIndividuo;
    private int vidaIndividuo;
    private Individuo individuoMasViejo;
    private int añosIndividuo;
    private int reproducciones=0;
    private int clonaciones=0;
    private int aguaBebida=0;
    private int comidaConsumida=0;
    private int montañaEscalada=0;
    private int tesorosEncontrados=0;
    private int muertesPozo=0;
    private int muertesMontaña=0;
    private int muertesNaturales =0;
    private int muertesSobrepobladas =0;
    protected void start(PrincipalController pC) {
        log.info("Inciando metodo start ventana información");
        this.pC = pC;
        pC.getTab().getStageTablero().close();
        this.arbolesGenealogicos = new ListaSimple<>(pC.getSupervivientes().getNumeroElementos());
        this.individuoQueMasAgua = new ListaSimple<>(pC.getIndividuosTotales().getNumeroElementos());
        for(int i=0;i<pC.getIndividuosTotales().getNumeroElementos();i++){
            individuoQueMasAgua.add(0);
        }
        this.individuoQueMasClonacion = new ListaSimple<>(pC.getIndividuosTotales().getNumeroElementos());
        for(int i=0;i<pC.getIndividuosTotales().getNumeroElementos();i++){
            individuoQueMasClonacion.add(0);
        }
        this.individuoQueMasReproduccion = new ListaSimple<>(pC.getIndividuosTotales().getNumeroElementos());
        for(int i=0;i<pC.getIndividuosTotales().getNumeroElementos();i++){
            individuoQueMasReproduccion.add(0);
        }
        this.individuoQueMasVidaTotal = new ListaSimple<>(pC.getIndividuosTotales().getNumeroElementos());
        for(int i=0;i<pC.getIndividuosTotales().getNumeroElementos();i++){
            individuoQueMasVidaTotal.add(0);
        }
        individuoMasViejo = pC.getIndividuosTotales().getPrimero().getData();
        for(int i=0;i<pC.getIndividuosTotales().getNumeroElementos();i++){
            if(individuoMasViejo.getAñosVividos()<pC.getIndividuosTotales().getElemento(i).getData().getAñosVividos()){
                individuoMasViejo = pC.getIndividuosTotales().getElemento(i).getData();
            }
            for(int j=0;j< pC.getIndividuosTotales().getElemento(i).getData().getCola().getNumeroElementos();j++){
                if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Se ha clonado")){
                    clonaciones +=1;
                    int z = individuoQueMasClonacion.getElemento(i).getData();
                    z+=1;
                    individuoQueMasClonacion.insert(z,i);
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Ha tenido un hijo")){
                    reproducciones+=1;
                    int z = individuoQueMasReproduccion.getElemento(i).getData();
                    z+=1;
                    individuoQueMasReproduccion.insert(z,i);
                } else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Agua consumida")){
                    aguaBebida+=1;
                    int z = individuoQueMasAgua.getElemento(i).getData();
                    z+=1;
                    individuoQueMasAgua.insert(z,i);
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Comida consumida")) {
                    comidaConsumida += 1;
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Montaña escalada")) {
                    montañaEscalada += 1;
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Tesoro encontrado")) {
                    tesorosEncontrados += 1;
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Muere por caerse a un pozo")) {
                    muertesPozo += 1;
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Muere intenando escalar una montaña")) {
                    muertesMontaña += 1;
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Muere porque hay más de 3 individuos")) {
                    muertesSobrepobladas += 1;
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Muere por causas naturales")) {
                    muertesNaturales += 1;
                }else if(pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData().contains("Vida total")) {
                    String z = pC.getIndividuosTotales().getElemento(i).getData().getCola().getElemento(j).getData();
                    int cifras = z.length()-12;
                    int multiplicador = 1;
                    Integer numero=0;
                    for(int x=cifras-1;x>0;x--){
                        numero += Integer.valueOf(z.charAt(12+x))*multiplicador;
                        multiplicador = multiplicador*10;
                        multiplicador = multiplicador*10;
                    }
                    individuoQueMasVidaTotal.insert(numero,i);
                }
            }
        }
        int agua = 0;
        int vida = 0;
        int reproduccion = 0;
        int clonacion = 0;
        for(int i = 0;i<pC.getIndividuosTotales().getNumeroElementos();i++){
            if(individuoQueMasVidaTotal.getElemento(i).getData()>individuoQueMasVidaTotal.getElemento(vida).getData()){
                vida = i;
            }
            if(individuoQueMasClonacion.getElemento(i).getData()>individuoQueMasClonacion.getElemento(clonacion).getData()){
                clonacion = i;
            }
            if(individuoQueMasReproduccion.getElemento(i).getData()>individuoQueMasReproduccion.getElemento(reproduccion).getData()){
                reproduccion = i;
            }
            if(individuoQueMasAgua.getElemento(i).getData()>individuoQueMasAgua.getElemento(agua).getData()){
                log.debug(individuoQueMasAgua.getElemento(i).getData());
                agua = i;
            }
        }
        individuoQueMasAguaIndividuo = pC.getIndividuosTotales().getElemento(agua).getData();
        individuoQueMasReproduccionIndividuo = pC.getIndividuosTotales().getElemento(reproduccion).getData();
        individuoQueMasClonacionIndividuo = pC.getIndividuosTotales().getElemento(clonacion).getData();
        individuoQueMasVidaTotalIndividuo = pC.getIndividuosTotales().getElemento(vida).getData();
        log.info("reproducciones totales= "+reproducciones/2);
        log.info("clonaciones totales= "+clonaciones);
        log.info("aguaBebida= "+aguaBebida);
        log.info("comidaConsumida= "+comidaConsumida);
        log.info("montañas escaladas= "+montañaEscalada);
        log.info("Tesoros encontrados= "+tesorosEncontrados);
        log.info("Muertes por pozo= "+muertesPozo);
        log.info("Muertes por montaña= "+muertesMontaña);
        log.info("Muertes por sobrepoblación= "+muertesSobrepobladas);
        log.info("Muertes naturales= "+muertesNaturales);
        log.info("Individuo que más agua ha bebido= "+"Individuo "+individuoQueMasAguaIndividuo.getId()+", Agua bebida= "+individuoQueMasAgua.getElemento(agua).getData());
        log.info("Individuo que más se ha clonado= "+"Individuo "+individuoQueMasClonacionIndividuo.getId()+", veces que se ha clonado= "+individuoQueMasClonacion.getElemento(clonacion).getData());
        log.info("Individuo que más se ha reproducido= "+"Individuo "+individuoQueMasReproduccionIndividuo.getId()+", veces que se ha reproducido= "+individuoQueMasReproduccion.getElemento(reproduccion).getData());
        log.info("Individuo que más vida maxima ha tenido= "+"Individuo "+individuoQueMasVidaTotalIndividuo.getId()+", Vida maxima= "+individuoQueMasVidaTotal.getElemento(vida).getData());
        log.info("Individuo que más años ha vivido= "+"Individuo "+individuoMasViejo.getId()+", años= "+individuoMasViejo.getAñosVividos());
        this.aguaIndividuo = individuoQueMasAgua.getElemento(agua).getData();
        this.clonacionIndividuo = individuoQueMasClonacion.getElemento(clonacion).getData();
        this.reproduccionIndividuo = individuoQueMasReproduccion.getElemento(reproduccion).getData();
        this.vidaIndividuo = individuoQueMasVidaTotal.getElemento(vida).getData();
        InformaciónFinalController iF = new InformaciónFinalController();
        iF.start(pC,reproducciones,clonaciones,aguaBebida,comidaConsumida,montañaEscalada,tesorosEncontrados,muertesMontaña,
                muertesPozo,muertesSobrepobladas,muertesNaturales,individuoQueMasAguaIndividuo,individuoQueMasReproduccionIndividuo,
                individuoQueMasClonacionIndividuo,individuoQueMasVidaTotalIndividuo,individuoMasViejo,aguaIndividuo,clonacionIndividuo,
                reproduccionIndividuo,vidaIndividuo);
    }
}
