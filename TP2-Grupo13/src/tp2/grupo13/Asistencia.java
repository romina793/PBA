package tp2.grupo13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Asistencia implements IAsistencia {

    private String fecha;
    private Materia materia;
    private List<Alumno> alumnos;

    public Asistencia(String fecha, Materia materia) {
        this.fecha = fecha;
        this.materia = materia;

        alumnos = new ArrayList<>();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public void GestionarAsistencia() {
        for (Alumno alumno : materia.getAlumnos()) {
            boolean presente = validarAsistencia(alumno);
            if (presente) {
                alumnos.add(alumno);
            }
        }
    }

    @Override
    public void VisualizarAsistencia() {
        System.out.println("\n----------------------------------------------------------------");
        System.out.println(toString());
        System.out.println("----------------------------------------------------------------");
        System.out.println("    Legajo | Apellido y Nombres");
        System.out.println("----------------------------------------------------------------");
        for (Alumno alumno : alumnos) {
            System.out.println(alumno.toString());
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t\t\tTotal asistentes: " + alumnos.size());
        }

    private boolean validarAsistencia(Alumno alumno) {
        Scanner entrada = new Scanner(System.in);

        System.out.print(alumno.getApellido() + ", " + alumno.getNombre()
                + " esta presente? (S/N): ");
        String opcion = entrada.nextLine().toUpperCase();
        while (!opcion.equals("S") && !opcion.equals("N")) {
            System.err.print("Seleccione una opción valida (S/N): ");
            opcion = entrada.nextLine().toUpperCase();
        }
        if (opcion.equals("S")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "    " + materia.getNombre() + " - Asistencia: " + fecha;
    }
}
