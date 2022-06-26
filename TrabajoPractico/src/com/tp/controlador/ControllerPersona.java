package com.tp.controlador;

import com.tp.dao.ArticuloDaoImp;
import com.tp.dao.IArticuloDao;
import com.tp.dao.IPersonaDao;
import com.tp.dao.PersonaDaoImp;
import com.tp.modelo.Articulo;
import com.tp.modelo.Persona;
import com.tp.modelo.Vendedor;
import com.tp.vista.ViewPersona;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
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
    
    // Llama al DAO para actualzar una persona
    public void actualizar(Session session, Persona persona) {
        IPersonaDao dao = new PersonaDaoImp();
        dao.actualizar(session, persona);
    }

    
    // Llama al DAO para obtener la persona segun el id
    public Vendedor verPersonaPorId(Session session, int id) {
        IPersonaDao dao = new PersonaDaoImp();
        Vendedor vendedor = dao.obtenerPorId(session, id);
        vista.verPersona(vendedor);
        return vendedor;
    }
}
