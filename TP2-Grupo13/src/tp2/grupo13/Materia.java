package tp2.grupo13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Materia {

    private String identificador;
    private String nombre;
    private List<Materia> materias;
    private List<Alumno> alumnos;
    private List<Asistencia> asistencias;

    public Materia() {
        materias = new ArrayList<>();
        alumnos = new ArrayList<>();
        asistencias = new ArrayList<>();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void RegistrarMateria(String identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
        
        materias.add(this);
    }
    
    public void MatricularAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void DesmatricularAlumno(int numeroLegajo) {
        for (Alumno alumno : alumnos){
            if (alumno.getNumeroLegajo() == numeroLegajo) {
                alumnos.remove(alumno);
                break;
            }
        }
    }

    public void ListadoDeInscritos() {
        System.out.println("\n----------------------------------------------------------------");
        System.out.println(toString());
        System.out.println("----------------------------------------------------------------");
        System.out.println("    Legajo | Apellido y Nombres");
        System.out.println("----------------------------------------------------------------");
        Collections.sort(alumnos);
        for (Alumno alumno : alumnos){
            System.out.println(alumno.toString());
        }
        System.out.println("----------------------------------------------------------------");
        System.out.println("\t\t\t\tTotal inscriptos: " + alumnos.size());

    }

    @Override
    public String toString() {
        return "    " + nombre + " - Alumnos Inscriptos 2021";
    }   
}
