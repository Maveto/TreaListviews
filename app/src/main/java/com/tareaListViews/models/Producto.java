package com.tareaListViews.models;

public class Producto {

    private int id;
    private String nombre;
    private String precio;
    private int imagen;
    private double precioNum;

    public double getPrecioNum() {
        return precioNum;
    }

    public void setPrecioNum(double precioNum) {
        this.precioNum = precioNum;
    }

    public Producto(int id, String nombre, String precio, int imagen, double precioNum) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.imagen = imagen;
        this.precioNum = precioNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
