package edu.unsam.algo3.poifinder.model;

import java.util.ArrayList;

/**
 * Created by Laboratorio on 01/11/2016.
 */
public class Banco extends Poi {

    /*****************************************************
     * Atributos
     ****************************************************/

    private ArrayList<String> _servicios = new ArrayList<String>();
    public static final double distanciaMinCercania = 0.5;
    private String _gerente;


    public Banco(int id, String _nombre,String sucursal,String _gerente,ArrayList<String> _servicio, String dir)
    {
        super(id);
        super.setTipo("Banco");

        super.nombre = nombre;
        super.barrio = sucursal;
        _gerente = _gerente;
        _servicios = _servicio;
        super.setDireccion(dir);
        horarios = new Horario(10, 00, 15, 00);
    }

    public Banco(int id)
    {
        super(id);
        super.setTipo("Banco");
    }

    /*****************************************************
     * Getters & Setters
     ****************************************************/

     public void setServicios(ArrayList<String> servicios) {
        this._servicios = servicios;
    }

    public ArrayList<String> getServicios() {
        return _servicios;
    }

//    @Override
//    public static double getDistanciaMinCercania() {
//        return distanciaMinCercania;
//    }

    public String getGerente() {
        return _gerente;
    }

    public void setGerente(String gerente) {
        this._gerente = gerente;
    }


    /*****************************************************
     * Negocio
     ****************************************************/

    public void agregarServicio (String unServicio) {
        _servicios.add (unServicio);
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
