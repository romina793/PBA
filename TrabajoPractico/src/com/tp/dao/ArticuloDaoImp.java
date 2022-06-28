package com.tp.dao;

import com.tp.modelo.Articulo;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class ArticuloDaoImp implements IArticuloDao {

    @Override
    public void registrar(Session session, Articulo articulo) {
        session.saveOrUpdate(articulo);
    }

    @Override
    public void borrar(Session session, Articulo articulo) {
        session.delete(articulo);
    }

    @Override
    public List<Articulo> obtener(Session session) {
        String sql = "from Articulo order by id";
        return session.createQuery(sql).list();
    }

    @Override
    public Articulo obtenerPorId(Session session, int id) {
        String sql = "from Articulo where id=" + id;
        return (Articulo) session.createQuery(sql).uniqueResult();
    }
}
