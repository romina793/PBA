package com.tp.dao;

import com.tp.modelo.Articulo;
import com.tp.modelo.Persona;
import com.tp.modelo.Vendedor;
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
    public void actualizar(Session session, Persona persona) {
        session.update(persona);
    }

    @Override
    public List<Persona> obtener(Session session) {
        String sql = "from persona order by id asc";
        return session.createQuery(sql).list();
    }
    
    @Override
    public Vendedor obtenerPorId(Session session, int id) {
        String sql = "From Persona WHERE id=" + id;
        return (Vendedor) session.createQuery(sql).uniqueResult();
    }
}
