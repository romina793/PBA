package tp2.grupo13;

public interface IMateria {

    public void RegistrarMateria(String identificador, String nombre);
    
    public void MatricularAlumno(Alumno alumno);
    
    public void DesmatricularAlumno(int numeroLegajo);
    
    public void ListadoDeInscritos();
}
