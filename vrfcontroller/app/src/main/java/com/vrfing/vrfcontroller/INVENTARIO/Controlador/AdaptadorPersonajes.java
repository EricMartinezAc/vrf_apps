package com.vrfing.vrfcontroller.INVENTARIO.Controlador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vrfing.vrfcontroller.INVENTARIO.Controlador.clases.PersonajeVo;
import com.vrfing.vrfcontroller.R;

import java.util.ArrayList;

public class AdaptadorPersonajes extends RecyclerView.Adapter<AdaptadorPersonajes.ViewHolderPersonajes> {

ArrayList<PersonajeVo> ListaPersonajes;

    public AdaptadorPersonajes(ArrayList<PersonajeVo> listaPersonajes) {
        ListaPersonajes = listaPersonajes;
    }

    @NonNull
    @Override
    public ViewHolderPersonajes onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_persona,null,false);
        return new ViewHolderPersonajes(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPersonajes holder, int position) {

        holder.etiNombre.setText(ListaPersonajes.get(position).getNombre());
        holder.etiInfo.setText(ListaPersonajes.get(position).getInfo());
        holder.foto.setImageResource(ListaPersonajes.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return ListaPersonajes.size();
    }

    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {

        TextView etiNombre, etiInfo;
        ImageView foto;


        public ViewHolderPersonajes(@NonNull View itemView) {
            super(itemView);

            etiNombre = (TextView)itemView.findViewById(R.id.nombreId);
            etiInfo = (TextView)itemView.findViewById(R.id.descripcionId);
            foto = (ImageView) itemView.findViewById(R.id.imageId);

        }
    }
}
