package com.example.juegodelavida1;

import com.example.juegodelavida1.*;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;

public class RecursoParametros {
    //Modelo de datos original
    protected Recurso original;
    private IntegerProperty tiempoAparicion = new SimpleIntegerProperty();
    private IntegerProperty porcentajeAparicion = new SimpleIntegerProperty();

    public RecursoParametros(Recurso original){
        setOriginal(original);
    }

    public void commit(){
        original.setTiempoAparicion(tiempoAparicion.get());
        original.setPorcentajeAparicion(porcentajeAparicion.get());
    }

    public void rollback(){
        tiempoAparicion.set(original.getTiempoAparicion());
        porcentajeAparicion.set(original.getPorcentajeAparicion());;
    }

    public Recurso getOriginal(){
        return original;
    }

    public void setOriginal(Recurso original){
        this.original = original;
        rollback(); //Se inicializan los properties.

    }

    public Property<Number> TiempoAparicionProperty() {
        return tiempoAparicion;
    }
    public Property<Number> PorcentajeAparicionProperty() {
        return porcentajeAparicion;
    }


    public static class RecursoParametrosAgua{
        protected RecursoAgua original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();
        private IntegerProperty turnosVidas = new SimpleIntegerProperty();

        public RecursoParametrosAgua(RecursoAgua original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
            original.setTurnosVida(turnosVidas.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());
            turnosVidas.set(original.getTurnosVida());
        }

        public RecursoAgua getOriginal(){
            return original;
        }

        public void setOriginal(RecursoAgua original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
        public Property<Number> TurnosVidasProperty() {
            return turnosVidas;
        }

    }
    public static class RecursoParametrosPozo{
        protected RecursoPozo original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();

        public RecursoParametrosPozo(RecursoPozo original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());;
        }

        public RecursoPozo getOriginal(){
            return original;
        }

        public void setOriginal(RecursoPozo original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
    }
    public static class RecursoParametrosComida{
        protected RecursoComida original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();
        private IntegerProperty turnosVida = new SimpleIntegerProperty();

        public RecursoParametrosComida(RecursoComida original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
            original.setTurnosVida(turnosVida.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());
            turnosVida.set(original.getTurnosVida());
        }

        public RecursoComida getOriginal(){
            return original;
        }

        public void setOriginal(RecursoComida original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
        public Property<Number> TurnosVidaProperty() {
            return turnosVida;
        }
    }
    public static class RecursoParametrosBiblioteca{
        protected RecursoBiblioteca original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();
        private IntegerProperty porcentajeClonacion = new SimpleIntegerProperty();

        public RecursoParametrosBiblioteca(RecursoBiblioteca original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
            original.setPorcentajeClonacion(porcentajeClonacion.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());
            porcentajeClonacion.set(original.getPorcentajeClonacion());
        }

        public RecursoBiblioteca getOriginal(){
            return original;
        }

        public void setOriginal(RecursoBiblioteca original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
        public Property<Number> PorcentajeClonacionProperty() {
            return porcentajeClonacion;
        }
    }
    public static class RecursoParametrosMontaña{
        protected RecursoMontaña original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();
        private IntegerProperty turnosVida = new SimpleIntegerProperty();

        public RecursoParametrosMontaña(RecursoMontaña original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
            original.setTurnosVida(turnosVida.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());
            turnosVida.set(original.getTurnosVida());
        }

        public RecursoMontaña getOriginal(){
            return original;
        }

        public void setOriginal(RecursoMontaña original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
        public Property<Number> TurnosVidaProperty() {
            return turnosVida;
        }
    }
    public static class RecursoParametrosTesoro{
        protected RecursoTesoro original;
        private IntegerProperty porcentajeAparicion2 = new SimpleIntegerProperty();
        private IntegerProperty porcentajeReproduccion = new SimpleIntegerProperty();

        public RecursoParametrosTesoro(RecursoTesoro original){
            setOriginal(original);
        }

        public void commit(){
            original.setPorcentajeAparicion2(porcentajeAparicion2.get());
            original.setPorcentajeReproduccion(porcentajeReproduccion.get());
        }

        public void rollback(){
            porcentajeAparicion2.set(original.getPorcentajeAparicion2());
            porcentajeReproduccion.set(original.getPorcentajeReproduccion());
        }

        public RecursoTesoro getOriginal(){
            return original;
        }

        public void setOriginal(RecursoTesoro original){
            this.original = original;
            rollback(); //Se inicializan los properties.

        }
        public Property<Number> PorcentajeAparicion2Property() {
            return porcentajeAparicion2;
        }
        public Property<Number> PorcentajeReproduccionProperty() {
            return porcentajeReproduccion;
        }
    }
}
