package com.tp.controlador;

import com.tp.dao.IPersonaDao;
import com.tp.dao.PersonaDaoImp;
import com.tp.modelo.Persona;
import com.tp.modelo.Vendedor;
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

    public ControllerPersona() {
    }

    // Llama al DAO para guardar una persona
    public void registrar(Session session, Persona persona) {
        IPersonaDao dao = new PersonaDaoImp();
        dao.registrar(session, persona);
    }

    // Llama al DAO para obtener todas las personas
    public List<Persona> obtener(Session session) {
        IPersonaDao dao = new PersonaDaoImp();
        return dao.obtener(session);
    }
    
    // Llama al DAO para obtener todas los vendedores
    public List<Vendedor> obtenerVendedores(Session session) {
        IPersonaDao dao = new PersonaDaoImp();
        return dao.obtenerVendedores(session);
    }
}
