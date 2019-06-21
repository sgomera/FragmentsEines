package com.example.eines;

public interface ComunicaMenu {
    //aquesta interfase ha de tenir el mètode comú que s'utilitzi en les dues activities.
    //el menu ha de fer dues coses diferents segons en quina activity es trobi:
        // si es troba a activity main, el botó ha de portar a l'activity herramientas i carregar el
            //fragment corresponent al botó premut
        //si es troba a activity herramientas, només ha de carregar el fragment corresponent al botó

    public void menu(int queBoton); //en una interfase els mètodes només es declaren, no es desenvolupen.
    //aquest mètode d'haurà de desenvolupar en cada classe on s'hagi implementat la interfase
}
