package com.curso.pedidos;


public class ItemCarrito{
    Integer id;
    Producto producto;
    double cantidad;

    public ItemCarrito() {
    }
  
    public ItemCarrito(Producto producto, double cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double precio(){
    Producto precio = new Producto();
    return precio.getPreciounitario();
    }

    @Override
    public String toString() {
        return "ItemCarrito{" + "id=" + id + ", producto=" + producto + ", cantidad=" + cantidad + '}';
    }


}
