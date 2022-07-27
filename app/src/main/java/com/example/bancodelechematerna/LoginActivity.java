package com.example.bancodelechematerna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    //botón siguiente
    public void Pantalla1 (View view){
        Intent pantalla1 = new Intent(this, MainActivity.class);
        startActivity(pantalla1);
    }

    //botón siguiente
    public void Pantalla2 (View view){
        Intent pantalla2 = new Intent(this, CrearActivity.class);
        startActivity(pantalla2);
    }

}