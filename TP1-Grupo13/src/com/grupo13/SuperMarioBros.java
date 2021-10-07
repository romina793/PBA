package com.grupo13;

import java.util.Random;

public class SuperMarioBros {

    public static void main(String[] args) {
        nivel1();
    }

    /**
     * Nivel 1: El encuentro
     */
    public static void nivel1() {
        Personaje luigi = crearLuigi();
        Personaje mario = crearMario();

        mostrarUbicacion(luigi.indicarUbicacion(), mario.indicarUbicacion());

        if (luigi.getPosicion().getX() > mario.getPosicion().getX()) {
            luigi.girar();
        } else if (mario.getPosicion().getX() > luigi.getPosicion().getX()) {
            mario.girar();
        }

        while (luigi.getPosicion().getX() != mario.getPosicion().getX()) {
            luigi.caminar();
            mario.caminar();

            mostrarUbicacion(luigi.indicarUbicacion(), mario.indicarUbicacion());
        }
        mostrarSaludo(luigi.saludar(), mario.saludar());
    }

    private static Personaje crearLuigi() {
        Random random = new Random();
        return new Personaje(
                "Luigi",
                "Verde",
                "Azul oscuro",
                "Verde",
                'L',
                random.nextInt() % 51,
                0,
                "Derecha"
        );
    }

    private static Personaje crearMario() {
        return new Personaje(
                "Mario",
                "Roja",
                "Azul claro",
                "Rojo",
                'M'
        );
    }

    private static void mostrarUbicacion(String ubicacionLuigi, String ubicacionMario) {
        System.out.println(ubicacionLuigi);
        System.out.println(ubicacionMario);
    }

    private static void mostrarSaludo(String saludoLuigi, String saludoMario) {
        System.out.println("\nFelicitaciones se encontraron!!");
        System.out.println(saludoLuigi);
        System.out.println(saludoMario);
    }
}
