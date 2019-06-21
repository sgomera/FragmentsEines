package com.example.eines;

public interface ManejaFlashCamara {
    //necessitem aquesta interface pq per fer servir el Camera manager s'han d'utilitzar mètodes que
    //necessiten heretar d'activity, però clar, la nostra classe llanterna no és una activity sinó
    //un fragment, i per tant, no hereta d'activity. Així que haurem de gestionar el flash de la càmera
    //que funciona de llanterna desde l'activity Herramientas. Per a comunicar informació entre
    //el fragment llanterna i l'activity Herramientas, creem aquesta interfase.
    //hem de passar la informació de si la llanterna està encesa o apagada. Per tant hem de crear un mètode
    //per passar aquesta info que haurà d'implementar a herramientas:
    public void enciendeApaga(boolean estadoFlash);
}
