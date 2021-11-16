package tp2.grupo13;

public class Util {

    public static boolean esNumerico(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
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
