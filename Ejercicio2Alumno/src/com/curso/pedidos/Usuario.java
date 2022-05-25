package com.curso.pedidos;

import java.util.Date;





public class Usuario extends Persona {
    
     String nombreUsuario;
     String password;
     CarritoCompras carritocompras;
     
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

    public CarritoCompras getCarritocompras() {
        return carritocompras;
    }

    public void setCarritocompras(CarritoCompras carrito) {
        this.carritocompras = carrito;
    }

     @Override
    public void setDni(Long dni) {
        this.dni = dni;
    }
    
     @Override
    public Date getFechadeNacimiento() {
        return fechadeNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombreUsuario=" + nombreUsuario + ", password=" + password + '}';
    }


}
