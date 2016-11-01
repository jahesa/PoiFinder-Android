package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class RepoPois {
    public static final ArrayList<Poi> poisList = new ArrayList<Poi>();

    static {
        Poi poi1 = new Banco(1);
        poi1.setNombre("Poi1");
        poi1.setDireccion("por aca cerca");
        Poi poi2 = new CGP(2);
        poi2.setNombre("Poi2");
        poi2.setDireccion("un poco lejos");
        Poi poi3 = new Poi(3);
        poi3.setNombre("Poi3");
        poi3.setDireccion("aca noma");
        Poi poi4 = new Poi(4);
        poi4.setNombre("Poi4");
        poi4.setDireccion("la de la lora");

        poisList.add(poi1);
        poisList.add(poi2);
        poisList.add(poi3);
        poisList.add(poi4);
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
