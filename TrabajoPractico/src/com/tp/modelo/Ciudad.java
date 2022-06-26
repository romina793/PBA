package com.tp.modelo;

/**
 * Integrantes:
 *
 * @author Baudino Gerardo
 * @author Poleri Franco
 * @author Pozzuto Romina
 */
public class Ciudad {

    private int id;

    private String pais = "Argentina";
    private String provincia;

    public Ciudad() {
    }

    public Ciudad(String pais, String provincia) {
        this.pais = pais;
        this.provincia = provincia;
    }

    public Ciudad(String provincia) {
        this.provincia = provincia;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Ciudad{"
                + "id=" + id
                + ", pais=" + pais
                + ", provincia=" + provincia
                + '}';
    }
}
