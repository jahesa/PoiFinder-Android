package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Banco extends Poi {

    // -------------------------------------------

    // FALTA

    // public Horario h = new Horario [10,0,15,0];

    // -------------------------------------------


    // Atributos

    public ArrayList<String> diasAtencionList = new ArrayList<String>();
    public ArrayList<String> servicios = new ArrayList<String>();
    public static final double distanciaMinCercania = 0.5;
    private String gerente;
    private String direccion;

    //Acciones

    public Banco(int id)
    {
        super(id);
    }

    public ArrayList<String> getDiasAtencionList() {
        return diasAtencionList;
    }

    public void setDiasAtencionList(ArrayList<String> diasAtencionList) {
        this.diasAtencionList = diasAtencionList;
    }

    public void setServicios(ArrayList<String> servicios) {
        this.servicios = servicios;
    }

    public ArrayList<String> getServicios() {
        return servicios;
    }


//    @Override
//    public static double getDistanciaMinCercania() {
//        return distanciaMinCercania;
//    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

//    public Banco() {
//        horarios = new Horario(10, 00, 15, 00);
//    }

//    public Banco(String _nombre, Point _coordenada, String sucursal, String _gerente, List<String> _servicio, String dir) {
//        nombre = _nombre;
//        coordenada = _coordenada;
//        barrio = sucursal;
//        gerente = _gerente;
//        servicios = _servicio:
//        direccion = dir;
//        horarios = new Horario(10, 00, 15, 00);
//    }

//    public Poi(String _nombre) {
//        nombre = _nombre;
//    }

//    public Banco(Point punto) {
//        coordenada = punto;
//    }

    public void agregarServicio (String unServicio) {
        servicios.add (unServicio);
    }

    public void adddia(String dia) {
        diasAtencionList.add(dia);
    }

    @Override
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
