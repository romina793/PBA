package com.tp.controlador;

import com.tp.dao.ArticuloDaoImp;
import com.tp.dao.IArticuloDao;
import com.tp.modelo.Articulo;
import com.tp.modelo.Marca;
import com.tp.vista.ViewArticulo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class ControllerArticulo {

    private ViewArticulo vista = new ViewArticulo();

    public ControllerArticulo() {
    }

    // Llama al DAO para guardar una articulo
    public void registrar(Session session, Articulo articulo) {
        IArticuloDao dao = new ArticuloDaoImp();
        dao.registrar(session, articulo);
    }
    
    // Llama al DAO para actualzar una articulo
    public void actualizar(Session session, Articulo articulo) {
        IArticuloDao dao = new ArticuloDaoImp();
        dao.actualizar(session, articulo);
    }

    // Llama al DAO para obtener todos los articulos
    public void verArticulos(Session session) {
        List<Articulo> articulos = new ArrayList<>();
        IArticuloDao dao = new ArticuloDaoImp();
        articulos = dao.obtener(session);
        vista.verArticulos(articulos);
    }

    // Llama al DAO para obtener el articulo segun el id
    public Articulo verArticuloPorId(Session session, int id) {
        IArticuloDao dao = new ArticuloDaoImp();
        Articulo articulo = dao.obtenerPorId(session, id);
        vista.verArticulo(articulo);
        return articulo;
    }

    /**
     * Devuelve una lista de artículos por marca
     *
     * @param marca del tipo Marca
     *
     * @return articulos del tipo List<Articulo> segun la marca
     */
    public List<Articulo> getArticulosPorMarca(Marca marca) {
        List<Articulo> articulos = new ArrayList<>();

        Articulo tv1 = new Articulo(1, "Televisor",
                "Televisor LED 32", 38000, 48000, marca);
        Articulo tv2 = new Articulo(1, "Televisor",
                "Televisor LED 43", 40000, 49000, marca);
        Articulo tv3 = new Articulo(1, "Televisor",
                "Televisor LED 55", 42000, 50000, marca);
        Articulo tv4 = new Articulo(1, "Televisor",
                "Televisor LED 65", 50000, 59000, marca);

        Articulo cel1 = new Articulo(1, "Celular",
                "Pulgada de Celular 6.43", 40000, 50000, marca);
        Articulo cel2 = new Articulo(1, "Celular",
                "Pulgada de Celular 6.53", 60000, 66000, marca);
        Articulo cel3 = new Articulo(1, "Celular",
                "Pulgada de Celular 6.55", 64000, 67000, marca);
        Articulo cel4 = new Articulo(1, "Celular",
                "Pulgada de Celular 6.78", 42000, 50000, marca);

        articulos.add(tv1);
        articulos.add(tv2);
        articulos.add(tv3);
        articulos.add(tv4);
        articulos.add(cel1);
        articulos.add(cel2);
        articulos.add(cel3);
        articulos.add(cel4);

        return articulos;
    }
}
