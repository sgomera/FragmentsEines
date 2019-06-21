package com.example.eines;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {
    //creem un array per emmagatzemar-hi els ID dels botons del menú:
    private final int[] BOTONESMENU = {R.id.linterna, R.id.musica, R.id.nivel};


    public Menu() {
        // Required empty public constructor
    }


    //this method returns a view with the argument layout instantiated.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        // The class LayoutInflater, instantiates a layout XML file into its corresponding View objects

        // return inflater.inflate(R.layout.fragment_menu, container, false);

        //enlloc de retornar la vista, la guardarem en una nova variable menu, que és la que ens
        //ens retornarà la interfase que hem creat comunicaMenu
        View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);

        //declarem variable botonMenu de tipus ImageButton per representar cadascun dels botons de
            //dins de miMenu
        ImageButton botonMenu;

        // posar els 3 botons a l'escolta de l'event onClick, i averiguar en quin botó s'ha premut
        for (int i = 0; i < BOTONESMENU.length; i++) {
            botonMenu = (ImageButton) miMenu.findViewById(BOTONESMENU[i]);
            final int queBoton = i; //és la variable que hem d'enviar a la interfase comunicaMenu
            botonMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity estaActividad = getActivity(); //amb això ja sabem a quina activity estem
                   // estaActividad.menu(queBoton); //estem utilitzant una variable de tipus "activity" (estaActividad)
                        //per cridar a un mètode (menu) que pertany a una interface que es diu ComunicaMenu, per
                        //tant hem de fer un casting per a que corresponguin els tipus.
                    ((ComunicaMenu)estaActividad).menu(queBoton);
                }
            });
        }

        return miMenu;
    }
    //posant on posem el fragment menu, sigui l'activitat que sigui, s'encarregarà de determinar en
    //quina activitat em trobo i passar el botó que hem premut.

}
