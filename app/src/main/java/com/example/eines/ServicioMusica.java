/*
package com.example.eines;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;



public class ServicioMusica extends Service {

    //creem objecte MediaPlayer
    MediaPlayer miReproductor;


    @Override
    public void onCreate() {
        super.onCreate();

        //carreguem l'arxiu de la música
       miReproductor = MediaPlayer.create(this, R.raw.busters);

        //creem un loop per a que la cançó es reprodueixi constament (es reinicïi)
        miReproductor.setLooping(true);

        //establim el volum de la música
        miReproductor.setVolume(100,100);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        miReproductor.start();
     //   return super.onStartCommand(intent, flags, startId);
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //aturar
        if (miReproductor.isPlaying()) miReproductor.stop();

        //alliberar recursos
        miReproductor.release();
        miReproductor = null;
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
*/
