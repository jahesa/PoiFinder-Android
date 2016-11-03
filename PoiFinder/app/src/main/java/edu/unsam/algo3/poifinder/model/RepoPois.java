package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class RepoPois {

    public static final ArrayList<Poi> poisList = new ArrayList<Poi>();

    static {
        Poi poi1 = new Banco(1);
        poi1.setNombre("Galicia");
        poi1.setDireccion("Esmeralda 4447");

        Poi poi2 = new CGP(2);
        poi2.setNombre("Poi2");
        poi2.setDireccion("La Plata 2523");

        Poi poi3 = new Colectivo(3);
        poi3.setNombre("Colectivo 78");
        poi3.setDireccion("aca noma");

        Poi poi4 = new Local(4);
        poi4.setNombre("Lo de Pocho");
        poi4.setDireccion("Suipacha 7748");

        Poi poi5 = new Banco(5);
        poi5.setNombre("Nacion");
        poi5.setDireccion("La Paz 1123");

        Poi poi6 = new Colectivo(6);
        poi6.setNombre("Colectivo 23");
        poi6.setDireccion("La Rioja 2159");

        Poi poi7 = new Colectivo(7);
        poi7.setNombre("Colectivo 7");
        poi7.setDireccion("Hoston 4523");

        Poi poi8 = new Local(8);
        poi8.setNombre("Los Amigos");
        poi8.setDireccion("Suipacha 77");

        poisList.add(poi1);
        poisList.add(poi2);
        poisList.add(poi3);
        poisList.add(poi4);
        poisList.add(poi5);
        poisList.add(poi6);
        poisList.add(poi7);
        poisList.add(poi8);
    }

    public static Poi findById(int id){
        for (int i=0; i< poisList.size(); i++) {
            Poi poi = poisList.get(i);
            if (poi.getId() == id) {
                return poi;
            }
        }
        return null;
    }

}
