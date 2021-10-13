package com.grupo13;

import java.util.Random;
import java.util.Scanner;

public class SuperMarioBros {

    protected static Personaje luigi;
    protected static Personaje mario;

    protected static Scanner entrada;
    protected static Personaje personajeSeleccionado;

    public static void main(String[] args) {
        luigi = crearLuigi();
        mario = crearMario();

        //nivel1();
        nivel2();
    }

    /**
     * Nivel 1: El encuentro
     */
    public static void nivel1() {
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
                (int)(Math.random()*99-50),
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

    /**
     * Nivel 2: El rescate
     */
    public static void nivel2() {
        entrada = new Scanner(System.in);

        elegirProtagonista();
        presentarMenu();
    }

    private static void elegirProtagonista() {
        System.out.print("Elija un personaje mediante su inicial: Mario 'M' o Luigi 'L': ");
        String inicial = entrada.nextLine();

        while (!inicial.equals("M") && !inicial.equals("L")) {
            System.out.print("No es una inicial valida, ingrese 'M' o 'L': ");
            inicial = entrada.nextLine();
        }

        if (inicial.equals("M")) {
            personajeSeleccionado = mario;
        } else {
            personajeSeleccionado = luigi;
        }
        System.out.println("EL personaje seleccionado es: " + personajeSeleccionado.getNombre());
        System.out.println();
    }

    private static void presentarMenu() {
        System.out.println("Oráculo Whallum, te tengo que hacer una pregunta sobre la ubicación de\n" +
                "Princesa Peach:\n" +
                "1.- Posición de Princesa Peach mayor que ...\n" +
                "2.- Posición de Princesa Peach menor que ...\n" +
                "3.- Te arriesgas al valor ..."
        );
    }

    private static Aldeano crearPrincesaPeach() {
        Random random = new Random();
        return new Aldeano(
                "Princesa Peach",
                "Violeta",
                "Amarillo",
                "Violeta",
                'P',
                random.nextInt() % 51,
                0,
                "Derecha"
        );
    }
}
