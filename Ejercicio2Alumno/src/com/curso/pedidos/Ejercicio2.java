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
        Usuario usuario2 = new Usuario("Admin", "Martinez", 32299777L);

        Producto producto1 = new Producto("M1", "Mesa de madera", 3500.00);
        Producto producto2 = new Producto("MH", "Mesa de hierro", 1060.00);

        ItemCarrito itemCarrito1 = new ItemCarrito(producto1, 2);
        ItemCarrito itemCarrito2 = new ItemCarrito(producto2, 1);

        CarritoCompras carritoCompras = new CarritoCompras();
        carritoCompras.setCantidadMaxItem(1);
        carritoCompras.setFechaCreacion(LocalDate.of(2022, 05, 26));
        carritoCompras.setUsuario(usuario1);

        List<ItemCarrito> items = new ArrayList<>();
        items.add(itemCarrito1);
        items.add(itemCarrito2);
        carritoCompras.setItemsCarrito(items);

        usuario1.setCarritoCompras(carritoCompras);

        session.save(usuario1);
        session.save(usuario2);
        session.save(producto1);
        session.save(producto2);
        session.save(carritoCompras);
        session.save(itemCarrito1);
        session.save(itemCarrito2);
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
