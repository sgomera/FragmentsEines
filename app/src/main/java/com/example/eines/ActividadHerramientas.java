package com.example.eines;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class ActividadHerramientas extends AppCompatActivity implements ComunicaMenu, ManejaFlashCamara{

    Fragment[] misFragmentos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_herramientas);

        //creem un array de fragments, on en cada posició hem posat cadascun dels tipus,
        //en el mateix ordre que el paràmetre queBoton que rebem del bundle
        misFragmentos = new Fragment[3];
        misFragmentos[0] = new Linterna();//casdascun dels fragments té un constructor obligatori
        misFragmentos[1] = new Musica();    //que podem utilitzar per crear fragments de cada tipus
        misFragmentos[2] = new Nivel();


        //cal recuperar la informació del bundle de quan hem cridat aquesta activity, dins de onCreate:
        Bundle extras = getIntent().getExtras();
        // Hem de passar la informació del bundle al mètode menú de la interfase
        menu(extras.getInt("BOTONPULSADO"));


    }

   //Ara el que cal és
    //carregar el fragment corresponent al botó que s'hagi premut pq es carregui la seva imatge a sota.
    //per a fer tot això necessitem la classe FragmentManager.
    //mètode getFragmentManager: Return the FragmentManager for interacting with fragments associated
        // with this fragment's activity.
    //la classe FragmentManager té un mètode anomenat beginTransaction que:
        // Start a series of edit operations on the Fragments associated with this FragmentManager. Retorna
        //un FragmentTransaction que és el que té els mètodes per afegir fragments etc.
        //el mètode que necessitem és replace. Té dos paràmetres, el container i el fragment.
        //també necessitem el commit que és el mètode que executa la transacció.

    @Override
    public void menu(int queBoton) {
        FragmentManager miManejador = getFragmentManager();
        FragmentTransaction miTransaccion = miManejador.beginTransaction();

        //aquí cal crear programàticament els fragments de menú amb botons il·luminats, i després
        // fer un altre replace per al fragment del menú
        Fragment menuIluminado = new Menu();
        Bundle datos = new Bundle();
        datos.putInt("BOTONPULSADO", queBoton);
        menuIluminado.setArguments(datos); //li diuem al nou menu creat, quin botó ha d'ésser el que ha d'estar il·luminat.

        miTransaccion.replace(R.id.menu, menuIluminado); //canviem el menu per el menuIluminado

        miTransaccion.replace(R.id.herramientas, misFragmentos[queBoton]);
        miTransaccion.commit();

    }

    @Override
    public void enciendeApaga(boolean estadoFlash) {
        //per provar fàcilment, mostrem toasts enlloc d'encendre i apagar el flash:
        if(estadoFlash){
            Toast.makeText(this, "Flash desactivado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Flash activado", Toast.LENGTH_SHORT).show();
        }
    }
}
