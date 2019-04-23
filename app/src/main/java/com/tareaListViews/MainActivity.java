package com.tareaListViews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.tareaListViews.adapter.ProductsAdapter;
import com.tareaListViews.models.Producto;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private Context mContext;

    private ListView lista;
    private List<Producto> productos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;

        LlenarLista();
        initViews();
        AddEvents();
    }

    public void LlenarLista(){
        productos.add(new Producto(1, "Ark Survival Evolved", "49.99$", R.drawable.ark, 49.99));
        productos.add(new Producto(2, "Age of Empires III", "39.99$", R.drawable.aoe, 39.99));
        productos.add(new Producto(3, "Borderlands 2", "19.99$", R.drawable.bl2, 19.99));
        productos.add(new Producto(4, "Jurassic World Evolution", "44.99$", R.drawable.jwe, 44.99));
        productos.add(new Producto(5, "Left 4 Dead 2", "9.99$", R.drawable.l4d2, 9.99));
    }

    public void initViews(){
        lista=findViewById(R.id.lista);
        ProductsAdapter adapter = new ProductsAdapter(mContext, productos);
        lista.setAdapter(adapter);
    }

    private void AddEvents(){
        lista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Producto objeto = productos.get(position);
        Intent intent = new Intent(mContext, ProductActivity.class);
        intent.putExtra(Constants.KEY_INTENT, new Gson().toJson(objeto));
        startActivity(intent);
    }


}
