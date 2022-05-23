package com.curso.pedidos;

import java.util.*;
import org.hibernate.*;
import java.util.Scanner;



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
        session.close();

    }
}
