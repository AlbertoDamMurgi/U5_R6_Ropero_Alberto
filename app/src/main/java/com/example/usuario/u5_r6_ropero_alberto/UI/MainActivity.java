package com.example.usuario.u5_r6_ropero_alberto.UI;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.usuario.u5_r6_ropero_alberto.Datos.Producto;
import com.example.usuario.u5_r6_ropero_alberto.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Producto> datos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rellenarDatos();

        ListView lista = (ListView) findViewById(R.id.lista);

        ProductosAdapter adapter = new ProductosAdapter(getApplicationContext(),datos,0);

        lista.setAdapter(adapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    private void rellenarDatos() {

        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));
        datos.add(new Producto(R.drawable.camiseta,"Camiseta zebra",18.5,""));
        datos.add(new Producto(R.drawable.gorra,"Gorra hipster",20,""));
        datos.add(new Producto(R.drawable.legging,"Legggins feisimos",23.5,""));
        datos.add(new Producto(R.drawable.sudadera2,"Sudadera guapa",19,""));
        datos.add(new Producto(R.drawable.vestido,"Vestido bonico",163.23,""));
        datos.add(new Producto(R.drawable.sudadera1,"Sudadera to guapa",60.39,""));
        datos.add(new Producto(R.drawable.camiseta3,"Camiseta delmerca",21.25,""));
        datos.add(new Producto(R.drawable.gorra2,"The thing go SCRAAA",25.98,""));
        datos.add(new Producto(R.drawable.sudadera3,"Sudadera MAN'S NOT HOT",50,""));



    }


}
