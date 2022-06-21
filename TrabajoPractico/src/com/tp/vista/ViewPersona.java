package com.tp.vista;

import com.tp.modelo.Persona;
import java.util.List;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzutto Romina
 */
public class ViewPersona {

    public void verPersona(Persona persona) {
        System.out.println("Datos de la Persona: " + persona);
    }

    public void verPersonas(List<Persona> personas) {
        personas.forEach((persona) -> {
            System.out.println("Datos de la Persona: " + persona);
        });
    }
}
