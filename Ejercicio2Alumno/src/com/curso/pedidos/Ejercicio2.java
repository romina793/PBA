package com.curso.pedidos;

import java.util.*;
import org.hibernate.*;


public class Ejercicio2 {

    public static void main(String[] args) {
       SessionFactory sf = HibernateUtil.getSessionFactory(); 
       create(sf);
    }
    public static void create(SessionFactory sf) {

    
        
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Horacio");
        usuario.setPassword("123456");
        usuario.setApellido("perez");
        usuario.setDni(24567890);

        Producto producto = new Producto();
        producto.setCodigo("M1");
        producto.setDescripcion("Mesa de madera");
        producto.setPrecioUnitario(3.450);

        CarritoCompras carritoCompras = new CarritoCompras();
        carritoCompras.setCantidadMaxItem(1);
        carritoCompras.setFechaCreacion(new Date());

        // Obtenemos la session de hibernate         
        Session session = sf.openSession();
        // Iniciamos una transaccion         
        Transaction trx = session.beginTransaction();
         session.save(usuario);
         session.save(producto);
         session.save(carritoCompras);
              
        trx.commit();
        System.out.println(usuario.toString());
        System.out.println(producto.toString());
        System.out.println(carritoCompras.toString());
        // Implementar consultas HQL...
        //obtener todos los usuarios ordenados por nombre
        List usuarios = session.createQuery(
                "from Usuario as u order by u.name asc")
                .list();
        System.out.println(usuarios);

        //obtener todos los productos cuyo precio sea mayor a 1000
        List productos = session.createQuery(
                "from Producto as p where p.precio > 1000")
                .list();
        System.out.println(productos);
        session.close();

    }
}
