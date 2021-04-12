package com.scen.sigpre.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText nombreText;
    EditText numeroText;
    EditText correoText;
    EditText descripcionText;
    DatePicker fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombreText=findViewById(R.id.nombreText);
        fecha=findViewById(R.id.fecha);
        numeroText=findViewById(R.id.numeroTexto);
        correoText=findViewById(R.id.correoText);
        descripcionText=findViewById(R.id.descripcionText);
        try {
            llenarVariables();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void llenarVariables() throws ParseException {
        Bundle parametros=getIntent().getExtras();
        if(parametros!=null) {
            nombreText.setText(parametros.getString("nombre"));
            numeroText.setText(parametros.getString("numero"));
            correoText.setText(parametros.getString("correo"));
            descripcionText.setText(parametros.getString("descripcion"));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_superior_opciones,menu);
        return true;
    }

    public void vistaSiguiente(View view) {
        Intent intent=new Intent(this,ConfirmacionEditar.class);
        intent.putExtra("nombre",nombreText.getText().toString());
        int day = fecha.getDayOfMonth();
        int month = fecha.getMonth();
        int year =  fecha.getYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        intent.putExtra("fecha",calendar.getTime().toString());
        intent.putExtra("numero",numeroText.getText().toString());
        intent.putExtra("correo",correoText.getText().toString());
        intent.putExtra("descripcion",descripcionText.getText().toString());
        startActivity(intent);
        finish();
    }
}