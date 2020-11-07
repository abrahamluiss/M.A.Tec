package edu.pe.continental.vadt.teacher.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import edu.pe.continental.vadt.teacher.R;

public class HomeActivity extends AppCompatActivity {

    CardView mCarRegistrar, mCarRuta,mCarValoracion,mCarCursos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mCarRegistrar = findViewById(R.id.carRegitrar);
        mCarRuta=findViewById(R.id.carRuta);
        mCarValoracion=findViewById(R.id.carValoracion);
        mCarCursos=findViewById(R.id.carCursosRap);

        mCarRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(HomeActivity.this, "intent registrar", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(HomeActivity.this, CentroProblemasActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        mCarRuta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        mCarValoracion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, ValoracionActivity.class);
                startActivity(intent);
            }
        });
        mCarCursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, CursosRapidosActivity.class);
                startActivity(intent);
            }
        });
    }
}