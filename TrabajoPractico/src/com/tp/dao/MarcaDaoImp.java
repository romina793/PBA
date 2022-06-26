package com.tp.dao;

import com.tp.modelo.Marca;
import com.tp.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class MarcaDaoImp extends HibernateUtil implements IMarcaDao {

    @Override
    public void registrar(Session session, Marca marca) {
        session.saveOrUpdate(marca);
    }

    @Override
    public List<Marca> obtener(Session session) {
        String sql = "from Marca order by id";
        return session.createQuery(sql).list();
    }

    @Override
    public Marca obtenerPorId(Session session, int id) {
        String sql = "from Marca where id=" + id;
        return (Marca) session.createQuery(sql).list().get(0);
    }
}
