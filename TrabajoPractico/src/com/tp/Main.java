package com.tp;

import com.tp.vista.Menu;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzutto Romina
 */
public class Main {

    public static void main(String[] args) {
        try {
            Menu menu = new Menu();
            menu.pack();
            menu.setVisible(true);
        } catch (Exception e) {
            System.err.println("Error al iniciar el programa");
        }
    }
}
