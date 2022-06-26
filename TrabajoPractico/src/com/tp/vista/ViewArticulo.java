package com.tp.vista;

import com.tp.modelo.Articulo;
import java.util.List;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class ViewArticulo {

    public void verArticulo(Articulo articulo) {
        System.out.println("Datos del Articulo: " + articulo);
    }

    public void verArticulos(List<Articulo> articulos) {
        articulos.forEach((articulo) -> {
            System.out.println("Datos del Articulo: " + articulo);
        });
    }
}
