package com.tareaListViews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tareaListViews.R;
import com.tareaListViews.models.Producto;

import java.util.List;

public class ProductsAdapter extends BaseAdapter {

    private Context context;
    private List<Producto> items;

    public ProductsAdapter(Context context, List<Producto> items){
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Producto getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View vista, ViewGroup parent) {

        ViewHolder viewHolder;

        if(vista == null){
            viewHolder = new ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.layout_producto,null);

            viewHolder.imagen = vista.findViewById(R.id.icon);
            viewHolder.nombre = vista.findViewById(R.id.NombreJuego);
            viewHolder.precio = vista.findViewById(R.id.Precio);
            vista.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)vista.getTag();
        }

        Producto productoActual =items.get(position);
        viewHolder.imagen.setImageResource(productoActual.getImagen());
        viewHolder.nombre.setText(productoActual.getNombre());
        viewHolder.precio.setText(productoActual.getPrecio());

        return vista;
    }

    static class ViewHolder{
        ImageView imagen;
        TextView nombre;
        TextView precio;
    }
}
