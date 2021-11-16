package tp2.grupo13;

import java.util.Scanner;

public class main {

    public static Scanner entrada = new Scanner(System.in);

    public static Materia materia;
    public static Alumno alumno;
    public static Asistencia asistencia;

    public static void main(String[] args) {
        presentarMenuInicio();
        
        String opcion = entrada.nextLine();
        while (!Util.esNumerico(opcion) || !opcion.equals("1") && !opcion.equals("9")) {
            System.err.print("No es una opción valida, ingrese 1 o 9: ");
            opcion = entrada.nextLine();
        }
        if (opcion.equals("1")) {
            registrarMateria();
            gestionarMateria();
        } else if (opcion.equals(9)) {
            System.exit(0);
        }
    }

    private static void presentarMenuInicio() {
        System.out.println("\n\tMENÚ INICIO");
        System.out.println("==========================");
        System.out.println("   1.- Registrar Materia\n");
        System.out.println("   9.- Salir");
        System.out.print("\n   Ingrese una opción: ");
    }

    /**
     * Registrar Materia: Permite crear la materia, asignándole un identificador
     * (sigla de 3 letras) y nombre de la materia. Por ejemplo: “PBA” - ”
     * Programación Básica”.
     */
    private static void registrarMateria() {
        System.out.print("\nIngrese el identificador de la materia (sigla de 3 letras): ");
        String identificador = entrada.nextLine().toUpperCase();
        while (Util.esNumerico(identificador) || identificador.length() != 3 || Util.letras(identificador)) {
            System.err.print("El identificador debe de contener 3 letras: ");
            identificador = entrada.nextLine().toUpperCase();
        }
        System.out.print("Ingrese el nombre de la materia: ");
        String nombre = entrada.nextLine();

        materia = new Materia();
        materia.RegistrarMateria(identificador, nombre);
    }

    private static void gestionarMateria() {
        presentarMenuGestionarMateria();

        String opcion = entrada.nextLine();
        while (!Util.esNumerico(opcion)
                || !opcion.equals("1")
                && !opcion.equals("2")
                && !opcion.equals("3")
                && !opcion.equals("4")
                && !opcion.equals("5")
                && !opcion.equals("9")) {
            System.err.print("No es una opción valida, ingrese 1, 2, 3, 4, 5 o 9: ");
            opcion = entrada.nextLine();
        }
        ejecutarOpcionSeleccionada(opcion);
    }

    private static void presentarMenuGestionarMateria() {
        System.out.println("\n\n    GESTIONAR MATERIA");
        System.out.println("==========================");
        System.out.println("1.-  Matricular Alumno");
        System.out.println("2.-  Desmatricular Alumno");
        System.out.println("3.-  Gestionar Asistencia");
        System.out.println("-- Consultas");
        System.out.println(" 4.- Listado de Inscriptos");
        System.out.println(" 5.- Visualizar Asistencia\n");
        System.out.println("9.- Salir");
        System.out.print("\nIngrese una opción: ");
    }

    private static void ejecutarOpcionSeleccionada(String opcion) {
        switch (opcion) {
            case "1":
                matricularAlumno();
                gestionarMateria();
                break;
            case "2":
                desmatricularAlumno();
                gestionarMateria();
                break;
            case "3":
                gestionarAsistencia();
                gestionarMateria();
                break;
            case "4":
                visualizarListadoDeInscritos();
                gestionarMateria();
                break;
            case "5":
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
        System.out.print("\nIngrese el número de legajo: ");
        String numeroLegajo = entrada.nextLine();
        
        while (!Util.esNumerico(numeroLegajo)) {
            System.err.print("El valor ingresado debe ser numérico, ingrese el número de legajo: ");
            numeroLegajo = entrada.nextLine();
        }

        System.out.print("Ingrese el Apellido: ");
        String apellido = entrada.nextLine();

        System.out.print("Ingrese los Nombres: ");
        String nombre = entrada.nextLine();

        System.out.print("Ingrese la Fecha de Nacimiento con el formato (dd/mm/aaaa): ");
        String fechaNacimiento = entrada.nextLine();

        System.out.print("Ingrese el correo electrónico: ");
        String correoElectronico = entrada.nextLine().toLowerCase();

        alumno = new Alumno(Integer.parseInt(numeroLegajo), apellido, nombre, fechaNacimiento, correoElectronico);
        materia.MatricularAlumno(alumno);
    }

    /**
     * Desmatricular Alumno: Permite desvincular a un alumno de la materia
     * ingresando su número de legajo.
     */
    private static void desmatricularAlumno() {
        System.out.print("\nIngrese el número de legajo: ");
        String numeroLegajo = entrada.nextLine();

        while (!Util.esNumerico(numeroLegajo)) {
            System.err.print("El valor ingresado debe ser numérico, ingrese el número de legajo: ");
            numeroLegajo = entrada.nextLine();
        }

        materia.DesmatricularAlumno(Integer.parseInt(numeroLegajo));
    }

    /**
     * Gestionar Asistencia: Permite registrar la asistencia de una clase,
     * ingresando la fecha y lista de alumnos presentes. Por cada alumno
     * registrado a la materia, se solicitará la confirmación de asistencia a la
     * clase.
     */
    private static void gestionarAsistencia() {
        System.out.print("\nIngrese la fecha a tomar asistecia con el formato (dd/mm/aaa): ");
        String fecha = entrada.nextLine();

        asistencia = new Asistencia(fecha, materia);
        asistencia.GestionarAsistencia();
    }

    /**
     * Listado de Inscriptos: Muestra por pantalla los datos correspondientes a
     * los inscriptos a la materia, ordenados ascendentemente en primer lugar
     * por apellido y luego por nombres:
     */
    private static void visualizarListadoDeInscritos() {
        if (materia.getAlumnos().size() > 0) {
            materia.ListadoDeInscritos();
        } else {
            System.out.println("\nNo existen inscriptos registrados");
        }
    }

    /**
     * Visualizar Asistencia: Muestra por pantalla los datos correspondientes a
     * la asistencia de una clase, ordenados ascendentemente en primer lugar por
     * apellido y luego por nombres:
     */
    private static void visualizarAsistencia() {
        if (asistencia != null) {
            asistencia.VisualizarAsistencia();
        } else {
            System.out.println("\nNo existen asistencias registradas");
        }
    }
}
