package com.example.usuario.u5_r6_ropero_alberto.Datos;

/**
 * Created by usuario on 28/11/17.
 */

public class Producto {

    private int imagen;
    private String nombre;
    private double precio;
    private String talla;

    public Producto(int imagen, String nombre, double precio, String talla) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.precio = precio;
        this.talla = talla;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
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
