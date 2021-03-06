package com.tareaListViews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import com.tareaListViews.adapter.CarritoAdapter;
import com.tareaListViews.models.Producto;

import java.util.List;

public class CompraActivity extends AppCompatActivity {

    private Context mContext;

    //private TextView juego;
    //private TextView precio;
    private ListView productos;
    private TextView total;
    private Button comprar;
    private Button seguirCompra;
    private Button volver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compra);

        mContext = this;

        initViews();
        reciveData();
        addEvents();
    }

    public void initViews(){
        //juego = findViewById(R.id.juego);
        //precio = findViewById(R.id.precio);
        productos = findViewById(R.id.productos);
        CarritoAdapter adapter= new CarritoAdapter(mContext, Carrito.getInstance().getCompras());
        productos.setAdapter(adapter);
        total = findViewById(R.id.total);
        comprar = findViewById(R.id.comprar);
        seguirCompra = findViewById(R.id.seguirCompra);
        volver = findViewById(R.id.volver);
    }

    public void reciveData(){
        Intent intent = getIntent();
        String json = intent.getStringExtra(Constants.KEY_INTENT);
        Producto objeto = new Gson().fromJson(json, Producto.class);
        //juego.setText(objeto.getNombre());
        //precio.setText(objeto.getPrecio());
        verificarCarrito(objeto);
        total.setText(Carrito.getInstance().suma() + "$");
    }

    public void addEvents(){
        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Carrito.getInstance().removeAll();
                Toast.makeText(mContext, "Compra Realizada", Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        seguirCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    public void verificarCarrito(Producto objeto){
        List<Producto> carrito = Carrito.getInstance().getCompras();
        boolean contiene = false;
        for(int i  = 0; i<carrito.size(); i++) {
            if (carrito.get(i).getId() == objeto.getId()) {
                contiene = true;
            }
        }

        if (!contiene){
            Carrito.getInstance().addCompra(objeto);
        }
    }
}
