package com.tp.controlador;

import com.tp.dao.IPersonaDao;
import com.tp.dao.PersonaDaoImp;
import com.tp.modelo.Persona;
import com.tp.vista.ViewPersona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzutto Romina
 */
public class ControllerPersona {

    private ViewPersona vista = new ViewPersona();

    public ControllerPersona() {
    }

    // Llama al DAO para guardar una persona
    public void registrar(Session session, Persona persona) {
        IPersonaDao dao = new PersonaDaoImp();
        dao.registrar(session, persona);
    }

    // Llama al DAO para obtener todas las personas
    public void verPersonas(Session session) {
        List<Persona> personas = new ArrayList<Persona>();
        IPersonaDao dao = new PersonaDaoImp();
        personas = dao.obtener(session);
        vista.verPersonas(personas);
    }
}
