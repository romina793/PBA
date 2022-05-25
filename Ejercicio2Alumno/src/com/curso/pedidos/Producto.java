package com.curso.pedidos;



public class Producto {
    Integer id;
    String codigo;
    String descripcion;
    double preciounitario;

    public Producto(String codigo) {
        this.codigo = codigo;
    }

    public Producto() {
    }

    public Producto(String codigo, String descripcion, double preciounitario) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.preciounitario = preciounitario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPreciounitario() {
        return preciounitario;
    }

    public void setPreciounitario(double precioUnitario) {
        this.preciounitario = precioUnitario;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", codigo=" + codigo + ", descripcion=" + descripcion + ", preciounitario=" + preciounitario + '}';
    }

}
