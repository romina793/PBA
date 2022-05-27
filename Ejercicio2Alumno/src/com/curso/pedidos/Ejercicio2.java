package com.curso.pedidos;

import java.time.LocalDate;
import java.util.*;
import org.hibernate.*;

public class Ejercicio2 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Transaction tx = null;
        try {
            Session session = sf.openSession();
            tx = session.beginTransaction();

            Create(session);
            Select(session);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) {
                tx.rollback();
            }
            System.err.println("Ocurrio un error: " + e);
        } finally {
            sf.close();
        }
    }

    /**
     * Persistencia de datos
     *
     * @param session
     */
    public static void Create(Session session) {
        Usuario usuario1 = new Usuario("Hora_20", "Perez", 24567890L);
        usuario1.setPassword("1234");
        usuario1.setNombre("Horacio");
        usuario1.setFechaDeNacimiento(LocalDate.of(1985, 11, 26));
        usuario1.setDireccion("Libertador 1234");
        
        Usuario usuario2 = new Usuario("Andy_90", "Martinez", 32299777L);
        usuario2.setPassword("password");
        usuario2.setNombre("Andrés");
        usuario2.setFechaDeNacimiento(LocalDate.of(1995, 12, 06));
        usuario2.setDireccion("Santa Fé 1234");
        
        Usuario usuario3 = new Usuario("Eli-3", "Alan", 35291177L);
        usuario3.setPassword("4356");
        usuario3.setNombre("Eliana");
        usuario3.setFechaDeNacimiento(LocalDate.of(1990, 05, 07));
        usuario3.setDireccion("Juncal 1234");

        Producto producto1 = new Producto("M1", "Mesa de madera", 3500.00);
        Producto producto2 = new Producto("MH", "Mesa de hierro", 1060.00);
        Producto producto3 = new Producto("MS", "Silla", 950.00);

        ItemCarrito itemCarrito1 = new ItemCarrito(producto1, 2);
        ItemCarrito itemCarrito2 = new ItemCarrito(producto2, 1);
        ItemCarrito itemCarrito3 = new ItemCarrito(producto3, 5);

        CarritoCompras carritoCompras = new CarritoCompras();
        carritoCompras.setFechaCreacion(LocalDate.now());
        carritoCompras.setUsuario(usuario1);

        List<ItemCarrito> items = new ArrayList<>();
        items.add(itemCarrito1);
        items.add(itemCarrito2);
        carritoCompras.setItemsCarrito(items);

        usuario1.setCarritoCompras(carritoCompras);

        CarritoCompras carritoCompras2 = new CarritoCompras();
        carritoCompras2.setFechaCreacion(LocalDate.now());
        carritoCompras2.setUsuario(usuario2);

        List<ItemCarrito> items2 = new ArrayList<>();
        items2.add(itemCarrito3);
        carritoCompras2.setItemsCarrito(items2);

        usuario2.setCarritoCompras(carritoCompras2);

        CarritoCompras carritoCompras3 = new CarritoCompras();
        carritoCompras3.setFechaCreacion(LocalDate.now());
        carritoCompras3.setUsuario(usuario3);

        List<ItemCarrito> items3 = new ArrayList<>();
        items3.add(itemCarrito3);
        items3.add(itemCarrito2);
        carritoCompras3.setItemsCarrito(items3);

        usuario3.setCarritoCompras(carritoCompras3);

        session.save(usuario1);
        session.save(usuario2);
        session.save(producto1);
        session.save(producto2);
        session.save(producto3);
        session.save(carritoCompras);
        session.save(carritoCompras2);
        session.save(carritoCompras3);
        session.save(itemCarrito1);
        session.save(itemCarrito2);
        session.save(itemCarrito3);
    }

    /**
     * Implementación de consultas HQL - Obtener todos los usuarios ordenados
     * por nombre - Obtener todos los productos cuyo precio sea mayor a 1000
     *
     * @param session
     */
    private static void Select(Session session) {
        System.out.println("\n######-USUARIOS-######");
        List<Usuario> usuarios = session.createQuery(
                "From Usuario order by nombreusuario asc")
                .list();
        for (Usuario usr : usuarios) {
            System.out.println(usr.toString());
        }

        System.out.println("\n######-PRODUCTOS-######");
        List<Producto> productos = session.createQuery(
                "From Producto where preciounitario > 1000")
                .list();
        for (Producto prod : productos) {
            System.out.println(prod.toString());
        }
    }
}
