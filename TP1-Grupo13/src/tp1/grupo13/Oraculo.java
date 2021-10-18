package tp1.grupo13;

public class Oraculo extends Personaje {

    public Oraculo(String nombre, int posicionX, int posicionY, String orientacion) {
        super(nombre, posicionX, posicionY, orientacion);
    }
    
    public String esRespuestaValida(Posicion posicionPersonaje, int puntoX, int opcion) {
        boolean resultado = false;
        switch (opcion) {
            case 1:
                resultado = posicionPersonaje.getX() > puntoX;
                break;
            case 2:
                resultado = posicionPersonaje.getX() < puntoX;
                break;
            case 3:
                resultado = posicionPersonaje.getX() == puntoX;
                break;
            default:
                break;
        }
        if (resultado) {
            return "Verdadero";
        } else {
            return "Falso";
        }
    }
}
