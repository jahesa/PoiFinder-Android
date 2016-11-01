package edu.unsam.algo3.poifinder.model;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Colectivo extends Poi {

    private String nombre;

    public Colectivo(int id)
    {
        super(id);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre (String nombre) {
        this. nombre = nombre;
    }
}
