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

    private ArrayList<Producto> datos = new ArrayList<>();

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
        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));
        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));
        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));
        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));
        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));
        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));
        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));
        datos.add(new Producto(R.drawable.calcetin,"Calcetin barato",12.5,""));



    }


}
