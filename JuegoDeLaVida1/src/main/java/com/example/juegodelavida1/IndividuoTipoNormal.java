package com.example.juegodelavida1;

public class IndividuoTipoNormal extends Individuo{
    private int iD;
    public IndividuoTipoNormal(int vidas, int porcentajeReproduccion, int porcentajeClonacion, int porcentajeTipoAlReproducirse) {
        super(vidas, porcentajeReproduccion, porcentajeClonacion, porcentajeTipoAlReproducirse);
    }

    @Override
    public String toString() {
        {
            return "Individuo"+" "+iD+" "+"{" +
                    "vidas=" + super.getVidas() +
                    ", porcentajeReproduccion=" + super.getPorcentajeReproduccion() +
                    ", porcentajeClonacion=" + super.getPorcentajeClonacion() +
                    ", porcentajeTipoAlReproducirse=" + super.getPorcentajeTipoAlReproducirse() +
                    '}';
        }
    }

    public IndividuoTipoNormal(int i,Individuo individuo) {
        super(individuo.getVidas(), individuo.getPorcentajeReproduccion(), individuo.getPorcentajeClonacion(), individuo.getPorcentajeTipoAlReproducirse());
        iD = i;
    }

    @Override
    public void move() {

    }
}
