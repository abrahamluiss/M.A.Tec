
package edu.pe.continental.vadt.voluntary.RutaAprendisaje;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import edu.pe.continental.vadt.voluntary.R;
import edu.pe.continental.vadt.voluntary.actividades.MenuActivity;

public class MenuRutaActivity extends AppCompatActivity {
    Button btn01, btn02, btn03,btn04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ruta);
        btn01=findViewById(R.id.btnInicials);
        btn02=findViewById(R.id.btnPrimari);
        btn03=findViewById(R.id.btnSecund);
        //btn04=findViewById(R.id.btnInicials);

        btn01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MenuRutaActivity.this, MenuActivity.class);
                startActivity(i);
            }
        });

        btn02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRutaActivity.this, PrimariActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        btn03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuRutaActivity.this, SecundariActivity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });


    }

}