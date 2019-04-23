package com.tareaListViews;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.tareaListViews.models.Producto;

public class ProductActivity extends AppCompatActivity {

    private Context mContext;

    private ImageView imagen;
    private TextView nombre;
    private TextView precio;
    private Button comprar;
    private Button volver;

    private Producto objeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        mContext = this;

        initViews();
        reciveData();
        AddEvent();
    }

    public void initViews(){
        imagen = findViewById(R.id.icono);
        nombre = findViewById(R.id.nombre);
        precio = findViewById(R.id.precio);
        comprar = findViewById(R.id.comprar);
        volver = findViewById(R.id.volver);
    }


   public void reciveData(){
       Intent intent = getIntent();
       String json = intent.getStringExtra(Constants.KEY_INTENT);
       objeto = new Gson().fromJson(json, Producto.class);
       nombre.setText(objeto.getNombre());
       precio.setText(objeto.getPrecio());
       imagen.setImageResource(objeto.getImagen());
   }

   public void AddEvent(){
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, CompraActivity.class);
                intent.putExtra(Constants.KEY_INTENT, new Gson().toJson(objeto));
                startActivityForResult(intent, 420);
            }
        });
   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 420){
            if(resultCode == RESULT_OK){
                finish();
            }
        }
    }
}
