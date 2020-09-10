package com.vrfing.vrfcontroller;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etEmail, etPsw;
    Button btnIngresar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail=(EditText)findViewById(R.id.index_etMail);
        etPsw=(EditText)findViewById(R.id.index_etPsw);
        btnIngresar=(Button)findViewById(R.id.index_btnIngresar);


        mAuth = FirebaseAuth.getInstance();
        btnIngresar.setOnClickListener(this);


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
            startActivity(intent);
        }

    }

    @Override
    public void onClick(View v) {
        if (v == btnIngresar){
            try {
                if(etEmail.getText().toString().isEmpty()){
                    Toast.makeText(this, "INGRESE UN EMAIL", Toast.LENGTH_SHORT).show();
                }else{
                    if(etPsw.getText().toString().isEmpty()){
                        Toast.makeText(this, "INGRESE UNA CONTRASEÑA", Toast.LENGTH_SHORT).show();
                    }else{
                        iniciarSesion();
                    }
                }




            }catch (Exception e){
                Toast.makeText(this, "ERROR EN ULTIMA INSTANCIA", Toast.LENGTH_SHORT).show();
                etEmail.setText("");
                etPsw.setText("");
            }

        }
    }

    private void iniciarSesion() {

        final String email = etEmail.getText().toString();
        final String password = etPsw.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "sesión iniciada como "+email, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, PerfilActivity.class);
                            intent.putExtra("email", email);
                            startActivity(intent);
                        }else{
                            Toast.makeText(MainActivity.this, "error en el inicio de sesión", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
