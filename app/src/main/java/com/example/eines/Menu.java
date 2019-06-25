package com.example.eines;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {
    //creem un array per emmagatzemar-hi els ID dels botons del menú, sense il·luminar:
    private final int[] BOTONESMENU = {R.id.linterna, R.id.musica, R.id.nivel};
    //ara en creem un altre amb els botons il·luminats:
    private final int[] BOTONESILUMINADOS = {R.drawable.linterna2, R.drawable.musica2, R.drawable.nivel2};

    //per fer que els botons s'il·luminin, necessitem crear 4 fragments de menú diferents, pq el contingut
    //dels fragments és immutable. Necessitem un menú amb cada botó il·luminat diferent.(això s'ha de crear
    //programant desde l'activitat herramientas.
    //a més, haurem de fer que l'activitat herramientas, li digui al a la classe fragment de menú
    // en quin fragment es troba. Per tant, necessitem una variable per saber quin és el botó premut:
    private int boton;


    public Menu() {
        // Required empty public constructor
    }


    //this method returns a view with the argument layout instantiated.

    //volem que, quan es generi el fragment de menú, el propi fragment, averigüi a quina activity
    //ens trobem i a més es posi a l'escolta i averigüi en quin botó es clica.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        // The class LayoutInflater, instantiates a layout XML file into its corresponding View objects

        // return inflater.inflate(R.layout.fragment_menu, container, false);

        //enlloc de retornar la vista, la guardarem en una nova variable menu, que és la que ens
        //ens retornarà la interfase que hem creat comunicaMenu
        View miMenu = inflater.inflate(R.layout.fragment_menu, container, false);


        //inicialitzem boton a -1 pq sinó per defecte val 0 i s'il·luminaria el botó de la llanterna:
        boton = -1;
        //si no és la primera vegada que s'executa el menú i per tant no estàs a l'activitat principal,
        //aleshores recull els arguments del bundle
        if (getArguments() != null) {
            boton = getArguments().getInt("BOTONPULSADO");
        }

        //declarem variable botonMenu de tipus ImageButton per representar cadascun dels botons de
            //dins de miMenu
        ImageButton botonMenu;

        // posar els 3 botons a l'escolta de l'event onClick, i averiguar en quin botó s'ha premut
        for (int i = 0; i < BOTONESMENU.length; i++) {
            botonMenu = (ImageButton) miMenu.findViewById(BOTONESMENU[i]);

            if (boton == i){
                botonMenu.setImageResource(BOTONESILUMINADOS[i]);

            }
            final int queBoton = i; //és la variable que hem d'enviar a la interfase comunicaMenu
            botonMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Activity estaActividad = getActivity(); //amb això ja sabem a quina activity estem
                   // estaActividad.menu(queBoton); //estem utilitzant una variable de tipus "activity" (estaActividad)
                        //per cridar a un mètode (menu) que pertany a una interface que es diu ComunicaMenu, per
                        //tant hem de fer un casting per a que corresponguin els tipus.
                    ((ComunicaMenu)estaActividad).menu(queBoton); //aquest és el mètode de la interface
                    //el que fa és rebre el botó que s'ha premut per poder-lo passar a la classe que
                    //implenti aquest mètode.
                }
            });
        }

        return miMenu;
    }
    //posant on posem el fragment menu, sigui l'activitat que sigui, s'encarregarà de determinar en
    //quina activitat em trobo i passar el botó que hem premut.

}
