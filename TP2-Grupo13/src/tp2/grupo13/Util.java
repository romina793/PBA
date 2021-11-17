package tp2.grupo13;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Util {

    public static boolean esNumerico(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean esFechaVaida(String fecha) {
        if (fecha == null || !fecha.matches("\\d{2}-\\d{2}-\\d{4}")) {
            return false;
        }
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);
        try {
            df.parse(fecha);
            return true;
        } catch (ParseException ex) {
            return false;
        }
    }

    public static boolean contieneSoloLetras(String cadena) {
        int contador = 0;
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.charAt(i);
            if (Character.isDigit(caracter)) {
                contador = contador + 1;
            }
        }
        return (contador != 0);
    }
}
