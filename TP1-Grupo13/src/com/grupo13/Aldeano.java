package com.grupo13;

public class Aldeano extends Personaje {

    private Moneda moneda;

    public Aldeano(String nombre, String camisa, String pantalon, String gorro, char inicial, int posicionX, int posicionY, String orientacion) {
        super(nombre, camisa, pantalon, gorro, inicial, posicionX, posicionY, orientacion);
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }
}
