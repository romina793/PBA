package com.tp.vista;

import com.tp.modelo.Marca;
import java.util.List;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzutto Romina
 */
public class ViewMarca {

    public void verMarca(Marca marca) {
        System.out.println("Datos de la Marca: " + marca);
    }

    public void verMarcas(List<Marca> marcas) {
        marcas.forEach((marca) -> {
            System.out.println("Datos de la Marca: " + marca);
        });
    }
}
