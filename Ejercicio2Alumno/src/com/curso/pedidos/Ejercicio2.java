package com.curso.pedidos;

import java.util.*;
import org.hibernate.*;

/*
PENDIENTES:
- revisar que todas las clases se inicialicen con los parámetros que pide e inicializarlas así
- despejar el Main con diferentes funciones
- renombrar el proyecto
- poner como constante el máximo de items
- revisar variables de mapeao, respetar camelCase
- Pasar las variables Date a LocalDate con fecha de nacimiento
- Revisar los warnings en consola
- Modificar toString()
- Rompe en las consultas HQL, se puede separar en funciones como está en el repo ClaseHibernate y ver si de esa manersa funciona bien
*/
 
public class Ejercicio2 {

    public static void main(String[] args) {
       SessionFactory sf = HibernateUtil.getSessionFactory(); 
       create(sf);
    }
    public static void create(SessionFactory sf) {
        
        Usuario usuario = new Usuario();
        usuario.setNombre("Horacio");
        usuario.setNombreUsuario("Hora_20");
        usuario.setPassword("123456");
        usuario.setApellido("perez");
        usuario.setDni(24567890L);
        //cambiar a fecha custom / Date() -> LocalDate()
        Date fecha = new Date();
        usuario.setFechadeNacimiento(fecha);
        usuario.setDireccion("Libertador 123");

        Producto producto = new Producto();
        producto.setCodigo("M1");
        producto.setDescripcion("Mesa de madera");
        producto.setPreciounitario(3500.00);
        
        Producto producto2 = new Producto();
        producto.setCodigo("MH");
        producto.setDescripcion("Mesa de hierro");
        producto.setPreciounitario(1060.00);

        ItemCarrito itemCarrito = new ItemCarrito(producto, 2);
        ItemCarrito itemCarrito2 = new ItemCarrito(producto2, 1);
        
        CarritoCompras carritoCompras = new CarritoCompras();
        carritoCompras.setCantidadMaxItem(1);
        carritoCompras.setFechaCreacion(new Date());
        carritoCompras.setUsuario(usuario);

        List<ItemCarrito> items = new ArrayList<>();
        items.add(itemCarrito);
        items.add(itemCarrito2);
        carritoCompras.setItemsCarrito(items);
        
        usuario.setCarritocompras(carritoCompras);
        
        // Obtenemos la session de hibernate         
        Session session = sf.openSession();
        // Iniciamos una transaccion         
        Transaction trx = session.beginTransaction();
         session.save(usuario);
         session.save(producto);
         session.save(producto2);
         session.save(carritoCompras);
         session.save(itemCarrito2);
         session.save(itemCarrito);
              
        trx.commit();
          System.out.println(usuario.toString());
          System.out.println(producto.toString());
          System.out.println(producto2.toString());
          System.out.println(itemCarrito.toString());
          System.out.println(itemCarrito2.toString());
          System.out.println(carritoCompras.toString());
        // Implementar consultas HQL...
        //obtener todos los usuarios ordenados por nombre
        List<Usuario> usuarios = session.createQuery(
                "From Usuario as u order by u.nombreusuario asc")
                .list();
        for (Usuario usr : usuarios) {
            System.out.println(usr.toString());
        }
           
        //obtener todos los productos cuyo precio sea mayor a 1000
        List <Producto> productos = session.createQuery(
                "From Producto as p where p.preciounitario > 1000")
                .list();
        for (Producto prod : productos) {
            System.out.println(prod.toString());
        }
        session.close();

    }
}
