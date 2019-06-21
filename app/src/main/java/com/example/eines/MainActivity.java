package com.example.eines;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ComunicaMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //aquí, la interface ja sap quin botó s'ha premut, és el que es reb per paràmetre. Ara cal passar-li a la
    //següent activitat (actividadHerramientas) aquesta informació (el botó que s'ha premut).
    @Override
    public void menu(int queBoton) {
        Intent in = new Intent(this, ActividadHerramientas.class);
        in.putExtra("BOTONPULSADO", queBoton);
        startActivity(in);
    }
}
