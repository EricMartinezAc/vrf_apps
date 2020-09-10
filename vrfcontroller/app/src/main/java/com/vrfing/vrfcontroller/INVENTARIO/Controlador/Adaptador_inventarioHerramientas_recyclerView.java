package com.vrfing.vrfcontroller.INVENTARIO.Controlador;

//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vrfing.vrfcontroller.INVENTARIO.Controlador.clases.Elementos_inventario_herramientas;
import com.vrfing.vrfcontroller.R;

import java.util.ArrayList;

public class Adaptador_inventarioHerramientas_recyclerView extends RecyclerView.Adapter<Adaptador_inventarioHerramientas_recyclerView.ViewHolderInventarioHerramientas> {

    ArrayList<Elementos_inventario_herramientas> lista_invantario_herramientas;

    public Adaptador_inventarioHerramientas_recyclerView(ArrayList<Elementos_inventario_herramientas> lista_invantario_herramientas) {
        this.lista_invantario_herramientas = lista_invantario_herramientas;
    }

    @NonNull
    @Override
    public ViewHolderInventarioHerramientas onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_inventario_herramientas,null,false);
        return new ViewHolderInventarioHerramientas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderInventarioHerramientas viewHolderInventarioHerramientas, int i) {

        viewHolderInventarioHerramientas.et_id_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getId());
        viewHolderInventarioHerramientas.et_nombre_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getNombre());
        viewHolderInventarioHerramientas.et_clase_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getClase());
        viewHolderInventarioHerramientas.et_marca_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getMarca());
        viewHolderInventarioHerramientas.et_modelo_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getModelo());
        viewHolderInventarioHerramientas.et_referencia_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getReferencia());
        viewHolderInventarioHerramientas.et_capacidad_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getCapacidad());
        viewHolderInventarioHerramientas.et_cantidad_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getCantidad());
        viewHolderInventarioHerramientas.et_estado_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getEstado());
        viewHolderInventarioHerramientas.et_personaACargo_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getPersonaACargo());
        viewHolderInventarioHerramientas.et_cedulaPersonaACargo_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getCedulaPersonaACargo());
        viewHolderInventarioHerramientas.et_descripcion_herramienta_inventario.setText(lista_invantario_herramientas.get(i).getDescripcion());

    }

    @Override
    public int getItemCount() {
        return lista_invantario_herramientas.size();
    }

    public class ViewHolderInventarioHerramientas extends RecyclerView.ViewHolder {

        TextView et_id_herramienta_inventario,et_clase_herramienta_inventario, et_nombre_herramienta_inventario,et_marca_herramienta_inventario
                , et_modelo_herramienta_inventario , et_referencia_herramienta_inventario,et_capacidad_herramienta_inventario
                , et_cantidad_herramienta_inventario, et_estado_herramienta_inventario, et_personaACargo_herramienta_inventario
                , et_cedulaPersonaACargo_herramienta_inventario;
        EditText et_descripcion_herramienta_inventario;
        ImageView image_herramienta_inventario;


        public ViewHolderInventarioHerramientas(@NonNull View itemView) {
            super(itemView);

            et_id_herramienta_inventario = (TextView) itemView.findViewById(R.id.herramientas_itemlist_id);
            et_clase_herramienta_inventario = (TextView) itemView.findViewById(R.id.herramientas_itemlist_clase);
            et_nombre_herramienta_inventario = (TextView)itemView.findViewById(R.id.herramientas_itemlist_nombre);
            et_marca_herramienta_inventario = (TextView) itemView.findViewById(R.id.herramientas_itemlist_marca);
            et_modelo_herramienta_inventario = (TextView) itemView.findViewById(R.id.herramientas_itemlist_modelo);
            et_referencia_herramienta_inventario = (TextView)itemView.findViewById(R.id.herramientas_itemlist_referencia);
            et_capacidad_herramienta_inventario = (TextView) itemView.findViewById(R.id.herramientas_itemlist_capacidad);
            et_cantidad_herramienta_inventario = (TextView) itemView.findViewById(R.id.herramientas_itemlist_cantidad);
            et_estado_herramienta_inventario = (TextView)itemView.findViewById(R.id.herramientas_itemlist_estado);
            et_personaACargo_herramienta_inventario = (TextView) itemView.findViewById(R.id.herramientas_itemlist_personaACargo);
            et_cedulaPersonaACargo_herramienta_inventario = (TextView) itemView.findViewById(R.id.herramientas_itemlist_presonaACargoCedula);
            et_descripcion_herramienta_inventario = (EditText) itemView.findViewById(R.id.herramientas_itemlist_descripcion);
            image_herramienta_inventario = (ImageView)itemView.findViewById(R.id.herramientas_itemlist_imagen);
        }
    }
}
