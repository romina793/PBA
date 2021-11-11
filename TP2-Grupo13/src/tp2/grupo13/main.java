package tp2.grupo13;

import java.util.Scanner;

public class main {

    public static Materia materia;
    public static Alumno alumno;
    public static Asistencia asistencia;

    public static void main(String[] args) {
        presentarMenuInicio();

        Scanner entrada = new Scanner(System.in);
        int opcion = entrada.nextInt();
        while (opcion != 1 && opcion != 9) {
            System.err.print("No es una opción valida, ingrese 1 o 9: ");
            opcion = entrada.nextInt();
        }
        if (opcion == 1) {
            registrarMateria();
            gestionarMateria();
        } else if (opcion == 9) {
            System.exit(0);
        }
    }

    private static void presentarMenuInicio() {
        System.out.println("\n\tMENÚ INICIO");
        System.out.println("==========================");
        System.out.println("   1.- Registrar Materia\n");
        System.out.println("   9.- Salir\n");
        System.out.print("   Ingrese una opción: ");
    }

    /**
     * Registrar Materia: Permite crear la materia, asignándole un identificador
     * (sigla de 3 letras) y nombre de la materia. Por ejemplo: “PBA” - ”
     * Programación Básica”.
     */
    private static void registrarMateria() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nIngrese el identificador de la materia (sigla de 3 letras): ");
        String identificador = entrada.nextLine().toUpperCase();
        while (identificador.length() != 3) {
            System.err.print("El identificador debe de contener 3 letras: ");
            identificador = entrada.nextLine().toUpperCase();
        }
        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = entrada.nextLine().toUpperCase();

        materia = new Materia();
        materia.RegistrarMateria(identificador, nombre);
    }

    private static void gestionarMateria() {
        presentarMenuGestionarMateria();

        Scanner entrada = new Scanner(System.in);
        int opcion = entrada.nextInt();
        while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4
                && opcion != 5 && opcion != 9) {
            System.err.print("No es una opción valida, ingrese 1, 2, 3, 4, 5 o 9: ");
            opcion = entrada.nextInt();
        }
        ejecutarOpcionSeleccionada(opcion);
    }

    private static void presentarMenuGestionarMateria() {
        System.out.println("\n    GESTIONAR MATERIA");
        System.out.println("==========================");
        System.out.println("1.-  Matricular Alumno");
        System.out.println("2.-  Desmatricular Alumno");
        System.out.println("3.-  Gestionar Asistencia");
        System.out.println("-- Consultas");
        System.out.println(" 4.- Listado de Inscriptos");
        System.out.println(" 5.- Visualizar Asistencia\n");
        System.out.println("9.- Salir");
        System.out.print("Ingrese una opción: ");
    }

    private static void ejecutarOpcionSeleccionada(int opcion) {
        switch (opcion) {
            case 1:
                matricularAlumno();
                gestionarMateria();
                break;
            case 2:
                desmatricularAlumno();
                gestionarMateria();
                break;
            case 3:
                gestionarAsistencia();
                gestionarMateria();
                break;
            case 4:
                visualizarListadoDeInscritos();
                gestionarMateria();
                break;
            case 5:
                visualizarAsistencia();
                gestionarMateria();
                break;
            default:
                main(null);
                break;
        }
    }

    /**
     * Matricular Alumno: Permite inscribir a un alumno a la materia. Por cada
     * alumno se registrará su número de legajo, apellido, nombres, fecha de
     * nacimiento y correo electrónico. El alumno deberá identificarse por su
     * número de legajo.
     */
    private static void matricularAlumno() {
        Scanner entradaInt = new Scanner(System.in);
        Scanner entradaString = new Scanner(System.in);

        System.out.print("\nIngrese el número de legajo: ");
        int numeroLegajo = entradaInt.nextInt();

        System.out.print("Ingrese el Apellido: ");
        String apellido = entradaString.nextLine().toUpperCase();

        System.out.print("Ingrese el Nombre: ");
        String nombre = entradaString.nextLine().toUpperCase();

        System.out.print("Ingrese la Fecha de Nacimiento con el formato (dd/mm/aaaa): ");
        String fechaNacimiento = entradaString.nextLine().toUpperCase();

        System.out.print("Ingrese el correo electrónico: ");
        String correoElectronico = entradaString.nextLine().toLowerCase();

        alumno = new Alumno(numeroLegajo, apellido, nombre, fechaNacimiento, correoElectronico);
        materia.MatricularAlumno(alumno);
    }

    /**
     * Desmatricular Alumno: Permite desvincular a un alumno de la materia
     * ingresando su número de legajo.
     */
    private static void desmatricularAlumno() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("\nIngrese el número de legajo: ");
        int numeroLegajo = entrada.nextInt();

        materia.DesmatricularAlumno(numeroLegajo);
    }

    /**
     * Gestionar Asistencia: Permite registrar la asistencia de una clase,
     * ingresando la fecha y lista de alumnos presentes. Por cada alumno
     * registrado a la materia, se solicitará la confirmación de asistencia a la
     * clase.
     */
    private static void gestionarAsistencia() {
        Scanner entrada = new Scanner(System.in);
        
        System.out.print("\nIngrese la fecha a tomar asistecia con el formato (dd/mm/aaa): ");
        String fecha = entrada.nextLine().toUpperCase();
        
        asistencia = new Asistencia(fecha, materia);
        asistencia.GestionarAsistencia();
    }

    /**
     * Listado de Inscriptos: Muestra por pantalla los datos correspondientes a
     * los inscriptos a la materia, ordenados ascendentemente en primer lugar
     * por apellido y luego por nombres:
     */
    private static void visualizarListadoDeInscritos() {
        materia.ListadoDeInscritos();
    }

    /**
     * Visualizar Asistencia: Muestra por pantalla los datos correspondientes 
     * a la asistencia de una clase, ordenados ascendentemente en primer lugar 
     * por apellido y luego por nombres:
     */
    private static void visualizarAsistencia() {
        asistencia.VisualizarAsistencia();
    }
}
