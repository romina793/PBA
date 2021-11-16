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

    public static boolean letras(String cadena) {
        String cad = cadena;
        int contador = 0;
        for (int i = 0; i < cad.length(); i++) {
            char guardar = cad.charAt(i);

            if (Character.isDigit(guardar)) {
                contador=contador+1;
            }
        }
        if (contador != 0) {
            return true;
        } else {

            return false;
        }

    }
}
