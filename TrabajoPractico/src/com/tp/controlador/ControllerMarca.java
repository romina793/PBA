package com.tp.controlador;

import com.tp.dao.IMarcaDao;
import com.tp.dao.MarcaDaoImp;
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
public class ControllerMarca {

    public ControllerMarca() {
    }

    // Llama al DAO para guardar una marca
    public void registrar(Session session, Marca marca) {
        IMarcaDao dao = new MarcaDaoImp();
        dao.registrar(session, marca);
    }

    // Llama al DAO para obtener todas las marcas
    public List<Marca> obtener(Session session) {
        IMarcaDao dao = new MarcaDaoImp();
        return dao.obtener(session);
    }

    // Llama al DAO para obtener la marca segun el id
    public Marca obtenerPorId(Session session, int id) {
        IMarcaDao dao = new MarcaDaoImp();
        return dao.obtenerPorId(session, id);
    }
}
