package com.curso.pedidos;

import java.time.LocalDate;
import java.util.*;

public class CarritoCompras {

    Integer id;
    int cantidadMaxItem = 10;
    LocalDate fechaCreacion;
    Usuario usuario;
    List<ItemCarrito> itemsCarrito = new ArrayList<>();

    public CarritoCompras() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCantidadMaxItem() {
        return cantidadMaxItem;
    }
    
    public void setCantidadMaxItem(int cantidadMaxItem) {
        this.cantidadMaxItem = cantidadMaxItem;
    }
    
    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<ItemCarrito> getItemsCarrito() {
        return itemsCarrito;
    }

    public void setItemsCarrito(List<ItemCarrito> items) {
        this.itemsCarrito = items;
    }

    @Override
    public String toString() {
        return "CarritoCompras{" + "id=" + id + ", cantidadMaxItem=" + cantidadMaxItem + ", fechaCreacion=" + fechaCreacion + ", itemsCarrito=" + itemsCarrito.toString() + '}';
    }
}
