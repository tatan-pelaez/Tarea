package com.example.trabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Confirmacion extends AppCompatActivity {
    private TextView nombreconfirmacion, telefonoconfirmacion,emailconfirmacion,descripcionconfirmacion,fechanacimientoconfirmacion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion);
        nombreconfirmacion = (TextView)findViewById(R.id.nombredos);
        telefonoconfirmacion = (TextView)findViewById(R.id.telefonodos);
        emailconfirmacion = (TextView)findViewById(R.id.emaildos);
        descripcionconfirmacion = (TextView)findViewById(R.id.descripciondos);
        fechanacimientoconfirmacion = (TextView)findViewById(R.id.fechanacimientodos);

        String nombredos = getIntent().getStringExtra("nombre");
        String telefonodos = getIntent().getStringExtra("telefono");
        String emaildos = getIntent().getStringExtra("email");
        String descripciondos = getIntent().getStringExtra("descripcion");
        String fechanacimientodos = getIntent().getStringExtra("fechanacimiento");

        nombreconfirmacion.setText(nombredos);
        telefonoconfirmacion.setText(telefonodos);
        emailconfirmacion.setText(emaildos);
        descripcionconfirmacion.setText(descripciondos);
        fechanacimientoconfirmacion.setText(fechanacimientodos);
    }

    public void regresar(View v){
        Intent i = new Intent(Confirmacion.this, MainActivity.class);
        i.putExtra("nombreconf",nombreconfirmacion.getText().toString());
        i.putExtra("telefonoconf",telefonoconfirmacion.getText().toString());
        i.putExtra("emailconf",emailconfirmacion.getText().toString());
        i.putExtra("descripcionconf",descripcionconfirmacion.getText().toString());
        i.putExtra("fechanacimientoconf",fechanacimientoconfirmacion.getText().toString());
        startActivity(i);
    }
}