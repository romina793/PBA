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
        session.save(persona);
    }

    @Override
    public List<Persona> obtener(Session session) {
        String sql = "from persona order by id asc";
        return session.createQuery(sql).list();
    }
}
