package com.tp.vista;

import com.tp.modelo.Ciudad;
import java.util.List;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class ViewCiudad {

    public void verCiudad(Ciudad ciudad) {
        System.out.println("Datos de la Ciudad: " + ciudad);
    }

    public void verCiudades(List<Ciudad> ciudades) {
        ciudades.forEach((ciudad) -> {
            System.out.println("Datos de la Ciudad: " + ciudad);
        });
    }
}
