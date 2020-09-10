package com.vrfing.vrfcontroller.INVENTARIO;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.vrfing.vrfcontroller.INVENTARIO.Controlador.AdaptadorPersonajes;
import com.vrfing.vrfcontroller.INVENTARIO.Controlador.Adaptador_inventarioHerramientas_recyclerView;
import com.vrfing.vrfcontroller.INVENTARIO.Controlador.clases.Elementos_inventario_herramientas;
import com.vrfing.vrfcontroller.INVENTARIO.Controlador.clases.GoogleSheet;
import com.android.volley.Response;
import com.vrfing.vrfcontroller.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HerramientasInventarioActivity extends AppCompatActivity implements Response.Listener<JSONArray>, Response.ErrorListener {

    ArrayList<Elementos_inventario_herramientas> lista_invantario_herramientas;
    RecyclerView recycler_invantario_herramientas;
    Elementos_inventario_herramientas claseElementos;
    JsonArrayRequest jsonArrayRequest;
    RequestQueue request;
    String id = "";
    String clase = "";
    String nombre = "";
    String marca = "";
    String modelo = "";
    String referencia = "";
    String capacidad = "";
    String cantidad = "";
    String estado = "";
    String personaACargo = "";
    String cedulaPersonaACargo = "";
    String descripcion = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas_inventario);


        lista_invantario_herramientas = new ArrayList<>();
        recycler_invantario_herramientas = (RecyclerView) findViewById(R.id.RecyclerId_invantario_herramientas);
        recycler_invantario_herramientas.setLayoutManager(new LinearLayoutManager(this));


        llenarReciclerInventarioHerramientas();

        Adaptador_inventarioHerramientas_recyclerView adaptador_inventarioHerramientas_recyclerView = new Adaptador_inventarioHerramientas_recyclerView(lista_invantario_herramientas);
        recycler_invantario_herramientas.setAdapter(adaptador_inventarioHerramientas_recyclerView);

    }

    @Override
    public void onResponse(JSONArray response) {



        try {

            for (int i = 0 ; i < 5; i++){

                JSONObject jsonResponse = response.getJSONObject(i);

                String id = jsonResponse.getString("ID");
                String clase = jsonResponse.getString("CLASE");
                String nombre = jsonResponse.getString("IDCLASE");
                String marca = jsonResponse.getString("MARCA");
                String modelo = jsonResponse.getString("MODELO");
                String referencia = jsonResponse.getString("REFERENCIA");
                String capacidad = jsonResponse.getString("CAPACIDAD");
                String cantidad = jsonResponse.getString("CANTIDAD");
                String estado = jsonResponse.getString("ESTADO");
                String personaACargo = jsonResponse.getString("PERSONA A CARGO");
                String cedula = jsonResponse.getString("CEDULA");
                String descripcion = jsonResponse.getString("USO");


                lista_invantario_herramientas.add(new Elementos_inventario_herramientas(id,clase,nombre,marca,modelo,
                        referencia,capacidad,cantidad,estado,personaACargo,cedula,
                        descripcion,R.drawable.inventario));


                /*
                * "CLASE":"herramienta especial","MARCA":"LG","MODELO":"PRCTILO","REFERENCIA":"LG161200088",
                * "CAPACIDAD":"single - multi v","CANTIDAD":"1","ESTADO":"operativa","PERSONA A CARGO":"Eric Martinez Acelas",
                * "CEDULA":"1140851982","USO":"hardware compilador de codigo para interfaz de monitorizacion de equipos AA LG"
                * */


            }
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "ERROR GARRAFAL", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onErrorResponse(VolleyError error) {


        Toast.makeText(this, "no se pudo consultar", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainInventarioActivity.class);
        startActivity(intent);
    }


    private void llenarReciclerInventarioHerramientas() {

        String GSheet_script_CONSULTAR_inventario_herramientas = "https://script.google.com/macros/s/AKfycbz0hdmeUtPx165lDLQ_z-615UCPybFF4_IPew1684s7t_vWm9U/exec?spreadsheetId=12lqNE8mcLEe5496oguAL2odAd1PJpsci98L_1IzkDmU&sheet=inventarioSheet1";


        request = Volley.newRequestQueue(this);

        jsonArrayRequest = new JsonArrayRequest(Request.Method.GET,GSheet_script_CONSULTAR_inventario_herramientas,null,this,this);
        request.add(jsonArrayRequest);


    }

}

/*
package com.example.ericyandrea.vrfsupervisor.INVENTARIO;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ericyandrea.vrfsupervisor.INVENTARIO.Controlador.AdaptadorPersonajes;
import com.example.ericyandrea.vrfsupervisor.INVENTARIO.Controlador.Adaptador_inventarioHerramientas_recyclerView;
import com.example.ericyandrea.vrfsupervisor.INVENTARIO.Controlador.Elementos_inventario_herramientas;
import com.vrfing.vrfcontroller.INVENTARIO.Controlador.clases.PersonajeVo;
import com.example.ericyandrea.vrfsupervisor.R;

import java.util.ArrayList;
import java.util.List;

public class HerramientasInventarioActivity extends AppCompatActivity {

    ArrayList<PersonajeVo> ListaPersonajes;
    RecyclerView recyclerPersonajes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herramientas_inventario);

        ListaPersonajes = new ArrayList<>();
        recyclerPersonajes = (RecyclerView) findViewById(R.id.RecyclerId);
        recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));

        llenarPersonajes();

        AdaptadorPersonajes adaptadorPersonajes = new AdaptadorPersonajes(ListaPersonajes);
        recyclerPersonajes.setAdapter(adaptadorPersonajes);

    }

    private void llenarPersonajes() {

        ListaPersonajes.add(new PersonajeVo("yo","comer comer",R.drawable.buscar));
        ListaPersonajes.add(new PersonajeVo("yo","caminar",R.mipmap.ic_launcher));


    }
}





 */