package com.example.eines;


import android.content.Context;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.RequiresApi;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Nivel extends Fragment implements SensorEventListener {
    private SensorManager miManager;
    private Sensor miSensor;
    private NivelPantalla pantalla; //haurem de passar info al mètode ángulos de la classe
                                    //nivelPantalla, per això hem de crear un objecte d'aquesta classa

    public Nivel() {
        // Required empty public constructor
    }

    //no tinc clar pq sobreescriu el mètode onCreate i posa a dins allò que surt a la API del sensor Manager
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //en l'exemple de la Api, s'està utilitzant el sensor manager en una activitat, nosaltres
        //en canvi estem en un fragment. Per tant, el fragment haurà de passar informació a l'activitat
        //pq en definitiva és la que controlarà tot això:
        miManager = (SensorManager)getActivity().getSystemService(Context.SENSOR_SERVICE);
        //amb això hem accedit als sensors del dispositiu i ara hem de crear l'objecte sensor concret:
        miSensor = miManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        int lado = getResources().getConfiguration().screenWidthDp;


        pantalla = new NivelPantalla(getActivity(), lado);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_nivel, container, false);
        return pantalla;
    }

    @Override
    public void onResume() {
        super.onResume();
        miManager.registerListener(this, miSensor, SensorManager.SENSOR_DELAY_GAME);
    }

    @Override
    public void onPause() {
        super.onPause();
        miManager.unregisterListener(this);
    }

    //aquest és el mètode que s'executa quan hi ha una varació en el sensor. El que volem és passar aquesta info
    //de la variació a angulos de la classe NivelPantalla.
    @Override
    public void onSensorChanged(SensorEvent event) {
        pantalla.angulos(event.values);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
