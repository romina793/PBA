package com.tp;

import com.tp.controlador.ControllerArticulo;
import com.tp.controlador.ControllerCiudad;
import com.tp.controlador.ControllerMarca;
import com.tp.controlador.ControllerPersona;
import com.tp.modelo.Articulo;
import com.tp.modelo.Ciudad;
import com.tp.modelo.Marca;
import com.tp.modelo.Vendedor;
import com.tp.util.HibernateUtil;
import java.util.List;
import org.hibernate.*;

public class Main {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction tx = null;
        try {
            Session session = sf.openSession();
            tx = session.beginTransaction();

            registrarValoresIniciales(session);

            tx.commit();
        } catch (RuntimeException e) {
            System.err.println("Error al registrar valores iniciales: " + e);
        } finally {
            sf.close();
        }
    }

    public static void registrarValoresIniciales(Session session) {
        ControllerCiudad controllerCiudad = new ControllerCiudad();
        ControllerMarca controllerMarca = new ControllerMarca();
        ControllerArticulo controllerArticulo = new ControllerArticulo();
        ControllerPersona controllerPersona = new ControllerPersona();

        List<Ciudad> ciudades = controllerCiudad.getCiudades();
        ciudades.forEach(ciudad -> {
            controllerCiudad.registrar(session, ciudad);
        });

        List<Marca> marcas = controllerMarca.getMarcas();
        marcas.forEach(marca -> {
            controllerMarca.registrar(session, marca);
        });

        List<Articulo> articulos = controllerArticulo.getArticulosPorMarca(marcas.get(0));
        articulos.forEach(articulo -> {
            controllerArticulo.registrar(session, articulo);
        });

        Vendedor vendedor1 = new Vendedor(3, 10, articulos, ciudades.get(0),
                "Gerardo", "Baudino", "Calle Falsa 123");

        Vendedor vendedor2 = new Vendedor(1, 15, articulos, ciudades.get(0),
                "Franco", "Poleri", "Calle Falsa 345");

        Vendedor vendedor3 = new Vendedor(2, 10, articulos, ciudades.get(0),
                "Romina", "Pozzutto", "Calle Falsa 678");

        controllerPersona.registrar(session, vendedor1);
        controllerPersona.registrar(session, vendedor2);
        controllerPersona.registrar(session, vendedor3);
    }
}
