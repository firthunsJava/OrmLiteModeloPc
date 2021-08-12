package com.firthuns.ormlite_modpc.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firthuns.ormlite_modpc.CrudActivity;
import com.firthuns.ormlite_modpc.R;
import com.firthuns.ormlite_modpc.modelos.Ordenador;

import java.util.List;

public class OrdenadoresAdapter extends RecyclerView.Adapter<OrdenadoresAdapter.OrdenadorVH> {

    // SEGUNDO-------------
    private Context context;
    private List<Ordenador> objects;
    private int resource;

//    CONSTRUCTOR----------------------
    public OrdenadoresAdapter(Context context, List<Ordenador> objects, int resource) {
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }

    // TERCERO implementamos los metodos de OrdenadorAdapter
    @NonNull
    @Override
    public OrdenadorVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Este crea elementos necesarios para reproducir los solicitado poe el usuario
        View view = LayoutInflater.from(context).inflate(resource, null);   // View
        // Layout params PARA FORZAR QUE EL CARD APROVECHE TO.DO EL ANCHO DE LA VENTANA
        view.setLayoutParams(new ViewGroup.LayoutParams(
                                ViewGroup.LayoutParams.MATCH_PARENT,
                                ViewGroup.LayoutParams.WRAP_CONTENT));
        return new OrdenadorVH(view);   // Devuelve new OrdenadorVH
    }

    @Override
    public void onBindViewHolder(@NonNull OrdenadorVH holder, int position) {
//       este metodo da valores a los elementos instanciados
        holder.txtMarca.setText(objects.get(position).getMarca());
        holder.txtModelo.setText(objects.get(position).getModelo());
        holder.txtRam.setText(String.valueOf(  objects.get(position).getRam()));
        holder.txtHd.setText(String.valueOf(objects.get(position).getHd() ));
        holder.txtPrecio.setText(String.valueOf(objects.get(position).getPrecio() ));

        // Asignar onClick a toda la fila (a tod0 el ViewHolder)
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1. Crear Bundle con el ID del ordenador en la BD
                Bundle bundle = new Bundle();
                bundle.putInt("ID", objects.get(position).getId());
                // 2. Crear Intent
                // (desde un Adapter no podemos decir que el origen es una MainActivity,
                // en este caso es el context)
                Intent intent = new Intent(context, CrudActivity.class);
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return objects.size();
    }



// eMPEZAMOS POR AQUI
//    PRIMERO LA CLASE DEL OrdenadorVH > creamos el constructor y la hacemos static
    public static class OrdenadorVH extends RecyclerView.ViewHolder {

    TextView txtMarca, txtModelo, txtRam, txtHd, txtPrecio;

    public OrdenadorVH(@NonNull View itemView) {
        super(itemView);

        txtMarca = itemView.findViewById(R.id.txtMarcaCard);
        txtModelo = itemView.findViewById(R.id.txtModeloCard);
        txtRam = itemView.findViewById(R.id.txtRamCard);
        txtHd = itemView.findViewById(R.id.txtHdCard);
        txtPrecio = itemView.findViewById(R.id.txtPrecioCard);
    }
}
}
