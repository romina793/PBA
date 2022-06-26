package com.tp.dao;

import com.tp.modelo.Articulo;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzutto Romina
 */
public class ArticuloDaoImp implements IArticuloDao {

    @Override
    public void registrar(Session session, Articulo articulo) {
        session.save(articulo);
    }
    
    @Override
    public void actualizar(Session session, Articulo articulo) {
        session.update(articulo);
    }

    @Override
    public List<Articulo> obtener(Session session) {
        String sql = "FROM ARTICULO ORDER BY ID";
        return session.createQuery(sql).list();
    }

    @Override
    public Articulo obtenerPorId(Session session, int id) {
        String sql = "From Articulo WHERE id=" + id;
        return (Articulo) session.createQuery(sql).uniqueResult();
    }
}
