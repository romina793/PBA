package com.curso.pedidos;

public class Usuario extends Persona {
    
     String nombreUsuario;
     String password;
     CarritoCompras carrito;

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

    void setDni(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", password=" + password + '}';
    }
}
