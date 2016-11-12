package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class CGP extends Poi {

    /*****************************************************
     * Atributos
     ****************************************************/
    private Comuna comuna;
    public ArrayList<String> servicios = new ArrayList<String>();
    public String director;
    private String direccion;
    private String tel;

    /*****************************************************
     * Constructores
     ****************************************************/

    public CGP(int id)
    {
        super(id);
    }

//    public CGP(int _numero, String barrios, String _director, String calle, String _telefono, ArrayList<String> _servicio){
//        nombre = "CGP "+_numero;
//        //numero=barrios;
//        barrio=barrios;
//        director=_director;
//        direccion = calle;
//        tel = _telefono;
//        servicio = _servicio;
//    }

    /*****************************************************
     * Getters & Setters
     ****************************************************/

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public void setServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<String> getServicios() {
        return servicios;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    /*****************************************************
     * Negocio
     ****************************************************/

    public void agregarServicio (String unServicio) {
        servicios.add (unServicio);
    }

}
