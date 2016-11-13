package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;


/**
 * Created by Laboratorio on 01/11/2016.
 */
public class RepoPois {

    public static ArrayList<Poi> poisList = new ArrayList<Poi>();

    public static ArrayList<Poi> poisFilteredList = new ArrayList<Poi>();

    /**
     * SINGLETON
     */
//    private static RepoPois instance;
//
//    private RepoPois() {
//        poisList = new ArrayList<Poi>();
//    }
//
//    public static RepoPois getInstance() {
//        if (instance == null) {
//            instance = new RepoPois();
//            instance.init();
//        }
//        return instance;
//    }


    /**
     *
     *   Inicializacion Juego de Datos
     */
    //private void init() {

    static {

        Banco poi1 = new Banco(1);
        poi1.setNombre("Galicia");
        poi1.setDireccion("Rivadavia 372");
        poi1.agregarServicio("cobro cheques");
        poi1.agregarServicio("depósitos");
        poi1.setNumero(13);

        Banco poi2 = new Banco(2);
        poi2.setNombre("Santander");
        poi2.setDireccion("Lavalleja 581");
        poi2.agregarServicio("cajero automatico");

        Colectivo poi3 = new Colectivo(3);
        poi3.setNombre("Colectivo 78");
        poi3.setCantParadas(4);

        Poi poi4= new Colectivo(4);
        poi4.setNombre("Colectivo 23");
        poi3.setCantParadas(7);

        Colectivo poi5 = new Colectivo(5);
        poi5.setNombre("Colectivo 7");
        poi3.setCantParadas(2);

        Local poi6 = new Local(6);
        poi6.setNombre("Lo de Rosa");
        poi6.setDireccion("Mitre 3271");
        poi6.agregarPalabrasClaves("Rabano");
        poi6.agregarPalabrasClaves("Lechuga");

        Local poi7 = new Local(7);
        poi7.setNombre("Lo de Carlo");
        poi7.setDireccion("Matheu 3289");
        poi7.agregarPalabrasClaves("Vacio");
        poi7.agregarPalabrasClaves("Chinchulin");
        poi7.agregarPalabrasClaves("Chorrizo");
        poi7.agregarPalabrasClaves("Nalga");

        CGP poi8 = new CGP(8);
        poi8.setNombre("Servicio Penetinciario");
        poi8.setDireccion("Pres. José E. Uriburu 1022");

        poisList.add(poi1);
        poisList.add(poi2);
        poisList.add(poi3);
        poisList.add(poi4);
        poisList.add(poi5);
        poisList.add(poi6);
        poisList.add(poi7);
        poisList.add(poi8);

        poisFilteredList.addAll(poisList);
    }

    //public Poi findById(int id){

   public static Poi findById(int id){
        for (int i=0; i< poisList.size(); i++) {
            Poi poi = poisList.get(i);
            if (poi.getId() == id) {
                return poi;
            }
        }
        return null;
    }
    public static void filterByName(String nombre){
        poisFilteredList.clear();
        for (int i=0; i< poisList.size(); i++) {
            Poi poi = poisList.get(i);
            if (poi.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                poisFilteredList.add(poi);
            }
        }
    }

}
