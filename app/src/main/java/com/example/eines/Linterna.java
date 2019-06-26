package com.example.eines;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Linterna extends Fragment {
    //variables per a poder clicar a llanterna per on/off:
    private ImageView botonCamara;
    private boolean encendida;

    public Linterna() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_linterna, container, false);
        View fragmento = inflater.inflate(R.layout.fragment_linterna, container, false);
        botonCamara = (ImageView)fragmento.findViewById(R.id.bot_linterna);
        //posar a l'escolta el botó imatge de la llanterna, per quan es cliqui:
        botonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (encendida){
                    botonApagaFlash();
                    encendida = false;
                } else {
                    botonEnciendeFlash();
                    encendida = true;
                }

            }
        });

        return fragmento;
    }

    //ha de canviar la imatge de la llanterna i després fer el que toqui:
    public void botonApagaFlash(){
        botonCamara.setImageResource(R.drawable.linterna);
        Activity estaActividad = getActivity();
        ((ManejaFlashCamara)estaActividad).enciendeApaga(encendida);

    }
    public void botonEnciendeFlash(){
        botonCamara.setImageResource(R.drawable.linterna2);
        Activity estaActividad = getActivity();
        ((ManejaFlashCamara)estaActividad).enciendeApaga(encendida);
    }
}
