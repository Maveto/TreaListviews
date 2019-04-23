package com.tareaListViews;

import com.tareaListViews.models.Producto;

import java.util.ArrayList;
import java.util.List;

class Carrito {
    private static final Carrito ourInstance = new Carrito();

    private List<Producto> compras;

    static Carrito getInstance() {
        return ourInstance;
    }

    private Carrito() {
        compras = new ArrayList<>();
    }

    public void addCompra(Producto compra){
        compras.add(compra);
    }

    public void quitarCompra(Producto compra){
        compras.remove(compra);
    }

    public List<Producto> getCompras(){
        return compras;
    }

    public void removeAll(){
        for (int i = compras.size()-1; i>=0; i--){
            compras.remove(i);
        }
    }
}
