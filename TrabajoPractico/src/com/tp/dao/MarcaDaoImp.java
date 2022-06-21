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
 * @author Pozzutto Romina
 */
public class MarcaDaoImp extends HibernateUtil implements IMarcaDao {

    @Override
    public void registrar(Session session, Marca marca) {
        session.save(marca);
    }

    @Override
    public List<Marca> obtener(Session session) {
        String sql = "FROM MARCA ORDER BY ID";
        return session.createQuery(sql).list();
    }

    @Override
    public Marca obtenerPorId(Session session, int id) {
        String sql = "FROM MARCA WHERE ID=" + id;
        Marca a =  (Marca) session.createQuery(sql).uniqueResult();
        return a;
    }
}
