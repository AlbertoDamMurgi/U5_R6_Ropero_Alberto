package com.example.usuario.u5_r6_ropero_alberto.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.usuario.u5_r6_ropero_alberto.Datos.Producto;
import com.example.usuario.u5_r6_ropero_alberto.R;

import java.util.ArrayList;

/**
 * Created by usuario on 28/11/17.
 */

public class ProductosAdapter extends ArrayAdapter<Producto> {

    private Context context;
    private int tipo;
    private ArrayList<Producto> datos;

    public ProductosAdapter(@NonNull Context context, ArrayList<Producto> datos, int tipo) {
        super(context, 0,datos);
        this.context=context;
        this.datos=datos;
        this.tipo = tipo;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View aux = convertView;

        ProductoHolder holder;
        if(aux==null){
            aux = LayoutInflater.from(context).inflate(R.layout.esqueleto,parent,false);

            holder = new ProductoHolder();
            holder.Nombre= (TextView) aux.findViewById(R.id.tv_nombre);
            holder.precio=(TextView) aux.findViewById(R.id.tv_precio);
            holder.imagen=(ImageView) aux.findViewById(R.id.imagen);
            holder.boton=(ImageButton) aux.findViewById(R.id.btn_add);
            holder.pequeña=(RadioButton) aux.findViewById(R.id.rb_pequeña_s);
            holder.mediana=(RadioButton) aux.findViewById(R.id.rb_mediana_m);
            holder.grande=(RadioButton) aux.findViewById(R.id.rb_grande_xl);

            aux.setTag(holder);



        }

        holder = (ProductoHolder) aux.getTag();

        if(tipo==0){
            holder.imagen.setImageResource(datos.get(position).getImagen());
            holder.Nombre.setText(datos.get(position).getNombre());
            holder.precio.setText(String.valueOf(datos.get(position).getPrecio()));

        }

        return aux;

    }
}
