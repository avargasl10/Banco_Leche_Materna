package com.example.bancodelechematerna;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CrearActivity extends AppCompatActivity {

    private Button btnCrear;
    private EditText txtContraseña;
    private EditText txtCorreo;
    private EditText txtNombre;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear);
        btnCrear = findViewById(R.id.btnCrear);
        txtNombre = findViewById(R.id.txtNombre);
        txtContraseña = findViewById(R.id.txtContraseña);
        txtCorreo = findViewById(R.id.txtCorreo);

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarSesion();
            }
        });
    }


    private void iniciarSesion() {
        boolean error = false;
        txtCorreo.setError(null);
        if(txtCorreo.getText().toString().isEmpty())
        {
            txtCorreo.setError("Debe ingresar el correo");
            error = true;
        }
        if(txtContraseña.getText().toString().isEmpty())
        {
            txtContraseña.setError("Debe ingresar la contraseña");
            error = true;
        }
        if(txtNombre.getText().toString().isEmpty())
        {
            txtNombre.setError("Debe ingresar el nombre");
            error = true;
        }

        if(error)  {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Error al ingresar los datos").
                    setPositiveButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });
            builder.show();
        }
        else  {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Ha creado su usuario correctamente correctamente").
                    setPositiveButton("Aceptar",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                }
                            });
            builder.show();
        }
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