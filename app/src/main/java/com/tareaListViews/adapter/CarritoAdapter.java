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

public class CarritoAdapter extends BaseAdapter {

    Context mContext;
    List<Producto> items;

    public CarritoAdapter(Context mContext, List<Producto> items) {
        this.mContext = mContext;
        this.items = items;
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
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

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.carrito_layout,null);

            viewHolder.imagen = vista.findViewById(R.id.imagen);
            viewHolder.nombre = vista.findViewById(R.id.nombre);
            viewHolder.costo = vista.findViewById(R.id.costo);
            vista.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)vista.getTag();
        }

        Producto productoActual = items.get(position);
        viewHolder.imagen.setImageResource(productoActual.getImagen());
        viewHolder.nombre.setText(productoActual.getNombre());
        viewHolder.costo.setText(productoActual.getPrecio());

        return vista;
    }

    static class ViewHolder{
        ImageView imagen;
        TextView nombre;
        TextView costo;

    }

}
