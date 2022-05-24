package com.curso.pedidos;

import java.util.*;

public class CarritoCompras {
   Integer id;
   int cantidadMaxItem = 10;
   Date fechaCreacion;
   Usuario usuario;
   List<ItemCarrito> items = new ArrayList<ItemCarrito>();

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

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<ItemCarrito> getItemsCarrito() {
        return items;
    }

    public void setItemsCarrito(List<ItemCarrito> itemsCarrito) {
        this.items = itemsCarrito;
    }
    @Override
    public String toString() {
        return "CarritoCompras{" + "id=" + id + ", cantidadMaxItem=" + cantidadMaxItem + ", fechaCreacion=" + fechaCreacion + '}';
    }
   
   
}

