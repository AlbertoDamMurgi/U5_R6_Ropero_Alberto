package com.example.usuario.u5_r6_ropero_alberto.Datos;

/**
 * Created by usuario on 28/11/17.
 */

public class Carrito {

    private String nombre;
    private double precio;
    private String talla;
    private int cantidad;

    public Carrito(String nombre, double precio, String talla) {
        this.nombre = nombre;
        this.precio = precio;
        this.talla = talla;
        this.cantidad=1;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }
}
