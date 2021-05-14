package com.example.trabajo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText fecha;
    private int dia,mes,ano;
    private EditText nombre, telefono, email,descripcion,fechanacimiento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        fecha = (EditText)findViewById(R.id.fechanacimiento);
        button.setOnClickListener(this);

        nombre = (EditText)findViewById(R.id.nombre);
        telefono = (EditText)findViewById(R.id.telefono);
        email = (EditText)findViewById(R.id.email);
        descripcion = (EditText)findViewById(R.id.descripcion);
        fechanacimiento = (EditText)findViewById(R.id.fechanacimiento);

        String nombretres = getIntent().getStringExtra("nombreconf");
        String telefonotres = getIntent().getStringExtra("telefonoconf");
        String emailtres = getIntent().getStringExtra("emailconf");
        String descripciontres = getIntent().getStringExtra("descripcionconf");
        String fechanacimientotres = getIntent().getStringExtra("fechanacimientoconf");

        nombre.setText(nombretres);
        telefono.setText(telefonotres);
        email.setText(emailtres);
        descripcion.setText(descripciontres);
        fechanacimiento .setText(fechanacimientotres);

    }

    public void enviar(View v){
        Intent intent = new Intent(MainActivity.this, Confirmacion.class);
        intent.putExtra("nombre",nombre.getText().toString());
        intent.putExtra("telefono",telefono.getText().toString());
        intent.putExtra("email",email.getText().toString());
        intent.putExtra("descripcion",descripcion.getText().toString());
        intent.putExtra("fechanacimiento",fechanacimiento.getText().toString());
        startActivity(intent);
    }
    @Override
    public void onClick(View v) {
        if (v == button){
            final Calendar c = Calendar.getInstance();
            dia = c.get(Calendar.DAY_OF_MONTH);
            mes = c.get(Calendar.MONTH);
            ano = c.get(Calendar.YEAR);

            DatePickerDialog datepickerdialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    fecha.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                }
            }
            ,dia,mes,ano);
            datepickerdialog.show();
        }

    }
}