package com.example.usuario.u5_r6_ropero_alberto.UI;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    public static double precio_total_adapter=0;
    private TextView precio_total;

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
        CarritoHolder holdercarrito;




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

                aux = LayoutInflater.from(context).inflate(R.layout.esqueleto_carrito,parent,false);
                holdercarrito = new CarritoHolder();

                holdercarrito.nombre = (TextView) aux.findViewById(R.id.tv_nombre_carrito);
                holdercarrito.precio = (TextView) aux.findViewById(R.id.tv_precio_carrito);
                holdercarrito.talla = (TextView) aux.findViewById(R.id.tv_talla_carrito);
                holdercarrito.cantidad = (TextView) aux.findViewById(R.id.tv_cantidad_carrito);
                holdercarrito.cantidad_mas=(Button) aux.findViewById(R.id.btn_mas_cantidad);
                holdercarrito.cantidad_menos = (Button) aux.findViewById(R.id.btn_menos_carrito);

                aux.setTag(holdercarrito);
            }

        }





       if(tipo==0) {
           holder = (ProductoHolder) aux.getTag();
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

       }else{
           holdercarrito = (CarritoHolder) aux.getTag();
           holdercarrito.nombre.setText(carrito.get(position).getNombre());
           holdercarrito.precio.setText(String.valueOf(carrito.get(position).getPrecio()));
           holdercarrito.talla.setText(carrito.get(position).getTalla());
           holdercarrito.cantidad.setText(String.valueOf(carrito.get(position).getCantidad()));

           precio_total_adapter=carrito.get(position).getPrecio()*carrito.get(position).getCantidad();


           final CarritoHolder finalHoldercarrito = holdercarrito;
           holdercarrito.cantidad_mas.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   carrito.get(position).setCantidad(carrito.get(position).getCantidad()+1);
                   precio_total_adapter+=carrito.get(position).getPrecio()*carrito.get(position).getCantidad();
                   finalHoldercarrito.cantidad.setText(String.valueOf(carrito.get(position).getCantidad()));

               }
           });


       }




        return aux;

    }
}
