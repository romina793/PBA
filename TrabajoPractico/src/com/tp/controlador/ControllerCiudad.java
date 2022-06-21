package com.tp.controlador;

import com.tp.dao.CiudadDaoImp;
import com.tp.dao.ICiudadDao;
import com.tp.modelo.Ciudad;
import com.tp.vista.ViewCiudad;
import java.util.ArrayList;
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

    private ViewCiudad vista = new ViewCiudad();

    public ControllerCiudad() {
    }

    // Llama al DAO para guardar una ciudad
    public void registrar(Session session, Ciudad ciudad) {
        ICiudadDao dao = new CiudadDaoImp();
        dao.registrar(session, ciudad);
    }

    // Llama al DAO para obtener todas las ciudades
    public void verCiudades(Session session) {
        List<Ciudad> ciudades = new ArrayList<>();
        ICiudadDao dao = new CiudadDaoImp();
        ciudades = dao.obtener(session);
        vista.verCiudades(ciudades);
    }

    // Llama al DAO para obtener la ciudad segun el id
    public void verCiudadPorId(Session session, int id) {
        ICiudadDao dao = new CiudadDaoImp();
        Ciudad ciudad = dao.obtenerPorId(session, id);
        vista.verCiudad(ciudad);
    }

    // Llama al DAO para devolver una ciudad
    public Ciudad ciudadPorId(Session session, int id) {
        ICiudadDao dao = new CiudadDaoImp();
        return dao.obtenerPorId(session, id);
    }

    /**
     * Devuelve una lista de ciudades
     *
     * @return ciudades del tipo List<Ciudad>
     */
    public List<Ciudad> getCiudades() {
        List<Ciudad> ciudades = new ArrayList<>();

        Ciudad entreRios = new Ciudad("Entre Rios");
        Ciudad bsAs = new Ciudad("Buenos Aires");
        Ciudad santaFe = new Ciudad("Santa Fe");
        Ciudad mendoza = new Ciudad("Mendoza");
        Ciudad cordoba = new Ciudad("Cordoba");

        ciudades.add(entreRios);
        ciudades.add(bsAs);
        ciudades.add(santaFe);
        ciudades.add(mendoza);
        ciudades.add(cordoba);

        return ciudades;
    }
}
