package com.tp.dao;

import com.tp.modelo.Ciudad;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public interface ICiudadDao {

    public void registrar(Session session, Ciudad ciudad);

    public List<Ciudad> obtener(Session session);
    
    public Ciudad obtenerPorId(Session session, int id);
}
