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
public interface IPersonaDao {

    public void registrar(Session session, Persona persona);

    public List<Persona> obtener(Session session);
}
