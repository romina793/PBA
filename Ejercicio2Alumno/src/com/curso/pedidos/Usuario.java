package com.curso.pedidos;

public class Usuario extends Persona {

    String nombreUsuario;
    String password;
    CarritoCompras carritoCompras;

    public Usuario() {
    }

    public Usuario(String nombreUsuario, String apellido, Long dni) {
        super(apellido, dni);
        this.nombreUsuario = nombreUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CarritoCompras getCarritoCompras() {
        return carritoCompras;
    }

    public void setCarritoCompras(CarritoCompras carritoCompras) {
        this.carritoCompras = carritoCompras;
    }

    @Override
    public String toString() {
        return "Usuario{Nombre de Usuario= " + nombreUsuario + ", Apellido= " + apellido + ", DNI= " + dni + "}";
    }
}
