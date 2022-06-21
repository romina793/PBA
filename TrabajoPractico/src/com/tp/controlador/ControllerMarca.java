package com.tp.controlador;

import com.tp.dao.IMarcaDao;
import com.tp.dao.MarcaDaoImp;
import com.tp.modelo.Marca;
import com.tp.vista.ViewMarca;
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
public class ControllerMarca {

    private ViewMarca vista = new ViewMarca();

    public ControllerMarca() {
    }

    // Llama al DAO para guardar una marca
    public void registrar(Session session, Marca marca) {
        IMarcaDao dao = new MarcaDaoImp();
        dao.registrar(session, marca);
    }

    // Llama al DAO para obtener todas las marcas
    public void verMarcas(Session session) {
        List<Marca> marcas = new ArrayList<>();
        IMarcaDao dao = new MarcaDaoImp();
        marcas = dao.obtener(session);
        vista.verMarcas(marcas);
    }

    // Llama al DAO para obtener la marca segun el id
    public void verMarcaPorId(Session session, int id) {
        IMarcaDao dao = new MarcaDaoImp();
        Marca marca = dao.obtenerPorId(session, id);
        vista.verMarca(marca);
    }
    
    // Llama al DAO para devolver una marca
    public Marca marcaPorId(Session session, int id) {
        IMarcaDao dao = new MarcaDaoImp();
        return dao.obtenerPorId(session, id);
    }

    /**
     * Devuelve una lista de marcas
     *
     * @return marcas del tipo List<Marca>
     */
    public List<Marca> getMarcas() {
        List<Marca> marcas = new ArrayList<>();

        Marca motorola = new Marca(1, "Motorola");
        Marca samsung = new Marca(1, "Samsung");
        Marca alcatel = new Marca(1, "Alcatel");
        Marca noblex = new Marca(1, "Noblex");
        Marca philco = new Marca(1, "Philco");
        Marca philips = new Marca(1, "Philips");
        Marca tcl = new Marca(1, "TCL");

        marcas.add(motorola);
        marcas.add(samsung);
        marcas.add(alcatel);
        marcas.add(noblex);
        marcas.add(philco);
        marcas.add(philips);
        marcas.add(tcl);

        return marcas;
    }
}
