package com.example.juegodelavida1;

import com.almasb.fxgl.core.math.Vec2;
import com.example.juegodelavida1.EstructurasDatos.ListaSimple.ListaSimple;
import javafx.scene.image.Image;
import org.junit.jupiter.api.Test;
import com.example.juegodelavida1.TableroController;

import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class PrincipalControllerTest {

    @Test
    void setTiempoEspera() {
    }

    @Test
    void getIdIndividuos() {
    }

    @Test
    void getIdArcos() {
    }

    @Test
    void identificadorIndividuos() {
    }

    @Test
    void identificadorArcos() {
    }

    @Test
    void getTurnos() {
    }

    @Test
    void identificadorTurnos() {
    }

    @Test
    void getListaCeldas() {
    }

    @Test
    void setListaCeldas() {
    }

    @Test
    void getIndividuoTipoBasico() {
        IndividuoTipoBasico individuo = new IndividuoTipoBasico(12, 12, 12, 12);
        assertDoesNotThrow(individuo::getId);
        Celda c = new Celda(1, 2);
        assertDoesNotThrow(()->c.getIndividuos().getPosicion(c.getIndividuos().getPrimero()));
    }

    @Test
    void setIndividuoTipoBasico() {
    }

    @Test
    void getIndividuoTipoNormal() {
    }

    @Test
    void setIndividuoTipoNormal() {
    }

    @Test
    void getIndividuoTipoAvanzado() {
    }

    @Test
    void setIndividuoTipoAvanzado() {
    }

    @Test
    void getRecursoAgua() {
    }

    @Test
    void getRecursoBiblioteca() {
    }

    @Test
    void getRecursoComida() {
    }

    @Test
    void getRecursoMontaña() {
    }

    @Test
    void getRecursoPozo() {
    }

    @Test
    void getRecursoTesoro() {
    }

    @Test
    void isPausa() {
    }

    @Test
    void setPausa() {
    }

    @Test
    void bucleControl() {

    }
}