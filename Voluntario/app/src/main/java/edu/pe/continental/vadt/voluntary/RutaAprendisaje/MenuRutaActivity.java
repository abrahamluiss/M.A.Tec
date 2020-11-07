
package edu.pe.continental.vadt.voluntary.RutaAprendisaje;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.pe.continental.vadt.voluntary.R;

public class MenuRutaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_ruta);
    }
    public void onClick(View view){
        Intent intent=null;
        switch (view.getId()){
            case R.id.btnInicial:
                intent = new Intent(MenuRutaActivity.this, InicialActivity.class);
                break;
            case R.id.btnPrimari:
                intent = new Intent(MenuRutaActivity.this, PrimariActivity.class);
                break;
            case R.id.btnSecund:
                intent = new Intent(MenuRutaActivity.this, SecundariActivity.class);
            case R.id.btnSuperior:
                intent = new Intent(MenuRutaActivity.this, SuperiActivity.class);
                break;
        }
        startActivity(intent);
    }
}