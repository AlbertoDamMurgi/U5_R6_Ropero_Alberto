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
import android.widget.Toast;

import com.example.usuario.u5_r6_ropero_alberto.Datos.Carrito;
import com.example.usuario.u5_r6_ropero_alberto.Datos.Producto;
import com.example.usuario.u5_r6_ropero_alberto.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.example.usuario.u5_r6_ropero_alberto.UI.CarritoActivity.posiciones;

/**
 * Created by usuario on 28/11/17.
 */

public class ProductosAdapter extends ArrayAdapter {

    private Context context;
    private int tipo;
    private ArrayList<Producto> datos;
    private ArrayList<Carrito> carrito;

    public ProductosAdapter(@NonNull Context context, ArrayList<Producto> datos, int tipo) {
        super(context, 0,datos);
        this.context=context;
        this.datos=datos;
        this.tipo = tipo;
    }

    public ProductosAdapter(@NonNull Context context,ArrayList<Carrito> carrito, int tipo,String asd) {
        super(context, 0,carrito);
        this.context = context;
        this.tipo = tipo;
        this.carrito = carrito;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View aux = convertView;

        ProductoHolder holder;



        if(aux==null){

            if(tipo==0) {
                aux = LayoutInflater.from(context).inflate(R.layout.esqueleto, parent, false);

                holder = new ProductoHolder();
                holder.Nombre = (TextView) aux.findViewById(R.id.tv_nombre);
                holder.precio = (TextView) aux.findViewById(R.id.tv_precio);
                holder.imagen = (ImageView) aux.findViewById(R.id.imagen);
                holder.boton = (ImageButton) aux.findViewById(R.id.btn_add);
                holder.pequeña = (RadioButton) aux.findViewById(R.id.rb_pequeña_s);
                holder.mediana = (RadioButton) aux.findViewById(R.id.rb_mediana_m);
                holder.grande = (RadioButton) aux.findViewById(R.id.rb_grande_xl);

                aux.setTag(holder);

            }else{


            }

        }



        holder = (ProductoHolder) aux.getTag();

       if(tipo==0) {
           holder.imagen.setImageResource(datos.get(position).getImagen());
           holder.Nombre.setText(datos.get(position).getNombre());
           holder.precio.setText(String.valueOf(datos.get(position).getPrecio()));
           final ProductoHolder finalHolder = holder;
           holder.boton.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   if(finalHolder.pequeña.isChecked()|| finalHolder.mediana.isChecked()|| finalHolder.grande.isChecked()){
                       if(finalHolder.pequeña.isChecked()){
                           datos.get(position).setTalla("pequeña");
                       }else if(finalHolder.mediana.isChecked()){
                           datos.get(position).setTalla("mediana");
                       }else{
                           datos.get(position).setTalla("grande");
                       }
                       finalHolder.boton.setEnabled(false);
                       Toast.makeText(getContext(),"Producto añadido al carrito.",Toast.LENGTH_LONG).show();
                       posiciones.add(position);
                   }else{
                       Toast.makeText(getContext(),"Debes seleccionar una talla",Toast.LENGTH_LONG).show();

                   }
               }
           });

       }




        return aux;

    }
}
