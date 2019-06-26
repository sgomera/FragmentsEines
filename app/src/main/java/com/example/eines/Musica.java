package com.example.eines;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



/**
 * A simple {@link Fragment} subclass.
 */
public class Musica extends Fragment {

    private ImageView botonMusica;
    private boolean encendida;


    public Musica() {
        // Required empty public constructor
    }

/*    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        encendida = false;
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmento = inflater.inflate(R.layout.fragment_musica, container, false);

        botonMusica = (ImageView)fragmento.findViewById(R.id.bot_musica);
        //posar a l'escolta el botó imatge de la múscia, per quan es cliqui:
        botonMusica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (encendida) {
                    apagaMusica();
                    encendida = false;
                }
                 else {
                     enciendeMusica();
                     encendida = true;
                }
            }
        });
        return fragmento;
    }

    private void enciendeMusica() {
        botonMusica.setImageResource(R.drawable.musica2);
        //Intent miReproductor = new Intent(getActivity(), ServicioMusica.class );
        //getActivity().startService(miReproductor);

     //   encendida = !encendida;
    }

    private void apagaMusica() {
        botonMusica.setImageResource(R.drawable.musica);
      //  Intent miReproductor = new Intent(getActivity(), ServicioMusica.class );
        //getActivity().stopService(miReproductor);
      //  encendida = !encendida;
    }

}
