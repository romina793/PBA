package com.grupo13;

public class Posicion {
    private int x = 0;
    private int y = 0;

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void avanzar() {
        this.x++;
    }

    public void retroceder() {
        this.x--;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ").";
    }
}
