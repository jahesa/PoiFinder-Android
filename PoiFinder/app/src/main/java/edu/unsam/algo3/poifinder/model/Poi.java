package edu.unsam.algo3.poifinder.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public abstract class Poi {

    // -------------------------------------------

    // FALTA ... x q todavia NO tenemos la dependencia de Point

//    public boolean estaCerca = false;
//
//    abstract void estaCercaDe(Point point) {
//        estaCerca = this.coordenada.distance(point) <= this.distanciaMinCercania;
//    }

    //    abstract double distancia(Point point) {
//        coordenada.distance(point);
//    }

    // -------------------------------------------

    /*****************************************************
     * Atributos
     ****************************************************/
    private int id;
    public String nombre;
    public String barrio;
    private String direccion;
    private int numero;
    public Horario horarios;
    private String tipo;

    //private Point coordenada;

    double distanciaMinCercania;
    public ArrayList<String> diasAtencionList = new ArrayList<String>();
    public ArrayList<String> palabrasClaves = new ArrayList<String>();


    //Acciones
    public Poi (int id)
    {
        this.id = id;
    }


    /*****************************************************
     * Getters & Setters
     ****************************************************/
    public int getId()
    {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Horario getHorarios() {
        return horarios;
    }

    public void setHorarios(Horario horarios) {
        this.horarios = horarios;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    //public Point getCoordenada() {
    //     return coordenada;
    //}

//    public void setCoordenada(Point coordenada) {
//        this.coordenada = coordenada;
//    }

    public double getDistanciaMinCercania() {
        return distanciaMinCercania;
    }

    public void setDistanciaMinCercania(double distanciaMinCercania) {
        this.distanciaMinCercania = distanciaMinCercania;
    }

    public ArrayList<String> getPoisDiasAtencion() {
        return diasAtencionList;
    }

    public void setPoisDiasAtencion(ArrayList<String> poisDiasAtencion) {
        this.diasAtencionList = poisDiasAtencion;
    }

    public ArrayList<String> getPalabrasClaves() {
        return palabrasClaves;
    }

    void setPalabrasClaves(ArrayList<String> palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }

    boolean estaAbierto(String nombre, String dia, int hora, int minuto)
    {
        if(horarios.checkHora(hora, minuto) && diasAtencionList.contains(dia))
        {
            return true;
        }
        else
        {
            return false;
        }
    }



}
