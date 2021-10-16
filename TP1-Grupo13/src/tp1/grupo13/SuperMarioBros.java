package tp1.grupo13;

import java.util.Random;
import java.util.Scanner;

public class SuperMarioBros {

    protected static Personaje luigi;
    protected static Personaje mario;

    protected static Scanner entrada;
    protected static Personaje personajeSeleccionado;
    protected static Aldeano princesaPeach;
    protected static Oraculo whallum;

    public static void main(String[] args) {
        luigi = crearLuigi();
        mario = crearMario();
        princesaPeach = crearPrincesaPeach();
        whallum = crearWhallum();

        nivel1();
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
        return new Personaje(
                "Luigi",
                "Verde",
                "Azul oscuro",
                "Verde",
                'L',
                (int) (Math.random() * 99 - 50),
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

    private static Aldeano crearPrincesaPeach() {
        return new Aldeano(
                "Princesa Peach",
                "Violeta",
                "Amarillo",
                "Violeta",
                'P',
                (int) (Math.random() * 99 - 50),
                0,
                "Derecha"
        );
    }

    private static Oraculo crearWhallum() {
        return new Oraculo(
                "Whallum",
                0,
                (int) (Math.random() * 99 - 50),
                "Derecha"
        );
    }

    private static void mostrarUbicacion(String ubicacionLuigi, String ubicacionMario) {
        System.out.println(ubicacionLuigi);
        System.out.println(ubicacionMario);
    }

    private static void mostrarSaludo(String saludoLuigi, String saludoMario) {
        System.out.println("Felicitaciones se encontraron!!");
        System.out.println(saludoLuigi);
        System.out.println(saludoMario);
    }

    /**
     * Nivel 2: El rescate
     */
    //@TODO Preguntar, el oraculo debe de tener la misma ubicacion que la princesa?
    public static void nivel2() {
        entrada = new Scanner(System.in);

        elegirProtagonista();
        presentarMenu();

        int opcion = elegirOpcionDeMenu();
        int valor = ingresarValor();
        boolean isGameOver = false; 
        
        while (!isGameOver) {
            boolean esValido = whallum.esRespuestaValida(princesaPeach.getPosicion(), valor, opcion);
            switch (opcion) {
                case 1:
                    System.out.println("¿La posición de la Princesa Peach es mayor que: " + valor + "?");
                    System.out.println("Respuesta: " + devolverRespuesta(esValido) + "\n");
                    presentarMenu();
                    opcion = elegirOpcionDeMenu();
                    valor = ingresarValor();
                    break;
                case 2:
                    System.out.println("¿La posición de la Princesa Peach es menor que: " + valor + "?");
                    System.out.println("Respuesta: " + devolverRespuesta(esValido) + "\n");
                    presentarMenu();
                    opcion = elegirOpcionDeMenu();
                    valor = ingresarValor();
                    break;
                case 3:
                    if (valor == princesaPeach.getPosicion().getX()){
                        //CAMBIAR EL TEXTO - VA A LA SIGUIENTE SECCIÓN
                       System.out.println("Continúa con la segunda etapa volviendo al modo tercera persona"); 
                    } else {
                       System.out.println("GAME OVER"); 
                    }
                    isGameOver = true; 
                    break;
                default:
                    break;
            }
        }
    }

    private static void elegirProtagonista() {
        System.out.print("\nElija un personaje mediante su inicial: Mario 'M' o Luigi 'L': ");
        String inicial = entrada.nextLine();

        while (!inicial.equals("M") && !inicial.equals("L")) {
            System.out.println("No es una inicial valida, ingrese 'M' o 'L': ");
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
        System.out.println("Oráculo Whallum, te tengo que hacer una pregunta sobre la ubicación de\n"
                + "Princesa Peach:\n"
                + "1.- Posición de Princesa Peach mayor que ...\n"
                + "2.- Posición de Princesa Peach menor que ...\n"
                + "3.- Te arriesgas al valor ..."
        );
    }

    private static int elegirOpcionDeMenu() {
        System.out.print("\nElija una opción de menú (1-2-3): ");
        int opcion = entrada.nextInt();

        while (opcion != 1 && opcion != 2 && opcion != 3) {
            System.out.print("No es una opcion valida, ingrese (1-2-3): ");
            opcion = entrada.nextInt();
            System.out.println();
        }
        return opcion;
    }

    private static int ingresarValor() {
        System.out.print("Ingrese el valor de X: ");
        return entrada.nextInt();
    }
    
    private static String devolverRespuesta(boolean respuesta) {
        if (respuesta) {
            return "Verdadero";
        } else {
            return "Falso";
        }
    }
}
