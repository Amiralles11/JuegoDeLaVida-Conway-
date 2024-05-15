module com.example.juegodelavida1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires org.apache.logging.log4j;
    requires com.google.gson;

    opens com.example.juegodelavida1 to com.google.gson,javafx.fxml;
    opens com.example.juegodelavida1.EstructurasDatos.ListaEnlazada to com.google.gson;
    opens com.example.juegodelavida1.EstructurasDatos.ListaSimple to com.google.gson;
    exports com.example.juegodelavida1;
}