package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Colectivo extends Poi {

    /*****************************************************
     * Atributos
     ****************************************************/
    //public ArrayList<Point> paradas = new ArrayList<Point>();
    public int cantParadas;


    /*****************************************************
     * Constructores
     ****************************************************/
    public Colectivo(int id)
    {
        super(id);
        super.setTipo("colectivo");
    }

    public Colectivo(int id, int nombre , int cantParadas)
    {
        super(id);
        super.setTipo("Colectivo");
        super.nombre = String.valueOf(nombre);
        cantParadas = cantParadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this. nombre = nombre;
    }

    public int getCantParadas() {
        return cantParadas;
    }

    public void setCantParadas(int cantParadas) {
        this.cantParadas = cantParadas;
    }

    //    public void addParada(double x, double y)
//    {
//        paradas.add(Point.and(x, y));
//    }

    @Override
    boolean estaAbierto(String nombre, String dia, int hora, int minuto)
    {
        return true;
    }




    // -------------------------------------------

    // FALTA

//    public double distancia(Point point)
//    {
//        double tempa = paradas.get(0).distance(point);
//        for(int i=1;i<paradas.size;i++)
//        {
//            if(paradas.get(i).distance(point)< tempa)
//            {
//                tempa=paradas.get(i).distance(point);
//            }
//        }
//        double tempa;
//    }

//
//    public void estaCercaDe(Point point)
//    {
//        estaCerca=(paradas.exists[paradas|paradas.distance(point) <= 0.1]);
//    }

    // -------------------------------------------


}
