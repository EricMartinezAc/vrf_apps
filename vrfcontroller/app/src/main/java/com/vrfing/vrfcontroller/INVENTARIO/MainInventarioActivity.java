package com.vrfing.vrfcontroller.INVENTARIO;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import com.vrfing.vrfcontroller.R;


public class MainInventarioActivity extends AppCompatActivity implements View.OnClickListener {

    Button goToPag_inventarioHerramientas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_inventario);

        goToPag_inventarioHerramientas = (Button)findViewById(R.id.inventario_btn_goHerramientas);

        goToPag_inventarioHerramientas.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == goToPag_inventarioHerramientas){
            Intent intent = new Intent(this, com.vrfing.vrfcontroller.INVENTARIO.HerramientasInventarioActivity.class);
            startActivity(intent);
        }
    }
}
