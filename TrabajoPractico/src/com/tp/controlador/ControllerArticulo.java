package com.tp.controlador;

import com.tp.dao.ArticuloDaoImp;
import com.tp.dao.IArticuloDao;
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
public class ControllerArticulo {

    public ControllerArticulo() {
    }

    // Llama al DAO para guardar una articulo
    public void registrar(Session session, Articulo articulo) {
        IArticuloDao dao = new ArticuloDaoImp();
        dao.registrar(session, articulo);
    }

    // Llama al DAO para obtener todos los articulos
    public List<Articulo> obtener(Session session) {
        IArticuloDao dao = new ArticuloDaoImp();
        return dao.obtener(session);
    }

    // Llama al DAO para obtener el articulo segun el id
    public Articulo obtenerPorId(Session session, int id) {
        IArticuloDao dao = new ArticuloDaoImp();
        return dao.obtenerPorId(session, id);
    }
}
