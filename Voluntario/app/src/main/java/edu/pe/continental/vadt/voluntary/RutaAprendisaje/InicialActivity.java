
package edu.pe.continental.vadt.voluntary.RutaAprendisaje;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import edu.pe.continental.vadt.voluntary.R;

public class InicialActivity extends AppCompatActivity {
    CardView car01,car02,car03,car04, car05, car06;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicial);

        car01.findViewById(R.id.carVideoClase);
        car02.findViewById(R.id.carVideoClase);
        car03.findViewById(R.id.carVideoClase);
        car04.findViewById(R.id.carVideoClase);
        car05.findViewById(R.id.carVideoClase);
        car06.findViewById(R.id.carVideoClase);

        car01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
        car02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
        car03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
        car04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
        car05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
        car06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InicialActivity.this, VideoActivity.class);
                startActivity(intent);
            }
        });
    }
}