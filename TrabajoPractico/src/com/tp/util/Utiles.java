package com.tp.util;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class Utiles {

    public static boolean esNumerico(String valor) {
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    
    public static boolean esDouble(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
}
