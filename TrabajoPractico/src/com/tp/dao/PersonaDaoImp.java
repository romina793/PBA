package com.tp.dao;

import com.tp.modelo.Persona;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzutto Romina
 */
public class PersonaDaoImp implements IPersonaDao {

    @Override
    public void registrar(Session session, Persona persona) {
        session.saveOrUpdate(persona);
    }

    @Override
    public List<Persona> obtener(Session session) {
        String sql = "from Persona order by id";
        return session.createQuery(sql).list();
    }
}
