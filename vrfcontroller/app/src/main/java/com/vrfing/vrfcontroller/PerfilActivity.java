package com.vrfing.vrfcontroller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;


import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;



public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {

    //para tomar el correo de inicio de sesión
    TextView email;
    String correo;
    //para configurar menu listview clientes
    private DrawerLayout drawerLayoutMetodos;
    private RelativeLayout principalLayout;
    private ListView menuMetodos;
    //botones
    private Button fabPrincMenu, btnInventario;

    //firebase
    FirebaseAuth mFirebaseAuth;
    FirebaseUser mFirebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        //firebase
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseUser = mFirebaseAuth.getCurrentUser();

        //para mostrar correo de inicio de sesión
        email = (TextView)findViewById(R.id.perfil_txtEmail);
        correo = mFirebaseUser.getEmail();
        if(correo == null) {
            Intent VolverInicio = new Intent(PerfilActivity.this, MainActivity.class);
            startActivity(VolverInicio);
            email.setText("Desconocido");
        }else{
            email.setText(correo);
        }

        //para relacionar elementos menu listview clientes
        drawerLayoutMetodos = (DrawerLayout) findViewById(R.id.activity_perfil);
        principalLayout = (RelativeLayout) findViewById(R.id.principalLayout);
        menuMetodos = (ListView) findViewById(R.id.ListarMetodos);

        //para relacionar botones
        btnInventario = (Button) findViewById(R.id.btn_goToPagInventario);
        fabPrincMenu = (Button) findViewById(R.id.main_fabPrincipalMenu);

        //configurar botones
        btnInventario.setOnClickListener(this);
        fabPrincMenu.setOnClickListener(this);

        //configurar elementos de menu listview clientes
        String[] opciones = {"CONFIGURACIÓN  (?) ", "SALIR"};
        ArrayAdapter<String> adp = new ArrayAdapter<String>(PerfilActivity.this, android.R.layout.simple_list_item_1, opciones);
        menuMetodos.setAdapter(adp);

        //método para configurar el clicleable de la lista clientes
        menuMetodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String opcSeleted = (String) menuMetodos.getAdapter().getItem(position);
                int indiceMenu;
                indiceMenu = 0;
                if (opcSeleted == menuMetodos.getAdapter().getItem(indiceMenu)) {
                    System.exit(0);
                }
                indiceMenu++;
            }
        });

    }

    @Override
    public void onClick(View v) {

        if (v == btnInventario) {
            Intent goToPagInventario = new Intent(PerfilActivity.this, com.vrfing.vrfcontroller.INVENTARIO.MainInventarioActivity.class);
            startActivity(goToPagInventario);
        }

        if (v == fabPrincMenu) {
            if (drawerLayoutMetodos.isDrawerOpen(menuMetodos)) {
                drawerLayoutMetodos.closeDrawer(menuMetodos);
            } else {
                drawerLayoutMetodos.openDrawer(menuMetodos);
            }
        }

    }
}
