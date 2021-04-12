package com.scen.sigpre.agenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ConfirmacionEditar extends AppCompatActivity {
    TextView viewNombre;
    TextView viewFechaNa;
    TextView viewNumero;
    TextView viewCorreo;
    TextView viewDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacion_editar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        viewNombre=findViewById(R.id.viewNombre);
        viewFechaNa=findViewById(R.id.viewFechaNa);
        viewNumero=findViewById(R.id.viewNumero);
        viewCorreo=findViewById(R.id.viewCorreo);
        viewDescripcion=findViewById(R.id.viewDescripcion);
        llenarVariables();
    }
String  fechaNac,nombre,correo,numero,descripcion;
    private void llenarVariables() {
        Bundle parametros=getIntent().getExtras();

        nombre=parametros.getString("nombre");
        viewNombre.setText(nombre);

        fechaNac=parametros.getString("fecha");
        viewFechaNa.setText("Fecha Nacimiento: "+fechaNac);

        numero=parametros.getString("numero");
        viewNumero.setText("No. "+numero);

        correo=parametros.getString("correo");
        viewCorreo.setText("Correo: "+correo);

        descripcion=parametros.getString("descripcion");
        viewDescripcion.setText("Descripcion: "+descripcion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_superior_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(myIntent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(myIntent);
        finish();
        super.onBackPressed();
    }

    public void confirmarEditar(View view) {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("nombre",nombre);
        intent.putExtra("fecha",fechaNac);
        intent.putExtra("numero",numero);
        intent.putExtra("correo",correo);
        intent.putExtra("descripcion",descripcion);
        startActivity(intent);
        finish();
    }
}