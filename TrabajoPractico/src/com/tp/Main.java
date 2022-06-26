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
import com.tp.vista.Menu;
import java.util.List;
import javax.swing.JFrame;
import org.hibernate.*;

/* 
PENDIENTES
- AGREGAR UN FRAME A CADA ACCIÓN DEL MENU
- AGREGAR LÓGICA PARA ASOCIAR UN VENDEDOR CON UN ARTÍCULO
- AGREGAR UN README
- RENOMBRAR LAS VARIABLES DEL FRAME PARA QUE QUEDEN UNIFICADAS
*/



public class Main {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction tx = null;
        try {
            Session session = sf.openSession();
            tx = session.beginTransaction();

            //ESTO DBERÍAMOS TENERLO EN LA BASE DE DATOS Y NO CARGARLO CADA VEZ QUE INICIAMOS
            registrarValoresIniciales(session);
            
            tx.commit();
            session.close();
        } catch (RuntimeException e) {
            System.err.println("Error al registrar valores iniciales: " + e);
        } 
        
        //Lo borro para poder usar la sessión desde el FE
        /*
        finally {
            sf.close();
        }
        */
        
        JFrame frame = new Menu();
        frame.pack();
        frame.setVisible(true);
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
                "Romina", "Pozzuto", "Calle Falsa 678");
        
        controllerPersona.registrar(session, vendedor1);
        controllerPersona.registrar(session, vendedor2);
        controllerPersona.registrar(session, vendedor3);   
    }
}
