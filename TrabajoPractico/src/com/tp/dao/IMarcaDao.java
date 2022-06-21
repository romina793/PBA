package com.tp.dao;

import com.tp.modelo.Marca;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzutto Romina
 */
public interface IMarcaDao {

    public void registrar(Session session, Marca marca);

    public List<Marca> obtener(Session session);
    
    public Marca obtenerPorId(Session session, int id);
}
