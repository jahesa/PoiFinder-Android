package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;

import edu.unsam.algo3.poifinder.model.Horario;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Servicio {

    /*****************************************************
     * Atributos
     ****************************************************/

    private String nombre;
    public ArrayList<String> poisList = new ArrayList<String>();
    private Horario horario;

    /*****************************************************
     * Getters & Setters
     ****************************************************/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getPoisList() {
        return poisList;
    }

    public void setPoisList(ArrayList<String> poisList) {
        this.poisList = poisList;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

//    public void sethorarios(int horaap, int minap, int horacierr, int mincierr) {
//        horario = new Horario(horaap,  minap,  horacierr,  mincierr);
//    }

}
