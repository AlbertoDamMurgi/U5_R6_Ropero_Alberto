package com.example.usuario.u5_r6_ropero_alberto.UI;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.usuario.u5_r6_ropero_alberto.Datos.Carrito;
import com.example.usuario.u5_r6_ropero_alberto.R;

import java.util.ArrayList;

import static com.example.usuario.u5_r6_ropero_alberto.UI.MainActivity.datos;

public class CarritoActivity extends AppCompatActivity {

public static ArrayList<Integer> posiciones = new ArrayList<>();
    private ArrayList<Carrito> carrito = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);

        rellenarCarrito();

        ListView lista = (ListView) findViewById(R.id.lista_carrito);

        ProductosAdapter adapter = new ProductosAdapter(getApplicationContext(),carrito
        ,1,"asd");

        lista.setAdapter(adapter);

        Button boton = (Button) findViewById(R.id.btn_calcular_precio);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPrecio();
            }
        });



    }

    private void rellenarCarrito() {

        for (int i = 0; i < posiciones.size(); i++) {
            carrito.add(new Carrito(datos.get(posiciones.get(i)).getNombre(),
                    datos.get(posiciones.get(i)).getPrecio(),
                    datos.get(posiciones.get(i)).getTalla()));

        }

    }


    public void calcularPrecio(){

        TextView preciototal;
        preciototal = (TextView) findViewById(R.id.tv_preciototal);

        preciototal.setText(String.valueOf(ProductosAdapter.precio_total_adapter));

    }


}
