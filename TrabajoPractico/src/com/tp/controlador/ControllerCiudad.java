package com.tp.controlador;

import com.tp.dao.CiudadDaoImp;
import com.tp.dao.ICiudadDao;
import com.tp.modelo.Ciudad;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzutto Romina
 */
public class ControllerCiudad {

    public ControllerCiudad() {
    }

    // Llama al DAO para guardar una ciudad
    public void registrar(Session session, Ciudad ciudad) {
        ICiudadDao dao = new CiudadDaoImp();
        dao.registrar(session, ciudad);
    }

    // Llama al DAO para obtener todas las ciudades
    public List<Ciudad> obtener(Session session) {
        ICiudadDao dao = new CiudadDaoImp();
        return dao.obtener(session);
    }

    // Llama al DAO para obtener la ciudad segun el id
    public Ciudad obtenerPorId(Session session, int id) {
        ICiudadDao dao = new CiudadDaoImp();
        return dao.obtenerPorId(session, id);
    }

    // Llama al DAO para devolver una ciudad
    public Ciudad ciudadPorId(Session session, int id) {
        ICiudadDao dao = new CiudadDaoImp();
        return dao.obtenerPorId(session, id);
    }
}
